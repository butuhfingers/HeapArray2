import java.util.Arrays;

/**
 * Created by derek on 11/16/16.
 */
public class Heap<T extends Comparable<T>> {
    //Variables
    HeapNode<T>[] items;
    int heapCount;

    //Properties
    private HeapNode<T> LeftChild(HeapNode<T> node){
        if(((node.HeapIndex() * 2) + 1) > items.length)
            return null;

        return items[(int)(node.HeapIndex() * 2) + 1];
    }
    private int LeftChildIndex(HeapNode<T> node){
        if(((node.HeapIndex() * 2) + 1) > items.length)
            return -1;

        return (int)(node.HeapIndex() * 2) + 1;
    }
    private HeapNode<T> RightChild(HeapNode<T> node){
        if(((node.HeapIndex() * 2) + 2) > items.length)
            return null;

        return items[(int)(node.HeapIndex() * 2) + 2];
    }
    private int RightChildIndex(HeapNode<T> node){
        if(((node.HeapIndex() * 2) + 2) > items.length)
            return -1;

        return (int)(node.HeapIndex() * 2) + 2;
    }
    private HeapNode<T> Parent(HeapNode<T> node){
        return items[(int)(node.HeapIndex() - 1) / 2];
    }
    private int ParentIndex(HeapNode<T> node){
        return (int)(node.HeapIndex() - 1) / 2;
    }

    //Constructors
    public Heap(int maxHeapSize){
        items = new HeapNode[maxHeapSize];
    }

    //Functions and Methods
    private HeapNode CreateNode(T item){
        return new HeapNode<T>(item);
    }

    public void Poll(){
        //Remove the top element
        Remove(items[0]);
    }

    private void Remove(HeapNode<T> nodeToRemove){
        HeapNode<T> bottomNode = items[heapCount - 1];

        Swap(nodeToRemove, bottomNode);

        nodeToRemove = null;
        heapCount--;

        SortDown(bottomNode);
        SortUp(bottomNode);
    }

    public void Add(T item){
        if(heapCount >= items.length)
            items = GrowArray(items);

        //Create a new node and add it
        HeapNode<T> node = CreateNode(item);
        items[heapCount] = node;
        node.HeapIndex(heapCount);


        heapCount++;

        SortUp(node);
    }

    public boolean Contains(){
        return false;
    }

    private void SortUp(HeapNode<T> item){
        //Sort the item up
        //Get its parent
        while(true){
            HeapNode<T> parentItem = this.Parent(item);

            //Is our parent item less than our current item?
            if(parentItem.Item().compareTo(item.Item()) < 0){
                //Swap
                Swap(parentItem, item);
            }else{
                return;
            }
        }
    }

    private void SortDown(HeapNode<T> item){
        //Sort the item down
        //Get its parents
        while(true){
            int swapIndex = -1;

            //Check if we have a left child
            if(LeftChild(item) != null){
                swapIndex = LeftChildIndex(item);

                if(RightChild(item) != null){
                    if(RightChild(item).Item().compareTo(LeftChild(item).Item()) > 0){
                        swapIndex = RightChildIndex(item);
                    }
                }
                //We have no left child, we are the leaf node, exit

                Swap(item, items[swapIndex]);
            }else{
                return;
            }
        }
    }

    private void Swap(HeapNode<T> itemA, HeapNode<T> itemB){
        //Reverse the items
        items[itemA.HeapIndex()] = itemB;
        items[itemB.HeapIndex()] = itemA;

        //Int B index
        int itemBIndex = itemB.HeapIndex();
        itemB.HeapIndex(itemA.HeapIndex());
        itemA.HeapIndex(itemBIndex);
    }

    public void Display(){
        for(int i = 0; i < heapCount;i++){
            HeapNode<T> item = items[i];
            System.out.println("Current Node: " + item.Item().toString() + " --- Parent Node:" + Parent(item).Item().toString());
        }
    }

    private HeapNode<T>[] GrowArray(HeapNode<T>[] arrayToGrow){
        HeapNode<T>[] newItems = new HeapNode[arrayToGrow.length * 2];

        newItems = Arrays.copyOf(arrayToGrow, arrayToGrow.length);

        return newItems;
    }
}
