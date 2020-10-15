//Shashank Eeda
/*
This is the LinkedList class which will have a head node and a size variable as data members
 */
public class LinkedList<E> {
    Node<E> head;
    int size;
    /*
    This is the constructor which is used to create the first linkedlist
     */
    public LinkedList(E node){
        Node<E> x=new Node(node);
        head=x;
        size++;
    }
    /*
    This print function is used to print out all the nodes in order using a while loop
     */
    public void print(){
        Node<E> curr=head;
        while(curr!=null){
            if(curr.next!=null)
                System.out.print(curr.value+"->");
            else
                System.out.print(curr.value);
            curr=curr.next;
        }
        System.out.println();
    }
    /*
    The add function is used to go all the way to the last element and then add a new node over there
     */
    public void add(E Node){
        Node<E> curr=head;
        while(curr.next!=null)
            curr=curr.next;
        Node<E> x=new Node(Node);
        curr.next=x;
        size++;
    }
    /*
    This add function loops to a specific index and adds a new node in between unless an index is out of bounds
    and the technique is different to adding the first element and the last element
     */
    public void add(E Node,int pos){
        Node<E> curr=head;
        Node<E> prev=head;
        Node<E> x=new Node(Node);
        if(pos>size+1||pos<0)
            System.out.println("Invalid Position");
        else if(pos==0){
            head=x;
            head.next=curr;
            size++;
        }
        else if(pos==size-1){
            while(curr.next!=null)
                curr=curr.next;
            curr.next=x;
            size++;
        }
        else{
            for(int i=0;i<pos;i++){
                prev=curr;
                curr=curr.next;
            }
            x.next=prev.next;
            prev.next=x;
            size++;
        }
    }
    /*
    The get function will loop to the desired position and return the node at that index once it is reached
    unless the position is an invalid position
     */
    public Node<E> get(int position){
        Node<E> curr=head;
        Node<E> prev=head;
        if(position>=size||position<0)
            System.out.println("Invalid Position");
        else {
            for (int i = 0; i < position + 1; i++) {
                prev = curr;
                if (i == size - 1)
                    break;
                curr = curr.next;
            }
        }
        return head;
    }
    /*
    The remove function will loop to the desired position and readjust it so that no linkedlist will point to the
    linked list in that position unless the position is not in range
     */
    public Node<E> remove(int position){
        Node<E> curr=head;
        Node<E> prev=head;
        if(position>=size||position<0)
            System.out.println("Invalid Position");
        else if(position==0) {
            head = curr.next;
            size--;
        }
        else {
            for (int i = 0; i < position; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next= curr.next;
            size--;
        }
        return curr;
    }
    /*
    The reverse function will take the head as a parameter and then slowly start to reverse the pointers in a while
    loop and reassign the head;
     */
    public E reverse(Node<E> head){
        Node<E> next=null;
        Node<E> curr=head;
        Node<E> prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        this.head=prev;
        return head.value;
    }
    /*
    This is the node class which consists of a value and a next pointer and a constructor
     */
    private class Node<E>{
        E value;
        Node<E> next;
        public Node(E val){
            value=val;
            next=null;
        }
    }
    public static void main(String[] args){
        /*
        This is the main method which will test all 6 functions, can be adjusted as you like
         */
        LinkedList<Integer> linkedList=new LinkedList<Integer>(5);
        linkedList.add(3);
        linkedList.add(10,2);
        linkedList.add(4);
        linkedList.add(10,3);
        System.out.println(linkedList.get(1).value);
        linkedList.print();
        linkedList.remove(4);
        linkedList.print();
        linkedList.reverse(linkedList.head);
        linkedList.print();

    }
}
