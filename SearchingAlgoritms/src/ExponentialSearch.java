public class ExponentialSearch {
    public static int exponentialSearch(int[] array, int data){
        int bound=1;
        while(bound<array.length && array[bound]<data) bound*=2;
        int left = bound/2;                          // we have already checked our data is bigger than bound/2
        int right = Math.min(bound,array.length-1);  // if we reach end then take last element...
        return BinarySearchRecursive.binarySearchRec(array,data,left,right); // after finding the right place (block) we started binary search
    }
}
