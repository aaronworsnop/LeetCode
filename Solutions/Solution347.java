import java.utils.HashMap;
import java.utils.Pair;

class Solution347 {
  public int[] topKFrequent(int[] nums, int k) {
    // Edgecase
    if (nums.length == 1) return new int[] {nums[0]};

    // Count number frequencies
    // Key: Number | Value: Frequency
    HashMap<Integer, Integer> numFrequencies = new HashMap<>();

    for (int numIndex = 0; numIndex < nums.length; numIndex++) {
      // TODO: Use x or default
      int num = nums[numIndex];
      if (numFrequencies.containsKey(num)) {
        int numFrequency = numFrequencies.get(num);
        numFrequencies.replace(num, numFrequency + 1);
      } else {
        numFrequencies.put(num, 1);
      }
    }

    // Max Heap priority queue
    // Key: Number | Value Frequency

    PriorityQueue<Pair<Integer, Integer>> maxHeap =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    for (Map.Entry<Integer, Integer> entry : numFrequencies.entrySet()) {
      maxHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
    }

    // Return the k most frequent elements

    int[] kMostFrequent = new int[k];

    for (int i = 0; i < k; i++) {
      kMostFrequent[i] = maxHeap.poll().getKey();
    }

    return kMostFrequent;
  }
}
