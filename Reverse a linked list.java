public class Node
{
    int data;
    Node next;
}
class Main 
{
    public static void main(String[] args)
       {
           LinkedList list=new LinkedList();
           list.insert(8);
           list.insert(15);
           list.insert(3);
           list.show();
           list.reverse();
       }
}
public class LinkedList
{
    
    Node head;
    public void insert(int data)
    {
        Node node=new Node();
        node.data=data;
        node.next=null;
        
        if(head==null)
        {
            head=node;
        }
        else
        {
            Node n=head;
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next=node;
        }
    }
    public void show()
    {
        Node node=head;
        System.out.println("Linked list:");
        while(node.next!=null)
        {
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println(node.data);
    }
    public void reverse()
    {
        Node current=head;
        Node previous=null;
        Node next=null;
        while(current!=null)
        {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        System.out.println("Reversed linked list:");
        while(previous!=null)
        {
            System.out.print(previous.data+" ");
            previous=previous.next;
        }
        
    }
}
