import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
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
    //-----------------------------------------------Interview------------------------------------------------------

    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (var i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length &&
                array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length &&
                array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (var number : array)
            heap.insert(number);

        for (var i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

    // -----------------------------------------------HELPER---------------------------------------------------------

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++){list.add(heap[i]);}
        return list.toString();
    }
}
