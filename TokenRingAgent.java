/**
 * TokenRingAgent
 */
public class TokenRingAgent implements Runnable {
    
    private Token token;
    private int tokenID, processorID, ringPredID, ringSuccID;
    private boolean isActive;
    // Init 
    //private boolean flagToken[];
    //flagToken[0] = true;

    public TokenRingAgent (int processorID, boolean isActive) {
        this.processorID = processorID;
        this.isActive = isActive;
    }

    public Token ReceiveToken(){
        
        // receive from succ 
        return token;
    }
    
    public void SendToken(Token token){
        this.token = token;
    }

    public void successor(Token token, int ringSuccID){
        this.ringSuccID = ringSuccID;
    }


    
    public void run(){
        
    }
    
}