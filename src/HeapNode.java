/**
 * Created by derek on 11/16/16.
 */
public class HeapNode<T> {
    //Variables
    private T item;
    private int heapIndex;

    //Properties
    public T Item(){
        return this.item;
    }

    public void HeapIndex(int value){
        heapIndex = value;
    }
    public int HeapIndex(){
        return heapIndex;
    }

    //Constructors
    public HeapNode(T item){
        this.item = item;
    }
}
