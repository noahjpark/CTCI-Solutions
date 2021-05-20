/* Noah Park

Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    // One pass solution maintaining both the previous node and the largest node. (largest is because when the dfs ends, prev will be the smallest and we must create the final cycle).
    // Time: O(n) to iterate over the tree single pass.
    // Space: O(h) height of the tree for the recursion.
    Node prev = null, largest = null;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        
        dfs(root);
        
        // Create circular list
        prev.left = largest;
        largest.right = prev;
        
        return prev;
    }
    
    public void print(Node n) {
        Node c;
        for (c = n; c.right != null; c = c.right)
            System.out.print(c.val + " ");
        System.out.print(c.val + " " + c.right);
        System.out.println();
        for (; c.left != null; c = c.left)
            System.out.print(c.val + " ");
        System.out.print(c.val + " " + c.left);
        System.out.println();
    }
    
    public void dfs(Node root) {
        if (root == null) return;
        
        dfs(root.right);
        if (largest == null) largest = root;
        root.right = prev;
        if (prev != null) prev.left = root;
        prev = root;
        dfs(root.left);
    }
}
