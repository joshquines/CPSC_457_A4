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
        int x = ringAgentList.size()-1; 
        int i = 0;
        while(true){ // Never end the for loop

            // The current token is in i and has to be passed
            // This is the RingAgent that will send the token to the succ 
            TokenRingAgent predecessor = ringAgentList.get(i);

            // Get successor. Special case if i = x
            if( i == x){
                TokenRingAgent successor = ringAgentList.get(0);
            }else{
                TokenRingAgent successor = ringAgentList.get((i + 1));
            }

            predecessor.SendToken(token, successor); 

            // If end of the arrayList, go back to beginning of arrayList
            // otherwise, continue iterating through arrayList
            if (i == x){
                i = 0;
            }else{
                i++; 
            }

            // TODO
            // I think here we can also set the succ, predecessor 
            // So successor now is i since we already incremented i ; if we switch this to a whileLoop

            


        }
    }
}

