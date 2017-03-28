import java.util.concurrent.*;

/**
 * BroadcastAgent class
 * 
 * Provides the implementation of the broadcast mechanism needed by DSM. 
 * Each agent executes in a separate thread.
 */
public class BroadcastAgent implements Runnable{
    
    private LocalMemory lMemory;
    public ConcurrentLinkedDeque<QueueItem> queue;
    private BroadcastSystem bcs;
    
    public BroadcastAgent(BroadcastSystem bcs, LocalMemory lMemory){
        this.bcs = bcs;
        this.lMemory = lMemory;
        bcs.addAgent(this);
        this.queue = bcs.getQueue();

    }

  
    // Broadcasts <key,int> pair to BroadcastSystem
    public void broadcast(String key, int value){
        QueueItem item = new QueueItem(key,value);
        queue.add(item);
    }

    // Receives <key, int> pair from BroadcastSystem
    // Stores <key, int> pair to local memory which BroadcastAgent belongs to
    public void receive(String key, int value){
        lMemory.store(key,value);
    }

    public void run(){
        while(bcs.flag){}
    }

}