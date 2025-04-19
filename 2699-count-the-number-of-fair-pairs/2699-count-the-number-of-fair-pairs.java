import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Sort is needed for two-pointer logic
        long count = 0;

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int low = lower - nums[i];
            int high = upper - nums[i];

            // Find how many nums[j] with j > i that satisfy:
            // nums[i] + nums[j] ∈ [lower, upper]
            int start = lowerBound(nums, left, n - 1, low);
            int end = upperBound(nums, left, n - 1, high);
            if (start <= end) {
                count += end - start + 1;
            }
        }
        return count;
    }

    // Find first index >= target
    private int lowerBound(int[] nums, int left, int right, int target) {
        int res = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    // Find last index <= target
    private int upperBound(int[] nums, int left, int right, int target) {
        int res = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
