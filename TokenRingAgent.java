/**
 * TokenRingAgent
 * 
 * Each Processor has a TokenRingAgent object
 * 
 * @author 10129668 and 10138118
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
        System.out.println("try add");
        tokenRing.addRingAgent(this);
        System.out.println("it added");
        
    }

    public int ReceiveToken(){
        return tokenID;
    }
    
    // SEND THE TOKEN TO THE SUCC
    // syntax might be wrong, so it's probably kinda like psuedocode
    public void SendToken(Token token){
        System.out.println("WE ARE MAYBE SENDING THE TOKEN");
        tokenRing.ringAgentList.get(ringSuccID).token = token;
        tokenRing.ringAgentList.get(ringSuccID).hasToken = true;
        //token.setID(ringSuccID);
        hasToken = false;
    }

    public void setPredID(int ID){
        this.ringPredID = ID;
    }

    public void setSuccID(int ID){
        this.ringSuccID = ID;
    }

     public int getSuccID(){
        return this.ringSuccID;
    }

    public boolean hasTokenM(){
        return this.hasToken;
    }


    public int getPID(){
        return processorID;
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }
    
    public void run(){
        while(isActive){
            //System.out.println(processorID + " is active");
            int thisId = this.processorID;
            boolean x = this.hasToken;
            while (!x){
                //System.out.println("not x");
            }
            /*
            if(tokenRing.token.getID() == processorID){
                //System.out.println("Processor " + processorID + " has token");
                hasToken = true;
            }*/
        }
        System.out.println(processorID + " not active anymore");
    }
    
}