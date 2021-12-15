import java.util.Arrays;

public class SortRunner {
    public static void main(String[] args) {
        int[] list = {1,3,5,6,2,7,9,};
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        //System.out.println(Arrays.toString(BubbleSort.bubbleSort(list)));
        //System.out.println(Arrays.toString(SelectionSort.selectionSort(list)));
        //System.out.println(Arrays.toString(InsertionSort.insertionSort(list)));
//        mergeSort.mergeSort(list);
//        System.out.println(Arrays.toString(list));
        quickSort.sort(list);
        System.out.println(Arrays.toString(list));

    }
}
