import java.util.concurrent.*;

/**
 * name
 */
public class DSM implements Runnable{
    private LocalMemory localMem = new LocalMemory();
    private BroadcastAgent broadcastAgent;

    public DSM(int size){
        localMem = new LocalMemory(size);
        broadCastAgent = new BroadcastAgent();
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