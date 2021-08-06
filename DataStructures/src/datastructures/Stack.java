package datastructures;

public class Stack<DataType> extends LinkedList {
    
    public Stack(){
        this.first = null;
        this.count = 0;
    }
    //Retornar TRUE si la pila está vacía
    @Override
    public boolean isEmpty(){
        return first == null;
    }
    //Hacer PUSH (Apilar)
    public void push(DataType toPush){
        this.insertBegin(toPush);
    }
    //Hacer POP (Desapilar)
    public DataType pop(){
        DataType a = (DataType) first.getData();
        this.deleteBegin();
        return a;   
    }
    //Hacer TOP (Mostrar el primero de la pila)
    public DataType top(){
        return (DataType) first.getData();
    }
    //Mostrar los elementos de la pila
    @Override
    public Integer count(){
        return this.count;
    }
    //Mostrar el Stack (pila)
    public void showStack(){
        this.showList();
    }
    //Vaciar la pila
    @Override
    public void makeEmpty(){       
        this.first = null;
        this.count = 0;
    }
}
