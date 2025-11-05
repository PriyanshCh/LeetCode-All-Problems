class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node head = root;
        
        while (head != null) {
            Node dummy = new Node(0);
            Node curr = dummy;
            
            while (head != null) {
                if (head.left != null) {
                    curr.next = head.left;
                    curr = curr.next;
                }
                if (head.right != null) {
                    curr.next = head.right;
                    curr = curr.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}
