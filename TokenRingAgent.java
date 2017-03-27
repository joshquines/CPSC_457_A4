/**
 * TokenRingAgent
 */
public class TokenRingAgent implements Runnable {
    
    private Token token;
    private int tokenID, processorID, ringPredID, ringSuccID;
    private boolean active;
    // Init 
    //private boolean flagToken[];
    //flagToken[0] = true;

    public TokenRingAgent () {

    }
        // For this part, what I think it does is 
      
        // Processor will have a enteredCrit() method 
      
        // if player[i] entered critical method 
            // enteredCrit(i) 
        /*
        enteredCrit(int i){
            hasToken(i, false);
            hasToken(i-1, true);
        }
        
        hasToken(int i, bool t){
            playerToken[i] = t;
        }
        
        */
        
    public Token ReceiveToken(){
        return token;
    }
    
    public void SendToken(Token t){
        
    }
    
    public void run(){
        
    }
    
}