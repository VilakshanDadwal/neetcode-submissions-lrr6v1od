class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Comparator using key x^2 + y^2 for distance comparison.
        Comparator<int[]> distanceComparator = Comparator.comparingInt(
            point -> point[0]*point[0] + point[1]*point[1]);

        var maxHeap = new PriorityQueue<>(distanceComparator.reversed());

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
