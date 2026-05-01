// Without extra space
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var idx1 = m-1;
        var idx2 = n-1;
        var currentIdx = m+n-1;

        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] > nums2[idx2]) {
                nums1[currentIdx--] = nums1[idx1--];
            } else {
                nums1[currentIdx--] = nums2[idx2--];
            }
        }
        // This section can be removed because , if num1 element lefts, they are already in their sorted position.
        // Becasue once nums2 exhausts, all the remaining nums1 elements , would be in their correct possition from starting of array.
        // while (idx1 >= 0) {
        //     nums1[currentIdx--] = nums1[idx1--];
        // }

        while (idx2 >= 0) {
           nums1[currentIdx--] = nums2[idx2--];
        }
    }
}