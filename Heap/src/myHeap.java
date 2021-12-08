import java.util.ArrayList;
import java.util.List;

public class myHeap {
    private final int[] heap = new int[20];
    private int size;
    private int parent (int index){return (index-1)/2;}
    private boolean isFull(){return size== heap.length;}

    public void insert(int value){
        if(isFull())throw new IllegalStateException();
        heap[size++] = value;
        bubbleUp();


    }

    public void bubbleUp(){
        int index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]){
            swap(index, parent(index));
        }
    }

    private void swap(int first, int second){
        var temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        for (int i : heap ) list.add(i);

        return list.toString();
    }
}
