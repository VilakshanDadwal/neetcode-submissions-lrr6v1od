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

        for(int course=0; course<numCourses; course++) {
            if(isCyclePresent(course, adjList, new HashSet<Integer>())){
                return false;
            }
        }
        return true;
    }

    private boolean isCyclePresent(int course, Map<Integer, List<Integer>> adjList, Set<Integer> ancestors) {
        if(ancestors.contains(course))
            return true;
        if(adjList.get(course).isEmpty())
            return false;
        ancestors.add(course);
        for(int dependantCourse: adjList.get(course)) {
            if(isCyclePresent(dependantCourse, adjList, ancestors)) {
                return true;
            }
        }
        ancestors.remove(course);
        adjList.put(course, new ArrayList<Integer>());
        return false;
    }
}
