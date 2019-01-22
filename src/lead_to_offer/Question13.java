package lead_to_offer;

public class Question13 {
    public int JumpFloorII(int target) {
        if(target<0) return -1;
        if(target<=1) return 1;
        return  JumpFloorII(target-1)*2;
    }

    public static void main(String[] args) {
        int number = 2;
        System.out.println(2<<1);
    }
}
