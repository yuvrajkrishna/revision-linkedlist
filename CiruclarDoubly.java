public class CiruclarDoubly {
    public static void main(String[] args) {
        CdLinkList c = new CdLinkList();
        c.insert(10);
        c.insert(20);
        c.print();
    }
}

class CdLinkList{
    CdNode head;
    CdLinkList(){
        head = null;
    }
    public void insert(int data){
        CdNode nn = new CdNode(data);
        if(head == null){
            head = nn;
            head.next = nn;
            head.prev = nn;
        }
        else{
            CdNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = nn;
            nn.prev = temp;
            temp= nn;
            temp.next = head;
        }
    }

    public void print(){
        if(head == null){
            System.out.println("Empty List");
            return ;
        }
        else{
            CdNode temp = head;
            do{
                System.out.println(temp.data);
                temp = temp.next;
            }
            while(temp!= head);
        }
    }
}

class CdNode{
    int data;
    CdNode prev;
    CdNode next;
    CdNode(int data){
        this.data = data;
    }
}
