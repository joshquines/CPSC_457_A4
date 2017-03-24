/**
 * name
 */
public class BroadcastAgent implements Runnable{
    
    private LocalMemory lMemory;
    public BroadcastAgent(BroadcastSystem bcs, LocalMemory lMemory){
        this.lMemory = lMemory;
        bcs.addAgent(this);
        

    }

    public void Broadcast(String y){

    }

    public void receive(){


    }

    public void run(){

    }

}