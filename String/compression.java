import java.util.*;

public class compression {
    public static StringBuilder Compress(String str) {
        StringBuilder sb = new StringBuilder("");
        //String newStr = "";
        // aaabc
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb;
    }
    public static void main(String[] args) {
        String str = "abs";
        System.out.println(Compress(str));
    }

}
//Time complexity is O(n);
//While loop do same as for loop increment i upto n
