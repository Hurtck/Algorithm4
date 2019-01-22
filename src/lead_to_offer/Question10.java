package lead_to_offer;

public class Question10 {
    public int minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0) return 0;
        int p1 = 0;
        int p2 = array.length-1;
        int midle = p1;
        while (array[p1]>=array[p2]){
            if(p2-p1==1){
                midle = p2;
                break;
            }
            midle = (p1+p2)/2;
            if(array[p1]==array[p2]&&array[p2]==array[midle]) return minValue(array,p1,p2);
            if(array[midle]>=array[p1]) p1 = midle;
            if(array[midle]<=array[p2]) p2 = midle;
        }
        return array[midle];
    }

    public int minValue(int [] array,int start,int end){
        int min = array[0];
        for (int i = start; i <= end; ++i) {
            if(array[i]<min) min = array[i];
        }
        return min;
    }

}
