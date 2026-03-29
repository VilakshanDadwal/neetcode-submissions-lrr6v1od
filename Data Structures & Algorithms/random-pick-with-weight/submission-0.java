class Solution {

    List<Integer> bucket = new ArrayList<>();
    Random random = new Random();

    public Solution(int[] w) {

        for (int i = 0; i < w.length; i++) {

            for (int j = 0; j < w[i]; j++) {
                bucket.add(i);
            }
        }
    }

    public int pickIndex() {

        int randomIndex = random.nextInt(bucket.size());

        return bucket.get(randomIndex);
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */