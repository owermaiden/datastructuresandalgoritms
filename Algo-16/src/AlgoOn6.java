public class AlgoOn6 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {9,45,66,77,88,99,100};
        System.out.println(findMedian(arr1, arr2));
    }

    static double findMedian(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int halfSizeOfSum = (m+n)/2;
        int biggerSizedArrayLength = Math.max(m,n);
        int smallerSizedArrayLength = Math.min(m,n);

        /* ----------------------------------------------------- Under Construction-----------------------------------
        if (m==0 || n==0){
            if(isEven(biggerSizedArrayLength)) return;
        }
        */

        // --------------------------------------------- NOT MERGED -- O(1) not merged--------------------------------
        if (isNotMerge(arr1,arr2)){
            return findNotMergedMedian(arr2, arr1, n, m, halfSizeOfSum, biggerSizedArrayLength, smallerSizedArrayLength);
        } else if(isNotMerge(arr2,arr1)){
            return findNotMergedMedian(arr1, arr2, n, m, halfSizeOfSum, biggerSizedArrayLength, smallerSizedArrayLength);
        }

        // --------------------------------------------- MERGED -- O(n * log n+m) not merged-------------------------------

        AvlTree tree = new AvlTree();                           // O(n * log n+m) insertion
        tree.insert(arr1);
        tree.insert(arr2);

        return tree.getMedian();                                // O(log n)

        // ------------------------------------------- HELPER METHODS -------------------------------------------------
    }

    private static double findNotMergedMedian(int[] arr1, int[] arr2, int n, int m, int halfSize, int biggerSizedArray, int smallerSizedArray) {
        if (m==n) return (arr2[n-1] + arr1[0])/2.0;
        if (isEven(arr2,arr1)) return arr2.length == biggerSizedArray ?
                                                     ((arr2[halfSize - 1] + arr2[halfSize]) / 2.0) :
                                                     (arr1[(halfSize - 1)-smallerSizedArray] + arr1[((halfSize - 1)-smallerSizedArray) + 1]) / 2.0;
                               return arr2.length == biggerSizedArray ?
                                                     arr2[(m+n)/2] :
                                                     arr1[((m+n)/2)-smallerSizedArray];
    }

    static boolean isNotMerge(int[] arr1, int[] arr2){
        return arr1[arr1.length-1] <= arr2[0];
    }

    static boolean isEven(int[] arr1, int[] arr2){
        return (arr1.length + arr2.length)%2 == 0;
    }

    static boolean isEven(int arrLength){
        return arrLength % 2 == 0;
    }

}
