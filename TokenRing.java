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

    private TokenRingAgent tokenRingID;
    public static Token token;
    // Array of TokenRingAgents
    public ArrayList<TokenRingAgent> ringAgentList;
    public boolean isActive;
    public static boolean flag;

    public TokenRing (int tokenID) {
        token = new Token(tokenID);
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

    // RING TOKEN'S MAIN PURPOSE
    // PASS THE TOKEN IN THE TOKEN RING
    public void run(){
        while (ringAgentList.size() != 10){
            // Yield until TokenRingAgents are in the ringAgentList
            // This is basically a nop
        }
        for(int i=0; i<10;i++){
            // If first agent in arraylist, predecessor is last agent
            if(i==0){
                ringAgentList.get(i).setPredID(ringAgentList.get(9).getPID());
                ringAgentList.get(i).setSuccID(ringAgentList.get(i+1).getPID());
            }
            // if last agent in arraylist, successor is first agent
            else if(i==9) {
                ringAgentList.get(i).setPredID(ringAgentList.get(i-1).getPID());
                ringAgentList.get(i).setSuccID(ringAgentList.get(0).getPID());
            }
            // else predecessor = i-1, successor = i+1
            else{
                ringAgentList.get(i).setPredID(ringAgentList.get(i-1).getPID());
                ringAgentList.get(i).setSuccID(ringAgentList.get(i+1).getPID());
            }
        }


        // PASS TOKEN 
        // The token gets passed by iterating through the arrayList

        while(flag){ 
            while(!dsmstore){}
            tokenRingID = ringAgentList.get(token.getID());
            tokenRingID.SendToken(token); 
            //token.setID(ringAgentList.get(tokenRingID.ringSuccID).ReceiveToken());
            
        }

        isActive = false;
        // stop all TokenRingAgents
        for(int j=0;j<10;j++){
            ringAgentList.get(j).setActive(isActive);
        }
    }
}

