class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        var idx1 = 0;
        var idx2 = 0;
        var idxCopy = 0;

        while (idxCopy < m && idx2 < n) {
            if (nums1Copy[idxCopy] < nums2[idx2]) {
                nums1[idx1++] = nums1Copy[idxCopy++];
            } else {
                nums1[idx1++] = nums2[idx2++];
            }
        }

        while (idxCopy < m) {
            nums1[idx1++] = nums1Copy[idxCopy++];
        }

        while (idx2 < n) {
            nums1[idx1++] = nums2[idx2++];
        }
    }
}