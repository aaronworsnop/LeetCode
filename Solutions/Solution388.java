class Solution {
  public int lengthLongestPath(String input) {
    int pathLength = 0;

    // There won't always be a file
    // All names will have non-zero lengths
    // Are we including the \n\t as length? No

    // dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext

    // dir
    // ⟶ subdir1
    // ⟶ ⟶ file1.ext
    // ⟶ ⟶ subsubdir1
    // ⟶ subdir2
    // ⟶ ⟶ subsubdir2
    // ⟶ ⟶ ⟶ file2.ext

    // currentDepth: 3
    // pathLength: 29
    // longestPathLength: 29
    // stack: (b) dir, subdir2, subsubdir2, file2.ext(t)

    // Never going to have 2 item on a line. \n... represents a new item
    // currentDepth: 1 (count the `\t`s)
    // if the next depth (number of `\t`s) is greater, we're in the previous path
    // if the next depth is less, we are in some other path, and we need to move up paths.

    // Use a stack to keep track of the current path. (always updating the pathLength, including
    // the `/`s with stack.size() - 1)
    //  Depth greater, push to stack
    //  Depth same, pop then push to stack
    //  Depth less, pop (previousDepth - currentDepth + 1) times, then push to stack

    // Update absolute file length with an integer. Only when we add to the stack, for effeciency.
    // Only update the longestPathLength when we find a file.

    // Testcases
    // "dir\n\tsubdir" | SUCCESS
    // fileSystem: ["dir", "\tsubdir"]
    // pathStack: (b) dir, subdir (t)
    // longestLength: 0, currentLength: 10, depth: 0, currentDepth: 1

    // "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1"
    // "" | SUCCESS

    // Edge and known cases
    if (input.length() == 0) {
      return 0;
    }

    int longestPathLength = 0;
    int currentPathLength = 0;
    int depth = 0;
    Stack<String> pathStack = new Stack<>();

    String[] fileSystem = input.split("\\n");

    // Determine the longest absolute path by considering all paths that lead
    // to files.
    for (int itemIndex = 0; itemIndex < fileSystem.length; itemIndex++) {
      String currentItem = fileSystem[itemIndex];

      int currentDepth = findDepth(currentItem);

      // Parse `currentItem` to only include the item (no `\t`s)
      currentItem = currentItem.substring(currentDepth, currentItem.length());

      // Move upwards in the file system the according number of times
      // before adding the new item to the path
      int moveUp = depth - currentDepth + 1;
      for (int count = 0; count < moveUp; count++) {
        if (pathStack.isEmpty()) {
          break;
        } else if (pathStack.size() > 1) {
          // Account for the '/' we remove
          currentPathLength--;
        }

        currentPathLength -= pathStack.pop().length();
      }

      // Add the new item to the path
      if (!pathStack.isEmpty()) {
        // Account for "/"
        currentPathLength++;
      }
      currentPathLength += (currentItem.length());
      pathStack.push(currentItem);

      // Consider a new greatest absolute path length if the item is a file
      if (isFile(currentItem)) {
        longestPathLength = Math.max(longestPathLength, currentPathLength);
      }

      depth = currentDepth;
    }

    return longestPathLength;
  }

  /** Find the depth of the item in the file system */
  private int findDepth(String item) {
    int depth = 0;

    int currentIndex = 0;
    while (currentIndex < item.length()) {
      if (item.charAt(currentIndex) == '\t') {
        depth++;
        currentIndex++;
      } else {
        break;
      }
    }

    return depth;
  }

  /** Determine whether an item in the file system is a file or not. */
  private boolean isFile(String item) {
    return (item.indexOf(".") != -1);
  }
}
