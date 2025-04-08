class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                if (Math.abs(a - x) - Math.abs(b - x) == 0) {
                    // same distance
                    return a - b;
                } else {
                    return Math.abs(a - x) - Math.abs(b - x);
                }
            }
        );

        for (int num : arr) {
            pq.offer(num);
        }

        // Find the closest numbers that we need to consider
        int maxDistance = 0;
        List<Integer> closestElementsOfDistance = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int num = pq.poll();
            maxDistance = Math.max(maxDistance, Math.abs(num - x));
            closestElementsOfDistance.add(num);
        }

        Collections.sort(closestElementsOfDistance);
        return closestElementsOfDistance;
    }
}
