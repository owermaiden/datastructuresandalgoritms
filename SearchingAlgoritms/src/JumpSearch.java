public class JumpSearch {
    public static int jumpSearch(int[] array,int data){
        int blockSize=(int) Math.sqrt(array.length);
        int start= 0;
        int next=blockSize;
        while (start<array.length && array[next-1]<data){   // jump blocksize every time...
            start=next;
            next+=blockSize;
            if (next>array.length) next=array.length;   // we added this line in order not to get array out of bound exeption...
        }
        for (int i = start; i < next; i++) { if (array[i]==data) return i;  // make linear search once we find the true block...
        }
        return -1;
    }
}
