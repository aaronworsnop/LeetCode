class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> indices = new LinkedList<>();
    for (int word = 0; word < words.length; word++) {
      for (int i = 0; i < words[word].length(); i++) {
        if (words[word].charAt(i) == x) {
          indices.add(word);
          break;
        }
      }
    }
    return indices;
  }
}
