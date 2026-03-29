class TimeMap {
    private Map<String, List<ValueInfo>> store;

    public TimeMap() {
       store = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<ValueInfo>())
            .add(new ValueInfo(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        var values = store.get(key);
        if(values == null || values.isEmpty()) return "";

        var left =0; var right = values.size()-1;
        var result = "";
        while(left <= right) {
            var mid = (left+right)/2;
            if(values.get(mid).timestamp <= timestamp) {
                // there can be many values <= timestamp. Need to find the rightmost such timestamp.
                // Thus when such a value found, make that the result and then move right.
                result = values.get(mid).value;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return result;
    }

    static class ValueInfo {
        String value;
        int timestamp;
        ValueInfo(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
