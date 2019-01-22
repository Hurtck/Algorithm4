package lead_to_offer;

/**
 * 青蛙跳台阶问题
 */
public class Question12 {
    public int JumpFloor(int target) {
        if(target<=2) return target;
        int result = 0;
        int last1 = 1;
        int last2 = 0;
        for(int i=2;i<=target; i++){
            result = last1 + last2;
            last2 = last1;
            last1 = result;
        }
        return result;
    }
}
