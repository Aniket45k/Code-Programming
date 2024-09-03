public class circularTour {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    public static int tour(int petrol[], int distance[]) {
        // Your code here
        int n = petrol.length;

        int start = 0;
        int rem = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            rem += (petrol[i] - distance[i]);

            if (rem < 0) {
                start = i + 1;
                deficit += rem;
                rem = 0;
            } 

        }
        if (rem + deficit >= 0)
            return start;
        return -1;
    }

    public static void main(String[] args) {

        // Example input arrays
        int[] petrol = { 4, 6, 7, 4 };
        int[] distance = { 6, 5, 3, 5 };

        // Calling the tour method and printing the result
        int startPoint = tour(petrol, distance);
        System.out.println("Starting point: " + startPoint);
    }
}
