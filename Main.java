import java.util.concurrent.*;
/**
 * Main class
 * 
 * @author 10129668 and 10138118
 */
public class Main{
    private static int NPROCESSORS = 10;
    public static int counter= 0;
    public static void main(String[] args){

        // initialize local memory
        LocalMemory localMem = new LocalMemory();        

        // Start BroadcastSystem thread
        BroadcastSystem BCS = BroadcastSystem.getBroadcastSys();
        new Thread(BCS).start();
        
        //create flag and turn arrays
        int[] flag = new int[NPROCESSORS];
        int[] turn = new int[NPROCESSORS-1];
        //initialize all boards to -1
        for(int i=0;i<NPROCESSORS;i++){flag[i] = -1;}
        for(int i=0;i<NPROCESSORS-1;i++){turn[i] = -1;}
        
        // create thread pool
        ExecutorService pool = Executors.newFixedThreadPool(NPROCESSORS);
        
        // for each process, create a dsm and execute
        for(int i=0;i<NPROCESSORS;i++){
            pool.execute(new Processor(i, flag, turn, counter, localMem, BCS));    
        }
        
        pool.shutdown();
        // stop BroadcastSystem Thread
        BCS.flag = false;
	    // Wait until all threads are finish
		while (!pool.isTerminated()) {		}

        System.out.println("All Processes are finished");
    }
}