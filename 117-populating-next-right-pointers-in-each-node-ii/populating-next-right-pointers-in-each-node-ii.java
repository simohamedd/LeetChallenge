class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node current = root;
        
        while (current != null) {
            Node dummy = new Node(0);
            Node prev = dummy;
            
            while (current != null) {
                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }
                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }
                current = current.next;
            }
            
            current = dummy.next;
        }
        
        return root;
    }
}