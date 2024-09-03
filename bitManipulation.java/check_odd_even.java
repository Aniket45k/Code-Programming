import java.util.*;

public class check_odd_even {
    public static void oddOrEven(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 1) {
            System.out.println("odd number");
        } else {
            System.out.println("even number");
        }
    }
    public static void main(String[] args) {
        oddOrEven(4);
        oddOrEven(3);
        oddOrEven(11);
    }
}
