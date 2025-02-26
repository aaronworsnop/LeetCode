class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node('.', false);
    }
    
    public void addWord(String word) {
        Node current = root;

        for (char c : word.toCharArray()) {
            if (!current.containsNext(c)) {
                current.addNext(new Node(c, false));
            }
            
            current = current.getNext(c);
        }

        current.isEnd = true;
    }
    
    public boolean search(String word) {
        Node current = root;
        return search(word, current);
    }

    private boolean search(String word, Node current) {
        for (int index = 0; index < word.length(); index++) {
            char c = word.charAt(index);

            if (c == '.') {
                // Wildcard
                String restOfWord = word.substring(index + 1, word.length());
                boolean matchesWildcard = false;

                for (Node node : current.nextCharacters.values()) {
                    if (search(restOfWord, node)) {
                        matchesWildcard = true;
                        break;
                    }
                }

                return matchesWildcard;
            } else if (current.containsNext(c)) {
                // Matching letter
                current = current.getNext(c);
            } else {
                // No wildcards or matching letters
                return false;
            }
        }

        return current.isEnd;
    }

    class Node {
        char character;
        boolean isEnd;
        Map<Character, Node> nextCharacters;

        Node(char character, boolean isEnd) {
            this.character = character;
            this.isEnd = isEnd;
            this.nextCharacters = new HashMap<>();
        }

        Node getNext(char character) {
            return nextCharacters.get(character);
        }

        void addNext(Node node) {
            nextCharacters.put(node.character, node);
        }

        boolean containsNext(char character) {
            return nextCharacters.containsKey(character);
        }
    }
}
