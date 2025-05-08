class Logger {
  private Map<String, Integer> messageMap;

  public Logger() {
      this.messageMap = new HashMap<>();
  }
  
  public boolean shouldPrintMessage(int timestamp, String message) {
      int messageTimestamp = messageMap.getOrDefault(message, Integer.MIN_VALUE);

      if (messageTimestamp < timestamp - 9) {
          messageMap.put(message, timestamp);
          return true;
      } else {
          return false;
      }
  }
}
