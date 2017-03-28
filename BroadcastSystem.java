import java.util.concurrent.*;
import java.util.ArrayList;

/**
 * BroadcastSystem class
 * 
 * Implementation of the broadcasting mechanism between processors
 */
public class BroadcastSystem implements Runnable{

    // single instance of BroadcastSystem
    private static BroadcastSystem broadcastSys = new BroadcastSystem();
    
    // array of Agents
    private ArrayList<BroadcastAgent> agentList;
    // queue containing (v,x)
    public ConcurrentLinkedDeque<QueueItem> queue;

    public static boolean flag = true;

    /**
     * Constructor
     * 
     * private to ensure only one instance is created
     */
    private BroadcastSystem () {
        agentList = new ArrayList<BroadcastAgent>();
        queue = new ConcurrentLinkedDeque<QueueItem>();
    }

    /**
     * If other classes need a reference, send singleton 
     */    
    public static synchronized BroadcastSystem getBroadcastSys(){
        if(broadcastSys == null){
            broadcastSys = new BroadcastSystem();
        }
        return broadcastSys;
    }

    /**
     * Adds a BroadcastAgent to the ArrayList
     * 
     * @param agent     BroadcastAgent to be added
     */
    public void addAgent(BroadcastAgent agent){
        // add agent to array
        agentList.add(agent);
    }
    
    /**
     * Get the queue
     */
    public ConcurrentLinkedDeque<QueueItem> getQueue(){
        return queue;
    }

    // keeps checking if there is something in the queue
    // if there is then send it to all agents
    public void run(){
        
        while(flag){
            if(!queue.isEmpty()){
                
                QueueItem item = queue.remove();
                String key = item.getKey();
                int value = item.getValue();
                
                // sleep to break Peterson's Algorithm
                try {
                    Thread.currentThread().sleep(75);
                } catch (Exception e) {
                    System.out.println(e);
                }
                // send (key,value) to all agents
                for(int i = 0; i < agentList.size(); i++){
                    agentList.get(i).receive(key,value);
                }

                // sleep to break Peterson's Algorithm
                try {
                    Thread.sleep(75);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        
    }
}