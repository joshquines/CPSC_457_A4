public class Main{

    public static void main(String[] args){

        LocalMemory lm = new LocalMemory();
        
        //BroadcastAgent ba;// = new BroadcastAgent();
        BroadcastSystem broadcastSystem = new BroadcastSystem();
        DSM dsm  = new DSM(lm, broadcastSystem);

        Processor processor = new Processor(dsm);
        


    }
}