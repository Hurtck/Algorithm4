package lead_to_offer;

public class Question15 {
    public double Power(double base, int exponent) {
        if(Double.compare(base,0.0)==0) return 0;
        double result = 1.0;
        for (int i = 0; i <Math.abs(exponent); i++) {
            result *= base;
        }
        if(exponent<0) result = 1.0/result;
        return result;
    }
}
