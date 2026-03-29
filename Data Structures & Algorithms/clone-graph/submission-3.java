/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// Iterative DFS solution
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        // Create clone of the start node
        map.put(node, new Node(node.val));
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            // Visit neighbors
            for (Node nei : curr.neighbors) {
                if (!map.containsKey(nei)) {
                    // Create clone when first discovered
                    map.put(nei, new Node(nei.val));
                    stack.push(nei);
                }
                // Link clone of curr to clone of nei
                map.get(curr).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
}