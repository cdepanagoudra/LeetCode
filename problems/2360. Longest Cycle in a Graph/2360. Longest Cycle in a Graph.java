class Solution {
	int answer = -1;
	boolean[] visited;

	public int longestCycle(int[] edges) {
		int n = edges.length;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				Map<Integer, Integer> dist = new HashMap<>();
				dist.put(i, 1);
				dfs(dist, edges, i);
			}
		}
		return answer;
	}

	public void dfs(Map<Integer, Integer> dist, int[] edges, int node) {
		visited[node] = true;
		int neigbhour = edges[node];
		if (neigbhour != -1 && !visited[neigbhour]) {
			dist.put(neigbhour, dist.get(node) + 1);
			dfs(dist, edges, neigbhour);
		} else {
			if (neigbhour != -1 && dist.containsKey(neigbhour)) {
				answer = Math.max(answer, dist.get(node) - dist.get(neigbhour) + 1);
			}
		}
	}
}