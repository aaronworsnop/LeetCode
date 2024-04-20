class Logger {
  // stream of messages, along with timestamps
  // message printed if it has not been printed in the last 10 seconds

  // implement a couldPrintMessage() function given a message and a timestamp.
  // return if it can be printed

  // input: String message, int timestamp
  // output: boolean

  // message: ("ABC", 1) -> true
  // message: ("ABC", 2) -> false
  // message: ("BBB", 10) -> true
  // message: ("ABC", 12) -> true

  // HashMap to store messages, and their most recent timestamp.
  private Map<String, Integer> timestampMap;

  public Logger() {
    this.timestampMap = new HashMap<>();
  }

  public boolean couldPrintMessage(String message, int timestamp) {
    int previousTimestamp = timestampMap.getOrDefault(message, -1);

    if (previousTimestamp <= timestamp - 10 || previousTimestamp == -1) {
      timestampMap.put(message, timestamp);
      return true;
    }

    return false;
  }

  public void clearMessages() {
    this.timestampMap.clear();
  }
}
