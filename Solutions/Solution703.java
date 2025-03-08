class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            pq.offer(num);
        }

        while (pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        if (pq.size() < k || pq.peek() < val) {
            pq.offer(val);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
