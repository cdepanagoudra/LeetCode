class TrieNode {
	boolean isEndOfWord;
	TrieNode[] children;

	public TrieNode() {
		isEndOfWord = false;
		children = new TrieNode[26];
	}
}

class Trie {
	TrieNode root;

	public Trie() {

		root = new TrieNode();

	}

	public void insert(String word) {
		TrieNode curNode = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (curNode.children[index] == null) {
				curNode.children[index] = new TrieNode();
			}
			curNode = curNode.children[index];
		}
		curNode.isEndOfWord = true;
	}

	public boolean search(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (curNode.children[cur - 'a'] == null)
				return false;
			curNode = curNode.children[cur - 'a'];
		}
		return curNode.isEndOfWord;

	}

	public boolean startsWith(String prefix) {
		TrieNode curNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			char cur = prefix.charAt(i);
			if (curNode.children[cur - 'a'] == null)
				return false;
			curNode = curNode.children[cur - 'a'];
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */