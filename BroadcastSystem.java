import java.util.concurrent.*;

/**
 * BroadcastSystem
 */
public class BroadcastSystem implements Runnable{

    // array of Agents
    private ArrayList<BroadcastAgent> agentList;
    // queue containing (v,x)
    public ConcurrentLinkedDeque<String,Integer> queue;

    public BroadcastSystem () {
        agentList = new ArrayList<BroadcastAgent>();
        queue = new ConcurrentLinkedDeque<String,Integer>();
    }

    public void addAgent(BroadcastAgent agent){
        // add agent to array
        agentList.add(agent);
    }
    
    public ConcurrentLinkedDeque<String,Integer> getQueue(){
        return queue;
    }
    // keeps checking if there is something in the queue
    // if there is then send it to all agents
    public void run(){
        //calls broadcastAgent.receive();
        //for i = 0, i < arrayList.length, i++
            //broadcastAgent[i].receive(x,y);
    }
}