class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var edges = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<numCourses; i++) {
            edges.put(i, new ArrayList<Integer>());
        }

        for(int[] preRequisite: prerequisites) {
            int dependantCourse = preRequisite[0];
            int preRequisiteCourse = preRequisite[1];
            edges.get(dependantCourse).add(preRequisiteCourse);
        }

        for(int course=0; course<numCourses; course++) {
            if(isCyclePresent(course, edges, new HashSet<Integer>()))
                return false; // If cycle present, cannot complete.
        }
        return true;
    }

    boolean isCyclePresent(int course, Map<Integer, List<Integer>> edges, Set<Integer> ancestors) {
        // Cycle found
        if(ancestors.contains(course)) return true;
        // This course does not have any pre-requisites, means in can be finished.
        if(edges.get(course).isEmpty()) return false;

        ancestors.add(course);
        for(int preRequisiteCourse: edges.get(course)) {
            if(isCyclePresent(preRequisiteCourse, edges, ancestors))
                return true;
        }
        // Remove the ancestor when backtracking in the current path.
        ancestors.remove(course);
        // Remove when backtracking. This is so that next time this course is visited in some other path , its already verified that this course can be completed.        
        // Another way to do this is keep a visited array and mark it true for this course.
        edges.put(course, new ArrayList<Integer>());
        return false;
    }
}
