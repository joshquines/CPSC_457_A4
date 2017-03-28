/**
 * TokenRingAgent
 */
public class TokenRingAgent implements Runnable {
    
    private Token token;
    private int tokenID, processorID, ringPredID, ringSuccID;
    private boolean isActive;
    //private boolean hasToken;
    // Init 
    //private boolean flagToken[];
    //flagToken[0] = true;

    public TokenRingAgent (int processorID, boolean isActive, int tokenID) {
        this.processorID = processorID;
        this.isActive = isActive;
        this.tokenID = tokenID;
    }

    public int ReceiveToken(Token token){

        // Is this needed?
        // get token int value from token?
        // tokenStatus(sucessor, tokenID)

        // receive from succ 
        return token;
    }
    
    // SEND THE TOKEN TO THE SUCC
    // syntax might be wrong, so it's probably kinda like psuedocode
    public void SendToken(Token token, TokenRingAgent successor, TokenRingAgent predecessor){
        this.token = token;
        this.successor = successor;
        successor.ReceiveToken(token);
        tokenStatus(predecessor, -1);


    }

    public int TokenStatus(TokenRingAgent tokenRingAgent, int tokenID){
        this.tokenRingAgent = tokenRingAgent;
        this.tokenID = tokenID;
        tokenRingAgent.tokenID = tokenID;
    }


    public void SuccessorID(int ringSuccID){
        this.ringSuccID = ringSuccID;
    }

    
    public void run(){
        
    }
    
}