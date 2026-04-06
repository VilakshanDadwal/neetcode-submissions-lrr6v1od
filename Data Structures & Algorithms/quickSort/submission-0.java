// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size()-1);
        return pairs;
    }

    private void quickSort(List<Pair> pairs, int start, int end) {
        // Return if one or no elements left
        if(end - start +1 <=1) return;
        var left = start;
        var pivot = end;
        for(int i=start; i<end; i++) {
            // If current element is less than pivot, swap element at left with current elemetn.
            if(pairs.get(i).key < pairs.get(pivot).key) {
                var temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left++;
            }
        }
        // Swap left and pivot
        var temp = pairs.get(left);
        pairs.set(left, pairs.get(pivot));
        pairs.set(pivot, temp);

        quickSort(pairs, start, left-1);

        quickSort(pairs, left+1, end);
    }
}
