import java.util.Random;

/**
 * Created by derek on 11/16/16.
 */
public class Driver {
    public static void main(String[] args){
        int heapSize = 20;
        int heapMultiplier = 5;

        Heap<Integer> heap = new Heap<Integer>(heapSize);
        Random random = new Random();

        for(int i = 0;i < heapSize;i++){
            int rand = random.nextInt(heapSize) * heapMultiplier + 1;

            //Add to the heap
            heap.Add(new Integer(rand));
        }

        heap.Display();
    }
}
