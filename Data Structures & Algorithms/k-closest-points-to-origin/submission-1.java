class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Comparator using key x^2 + y^2 for distance comparison.
        var maxHeap = new PriorityQueue<int[]>(
                        (a,b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], 
                                                a[0]*a[0] + a[1]*a[1]));

        // Maintain maxHeap of size K
        for(int[] point: points) {
            maxHeap.add(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        var result = new int[k][2];
        for(int i=0; i<k;i++) {
            if(!maxHeap.isEmpty())
                result[i] = maxHeap.poll();
            else 
                break;
        }
        return result;
    }
}
