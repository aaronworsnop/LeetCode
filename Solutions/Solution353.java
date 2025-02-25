class SnakeGame {
    private int score;
    private int width;
    private int height;

    private LinkedList<int[]> snake;
    private Set<String> snakeSquares;

    private Queue<int[]> foodQueue;

    public SnakeGame(int width, int height, int[][] food) {
        // The snake starts on square 0, 0 with length 1
        this.snake = new LinkedList<>();
        this.snake.offerFirst(coordinate(0, 0));

        this.snakeSquares = new HashSet<>();
        this.snakeSquares.add(stringCoordinate(0, 0));

        // The initial score is zero
        this.score = 0;
        this.width = width;
        this.height = height;

        // Record the fruit positions
        this.foodQueue = new LinkedList<>();
        for (int[] coordinate : food) {
            this.foodQueue.offer(coordinate);
        }
    }
    
    public int move(String direction) throws IllegalArgumentException {
        int currentRow = snake.peekFirst()[0];
        int currentCol = snake.peekFirst()[1];
        
        // Move into next square
        switch (direction) {
            case "U":
                currentRow--;
                break;
            case "D":
                currentRow++;
                break;
            case "L":
                currentCol--;
                break;
            case "R":
                currentCol++;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction provided.");
        }

        int[] newHead = coordinate(currentRow, currentCol);

        // Check for food
        int[] foodSquare = !foodQueue.isEmpty() ? foodQueue.peek() : coordinate(-1, -1);
        if (Arrays.equals(newHead, foodSquare)) {
            // Snake grows
            foodQueue.poll();
            score++;
        } else {
            // Remove tail
            snakeSquares.remove(stringCoordinate(snake.pollLast()));
        }

        // Check for collision
        if (currentRow < 0 || currentRow >= height || currentCol < 0 || currentCol >= width || snakeSquares.contains(stringCoordinate(newHead))) {
            return -1;
        } else {
            snake.offerFirst(newHead);
            snakeSquares.add(stringCoordinate(newHead));
        }

        return score;
    }

    private int[] coordinate(int row, int col) {
        return new int[]{row, col};
    }

    private String stringCoordinate(int row, int col) {
        return row + "," + col;
    }

    private String stringCoordinate(int[] coordinate) {
        return coordinate[0] + "," + coordinate[1];
    }
}
