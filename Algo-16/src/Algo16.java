public class Algo16 {
    public static void main(String[] args) {
        int[] array1={1,3};
        int[] array2={2};
        System.out.println(findMedianOfTwoSortedArrays(array1,array2));
    }

    public static double findMedianOfTwoSortedArrays(int[] arr1, int[] arr2) {
        if(arr1.length>arr2.length){
            return findMedianOfTwoSortedArrays(arr2,arr1);
        }
        int low=0;
        int high= arr1.length;
        int lengthArr1=arr1.length;
        int lengthArr2=arr2.length;

        while (low<=high){
            int partArr1=(low+high)/2;
            int partArr2=(lengthArr1+lengthArr2+1)/2- partArr1;
            int maxOfleftArr1;
            int minOfRightArr1;
            int maxOfleftArr2;
            int minOfRightArr2;
            if (partArr1==0)  maxOfleftArr1 = Integer.MIN_VALUE;
            else  maxOfleftArr1=arr1[partArr1-1];

            if (partArr1==arr1.length) minOfRightArr1=Integer.MAX_VALUE;
            else minOfRightArr1=arr1[partArr1];

            if (partArr2==0)  maxOfleftArr2 = Integer.MIN_VALUE;
            else  maxOfleftArr2=arr2[partArr2-1];

            if (partArr2==arr2.length) minOfRightArr2=Integer.MAX_VALUE;
            else minOfRightArr2=arr2[partArr2];

            if (maxOfleftArr1<=minOfRightArr2 && maxOfleftArr2<=minOfRightArr1) {
                if((lengthArr1+lengthArr2) % 2==0){
                    return((double) (Math.max(maxOfleftArr1,maxOfleftArr2)+Math.min(minOfRightArr1,minOfRightArr2))/2);
                } else
                    return ((double) Math.max(maxOfleftArr1,maxOfleftArr2));
            } else if (maxOfleftArr1>minOfRightArr2) {high=partArr1-1;}
            else {
                low=partArr1+1;
            }

        }
        return -1;
    }
}