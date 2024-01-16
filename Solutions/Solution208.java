class Trie {
  private Node root;

  public Trie() {
    this.root = new Node();
  }

  public void insert(String word) {
    Node current = root;

    for (int letter = 0; letter < word.length(); letter++) {
      if (!current.children.containsKey(word.charAt(letter))) {
        current.children.put(word.charAt(letter), new Node());
      }

      current = current.children.get(word.charAt(letter));
    }

    current.endOfWord = true;
  }

  public boolean search(String word) {
    Node current = root;

    for (int letter = 0; letter < word.length(); letter++) {
      if (!current.children.containsKey(word.charAt(letter))) return false;
      current = current.children.get(word.charAt(letter));
    }

    return current.endOfWord;
  }

  public boolean startsWith(String prefix) {
    Node current = root;

    for (int letter = 0; letter < prefix.length(); letter++) {
      if (!current.children.containsKey(prefix.charAt(letter))) return false;
      current = current.children.get(prefix.charAt(letter));
    }

    return true;
  }

  private class Node {
    public Map<Character, Node> children;
    public boolean endOfWord = false;

    public Node() {
      this.children = new HashMap<>();
    }
  }
}
