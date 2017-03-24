/**
 * name
 */
public class BroadcastAgent implements Runnable{
    
    private LocalMemory lMemory;
    public BroadcastAgent(BroadcastSystem bcs, LocalMemory lMemory){
        this.lMemory = lMemory;
        bcs.addAgent(this);
        

    }
    private BroadcastSystem bSystem;

    public void broadcast(String y, int x){
      // Call BroadcastSystem.broadcast()
      String key = y;
      int value = x;
      bsystem.broadcast(key, value);

    }

    public void receive(String y, int x){
        
        // Index = y, value = x
        String storeKey = y;
        int storeValue = x;
        lmemory.store(storeKey,storeValue);

    }

    public void run(){

    }

}