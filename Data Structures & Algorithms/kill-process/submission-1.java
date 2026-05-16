class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        var result = new ArrayList<Integer>();
        var children = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<ppid.size(); i++) {
            children.computeIfAbsent(ppid.get(i), k ->new ArrayList<Integer>())
                .add(pid.get(i));
        }
        var queue = new LinkedList<Integer>();
        queue.add(kill);
        while(!queue.isEmpty()) {
            var id = queue.poll();
            result.add(id);
            if(!children.containsKey(id)) continue;

            for(int child : children.get(id)) {
                queue.add(child);
            }
        }

        return result;
    }
}
