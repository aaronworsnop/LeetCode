class Solution2942 {
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> indices = new LinkedList<>();
    for (int word = 0; word < words.length; word++) {
      if (words[word].indexOf(x) != -1) {
        indices.add(word);
      }
    }
    return indices;
  }
}
