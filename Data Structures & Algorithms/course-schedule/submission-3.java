// Revision
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adjList = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<numCourses; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        for(int[] preReq: prerequisites) {
            adjList.get(preReq[0]).add(preReq[1]);
        }
        var visited = new HashSet<Integer>();
        for(int course=0; course<numCourses; course++) {
            if(isCyclePresent(course, adjList, new HashSet<Integer>(), visited)){
                return false;
            }
        }
        return true;
    }

    private boolean isCyclePresent(int course, Map<Integer, List<Integer>> adjList, Set<Integer> ancestors, Set<Integer> visited) {
        if(visited.contains(course)) return false;
        if(ancestors.contains(course)) return true;
        // No need to check for empty neighbours, empty dependant course will get marked visited in the end of this function.
        ancestors.add(course);
        for(int dependantCourse: adjList.get(course)) {
            // no need to check visited here as well, becasue in the recursive call, visited is the first thing thats checked.
            if(isCyclePresent(dependantCourse, adjList, ancestors, visited)) {
                return true;
            }
        }
        ancestors.remove(course);
        visited.add(course); //Mark visited, only when all dependant courses have been visited
        return false;
    }
}
