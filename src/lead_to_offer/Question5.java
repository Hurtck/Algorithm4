package lead_to_offer;

/**
 * 两个有序数组A、b，A数组的空间足够容纳A、B请将B数组插入A
 */
public class Question5 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,0,0,0,0,0};
        int[] b = {2,3,4,5,9};
        reorderArray(a,b,6);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    private static String replaceBlank(String input){
        if (input == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<input.length();i++){
            if(input.charAt(i) == ' ') stringBuilder.append("%20");
            else stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

    private static void reorderArray(int[] a, int[] b, int aLength){
        if(a==null||b==null)
            return;
        int i = aLength-1;
        int j = b.length-1;
        int tail = a.length-1;
        while (tail>0){
            if(a[i]>b[j]){
                a[tail] = a[i];
                tail--;
                i--;
            }else if(a[i]<b[j]){
                a[tail] = b[j];
                tail--;
                j--;
            }else{
                a[tail] = a[i];
                tail--;
                i--;
                a[tail] = b[j];
                tail--;
                j--;
            }
        }
    }
}
