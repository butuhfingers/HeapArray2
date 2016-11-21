import java.util.Random;

/**
 * Created by derek on 11/16/16.
 */
import java.util.Timer;
public class Driver {
    public static void main(String[] args){
        for(int i = 0;i < 1;i++){
            RunHeap(10000000);
        }
    }

    public static void RunHeap(int heapSize){
        int heapMultiplier = 5;

        Heap<Integer> heap = new Heap<Integer>(heapSize);
        Random random = new Random();

        //Start the timer here
        long startTime = System.currentTimeMillis();

        for(int i = 0;i < heapSize;i++){
            int rand = random.nextInt(heapSize) * heapMultiplier + 1;

            //Add to the heap
            heap.Add(new Integer(rand));
        }
        if(heapSize < 21)
            heap.Display();

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(elapsedTime);

        heap.Poll();

        System.out.println(" ");

        if(heapSize < 21)
            heap.Display();
    }
}
