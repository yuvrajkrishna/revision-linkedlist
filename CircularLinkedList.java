public class CircularLinkedList {
    public static void main(String[] args) {
        CircLinkList c = new CircLinkList();
        c.Cinsert(10);
        c.Cinsert(20);
        c.Cinsert(30);
        c.Cinsert(40);
        c.swapFirstAndLastNode();
        c.Circularprint();
    }
}

class CircLinkList{
    CircularNode head;
    public void Cinsert(int data){
        CircularNode c = new CircularNode(data);
        if(head == null){
            head = c;
            head.next = head;
        }
        else{
            CircularNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = c;
            temp = c;
            temp.next = head;
        }
    }
    public void Circularprint(){
        if(head == null){
            System.out.println("Empty lIST");
        }
        else{
            CircularNode temp = head;
            do{
                System.out.println(temp.data);
                temp = temp.next;
            }while(temp!=head);
        }
        
    }
    public void checkifCircular(){
        if(head == null){
            System.out.println("Empty list");
        }
        else{
            CircularNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            if(temp.next == head){
                System.out.println("Circular");
            }
            else{
                System.out.println("Not Circular");
            }
        }
    }

    public void swapFirstAndLastNode(){
        CircularNode temp = head;
        CircularNode last = head;
        CircularNode lastPrev = head;
        while(last.next != head){
            lastPrev = last;
            last = last.next;
        }
        last.next = temp.next;
        lastPrev.next = temp;
        temp.next = last;
        head = last;
    }
}

class CircularNode{
    int data;
    CircularNode next;
    CircularNode(int data){
        this.data = data;
    }
}