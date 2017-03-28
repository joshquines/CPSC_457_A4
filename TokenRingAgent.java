/**
 * TokenRingAgent
 */
public class TokenRingAgent implements Runnable {
    
    public Token token;
    public int tokenID, processorID, ringPredID, ringSuccID;
    public boolean isActive;
    public volatile boolean hasToken;
    public TokenRing tokenRing;
    // Init 
    //private boolean flagToken[];
    //flagToken[0] = true;

    public TokenRingAgent (int processorID, TokenRing tokenRing) {
        this.processorID = processorID;
        this.tokenRing = tokenRing;
        this.isActive = tokenRing.isActive;
        this.tokenID = tokenRing.token.getID();
    }

    public int ReceiveToken(){
        return tokenID;
    }
    
    // SEND THE TOKEN TO THE SUCC
    // syntax might be wrong, so it's probably kinda like psuedocode
    public void SendToken(Token token){
        tokenRing.ringAgentList.get(ringSuccID).token = token;
        //token.setID(ringSuccID);
        hasToken = false;
    }

    public void setPredID(int ID){
        this.ringPredID = ID;
    }

    public void setSuccID(int ID){
        this.ringSuccID = ID;
    }

    public int getPID(){
        return processorID;
    }


    public void setActive(boolean isActive){
        this.isActive = isActive;
    }
    
    public void run(){
        while(isActive){
            if(tokenRing.token.getID() == processorID){
                hasToken = true;
            }
        }
    }
    
}