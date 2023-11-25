import java.util.LinkedList;
import java.util.List;

public class Solution271 {
  private static final String DELIMITER = "#";

  public String encode(List<String> strs) {
    // Seperate each word by DELIMITER + the number of characters in the word
    StringBuilder sb = new StringBuilder();

    for (String str : strs) {
      sb.append(str.length() + DELIMITER + str);
    }

    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> strs = new LinkedList<>();
    int currentCharacter = 0;

    // Seperate words using delimiters
    while (currentCharacter < str.length()) {
      // Find out how long the next word is
      int lastStrLengthIndex = currentCharacter;
      while (!String.valueOf(str.charAt(lastStrLengthIndex)).equals(DELIMITER)) {
        lastStrLengthIndex++;
      }

      int strLength = Integer.valueOf(str.substring(currentCharacter, lastStrLengthIndex));
      strs.add(str.substring(lastStrLengthIndex + 1, lastStrLengthIndex + 1 + strLength));

      currentCharacter = lastStrLengthIndex + 1 + strLength;
    }

    return strs;
  }
}
