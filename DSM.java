import java.util.concurrent.*;

public class DSM{
    LocalMemory readLocalMem = new LocalMemory();
    public int load (String x){
        return this.readLocalMem.get(x);
    }
    public int store(v,x){
        this.readLocalMem.put(v,x);
        // Do broadcast stuff
    }
}