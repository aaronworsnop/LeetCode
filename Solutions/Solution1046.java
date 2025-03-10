class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() > 1) {
            int remainingStone = Math.abs(pq.poll() - pq.poll());
            
            if (remainingStone != 0) {
                pq.offer(remainingStone);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
