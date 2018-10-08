public class MergeSort {
    public void sort(int[] a, int lo,int hi){
        if (lo<=hi) return;
        int mid = (lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    private void merge(int[] a, int lo, int mid,int hi) {
        int[] au = new int[a.length];
        int l = lo;
        int h = mid;
        for(int i = 0;i<a.length;i++){
            au[i] =au[i];
        }
        for(int i = 0;i<a.length;i++){
            if(l==mid){a[i] = au[h];h++;}
            else if(h == hi+1){a[i] = au[l];l++;}
            else if(au[l]>au[h]) {a[i]=au[h];h++;}
            else if(au[h]>au[l]) {a[i]=au[l];l++;}
        }
    }
}
