class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        var result = new ArrayList<Integer>();
        var ancestors = new HashSet<Integer>();
        var visited = new HashSet<Integer>();
        var edges = new HashMap<Integer, List<Integer>>();
        for(int[] preReq: prerequisites) {
            edges.computeIfAbsent(preReq[0], k -> new ArrayList<Integer>())
                .add(preReq[1]);        
        }

        for(int course=0; course<numCourses; course++) {
            if(isCyclePresent(course, edges, visited, ancestors, result))
                return new int[]{};
        }

        var output = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            output[i] =result.get(i);
        }
        return output;
    }

    boolean isCyclePresent(int course, Map<Integer, List<Integer>> edges, Set<Integer> visited, Set<Integer> ancestor, List<Integer> result) {
        if(ancestor.contains(course)) return true;
        if(visited.contains(course)) return false;

        ancestor.add(course);
        if(edges.containsKey(course)) {
            for(int dependantCourse: edges.get(course)) {
                if(isCyclePresent(dependantCourse, edges, visited, ancestor, result))
                    return true;
            }
        }
        
        ancestor.remove(course);
        visited.add(course);
        result.add(course);
        return false;
    }
}
