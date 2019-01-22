package lead_to_offer;

public class Question0_2 {
    public static String replaceSpace(StringBuffer str) {
        if(str==null) return null;
        int newIndex = str.length()-1;
        int resultLenth = str.length();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)==' ') resultLenth+=2;
        }
        str.setLength(resultLenth);
        for(int i = resultLenth-1;i>0&&i>newIndex;newIndex--){
            if(str.charAt(newIndex)==' '){
                str.setCharAt(i--,'0');
                str.setCharAt(i--,'2');
                str.setCharAt(i--,'%');
            }else{
                str.setCharAt(i--,str.charAt(newIndex));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
}
