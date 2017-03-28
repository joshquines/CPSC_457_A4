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

    public TokenRingAgent (int processorID, boolean isActive) {
        this.processorID = processorID;
        this.isActive = isActive;
    }

    public int ReceiveToken(Token token){

        // receive from succ 
        return token;
    }
    
    // SEND THE TOKEN TO THE SUCC
    // syntax might be wrong, so it's probably kinda like psuedocode
    public void SendToken(Token token, TokenRingAgent successor, TokenRingAgent predecessor){
        this.token = token;
        this.successor = successor;
        successor.ReceiveToken(token);

    }

    public int tokenStatus(TokenRingAgent tokenRingAgent, int tokenID){
        this.tokenRingAgent = tokenRingAgent;
        this.tokenID = tokenID;
        // Code to set tokenRingAgent's token ID
        // We proably might need a dictionary type thing here 
        // I was thinking something like <'TokenRingAgent[id2]',tokenID>
    }


    public void SuccessorID(int ringSuccID){
        this.ringSuccID = ringSuccID;
    }

    
    public void run(){
        
    }
    
}