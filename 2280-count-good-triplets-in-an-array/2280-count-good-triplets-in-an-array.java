class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        
        // Map values in nums2 to their positions
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        // Map nums1 to indices from nums2
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        long[] leftSmaller = new long[n];
        FenwickTree leftBIT = new FenwickTree(n);
        
        // Count how many elements are smaller to the left
        for (int i = 0; i < n; i++) {
            leftSmaller[i] = leftBIT.query(mapped[i] - 1);
            leftBIT.update(mapped[i], 1);
        }

        long[] rightLarger = new long[n];
        FenwickTree rightBIT = new FenwickTree(n);
        
        // Count how many elements are larger to the right
        for (int i = n - 1; i >= 0; i--) {
            rightLarger[i] = rightBIT.query(n - 1) - rightBIT.query(mapped[i]);
            rightBIT.update(mapped[i], 1);
        }

        // Final count: for each index, multiply left * right
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += leftSmaller[i] * rightLarger[i];
        }

        return count;
    }

    // Fenwick Tree (1-based indexing internally)
    class FenwickTree {
        long[] tree;
        int size;

        public FenwickTree(int n) {
            size = n + 2;
            tree = new long[size];
        }

        void update(int index, long value) {
            index++;
            while (index < size) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long query(int index) {
            index++;
            long result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}
