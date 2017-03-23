public class Main{

    public static void main(String[] args){

        LocalMemory lm = new LocalMemory();
        
        BroadcastAgent ba = new BroadcastAgent();
        DSM dsm = new DSM(lm, ba);

        Processor processor = new Processor(dsm);
        


    }
}