public class singlylinkedlist{
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.print();
    }
}

class LinkList{
    Node head;
    Node tail;
    public void insert(int data){
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn;
        }
        else{
            tail.next = nn;
            tail = nn;
        }
    }
    public void print(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void delete(int val){
        if(head == null){
            System.out.println("Empty List Nothing To Remove");
            return;
        }
        else if(head.data == val){
            if(head == tail){
                head = tail = null;
            }
            else{
                head = head.next;
            }
        }
        else {
            Node temp = head;
            Node prev = head;
            while(temp != null && temp.data != val){
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("value doesn't exist");
            }
            else{
                prev.next = temp.next;
            }
        }
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}