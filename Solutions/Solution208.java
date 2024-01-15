class Trie {
  private Node root;

  public Trie() {
    this.root = new Node();
  }

  public void insert(String word) {
    int currentCharacter = 0;

    Node currentNode = root;
    while (currentCharacter < word.length()
        && !currentNode.next.isEmpty()
        && currentNode.next.containsKey(word.charAt(currentCharacter))) {
      currentNode = currentNode.next.get(word.charAt(currentCharacter));
      currentCharacter++;
    }

    while (currentCharacter < word.length()) {
      currentNode.addNext(word.charAt(currentCharacter));
      currentNode = currentNode.next.get(word.charAt(currentCharacter));
      currentCharacter++;
    }

    currentNode.addNext(';');
  }

  public boolean search(String word) {
    int currentCharacter = 0;

    Node currentNode = root;
    while (currentCharacter < word.length()) {
      if (!currentNode.next.containsKey(word.charAt(currentCharacter))) return false;
      currentNode = currentNode.next.get(word.charAt(currentCharacter));
      currentCharacter++;
    }

    if (currentCharacter == word.length() && currentNode.next.containsKey(';')) return true;
    else return false;
  }

  public boolean startsWith(String prefix) {
    int currentCharacter = 0;

    Node currentNode = root;
    while (currentCharacter < prefix.length()) {
      if (!currentNode.next.containsKey(prefix.charAt(currentCharacter))) return false;
      currentNode = currentNode.next.get(prefix.charAt(currentCharacter));
      currentCharacter++;
    }

    return true;
  }

  private class Node {
    public char letter;
    public Map<Character, Node> next;

    public Node() {
      this.next = new HashMap<Character, Node>();
    }

    public Node(char letter) {
      this.letter = letter;
    }

    public void addNext(char letter) {
      Node newNode = new Node(letter);
      if (this.next == null) this.next = new HashMap<Character, Node>();
      next.put(letter, newNode);
    }
  }
}
