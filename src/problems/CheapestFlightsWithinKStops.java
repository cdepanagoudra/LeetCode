package problems;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] f : flights){
            graph.put(f[0], graph.getOrDefault(f[0], new HashMap<>()));
            graph.put(f[1], graph.getOrDefault(f[1], new HashMap<>()));
            graph.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, k+1});
        while(!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city == dst) return price;
            if(stops > 0) {
                Map<Integer, Integer> adj = graph.get(city);
                for(int a : adj.keySet()){
                    pq.add(new int[]{price+adj.get(a), a, stops-1});
                }
            }
        }
        return -1;
        System.out.println("Hii cheta");
    }
}
