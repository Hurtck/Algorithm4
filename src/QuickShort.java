import static edu.princeton.cs.algs4.StdOut.print;

public class QuickShort {

    public static void main(String[] args) {
        //9,6,8,1,9,2,7,6,4
        //4,6,8,1,9,2,7,6,9
        //8,2,1,4,9,6,7,6,9
        //7,2,1,4,6,6,8,9,9
        //6,2,1,4,6,7,8,9,9
        int a[] = {8,48,2,3,4,91,8,1,2,8};
        quickShort(0,a.length-1,a);
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }

    private static void quickShort(int left, int right, int[] a){
        if (left>=right){
            return;
        }
        int mid = part(left,right,a);
        quickShort(left, mid-1, a);
        quickShort(mid+1,right,a);

    }

    private static int part(int left, int right, int[] a) {
        int i = left;
        int j = right;
        int t = a[left];
        while(i<j){
            while (a[j]>=t&&j>left){
                j--;
            }
            while (a[i]<=t&&i<right){
                i++;
            }
            if(i>=j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[j];
        a[j] = a[left];
        a[left] =temp;

        return j;
    }
}
