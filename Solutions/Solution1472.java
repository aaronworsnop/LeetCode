class BrowserHistory {
    // History
    //    _
    // A, E
    // ^

    private ArrayList<String> history;
    private int currentIndex;
    private int lastValidIndex;

    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        this.currentIndex = -1;
        this.lastValidIndex = -1;
        visit(homepage);
    }
    
    public void visit(String url) {
        currentIndex++;
        history.add(currentIndex, url);
        lastValidIndex = currentIndex;
    }
    
    public String back(int steps) {
        int backPosition = currentIndex - steps;
        currentIndex = Math.max(0, backPosition);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        int forwardPosition = currentIndex + steps;
        currentIndex = Math.min(lastValidIndex, forwardPosition);
        return history.get(currentIndex);
    }
}
