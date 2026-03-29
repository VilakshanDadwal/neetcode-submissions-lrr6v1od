// Quick Select solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }

    private int quickSelect(int[] nums, int leftIdx, int rightIdx, int kIdx) {
        var pivot = nums[rightIdx];
        // pivot index which would eventually be the final position of pivot element.
        int pIdx = leftIdx;
        for(int i=leftIdx; i<rightIdx; i++) {
            if(nums[i] <= pivot) {
                swap(nums, i, pIdx);
                pIdx++; // Increment pivot index till now.
            }
        }
        swap(nums, pIdx, rightIdx); // Put pivot element in its correct position.

        if(pIdx > kIdx) {
            return quickSelect(nums, leftIdx, pIdx-1, kIdx);
        } else if(pIdx < kIdx) {
            return quickSelect(nums, pIdx+1, rightIdx, kIdx);
        } else {
            return nums[pIdx];
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
