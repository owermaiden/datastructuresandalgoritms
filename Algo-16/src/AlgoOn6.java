public class AlgoOn6 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {22,23,24,45,66,77,88};
        System.out.println(findMedian(arr1, arr2));

    }

    static double findMedian(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int halfSize = (m+n)/2;
        int biggerSizedArray = Math.max(m,n);
        int smallerSizedArray = Math.min(m,n);

        if(isNotMerge(arr1,arr2)){
            return findMedian(arr2, arr1, n, m, halfSize, biggerSizedArray, smallerSizedArray);
        } else if(isNotMerge(arr2,arr1)){
            return findMedian(arr1, arr2, n, m, halfSize, biggerSizedArray, smallerSizedArray);
        }


        return 1.3;


    }

    private static double findMedian(int[] arr1, int[] arr2, int n, int m, int halfSize, int biggerSizedArray, int smallerSizedArray) {
        if (m==n) return (arr2[n-1] + arr1[0])/2.0;
        if (isEven(arr2,arr1)) return arr2.length == biggerSizedArray ? ((arr2[halfSize - 1] + arr2[halfSize]) / 2.0) : (arr1[(halfSize - 1)-smallerSizedArray] + arr1[((halfSize - 1)-smallerSizedArray) + 1]) / 2.0;
                               return arr2.length == biggerSizedArray ? arr2[(m+n)/2] : arr1[((m+n)/2)-smallerSizedArray];
    }

    static boolean isNotMerge(int[] arr1, int[] arr2){
        return arr1[arr1.length-1] <= arr2[0];
    }

    static boolean isEven(int[] arr1, int[] arr2){
        return (arr1.length + arr2.length)%2 == 0;
    }


}
