package datastructures;

public class DoubleLinkedList<DataType> {
    Node<DataType> first;
    Node<DataType> last;
    Integer count;
    
    public DoubleLinkedList(){
        this.first = null;
        this.last = null;
        this.count = 0;        
    }
    
    //Retornar TRUE si la lista está vacía
    public boolean isEmpty(){
        return first == null;
    }
    //Agregar un Nodo al principio de la lista
    public void insertBegin(DataType toInsert){
        Node newNode = new Node<>(toInsert);
        newNode.setValue(toInsert);
        if(isEmpty()){
            this.first = newNode;
            this.last = this.first;
        }
        else{
            this.first.prev = newNode;
            newNode.next = this.first;
            this.first = newNode;
        }
        this.count++;
    }
    //Agregar un Nodo al final de la lista
    public void insertEnd(DataType toInsert){
        Node newNode = new Node(toInsert);
        newNode.setValue(toInsert);
        if(isEmpty()){
            this.first = newNode;
            this.last = this.first;
        }
        else{
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = this.last.next;
        }
        this.count++;    
    }
    //Agregar un nodo en una posición k
    public void insert(Integer key,DataType toInsert){
        if(key<0 || key >this.count){
            System.out.println("No es posible hacer la inserción en ese índice");
        }
        else if(key == 0){
            this.insertBegin(toInsert);
        }
        else{
            Node<DataType>  newNode = new Node<>(toInsert);
            Node<DataType> temp = this.first;
            for(int i=0; i<key-1;i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            this.count++;
        }
    } 
    //Consultar el elemento al principio de la lista 
    public DataType head(){
        return first.getData();
    }
    //Consultar el elemento al final de la lista
    public DataType tail(){
        return last.getData();
    }
    //Consultar el elemento en una posición k
    public DataType read(Integer key){
        if(key<0 || key>this.count ){
            System.out.println("No es posible realizar la búsqueda");
            return null;
        }
        else{
            Node<DataType> temp = this.first;
            for(int i = 0; i<key;i++){
                temp = temp.next;
            }
            return temp.getData();
        }
    }
    //Encontrar un dato y devolver arreglo de indices donde se encuentra
    public Integer[] find(DataType data){
        Integer i = 0;
        Integer count2 = 0;
        Integer arr[] = new Integer[count2+1];
        if(count == 0){
            System.err.println("Error, la lista está vacía");
        }
        else{
            Node<DataType> temp = this.first;
            Integer index = 0;
            while(temp != null){
                if(data.equals(temp.data)){
                    Integer a = 0;
                    arr[a]= index;
                    a++;
                    count2++;
                }
                i++;
                index++;
                temp = temp.next;
            }
        }
        if(count2 == 0){
             System.out.println("Error, elemento no encontrado"); 
        }
        return arr;
    }
    //Eliminar un nodo al principio de la lista
    public void deleteBegin(){
        if(this.first == null){
            System.err.println("Error, no puedo eliminar de una lista vacía");
        }
        else{
            this.first = this.first.next;
            this.count--;
        }
    }
    //Eliminar un nodo al final de la lista
    public void deleteEnd(){
        if(this.first == null){
            System.err.println("Error, no puedo eliminar de una lista vacía");
        }
        else{
            Node<DataType> aux= last.prev;
            if(aux == null) {
            	this.first = null;
            	this.last = null;            	
            }
            else {
            	this.last = aux;
                this.last.next = null;
            }
        }
        this.count--;
    }
    //Eliminar un nodo en una posición k
    public void delete(Integer key){
        if(key > 0 && key < count){
            if(key == 0){
                first = first.getNext();
            }
            else{
                Node aux = first;
                for(int i= 0; i < key-1;i++){
                    aux = aux.getNext();
                }
                Node next = aux.getNext();
                aux.setNext(next.getNext());
            }
            count --;
        }
        else{
           System.err.println("Error, no puedo eliminar de una lista vacía o esa posición no existe"); 
        }
    }
    //Mostrar la cantidad de elementos de la lista
    public Integer count(){
        return this.count;
    }
    //Mostrar la Lista 
    public void showList(){
        if(this.first == null){
            System.out.println( "La lista no contiene objetos");
        }
        else{
            int i = 0;
            Node temp = first;
            while (temp !=  null){
                System.out.print(i + ".[ " + temp.getData() + " ]" + " ->  ");
                temp = temp.getNext();
                i++;
            }
            System.out.println("");
        }
    }
    //Vaciar la Lista 
    public void makeEmpty(){
        this.first = null;
        this.last = null;
        this.count = 0;
    }
}
