import java.util.concurrent.*;

/**
 * name
 */
public class DSM implements Runnable{
    private LocalMemory localMem;
    private BroadcastAgent broadCastAgent;

    public DSM(LocalMemory lm, BroadcastSystem BCS){
        localMem = lm;
        broadCastAgent = new BroadcastAgent(BCS, localMem);
        
    }

    public int load (String key){
        return this.localMem.load(key);
    }
    
    public void store(String key,int value){
        this.localMem.store(key,value);
        // Do broadcast stuff
        broadCastAgent.broadcast(key,value);
    }

    public void run(){
        new BroadcastAgent.currentThread().start();
    }
}