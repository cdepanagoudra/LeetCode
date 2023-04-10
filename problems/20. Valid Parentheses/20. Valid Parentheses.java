class Solution {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		Stack<Character> st = new Stack();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				st.push(s.charAt(i));
				continue;
			}

			if (st.size() == 0 || map.get(s.charAt(i)) != st.pop()) {
				return false;
			}

		}
		if (st.size() == 0) {
			return true;
		}
		return false;

	}
}