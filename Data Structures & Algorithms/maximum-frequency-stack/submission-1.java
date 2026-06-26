class FreqStack {
    private Map<Integer, Integer> valToFreq;
    private Map<Integer, Stack<Integer>> freqToElements;
    private int maxFreq;

    public FreqStack() {
        valToFreq = new HashMap<Integer, Integer>();
        freqToElements = new HashMap<Integer, Stack<Integer>>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        var freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        if(freq > maxFreq) {
            maxFreq = freq;
            // putIfAbsent is used here, because when popping , empty stacks are not being removed.
            freqToElements.putIfAbsent(freq, new Stack<Integer>());
        }
        freqToElements.get(freq).push(val);
    }
    
    public int pop() {
        // Pops the most recently added number in the maxFreq stack.
        // So even if multiple elements are there, the one at the top of the stack is returned.
        var element = freqToElements.get(maxFreq).pop();
        valToFreq.put(element, valToFreq.get(element) - 1);
        // There can be more than one elemnt with maxFreq.
        // If after popping, elements remain at maxFreq. then maxFreq  does not need to be updated.
        // If after popping, no element remains at maxFreq, then maxFreq needs to be reduced by 1.
        if(freqToElements.get(maxFreq).isEmpty())
            maxFreq--;
        return element;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */