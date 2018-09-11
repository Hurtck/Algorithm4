import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class LCS {
//    求最长公共子序列
    public static void main(String[] args) {
        lcs("BDCABA","ABCBDAB");
    }

    public static void lcs(String a,String b){
        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();
        int[][] matrix = new int[strA.length+1][strB.length+1];
        for(int i=0; i<strA.length+1; i++){//行号
            for(int j=0; j<strB.length+1;j++){//列号
                if(i==0 || j==0){
                    matrix[i][j] = 0;
                }else if (strA[i-1] == strB[j-1]){
                    matrix[i][j] =matrix[i-1][j-1] + 1;
                }else{
                    matrix[i][j] = max(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]);
                }
            }
        }
        for(int i=0; i<strA.length+1; i++){
            for(int j=0; j<strB.length+1;j++){
                print(matrix[i][j]);
                print(' ');
            }
            println();
        }

    }
    public static int max(int a, int b, int c){
        int max = a;
        if (b>max){
            max=b;
        }
        if (c>max){
            max=c;
        }
        return max;
    }
}
