package lead_to_offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Question22 {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = new int[][]{{},{}};
        System.out.println(new Question22().printMatrix(matrix).toString());
    }

    /**
     * 按照 向左走到底--》 向下走到底-》 向右走到底-》 向上走到底的顺序访问数组，
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix.length==0) return result;
        int i=0,j=0;
        int direction = 1;
        HashSet set = new HashSet<String>();
        while (true){
            if(direction==1){
                if(j<matrix[0].length&&!set.contains(i+""+j)){
                    result.add(matrix[i][j]);
                    set.add(i+""+j);
                    j++;
                }else{
                    j--;
                    i++;
                    direction=2;
                }
            }
            if(direction==2){
                if(i<matrix.length&&!set.contains(i+""+j)){
                    result.add(matrix[i][j]);
                    set.add(i+""+j);
                    i++;
                }else{
                    i--;
                    j--;
                    direction=3;
                }
            }
            if(direction==3){
                if(j>=0&&!set.contains(i+""+j)){
                    result.add(matrix[i][j]);
                    set.add(i+""+j);
                    j--;
                }else{
                    j++;
                    i--;
                    direction=4;
                }
            }
            if(direction==4){
                if(i>=0&&!set.contains(i+""+j)){
                    result.add(matrix[i][j]);
                    set.add(i+""+j);
                    i--;
                }else{
                    i++;
                    j++;
                    direction=5;
                }
            }
            if(direction==5) direction=1;
            if(set.size()==matrix.length*matrix[0].length)return result;
        }
    }
}
