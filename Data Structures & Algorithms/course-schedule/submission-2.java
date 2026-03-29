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
        if(visited.contains(course))
            return false;
        if(ancestors.contains(course))
            return true;
        if(adjList.get(course).isEmpty())
            return false;

        ancestors.add(course);
        for(int dependantCourse: adjList.get(course)) {
            if(!visited.contains(dependantCourse) && isCyclePresent(dependantCourse, adjList, ancestors, visited)) {
                return true;
            }
        }
        ancestors.remove(course);
        visited.add(course); //Mark visited, only when all dependant courses have been visited
        return false;
    }
}
