import java.util.concurrent.*;

/**
 * name
 */
public class BroadcastAgent implements Runnable{
    
    private LocalMemory lMemory;
    public ConcurrentLinkedDeque<QueueItem> queue;
    
    
    public BroadcastAgent(BroadcastSystem bcs, LocalMemory lMemory){
        
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

    }

}