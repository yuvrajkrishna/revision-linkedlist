import java.util.Stack;

public class singlylinkedlist {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.cycleCreation();
        list.detectCycle();
        list.lengthOfTheLoop();
    }
}

class LinkList {
    Node head;
    Node tail;

    public void insert(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void delete(int val) {
        if (head == null) {
            System.out.println("Empty List Nothing To Remove");
        } else if (head.data == val) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
        } else {
            Node temp = head;
            Node prev = head;
            while (temp != null && temp.data != val) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("value doesn't exist");
            } else {
                prev.next = temp.next;
            }
        }
    }

    public void update(int oldVal, int newVal) {
        if (head == null) {
            System.out.println("Empty List Nothing To update");
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.data == oldVal) {
                    temp.data = newVal;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void find(int val) {
        if (head == null) {
            System.out.println("Empty List");
        } else {
            Node temp = head;
            int count = 0;
            while (temp != null) {
                count++;
                if (temp.data == val) {
                    System.out.println(count);
                    return;
                }
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("value does'nt exist");
            }
        }
    }

    public int count() {
        if (head == null) {
            return 0;
        } else {
            Node temp = head;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    public void printReverse() {
        if (head == null) {
            System.out.println("NOT POSSIBLE");
            return;
        } else if (head == tail) {
            System.out.println(head.data);
        } else {
            Stack stack = new Stack<>();
            Node temp = head;
            while (temp != null) {
                stack.add(temp.data);
                temp = temp.next;
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }
    }

    public void printNthNode(int node) {
        if (head == null) {
            System.out.println("Nothing to print");
            return;
        } else {
            Node temp = head;
            int count = 1;
            while (temp != null) {
                if (count == node) {
                    System.out.println(temp.data);
                    return;
                }
                count++;
                temp = temp.next;
            }
            System.out.println("Node doesn't Exist");
        }
    }

    public void printReverseNthNode(int node) {
        if (head == null) {
            System.out.println("Nothing to print");
            return;
        } else {
            Stack stack = new Stack<>();
            Node temp = head;
            while (temp != null) {
                stack.add(temp.data);
                temp = temp.next;
            }
            int count = 1;
            while (!stack.isEmpty()) {
                if (count == node) {
                    System.out.println(stack.pop());
                    return;
                }
                stack.pop();
                count++;
            }
        }
    }

    public Node extractRandomNodeAddress() {
        if (head == null) {
            System.out.println("Nothing to find");
            return head;
        } else {
            Node temp = head;
            int num = 3;
            int count = 1;
            while (temp != null) {
                if (count == num) {
                    return temp;
                }
                count++;
                temp = temp.next;
            }

            return head;
        }
    }

    public void randomDelete(Node d) {
        if (head == null) {
            System.out.println("Nothing to delete");
            return;
        }

        else {
            Node temp = d;

            while (temp.next != null) {
                temp.data = temp.next.data;

                if (temp.next == tail) {
                    tail = temp;
                    temp.next = null;
                    return;
                }

                temp = temp.next;
            }
        }
    }

    public void printMiddleNode(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }
        else {
            Node fast = head;
            Node slow = head;
            while(fast.next != null && fast != null){
                slow =slow.next;
                fast = fast.next.next;
            }
            System.out.println(slow.data);
        }
    }

    public void detectCycle(){
        if(head == null){
            System.out.println("Nothing to Detect");
        }
        else{
            Node fast = head;
            Node slow = head;
            while(fast.next != null && fast != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    System.out.println("Cycle");
                    return;
                }
            }
            System.out.println("Not Cycle");
        }
    }


    public void cycleCreation(){
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = head;
    }

    public void lengthOfTheLoop(){
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast != null){
            slow =slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int count = 1;
                Node temp = slow.next;
                while(temp!= slow){
                    count++;
                    temp = temp.next;
                }
                System.out.println(count);
                return;
            }
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}