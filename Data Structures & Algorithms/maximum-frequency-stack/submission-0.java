class FreqStack {
    private Queue<Info> maxHeap;
    private Map<Integer, Integer> freqCount;
    private int idx;

    public FreqStack() {
        maxHeap = new PriorityQueue<Info>((a,b) -> {
            var count = Integer.compare(b.freq, a.freq);
            return count != 0 ? count : Integer.compare(b.idx, a.idx);
        });
        freqCount = new HashMap<Integer, Integer>();
        idx = 0;
    }
    
    public void push(int val) {
        freqCount.put(val, freqCount.getOrDefault(val, 0) + 1);
        maxHeap.add(new Info(idx++, freqCount.get(val), val));
    }
    
    public int pop() {
        var top = maxHeap.poll();
        freqCount.put(top.val, freqCount.get(top.val) - 1);
        return top.val;
    }

    private class Info {
        int val;
        int freq;
        int idx;

        Info(int idx, int freq, int val) {
            this.idx = idx;
            this.freq = freq;
            this.val = val;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */