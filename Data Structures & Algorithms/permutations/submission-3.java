// Revision Recursive solution
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var current = new ArrayList<Integer>();
        var numList = new ArrayList<Integer>();
        Arrays
            .stream(nums)
            .forEach(num -> numList.add(num));

        permutate(current, numList, result);
        return result;
    }

    // No need for index as param , because all indexes in the current numList are traversed in a for loop.
    // this is not a take/not take scenario.
    private void permutate(List<Integer> current, List<Integer> numList, List<List<Integer>> result) {
        if(numList.isEmpty()) {
            // New list not created because a new arrayList is bein created for every recursive call.
            result.add(current);
            return;
        }

        for(int i=0; i<numList.size(); i++) {
            var newCurrent = new ArrayList<Integer>(current);
            var newNumList = new ArrayList<Integer>(numList);
            newCurrent.add(numList.get(i));
            newNumList.remove(i);
            permutate(newCurrent, newNumList, result);
        }
    }
}
