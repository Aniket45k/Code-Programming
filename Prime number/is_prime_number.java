import java.util.*;

public class is_prime_number {
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {//completely dividing
                return false;
            }
        }
        return true; 
    }

    public static void main(String args[]) {
        isPrime(9);
    }
}
