public class Utopia { // Method to calculate the cost for making city i reachable from any other city
    private static int getCost(int N, List<int[]> edges, int targetCity) {
        // Create adjacency list for the directed graph
        List<List<Integer>> adjList = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        // Helper function to perform BFS and check reachability
        boolean[] reachable = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(targetCity);
        reachable[targetCity] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (!reachable[neighbor]) {
                    reachable[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // Count how many cities are not reachable
        int unreachableCount = 0;
        for (int i = 1; i <= N; i++) {
            if (!reachable[i]) {
                unreachableCount++;
            }
        }

        // Return the number of changes needed to make targetCity reachable from all
        // cities
        return unreachableCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // Number of cities
        int M = scanner.nextInt(); // Number of edges
        int two = scanner.nextInt(); // Number of columns in Edges

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[] { u, v });
        }

        int totalCost = 0;

        // Calculate cost for each city
        for (int i = 1; i <= N; i++) {
            totalCost += getCost(N, edges, i);
        }

        System.out.println(totalCost);

        scanner.close();
    }
}