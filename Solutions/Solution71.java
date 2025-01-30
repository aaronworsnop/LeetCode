class Solution {
  public String simplifyPath(String path) {
    Deque<String> canonPath = new LinkedList<>();

    // Separate the path into each item
    String[] pathItems = path.split("/");
    for (String pathItem : pathItems) {
      if (pathItem.equals(""))
        continue;
      else if (pathItem.equals("."))
        continue;
      else if (pathItem.equals(".."))
        canonPath.pollFirst();
      else
        canonPath.offerFirst(pathItem);
    }

    // Build the canonical path
    StringBuilder pathBuilder = new StringBuilder();
    while (!canonPath.isEmpty()) {
      pathBuilder.append("/" + canonPath.pollLast());
    }

    return (pathBuilder.length() > 0) ? pathBuilder.toString() : "/";
  }
}