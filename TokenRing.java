/**
 * TokenRing
 */

import java.util.concurrent.*;
import java.util.ArrayList;

// Consists of individual TokenRingAgents 
// If TokenTing active, create token
// pass token to initially designated TokenRingAgent
// Can be more than one TokenRing instances with diff token messages
public class TokenRing extends Thread{
    private int tokenRingID;
    private Token token;
    private ArrayList<TokenRingAgent> agentsList;
    private int agentListIndex; // index 0 has the token

    public TokenRing (int tokenRingID) {
        this.tokenRingID = tokenRingID;


    }

    public setSucc(){
        // Get index + 1 ; the next in arrayList
        successor = agentList[index + 1].getId();

        // Successor gets token
        

        // Get index -1 ; the predecessor

        // Set predecessor as last, 

    }

    public setPred(){

    }

    // Start the Token Ring aka pass the token around
    public void run(){

    }
}

