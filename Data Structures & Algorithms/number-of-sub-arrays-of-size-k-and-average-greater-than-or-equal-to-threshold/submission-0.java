class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        var left = 0;
        var subArrayCount =0;
        var sum = 0;
        for(int right=0; right<arr.length; right++) {
            if(right - left + 1 > k) {
                sum -= arr[left];
                left++;
            }
            sum += arr[right];
            if(right - left + 1 == k && sum/k >= threshold) subArrayCount++;
        }
        return subArrayCount;
    }
}