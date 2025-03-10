class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>( 
            (a, b) -> 
            (int) Math.abs(Math.pow(a[0], 2) + Math.pow(a[1], 2)) -
            (int) Math.abs(Math.pow(b[0], 2) + Math.pow(b[1], 2))
        );

        for (int[] point : points) {
            minHeap.offer(point);
        }

        int[][] closest = new int[k][2];
        for (int i = 0; i < k; i++) {
            closest[i] = minHeap.poll();
        }
        
        return closest;
    }
}
