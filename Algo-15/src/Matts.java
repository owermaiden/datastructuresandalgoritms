import java.util.Arrays;

public class Matts {
    public static void main(String[] args) {

    }

    static int[] findTheUnsortedPart(int[] arr){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] result = {-1,-1};

        for(int i = 0;i< arr.length;i++){
            int j = arr.length-1-i;

            if(i != arr.length-1 && arr[i+1]<arr[i]) max = Math.max(arr[i],max );
            if(j != 0 && arr[j-1]>arr[j]) min = Math.min(arr[j],min);

            if( arr[i]<=max) result[1] = i;
            if( arr[j]>=min) result[0] = j;
        }
        return result;
    }

    static int[] findTheUnsortedPart2(int[] arr){
        int i = 0,j = arr.length-1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] result = {-1,-1};

        while(i< arr.length){

            if(i != arr.length-1 && arr[i+1]<arr[i]) max = Math.max(arr[i],max );
            if(j != 0 && arr[j-1]>arr[j]) min = Math.min(arr[j],min);

            if( arr[i++]<=max) result[1] = i-1;
            if( arr[j--]>=min) result[0] = j+1;
        }
        return result;
    }

    static int[] findTheUnsortedPartWithSort(int[] arr){
        int[] sorted = Arrays.copyOf(arr,arr.length);
        int[] result = {-1,-1};
        int left=-1, right= arr.length;
        Arrays.sort(sorted);

        for(int i=0;i< arr.length;i++){

            int j= arr.length-1-i;
            if(left == -1 && sorted[i]!=arr[i]) result[0]=left=i;
            if(right == arr.length && sorted[j]!=arr[j]) result[1]=right=j;
        }

        return result;
    }
}
