public class DoublyCircularList {
    public static void main(String[] args) {
        Doubly d = new Doubly();
        d.insert(1);
        d.insert(2);
        d.insert(3);
        d.insert(4);
        d.insert(5);
        d.insert(5);
        d.insert(6);
        d.pairSumForSortedList(8);
    }
}

class Doubly{
    DcNode head;
    Doubly(){
        head = null;
    }
    public void insert(int data){
        DcNode nn = new DcNode(data);
        if(head == null){
            head = nn;
            head.next = head;
            head.prev = head;
        }
        else{
            DcNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = nn;
            nn.prev = temp;
            temp = nn;
            nn.next = head;
            head.prev = nn;
        }
    }
    
    public void printDoubly(){
        if(head == null){
            System.out.println("Empty list");
        }
        else{
            DcNode temp = head;
            do{
                System.out.println(temp.data);
                temp = temp.next;
            }while(temp != head);
        }
    }

    public void delete(int val){
        if(head == null){
            System.out.println("Empty list");
        }
        else if(head.data == val){
            if(head == head.next){
                head = head.next = head.prev = null;
            }
            else{
                DcNode previous = head.prev;
                DcNode nextToHead = head.next;
                previous.next = nextToHead;
                nextToHead.prev = previous;
                head = nextToHead;
            }
        }
        else{
            DcNode temp = head.next;
            while(temp != head){
                if(temp.data == val){
                    break;
                }
                temp = temp.next;
            }
            if(temp.data == val){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            else{
                System.out.println("Value Does'nt Exist");
            }
        }
    }
    public void printReverse(){
        DcNode temp = head.prev;
        do{
            System.out.println(temp.data);
            temp = temp.prev;
        }
        while(temp != head.prev);
    }
    public void pairSumForSortedList(int target) {
    if (head == null || head.next == head) {
        System.out.println("Not Exist");
        return;
    }

    // Count nodes
    int n = 0;
    DcNode temp = head;

    do {
        n++;
        temp = temp.next;
    } while (temp != head);

    DcNode left = head;
    DcNode right = head.prev;

    for (int i = 0; i < n / 2; i++) {
        int sum = left.data + right.data;

        System.out.println(left.data + " + " + right.data + " = " + sum);

        if (sum == target) {
            System.out.println("Left: " + left.data);
            System.out.println("Right: " + right.data);
            return;
        } else if (sum < target) {
            left = left.next;
        } else {
            right = right.prev;
        }
    }

    System.out.println("Not Exist");
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