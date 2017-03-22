
import java.util.concurrent.*;

/*
LocalMemory: this class represents the local replica. It has the following methods:
load(x): returns the value of x read from memory 
store(x,v): stores the value v of x to memory 
*/
public class LocalMemory{

    private ConcurrentHashMap<String, Integer> memory;

    public LocalMemory(int size){
        memory = new ConcurrentHashMap<String, Integer>(size);
    }  
    public String load(int x){
        return this.memory.get(x);
    }

    public void store(String v, int x){
        this.memory.put(v, x);
    }
}