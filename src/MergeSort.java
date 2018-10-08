public class MergeSort {
    public static void main(String[] args) {
        int a[] = {8,48,2,3,4,91,8,1,2,8};
        sort(a,0,a.length-1);
        for(int i:a){
            System.out.println(i);
        }
    }
    public static void sort(int[] a, int lo,int hi){
        if (hi<=lo) return;
        int mid = (lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    private static void merge(int[] a, int lo, int mid,int hi) {
        int[] au = new int[hi-lo+1];

        int l = lo;
        int h = mid+1;
        for(int i = lo;i<=hi;i++){
            au[i-lo] =a[i];
        }
        for(int i = lo;i<=hi;i++){
            if(l > mid){a[i] = au[h-lo];h++;}
            else if(h > hi){a[i] = au[l-lo];l++;}
            else if(au[l-lo]>au[h-lo]) {a[i]=au[h-lo];h++;}
            else {a[i]=au[l-lo];l++;}
        }
    }
}
