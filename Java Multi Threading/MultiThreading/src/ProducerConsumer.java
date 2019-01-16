import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer extends Thread{
    BlockingQueue<String> queue;
    public int limit = 6;
    Producer(BlockingQueue<String> q){
        queue=q;
    }
    public void run(){
        for(int i=1;i<=20;i++){
            String s="Packet->"+i;
            try{
            	if(queue.size() == limit) {
            		System.out.println("Size of the Queue: " + queue.size());
            		Thread.sleep(2000);
            	}
            	 queue.put(s); 
                 System.out.println("Produced: " + s);
                 Thread.sleep(1000); 
            }
            catch(Exception e){
            	e.getStackTrace();
            }
        }      
    }

}
class Consumer extends Thread{
    BlockingQueue<String> queue;
    Consumer( BlockingQueue<String> q){
        queue=q;
    }
    public void run(){
        while(true){
            try{ 
            	Thread.sleep(3000);
            	String s=queue.take();
                System.out.println("Consumed: " + s);
            }
            catch(Exception e){
            	e.getStackTrace();
            }
        }
    }

}
public class ProducerConsumer{
    public static void main(String args[]){
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(6);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
    }
}