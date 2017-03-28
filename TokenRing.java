/**
 * TokenRing
 */

import java.util.concurrent.*;
import java.util.ArrayList;

// Consists of individual TokenRingAgents 
// If TokenTing active, create token
// pass token to initially designated TokenRingAgent
// Can be more than one TokenRing instances with diff token messages
public class TokenRing implements Runnable{

    private int tokenRingID;
    private Token token;
    // Array of TokenRingAgents
    private ArrayList<TokenRingAgent> ringAgentList;
    private boolean isActive;

    public TokenRing () {
        ringAgentList = new ArrayList<TokenRingAgent>();
        isActive = true;
    }

    public void addRingAgent(TokenRingAgent ringAgent){
        // add RingAgent to ArrayList
        ringAgentList.add(ringAgent);
        ringAgent.setActive(isActive);
        
    }

    public ArrayList<TokenRingAgent> getRingList(){
        return ringAgentList;
    }

    public void setStatus(){



    }


    // RING TOKEN'S MAIN PURPOSE
    // PASS THE TOKEN IN THE TOKEN RING
    public void run(){
        while (ringAgentList.size() != 10){
            // Yield until TokenRingAgents are in the ringAgentList
            // This is basically a nop
        }

        // PASS TOKEN
        while(true){
            // The token gets passed by iterating through the arrayList
            // When it reaches the end of the list, it goes back to 0 to complete the loop
        }

        // PASS TOKEN 
        // The token gets passed by iterating through the arrayList
        // When it reaches the end of the list, it goes back to 0 to complete the loop
        int x = ringAgentList.size();
        int i = 0;
        for (i = 0; i < (x + 1); i++){ // Never end the for loop

            // The current token is in i and has to be passed
            // This is the RingAgent that will send the token to the succ 
            TokenRingAgent predecessor = ringAgentList.get(i);
            predecessor.sendToken(token, ringAgentList); 

            // If end of the arrayList, go back to beginning to keep forLoop running
            if (i == x){
                i = 0;
            }
        }
    }
}

