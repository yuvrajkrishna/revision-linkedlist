public class DoublyCircularList {
    public static void main(String[] args) {
        Doubly d = new Doubly();
        d.insert(10);
        d.insert(20);
        d.insert(30);
        d.delete(10);
        d.printDoubly();
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
    }
}

class DcNode{
    int data;
    DcNode next;
    DcNode prev;
    DcNode(int data){
        this.data = data;
    }
}