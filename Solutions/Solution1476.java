class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                this.rectangle[row][col] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }
}
