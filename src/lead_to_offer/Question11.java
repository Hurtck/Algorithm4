package lead_to_offer;

public class Question11 {
    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int result = 0;
        int last1 = 1;
        int last2 = 0;
        for(int i=2;i<=n; i++){
            result = last1 + last2;
            last2 = last1;
            last1 = result;
        }
        return result;
    }
}
