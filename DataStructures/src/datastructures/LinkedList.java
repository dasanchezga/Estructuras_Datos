package datastructures;

public class LinkedList<DataType> {
    Node <DataType> first;
    Integer count;
    
    public LinkedList(){
        this.first = null;
        this.count = 0;
    }
    
    //Retornar TRUE si la lista está vacía
    public boolean isEmpty(){
        return first == null;
    }
    //Agregar un Nodo 
    protected void insertBegin(DataType toInsert){
        Node newNode = new Node(toInsert);
        newNode.setValue(toInsert);
        newNode.next = this.first;
        this.first = newNode;
        this.count++;
    }
    //Leer el dato de un Nodo en una posicion k
    public DataType read(Integer key){
        if(key<0 || key>this.count){
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
        Integer arr[] = new Integer[count];
        if(count == 0){
            System.err.println("Error, la lista está vacía");
        }
        else{
            Node<DataType> temp = this.first;
            Integer index = 0;
            while(temp != null){
                if(data.equals(temp.data)){
                    arr[i] = index;
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
    //Eliminar al inicio de la lista 
    protected void deleteBegin(){
        if(this.first == null){
            System.err.println("Error, no puedo eliminar de una lista vacía");
        }
        else{
            this.first = this.first.next;
            this.count--;
        }
    }
    //Retornar la cantidad de elementos de la lista 
    public Integer count(){
        return this.count;
    }
    //Mostrar la lista 
    protected void showList(){
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
        this.count = 0;
    }
}
