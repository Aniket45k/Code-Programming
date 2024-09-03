import java.util.*;

public class is_prime_Inrange {
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {//completely dividing
                return false;
            }
        }
        return true; 
    }
    public static void PrimeInRange(int n) {
       
        for (int i = 2; i <= n; i++) {
            if (isPrime(n)) {//completely dividing
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        PrimeInRange(20);
    }
}
