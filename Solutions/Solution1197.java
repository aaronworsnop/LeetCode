class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean visited[][] = new boolean[607][607];
        visited[302][302] = true;

        int moves = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();

                if (current[0] == x && current[1] == y) {
                    return moves;
                }

                for (int move = 0; move < 8; move++) {
                    int[] nextSquare = makeKnightMove(current[0], current[1], move);

                    // We only need to explore the upper-right quadrant
                    if (nextSquare[0] < -1 || nextSquare[1] < -1) continue; 

                    if (!visited[nextSquare[0] + 302][nextSquare[1] + 302]) {
                        visited[nextSquare[0] + 302][nextSquare[1] + 302] = true;
                        queue.offer(nextSquare);
                    }
                }
            }

            moves++;
        }

        return moves;
    }

    private int[] makeKnightMove(int x, int y, int move) {
        switch (move) {
            case 1:
                return new int[]{x + 2, y + 1};
            case 2:
                return new int[]{x + 2, y - 1};
            case 3:
                return new int[]{x + 1, y + 2};
            case 4:
                return new int[]{x - 1, y + 2};
            case 5:
                return new int[]{x - 2, y + 1};
            case 6:
                return new int[]{x - 2, y - 1};
            case 7:
                return new int[]{x + 1, y - 2};
            case 8:
                return new int[]{x - 1, y - 2};
            default:
                return new int[]{x, y};
        }
    }
}