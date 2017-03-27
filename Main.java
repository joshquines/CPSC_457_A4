import java.util.concurrent.*;
public class Main{
    private static int NPROCESSORS = 10;

    public static void main(String[] args){
        

        // initialize local memory
        LocalMemory localMemory = new LocalMemory();        

        // Start BroadcastSystem thread
        BroadcastSystem BCS = BroadcastSystem.getBroadcastSys();
        new BCS().currentThread().start();
        
        //create flag and turn arrays
        int[] flag = new int[NPROCESSORS];
        int[] turn = new int[NPROCESSORS-1];
        //initialize all boards to -1
        for(int i=0;i<NPROCESSORS;i++){flag[i] = -1;}
        for(int i=0;i<NPROCESSORS-1;i++){turn[i] = -1;}
        
        // create thread pool
        ExecutorService pool = Executors.newFixedThreadPool(NPROCESSORS);
        //Processor[] procArray = new Processor[10];
        
        // for each process, create a dsm and execute
        for(int i=0;i<NPROCESSORS;i++){
            //DSM dsm  = new DSM(localMemory, BCS);
            executor.execute(new Processor(i, flag, turn, localMemory, BCS));    
        }
        
       
    }
}