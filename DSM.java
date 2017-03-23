import java.util.concurrent.*;

/**
 * name
 */
public class DSM implements Runnable{
    private LocalMemory localMem;
    private BroadcastAgent broadcastAgent;

    public DSM(LocalMemory lm, BroadcastAgent ba){
        localMem = lm;
        broadCastAgent = ba;
    }

    public String load (int x){
        return this.localMem.get(x);
    }
    public void store(String v,int x){
        this.localMem.put(v,x);
        // Do broadcast stuff
    }

    public void run(){
        
    }
}