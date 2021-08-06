package datastructures;

public class Node<DataType> {
    DataType data;
    Node<DataType> prev;
    Node<DataType> next;
    
    public Node(DataType data){
        this.data= data;
        this.prev= null;
        this.next= null;
    }
    public DataType getData(){
        return data;
    }
    public void setValue (DataType value){
        this.data = value;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getPrev(){
        return prev;
    }
    public void setPrev(Node prev){
        this.prev = prev;
    }
}