class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closestElements = new LinkedList<>();
        if (arr.length == k) {
            for (int num : arr) {
                closestElements.add(num);
            }
            return closestElements;
        } 

        // Binary search to find the element closest to x
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < x) left = mid + 1;
            else right = mid;
        }

        // Find the correct window
        left--;
        right = left + 1;
        
        while (right - left <= k) {
            if (left < 0) {
                right++;
                continue;
            }

            if (right >= arr.length) {
                left--;
                continue;
            }

            int leftDist = Math.abs(arr[left] - x);
            int rightDist = Math.abs(arr[right] - x);
            
            if (rightDist < leftDist) right++;
            else left--;
        }

        for (int i = left + 1; i < right; i++) {
            closestElements.add(arr[i]);
        }

        return closestElements;
    }
}
