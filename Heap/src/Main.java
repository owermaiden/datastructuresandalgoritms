import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        System.out.println(heap);

        int[] numbers = {1,2,34,45,23};

        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
