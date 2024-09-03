import java.util.*;

public class towerOfHanoi {
    public static void TOH(int n, String src, String helper, String dest) {

        if (n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        TOH(n - 1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        TOH(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        int n = 3;
        TOH(n, "S", "H", "D");
    }

}
