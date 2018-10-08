
public class Short {

    public static void main(String[] args) {
        int a[] = {8,48,2,3,4,91,8,1,2,8};
        mergeShort(a,0,a.length-1);
        for(int i:a){
            System.out.println(i);
        }
    }


    private static void mergeShort(int[] a,int lo,int hi){
        if(hi<=lo) return;
        int mid = (lo+hi)/2;
        mergeShort(a,lo,mid);
        mergeShort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    private static void merge(int[] a,int lo,int mid,int hi){
        int[] ar = new int[hi-lo+1];
        int i = lo ,j = mid+1;
        for(int k =0;k<=hi-lo;k++){
            ar[k] = a[lo+k];
        }
        for(int k = lo;k<=hi;k++){
            if(i>mid){a[k] = ar[j-lo]; j++;}
            else if(j>hi){a[k]=ar[i-lo];i++;}
            else if(ar[i-lo]<ar[j-lo]){a[k] = ar[i-lo];i++;}
            else{a[k] = ar[j-lo];j++;}
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
