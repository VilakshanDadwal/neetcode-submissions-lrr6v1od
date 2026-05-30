class FirstUnique {

    private Map<Integer, Integer> numFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqNums;

    public FirstUnique(int[] nums) {
        numFreq = new HashMap<Integer, Integer>();
        freqNums = new HashMap<Integer, LinkedHashSet<Integer>>();
        for(int num: nums) 
            add(num);
    }
    
    public int showFirstUnique() {
        if(!freqNums.containsKey(1)) return -1;
        return freqNums.get(1).iterator().next();
    }
    
    public void add(int value) {
        var oldFreq = numFreq.getOrDefault(value, 0);
        numFreq.put(value, oldFreq + 1);
        var newFreq = numFreq.get(value);

        if(oldFreq !=0) freqNums.get(oldFreq).remove(value);
        if(freqNums.containsKey(oldFreq) && freqNums.get(oldFreq).size() == 0) freqNums.remove(oldFreq);
        freqNums.computeIfAbsent(newFreq, k -> new LinkedHashSet<Integer>())
                    .add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
