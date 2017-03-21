
import java.util.concurrent.*;

/*
LocalMemory: this class represents the local replica. It has the following methods:
load(x): returns the value of x read from memory 
store(x,v): stores the value v of x to memory 
*/

public class LocalMemory{

    ConcurrentHashMap(String, Integer) readValue = new ConcurrentHashMap<>();    
    public int load(String x){
        return this.readValue.get(x);
    }

    public int store(String v, int x){
        this.readValue.put(v, x);
    }
}