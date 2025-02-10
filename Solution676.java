class MagicDictionary {
    private Node head;

    public MagicDictionary() {
        this.head = new Node('\0');
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Node current = head;
            int index = 0;

            while (index < word.length()) {
                char currentCharacter = word.charAt(index++);

                if (!current.nextLetters.containsKey(currentCharacter)) {
                    current.nextLetters.put(currentCharacter, new Node(currentCharacter));
                } 

                current = current.nextLetters.get(currentCharacter);
            }

            current.nextLetters.put('.', new Node('.'));
        }
    }
    
    public boolean search(String searchWord) {
        return traverseWord(searchWord, 0, head, 1);
    }

    private boolean traverseWord(String word, int index, Node current, int wildcards) {
        Map<Character, Node> nextLetters = current.nextLetters;
        
        if (index == word.length()) {
            return nextLetters.containsKey('.') && wildcards == 0;
        }

        for (Map.Entry<Character, Node> entry : nextLetters.entrySet()) {
            if (entry.getKey() == word.charAt(index)) {
                if (traverseWord(word, index + 1, entry.getValue(), wildcards)) return true;
            } else {
                if (traverseWord(word, index + 1, entry.getValue(), wildcards - 1)) return true;
            }
        }

        return false;
    }

    class Node {
        char letter; // '.' denotes the end of a word
        Map<Character, Node> nextLetters;

        Node() {
            this.nextLetters = new HashMap<>();
        }

        Node(char letter) {
            this.letter = letter;
            this.nextLetters = new HashMap<>();
        }

        Node(char letter, Map<Character, Node> nextLetters) {
            this.letter = letter;
            this.nextLetters = nextLetters;
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */