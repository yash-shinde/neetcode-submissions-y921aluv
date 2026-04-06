/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //1. create a map of og node to copy node
        //2 use the map to update pointers
        Node temp = head;
        Node copy = null;
        Map<Node,Node> map = new HashMap<Node,Node>();
        while(temp!=null){
            copy = new Node(temp.val);
            map.put(temp,copy);
            temp = temp.next;
        }

        temp = head;
        while(temp!=null){
            copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
