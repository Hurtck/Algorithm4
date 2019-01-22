package lead_to_offer;

public class Question0_1 {
    public boolean Find(int target, int [][] array) {
        if(array == null) return false;
        int x_index = array.length-1;
        int y_index = 0;
        while (x_index>=0&&y_index<array[0].length){
            if(array[x_index][y_index] == target) return true;
            else if(array[x_index][y_index] > target) x_index--;
            else y_index++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9},{17,18,19}};
        System.out.println(a.length);
        System.out.println(a[0].length);
        System.out.println(a[1][2]);
    }
}
