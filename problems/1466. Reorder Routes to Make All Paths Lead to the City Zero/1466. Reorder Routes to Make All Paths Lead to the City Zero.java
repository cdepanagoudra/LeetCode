class Solution {
	List<Integer>[] incomeing, outgoing;
	HashSet<Integer> visited;
	int ans;

	public int minReorder(int n, int[][] conn) {
		ans = 0;
		incomeing = new ArrayList[n];
		outgoing = new ArrayList[n];
		visited = new HashSet();
		for (int i = 0; i < n; i++) {
			incomeing[i] = new ArrayList();
			outgoing[i] = new ArrayList();
		}
		for (int[] con : conn) {
			incomeing[con[1]].add(con[0]);
			outgoing[con[0]].add(con[1]);
		}

		dfs(0);
		return ans;
	}

	public void dfs(int v) {
		visited.add(v);
		for (int i : incomeing[v]) {
			if (!visited.contains(i)) {
				dfs(i);
			}

		}
		for (int i : outgoing[v]) {
			if (!visited.contains(i)) {
				ans++;
				dfs(i);
			}

		}

	}
}