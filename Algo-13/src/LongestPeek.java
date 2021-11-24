public class LongestPeek {
    public static void main(String[] args) {

    }
    static int findTheLongestPeak(int[] arr){
        int lb=0,ub=0,peak=0,distance=0;

        while(ub<arr.length){

            if(ub == arr.length-1){
                if(ub != peak) distance = Math.max(distance,ub-lb+1);
                break;
            }
            if(arr[ub+1]>arr[ub]) {
                if(ub!=peak){
                    distance = Math.max(distance,ub-lb+1);
                    peak = lb = ub;
                } else peak = ++ub;

            }else if(arr[ub+1]<arr[ub]){
                if(ub != lb) ub++;
                else peak = lb = ++ub;

            }else{
                if(ub != peak) distance = Math.max(distance,ub-lb+1);
                peak = lb = ++ub;
            }
        }
        return distance;
    }
}
