/**
 * TokenRingAgent
 * 
 * @author 10129668 and 10138118
 */
public class TokenRingAgent implements Runnable {
    
    private Token token;
    private int tokenID, processorID, ringPredID, ringSuccID;
    private boolean active;

    public TokenRingAgent () {

    }

    public Token ReceiveToken(){
        return token;
    }
    
    public void SendToken(Token t){
        
    }
    
    public void run(){
        
    }
    
}