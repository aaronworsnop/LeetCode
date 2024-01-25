class Trie {
  private Node root;

  public Trie() {
    this.root = new Node();
  }

  public void insert(String word) {
    Node current = root;

    for (int letter = 0; letter < word.length(); letter++) {
      if (current.children[word.charAt(letter) - 'a'] == null) {
        current.children[word.charAt(letter) - 'a'] = new Node();
      }

      current = current.children[word.charAt(letter) - 'a'];
    }

    current.endOfWord = true;
  }

  public boolean search(String word) {
    Node current = root;

    for (int letter = 0; letter < word.length(); letter++) {
      if (current.children[word.charAt(letter) - 'a'] == null) return false;
      current = current.children[word.charAt(letter) - 'a'];
    }

    return current.endOfWord;
  }

  public boolean startsWith(String prefix) {
    Node current = root;

    for (int letter = 0; letter < prefix.length(); letter++) {
      if (current.children[prefix.charAt(letter) - 'a'] == null) return false;
      current = current.children[prefix.charAt(letter) - 'a'];
    }

    return true;
  }

  private class Node {
    public Node[] children = new Node[26];
    public boolean endOfWord = false;
  }
}
