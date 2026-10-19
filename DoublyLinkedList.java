
public class DoublyLinkedList {
    public static void main(String[] args) {
        Doubly d = new Doubly();

        d.insert(1);
        d.insert(2);
        d.insert(2);
        d.insert(2);
        d.insert(1);
        d.insert(4);
        d.insert(5);
        d.insert(3);
        d.RemoveDuplicateUnsorted();
        d.printDoubly();

    }
}

class Doubly {
    DcNode head;

    Doubly() {
        head = null;
    }

    // Insert at the end
    public void insert(int data) {
        DcNode nn = new DcNode(data);

        if (head == null) {
            head = nn;
            return;
        }

        DcNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = nn;
        nn.prev = temp;
    }

    // Print forward
    public void printDoubly() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        DcNode temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Delete the first occurrence of a value
    public void delete(int val) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        DcNode temp = head;

        while (temp != null && temp.data != val) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value doesn't exist");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        // Disconnect the deleted node
        temp.next = null;
        temp.prev = null;
    }

    // Print backward
    public void printReverse() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        DcNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

    // Find all pairs in a sorted doubly linked list
    public void pairSumForSortedList(int target) {
        if (head == null || head.next == null) {
            System.out.println("No pair exists");
            return;
        }

        DcNode left = head;
        DcNode right = head;

        // Find the last node
        while (right.next != null) {
            right = right.next;
        }

        boolean found = false;

        while (left != right && left.prev != right) {
            int sum = left.data + right.data;

            if (sum == target) {
                System.out.println(
                        left.data + " + " + right.data + " = " + sum);

                found = true;

                left = left.next;
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        if (!found) {
            System.out.println("No pair exists");
        }
    }

    public void ReverseDoublyLinkedList() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            DcNode prv = null;
            DcNode temp = head;

            while (temp != null) {
                DcNode nxt = temp.next;

                temp.next = prv;
                temp.prev = nxt;

                prv = temp;
                temp = nxt;
            }

            head = prv;

        }
    }

    public void insertSorted(int data) {

        DcNode nn = new DcNode(data);

        // Case 1: Empty list or insert before head
        if (head == null || data <= head.data) {
            nn.next = head;

            if (head != null) {
                head.prev = nn;
            }

            head = nn;
            return;
        }

        // Find the correct position
        DcNode temp = head;

        while (temp.next != null && temp.next.data < data) {
            temp = temp.next;
        }

        // Insert after temp
        nn.next = temp.next;
        nn.prev = temp;

        if (temp.next != null) {
            temp.next.prev = nn;
        }

        temp.next = nn;

    }

    public void RemoveDuplicate() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            DcNode curr = head;
            DcNode nxt = head.next;
            while (nxt != null) {
                if (curr.data != nxt.data) {
                    curr.next = nxt;
                    nxt.prev = curr;
                    curr = nxt;
                }
                nxt = nxt.next;
            }
            curr.next = null;
        }
    }

    public void RemoveDuplicateUnsorted() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            DcNode curr = head;
            DcNode nxt = head.next;
            while (nxt != null) {
                boolean isdup = false;
                if (curr.data != nxt.data) {
                    DcNode temp = head;
                    while (temp != curr) {
                        if(temp.data == nxt.data){
                            isdup = true;
                            break;
                        }
                        temp = temp.next;
                    }
                    if(!isdup){
                        curr.next = nxt;
                        nxt.prev = curr;
                        curr = nxt;
                    }
                    
                }
                else{

                }
                nxt = nxt.next;
            }
            curr.next = null;
        }
    }

    public void deleteRandomNode(DcNode d){
        if(head == null || d == null){
            System.out.println("Nothing to Delete");
            return ;
        }
        else if(d.prev == null){
            if(d.next != null){
                 head = d.next;
             head.prev = null;
            }
            else{
                head = null;
            }
        }
        else if(d.next == null){
            d.prev.next = null;
        }
        else{
            DcNode pre = d.prev;
            DcNode nxt = d.next;
            pre.next = nxt;
            nxt.prev = pre;
        }
    }
}

class DcNode {
    int data;
    DcNode next;
    DcNode prev;

    DcNode(int data) {
        this.data = data;
    }
}
