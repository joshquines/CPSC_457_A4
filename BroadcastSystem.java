import java.util.concurrent.*;
import java.util.ArrayList;

/**
 * BroadcastSystem
 */
public class BroadcastSystem implements Runnable{

    // array of Agents
    private ArrayList<BroadcastAgent> agentList;
    // queue containing (v,x)
    public ConcurrentLinkedDeque<QueueItem> queue;

    public BroadcastSystem () {
        agentList = new ArrayList<BroadcastAgent>();
        queue = new ConcurrentLinkedDeque<QueueItem>();
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
            if(!queue.isEmpty){
                
                QueueItem item = queue.remove();
                
                //calls broadcastAgent.receive();
                //for i = 0, i < arrayList.length, i++
                //broadcastAgent[i].receive(x,y);
                
              
                // Do we get this from ConcurrentLinkedDeque?
                // x = key
                // y = value
                for(i = 0; i < agentList.size(); i++){
                    broadcastAgent[i].receive(x,y);
                }
            }
        }
        
    }
}