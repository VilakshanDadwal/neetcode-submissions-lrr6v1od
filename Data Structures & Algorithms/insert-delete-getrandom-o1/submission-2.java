class RandomizedSet {
    private Map<Integer, Integer> numIdx;
    private List<Integer> nums;
    private Random random;

    public RandomizedSet() {
        numIdx = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(numIdx.containsKey(val)) return false;
        numIdx.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!numIdx.containsKey(val)) return false;
        var idxToRemove = numIdx.get(val);
        var lastNum = nums.get(nums.size()-1);
        nums.set(idxToRemove, lastNum);
        numIdx.put(lastNum, idxToRemove);

        nums.remove(nums.size()-1);
        numIdx.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */