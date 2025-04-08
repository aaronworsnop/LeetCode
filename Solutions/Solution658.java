class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            int numLeft = arr[left];
            int numRight = arr[right];
            int leftDist = Math.abs(numLeft - x);
            int rightDist = Math.abs(numRight - x);

            if (leftDist < rightDist) right--;
            else if (rightDist < leftDist) left++;
            else right--;
        }

        List<Integer> closestElements = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            closestElements.add(arr[i]);
        }

        return closestElements;
    }
}
