/**
 * DSM class
 * 
 * This class represents the DSM layer. It has the following methods:
 * load(x): returns the value of x read from the local memory
 * store(x,v): writes v into x in the local memory and broadcasts 
 *             a message to all other DSMs to apply the write locally in their replicas
 */
public class DSM implements Runnable{
    private LocalMemory localMem;
    private BroadcastAgent broadCastAgent;
    /**
     * Constructor
     *  @param lm       reference to local memory
     *  @param BCS      reference to BroadcastSystem
     */
    public DSM(LocalMemory lm, BroadcastSystem BCS){
        localMem = lm;
        broadCastAgent = new BroadcastAgent(BCS, localMem);
        
    }

    public int load (String key){
        return this.localMem.load(key);
    }
    
    public void store(String key,int value){
        // store to Local Memory
        this.localMem.store(key,value);
        // broadcast to all other DSMs
        broadCastAgent.broadcast(key,value);
    }

    public void run(){
        // start BroadcastAgent Thread
        new Thread(broadCastAgent).start();
    }
}