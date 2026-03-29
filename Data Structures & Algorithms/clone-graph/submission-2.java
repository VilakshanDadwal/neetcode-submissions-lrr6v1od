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

class Solution {
    public Node cloneGraph(Node node) {
        var mapping = new HashMap<Node, Node>();
        return dfs(node, mapping);
    }

    Node dfs(Node originalNode, Map<Node, Node> mapping) {
        if(originalNode == null) return null;
        if(mapping.containsKey(originalNode)) return mapping.get(originalNode);

        Node newNode = new Node(originalNode.val);
        mapping.put(originalNode, newNode);

        for(Node originalNeighbours : originalNode.neighbors) {
            var newNeighbourNode = dfs(originalNeighbours, mapping);
            newNode.neighbors.add(newNeighbourNode);
        }
        return newNode;
    }
}