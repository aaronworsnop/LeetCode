class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Coordinate> obstacleCoordinates = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleCoordinates.add(new Coordinate(obstacle[0], obstacle[1]));
        }

        int maxDistance = 0;
        Coordinate robot = new Coordinate(0, 0);

        int direction = 0; // NESW = 0123
        for (int command : commands) {
            switch (command) {
                case -2:
                {
                    // Turn left
                    direction = turnLeft(direction);
                }
                    break;
                case -1:
                {
                    // Turn right
                    direction = turnRight(direction);
                }
                    break;
                default:
                {
                    // Attempt to move forwards
                    for (int step = 0; step < command; step++) {
                        Coordinate nextCoordinate = moveForward(robot, direction);
                        if (!obstacleCoordinates.contains(nextCoordinate)) {
                            robot = nextCoordinate;
                            maxDistance = Math.max(maxDistance, getDistance(robot));
                        } else {
                            break;
                        }
                    }
                }
                    break;
            }
        }

        return maxDistance;
    }

    private Coordinate moveForward(Coordinate position, int direction) {
        switch (direction) {
            case 0:
                // North
                position = new Coordinate(position.x, position.y + 1);
                break;
            case 1:
                // East
                position = new Coordinate(position.x + 1, position.y);
                break;
            case 2:
                // South
                position = new Coordinate(position.x, position.y - 1);
                break;
            case 3:
                // West
                position = new Coordinate(position.x - 1, position.y);
                break;
            default:
                // Don't move, invalid direction
                break;
        }

        return position;
    }

    private int turnLeft(int direction) {
        if (direction == 0) return 3;
        else return direction - 1;
    }

    private int turnRight(int direction) {
        return (direction + 1) % 4;
    }

    private int getDistance(Coordinate coordinate) {
        return (int) (Math.pow(coordinate.x, 2) + Math.pow(coordinate.y, 2));
    }

    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }

            Coordinate otherCoordinate = (Coordinate) obj;
            return otherCoordinate.x == x && otherCoordinate.y == y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
}