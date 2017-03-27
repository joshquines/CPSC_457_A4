import java.util.concurrent.*;

/**
 * name
 */
public class DSM implements Runnable{
    private LocalMemory localMem;
    private BroadcastAgent broadcastAgent;

    public DSM(LocalMemory lm, BroadcastSystem BCS){
        localMem = lm;
        broadCastAgent = new BroadcastAgent(bcs, localMem);
        
    }

    public int load (String key){
        return this.localMem.get(key);
    }
    
    public void store(String key,int value){
        this.localMem.put(key,value);
        // Do broadcast stuff
        broadCastAgent.broadcast(key,value);
    }

    public void run(){
        new broadCastAgent.currentThread().start();
    }
}