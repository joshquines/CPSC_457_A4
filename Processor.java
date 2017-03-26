asdfasdfas
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

    private int turn;
    private int processes; // # of processes 
    private boolean flag[]; //playerBoard 
    private boolean turn[]; //levelBoard
    private int i;
    private int j;
    private int n; //critical section level 
    private int counter; 

    private DSM dsm;
    
    public void lock(){
        // Algorithm from tutorial slides
        for(j=0; j < n-2; j++){
            flag[i] = j; //player writes level j to their playerBoard 
            turn[j] = i; //player writes id to level j board 
            
            //While there is another process at a higher level and the board at the
            //current level has the id of ith player on the level board
            //stay in current level 
            
            //Loop through all the players 
            for(k = 0; k < processes; i++){
                while((flag[k] >= j) && (turn[i] == j)){
                    nop; 
                }
            }
        }
    public void unlock(){
        // player writes -1 to personal board 
        // I think this is after player[i] reaches critical section 
        flag[i] = -1;        
    }

    
    }

    public Processor(DSM dsm){
        this.dsm = dsm;
    }
    
    public void run(){
    


    }
}