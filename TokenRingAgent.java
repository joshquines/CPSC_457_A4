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

    public TokenRingAgent (int processorID) {
        this.processorID = processorID;
    }

    public Token ReceiveToken(){
        // receive from succ 
        return token;
    }
    
    public void SendToken(Token token){
        this.token = token;
        
    }
    
    public void run(){
        
    }
    
}