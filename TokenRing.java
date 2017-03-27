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

        int x = ringAgentList.size();
        while(true){

            for (int i = 0; i < x; i++){

                // if i = 0
                if(i == 0){

                }


                // if i = x-1

            }


    }


    // Start the Token Ring aka pass the token around
    public void run(){
        while (ringAgentList.size() != 10){
            // YIELD UNTIL ALL TOKENRINGAGENTS IN ringAtengList 
        }

        // PASS TOKEN
        while(true){

        }


    }

}

