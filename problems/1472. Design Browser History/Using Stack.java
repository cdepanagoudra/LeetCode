class BrowserHistory {
	Stack<String> history = new Stack<>();
	Stack<String> forward = new Stack<>();

	public BrowserHistory(String homepage) {
		history.add(homepage);
		forward.clear();
	}

	public void visit(String url) {
		history.add(url);
		forward.clear();
	}

	public String back(int steps) {
		while (steps > 0 && history.size() > 1) {
			forward.add(history.pop());
			steps--;
		}
		return history.peek();
	}

	public String forward(int steps) {
		while (steps > 0 && forward.size() > 0) {
			history.add(forward.pop());
			steps--;
		}
		return history.peek();
	}
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage); obj.visit(url); String
 * param_2 = obj.back(steps); String param_3 = obj.forward(steps);
 */