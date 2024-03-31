class Solution71 {
  public String simplifyPath(String path) {
    // Path must start with "/"
    // Path should not end with "/"
    // "." refers to current directory
    // ".." refers to the level above

    // Stack: (b)  (t)

    // /home/user/aaron/./trash/..

    // FIXING PATH (treat deque like a stack)
    // (b) home, user, aaron (t)
    // Directory ->
    // "." ignore
    // ".." -> pop from the Deque

    // BUILD PATH (treat deque like a queue)
    // Build our string
    // Doubly linked list

    // Tests
    // /home/user/aaron/./trash
    // /home////trash
    // home
    // home/aaron/trash/..
    // home/
    // //

    // Edgecases
    if (path == null || path.length() == 0) {
      return "/";
    }

    // Parse original path
    String[] originalPath = path.split("/");
    if (originalPath == null || originalPath.length == 0) {
      return "/";
    }

    Deque<String> newPath = new ArrayDeque<>();
    for (String element : originalPath) {
      if (element.equals(".") || element.equals("")) {
        // Ignore
        continue;
      } else if (element.equals("..")) {
        // Consolidate useless
        newPath.pollFirst();
      } else {
        // Path
        newPath.offerFirst(element);
      }
    }

    // Build path
    StringBuilder builder = new StringBuilder();
    while (!newPath.isEmpty()) {
      builder.append("/").append(newPath.pollLast());
    }

    if (builder.isEmpty()) {
      return "/";
    } else {
      return builder.toString();
    }
  }
}
