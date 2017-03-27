
/**
 * name
 */
 
 /*
 
 IMPLEMENTATION
 
 N = levels
 player[id] = id 
 playerBoard[id] = -1 //aka the flag aray to check if there are processes at higher levels
 
 
 Board[n] = latest player to arrive or null if empty
 If player reaches level n:
    board[n] = player[id] //aka the turn[] array 
    playerBoard[id] = n //each player can read each other's board 
    
 
 
 */
 
 
public class Processor implements Runnable{

    //private int turn;
    //private int processes; // # of processes 
    private int flag[]; //playerBoard 
    private int turn[]; //levelBoard
    private int ID;
    //private int i;
    private int j;
    private int n; // # of processes
    private int counter; 
    private boolean exists;

    private DSM dsm;
    
    public Processor(int ID, int[] flag, int[] turn, LocalMemory localMem, BroadcastSystem BCS){
        //this.dsm = dsm;
        this.ID = ID;
        this.flag = flag;
        this.turn = turn;
        this.n = flag.length;
        this.dsm = new DSM(localMem, BCS);
    }
    
    public synchronized void lock(){
        // processes will be stuck here until they get to level n (crit section)
        // so the ones that exit lock() are in the critical section
        // Algorithm from tutorial slides
        for(j=0; j < n-2; j++){
            flag[ID] = j; //player writes level j to their playerBoard 
            turn[j] = ID; //player writes id to level j board 
            
            //While there is another process at a higher level and the board at the
            //current level has the id of ith player on the level board
            //stay in current level 
            
            //Loop through all the players 
            /*
            for(int k = 0; k < processes; i++){
                while((flag[k] >= j) && (turn[i] == j)){
                    nop; 
                }
            }
            */
            // Code from Critical Sections Slide 68
            do {
	            exists = false;
	            for (int k = 0; k < n; k ++){
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
    
    public synchronized void unlock(){
        // player writes -1 to personal board 
        // I think this is after player[i] reaches critical section 
        flag[ID] = -1;        
    }
	

    public void run(){
        new Thread(dsm).start();

        // 10 processes
        int n = 10;
        for (int i=0; i < n; i++){
            int id = i;
            String index = "flag[" + id + "]";
            
            /*
            dsm.store(key,val)
            - stores to localMemory 
            - calls broadcastAgent
            */
            dsm.store(index, i);

            lock();
            // ENTER CRITICAL SECTION 

            // UNLOCK AFTER CRITICAL 
            unlock();
        }
    
        
        
        // maybe 
        // lock();
        // critical section
        // unlock();

    }
}