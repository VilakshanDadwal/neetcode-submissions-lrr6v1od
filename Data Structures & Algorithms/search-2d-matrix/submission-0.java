class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var rows = matrix.length;
        var cols = matrix[0].length;
        var top =0;
        var bottom = rows-1;

        // Eliminating rows using last number and first number of midRow.
        var rowFound = false;
        while(top <=bottom) {
            var midRow = (top+bottom)/2;
            if(target > matrix[midRow][cols-1]) {
                // If target > last number of mid row.
                top = midRow+1;
            } else if(target < matrix[midRow][0]){
                // If target < first number of midRow
                bottom = midRow-1;
            } else {
                // If target < last number and > first number of current row.
                // Its in the current midRow. 
                rowFound = true;
                break;
            }
        }

        if(!rowFound) return false;
        
        return binarySearch(matrix[(top+bottom)/2], target);
    
    }
    private boolean binarySearch(int[] nums, int target) {
        int left =0; int right = nums.length-1;
        while(left <=right) {
            int mid = (left+right)/2;
            if(target > nums[mid]) {
                left = mid+1;
            } else if(target < nums[mid]) {
                right = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
