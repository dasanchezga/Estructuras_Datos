package datastructures;

public class Queue<DataType> extends DoubleLinkedList{
    
    public Queue(){
        this.first = null;
        this.last = null;
        this.count= 0;
    }
    
    //Retornar TRUE si la cola está vacía
    @Override
    public boolean isEmpty(){
        return first == null;
    }
    //Encolar un dato
    public void enqueue(DataType data){
        this.insertBegin(data);
    }
    //Desencolar imprimiendo el dato
    public void dequeue(){
        DataType data = (DataType) last.getData();
        this.deleteEnd();
        System.out.println(data);
    }
    //Desencolar retornando el dato
    public DataType push(){
        DataType data = (DataType) last.getData();
        this.deleteEnd();
        return data;
    }
    //Mostrar el dato al frente de la cola
    public DataType peek(){
        return (DataType) last.getData();
    }
    //Mostrar los elementos de la cola
    @Override
    public Integer count(){
        return this.count;
    }
    //Mostrar la cola
    public void showQueue(){
        this.showList();
    }
    //Vaciar la cola 
    @Override
    public void makeEmpty(){
        this.first =null;
        this.last =null;
        this.count = 0;
    }
}
