
import java.util.concurrent.*;

/*
LocalMemory: this class represents the local replica. It has the following methods:
load(x): returns the value of x read from memory 
store(x,v): stores the value v of x to memory 
*/
public class LocalMemory{

    private ConcurrentHashMap<String, Integer> memory;
    public int memSize = 200;

    public LocalMemory(){
        memory = new ConcurrentHashMap<String, Integer>(memSize);
    }  
    public String load(int x){
        return this.memory.get(x);
    }

    public void store(String v, int x){
        this.memory.put(v, x);
    }
}