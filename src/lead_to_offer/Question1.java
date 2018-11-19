package lead_to_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题描述：如何在n-1个数中找出其中所有重复的数
 */

public class Question1 {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1,0};
        System.out.println(compareFind(a));
    }
    public static void sort(int[] a, int lo, int hi){
        if(a==null) return;
        if (lo>=hi) return ;
        int mid = partition(a,lo,hi);
        sort(a,lo,mid -1);
        sort(a,mid+1,hi);
    }

    public static int partition(int[] a,int left,int right){
        int i = left;
        int j = right;
        int t = a[left];
        while(i<=j){
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
   //方法一，先排序(快排)，然后再找 时间复杂度O(nlgn) 空间复杂度O(lgn)
    public static void sortAndFind(int[] a){
        sort(a,0,a.length-1);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

        boolean isRepet = false;
        for(int i = 1;i<a.length;i++){
            if(!isRepet&&a[i] == a[i-1]){
                System.out.println(a[i]);
                isRepet = true;
            }
            if(a[i]!=a[i-1]){
                isRepet = false;
            }
        }
    }
    //方法二：使用集合 时间复杂度O(n) 空间复杂度O(n)
    public static void setFind(int[] a){
        if (a == null) return;
        Set set = new HashSet<Integer>();
        Set hasPrint = new HashSet<Integer>();
        for(int i=0;i<a.length;i++){
            if(!set.contains(a[i])){
                set.add(a[i]);
            }else {
                if(!hasPrint.contains(a[i]))
                    System.out.println(a[i]);
                    hasPrint.add(a[i]);
            }
        }
    }
    //方法三：使用比较法 时间复杂度O(n) 空间复杂度O(1)
    public static boolean compareFind(int[] a){
        for(int i = 0;i<a.length;i++){
            while (a[i] != i){
                if(a[i] == a[a[i]]) return true;
                int temp = a[i];
                a[i] = a[temp];
                a[temp] = temp;
            }
        }
        return false;
    }

}
