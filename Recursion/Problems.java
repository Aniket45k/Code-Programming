public class Problems {

    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fnm1 = fact(n - 1);
        int fn = n * fact(n - 1);
        return fn;
    }

    public static int calcSum(int n) {
        if (n == 1) {
            return 1;
        }
        int Snm1 = calcSum(n - 1);
        int Sn = n + Snm1;
        return Sn;

    }

    // calculate the nth term in fibonacci
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);
        int fn = fnm1 + fnm2;
        return fn;

    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr1[], int key, int i) {
        if (i == arr1.length) {
            return -1;
        }
        if (arr1[i] == key) {
            return i;
        }
        return firstOccurence(arr1, key, i + 1);
    }

    public static int lastOccurence(int arr1[], int key, int i) {
        if (i == arr1.length) {
            return -1;
        }
        int isFound = lastOccurence(arr1, key, i + 1);
        // check with self
        if (isFound == -1 && arr1[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        // int xnm1 = power(x, n - 1);
        // int xn = x * xnm1;
        // return xn;

        return x * power(x, n - 1);
    }

    public static int optimizedPower(int a, int n) {//O(logn)
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(a, n / 2);
        int halfPowerSq = halfPower * halfPower;
        // n is odd
        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String[] args) {
        printDec(10);
        printInc(10);
        System.out.println();
        System.out.println(fact(5));
        System.out.println(calcSum(5));
        System.out.println(fib(26));
        int arr[] = { 1, 2, 7, 4, 5 };
        System.out.println(isSorted(arr, 0));
        int arr1[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println(firstOccurence(arr1, 5, 0));
        System.out.println(lastOccurence(arr1, 5, 0));
        System.out.println(power(2, 5));
        System.out.println(optimizedPower(2, 6));
    }
}
