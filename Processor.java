
/**
 * name
 */
public class Processor implements Runnable{

    private DSM dsm;

<<<<<<< HEAD
    public Processor(int size){

        dsm = new DSM(size);
=======
    public Processor(DSM dsm){
        this.dsm = dsm;
>>>>>>> origin/master
    }
    
    public void run(){

    }
}