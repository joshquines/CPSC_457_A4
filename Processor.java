/**
 * Processor class
 * 
 * This class represents a processor. 
 * Each processor is executed in a separate thread. 
 * It has an object of type DSM.
 */
 
public class Processor implements Runnable{

    private int[] flag;         //playerBoard 
    private int[] turn;         //levelBoard
    private int ID;             // Processor ID
    private int n;              // # of processes
    public static int counter;  // turn counter
    private boolean exists;     // flag for Peterson's Algorithm

    private DSM dsm;
    
    
    public Processor(int ID, int[] flag, int[] turn,int counter, LocalMemory localMem, BroadcastSystem BCS, TokenRing tokenRing){
        //this.dsm = dsm;
        this.ID = ID;
        this.flag = flag;
        this.turn = turn;
        this.counter=counter;
        this.n = flag.length;
        this.dsm = new DSM(localMem, tokenRing);
    }
    
    /**
     * Peterson's Algorithm used as the Entry Section
     */
    public synchronized void lock(){
        // processes will be stuck here until they get to level n (crit section)
        // so the ones that exit lock() are in the critical section
        // Algorithm from tutorial slides
        for(int j = 0; j < n-2; j++){
            flag[ID] = j; //player writes level j to their playerBoard 
            turn[j] = ID; //player writes id to level j board 
            
            //While there is another process at a higher level and the board at the
            //current level has the id of ith player on the level board
            //stay in current level 

            // Code from Critical Sections Slide 68
            do {
	            exists = false;
	            for (int k = 0; k < n; k++){
	                if (k != ID){                       // if there exists a k != i
	                    if (flag[k] >= j) {             // at a higher level
		                    exists = true;             
		                    break; 
	                    }
                    }
                }
            } while (exists && turn[j] == ID);

        }
    }
    
    /**
     * Exit Section
     */
    public synchronized void unlock(){
        //System.out.println("unlocking algorithm");
        flag[ID] = -1;     
    }
	

    public void run(){
        // Create DSM Thread for this Processor
        new Thread(dsm).start();
        
        // ENTRY SECTION
        System.out.println("Process " + ID + " entering ENTRY SECTION");
        lock();
        
        // sleep to break Peterson's Algorithm
        try {
            Thread.currentThread().sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }

        //CRITICAL SECTION

        String turnID = "turn " + counter;        
        System.out.println("Process " + ID + " has entered the critical section on " + turnID);

        // sleep to break Peterson's Algorithm
        try {
            Thread.currentThread().sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
        // store turn = i to local memory
        dsm.store(turnID, ID);
        // increase turn counter
        counter++;

        // EXIT SECTION 
        System.out.println("Process "+ ID + " entering EXIT SECTION");
        unlock();
    }
}