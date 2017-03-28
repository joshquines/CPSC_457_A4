/**
 * QueueItem class
 * 
 * Used for BroadcastSystem queue
 */
public class QueueItem{
    public String key;
    public int value;
  
    public QueueItem(String key, int value){
        this.key = key;
        this.value = value;
    }
    
    public void setKey(String key){
        this.key = key;
    }
    
    public String getKey(){
        return key;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
}