import java.util.concurrent.*;
import java.util.ArrayList;

/**
 * BroadcastSystem
 */
public class BroadcastSystem implements Runnable{

    private static BroadcastSystem broadcastSys = new BroadcastSystem();
    
    // array of Agents
    private ArrayList<BroadcastAgent> agentList;
    // queue containing (v,x)
    public ConcurrentLinkedDeque<QueueItem> queue;

    private BroadcastSystem () {
        agentList = new ArrayList<BroadcastAgent>();
        queue = new ConcurrentLinkedDeque<QueueItem>();
    }
    
    // make sure there is only one BroadcastSystem
    public static synchronized BroadcastSystem getBroadcastSys(){
        if(broadcastSys == null){
            broadcastSys = new BroadcastSystem();
        }
        return broadcastSys;
    }

    public void addAgent(BroadcastAgent agent){
        // add agent to array
        agentList.add(agent);
    }
    
    public ConcurrentLinkedDeque<QueueItem> getQueue(){
        return queue;
    }
    // keeps checking if there is something in the queue
    // if there is then send it to all agents
    public void run(){
        
        while(true){
            if(!queue.isEmpty()){
                
                QueueItem item = queue.remove();
                String key = item.getKey();
                int value = item.getValue();
                
                //calls broadcastAgent.receive();
                //for i = 0, i < arrayList.length, i++
                //broadcastAgent[i].receive(x,y);
      
                for(int i = 0; i < agentList.size(); i++){
                    agentList.get(i).receive(key,value);
                }
            }
        }
        
    }
}