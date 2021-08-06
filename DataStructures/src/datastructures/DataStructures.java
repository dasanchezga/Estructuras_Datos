package datastructures;
import java.util.Arrays;
/**
 *
 * @author dlsan
 */
public class DataStructures {

    public static void main(String[] args) {
        /**
        //******LISTA SIMPLE******
        LinkedList<String> myList = new LinkedList();   
        //Insertar Nodos
        myList.insertBegin("pero no dejo de intentarlo");
        myList.insertBegin("que hago");
        myList.insertBegin("No sé");
        myList.insertBegin("4");
        myList.insertBegin("0");
        //Mostrar la Lista 
        System.out.println("LISTA");
        myList.showList();
        //Cantidad de elementos 
        System.out.println(myList.count());
        //Leer el dato de un Nodo en una posición k
        System.out.println(myList.read(2));
        //Encontrar un dato y devolver arreglo de indices donde se encuentra
        System.out.println(Arrays.toString(myList.find(4)));
        //Dato inexistente
        System.out.println(Arrays.toString(myList.find(29)));
        //Eliminar un nodo al principio
        myList.deleteBegin();
        //Mostrar la Lista 
        myList.showList();
        //Borrar la Lista 
        myList.makeEmpty();
        myList.showList();*/
        
        //******LISTA DOBLE******
        DoubleLinkedList<String> myDouble = new DoubleLinkedList();
        //Insertar Nodos al Principio
        myDouble.insertBegin("proceso");
        myDouble.insertBegin("el");
        myDouble.insertBegin("en");
        myDouble.insertBegin("mejorando");
        myDouble.insertBegin("Estoy");
        myDouble.insertBegin("3");
        myDouble.insertBegin("2");
        myDouble.showList(); 
        //Insertar Nodos al Final
        myDouble.insertEnd("porque");
        myDouble.insertEnd("no");
        myDouble.insertEnd("me");
        myDouble.insertEnd("rindo");
        myDouble.insertEnd("aún");
        myDouble.insertEnd("19");
        myDouble.insertEnd("20");
        myDouble.insertEnd("21");
        myDouble.showList();
        //Elemento al principio de la lista
        System.out.println(myDouble.head());
        //Elemento al final de la lista
        System.out.println(myDouble.tail());
        //Elemento en una posición k
        System.out.println(myDouble.read(10));
        //Insertar en una posición k
        myDouble.insert(10, "NUEVO");
        myDouble.showList();
        //Mostrar la cantidad de elementos en la lista
        System.out.println(myDouble.count());
        //Eliminar al principio de la lista 
        myDouble.deleteBegin();
        myDouble.showList();
        //Eliminar al final de la lista
        myDouble.deleteEnd();
        myDouble.showList();
        System.out.println(myDouble.count());
        //Mostrar la cantidad de elementos en la lista
        System.out.println(myDouble.count());
        //Eliminar en una posición k
        myDouble.delete(9);
        myDouble.showList();
        //Mostrar la cantidad de elementos en la lista
        System.out.println(myDouble.count());
        //Encontrar un dato y devolver arreglo de indices donde se encuentra
        System.out.println(Arrays.toString(myDouble.find("rindo")));
        //Vaciar la lista
        myDouble.makeEmpty();
        myDouble.showList();
        /*
        //******Stack (Pila)******
        Stack<String> myStack = new Stack();
        //Hacer push (apilar)
        myStack.push("manera");
        myStack.push("esta");
        myStack.push("de");
        myStack.push("bien");
        myStack.push("esto");
        myStack.push("Estara");
        myStack.push("2");
        myStack.push("1");
        myStack.push("200");
        myStack.push("4");
        myStack.push("1");
        myStack.showStack();
        //Numero de elementos
        System.out.println(myStack.count());
        //Hacer pop(Desapilar)
        myStack.pop();
        myStack.pop();
        myStack.showStack();
        //Numero de elementos
        System.out.println(myStack.count());
        //Mostrar el primero de la lista (top)
        System.out.println(myStack.top()); 
        //Está vacía la pila ?
        System.out.println(myStack.isEmpty());
        //Vaciar la pila 
        myStack.makeEmpty();
        myStack.showStack();*/
        /*
        //******Queue(Cola)******
        Queue<String> myQueue = new Queue();
        //Está vacía la cola ?
        System.out.println(myQueue.isEmpty());
        //Agregar a la cola(Add)
        myQueue.offer("primero");
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer("cola");
        myQueue.offer("una");
        myQueue.offer("comporta");
        myQueue.offer("se");
        myQueue.offer("Así");
        myQueue.offer("8");
        myQueue.offer("9");
        myQueue.offer("10");
        myQueue.showQueue();
        //Numero de datos en cola
        System.out.println(myQueue.count());
        //Desencolando
        myQueue.poll();
        myQueue.poll();
        myQueue.poll();
        myQueue.poll();
        myQueue.showQueue();
        System.out.println(myQueue.count());
        //Consultar el primero de la cola 
        System.out.println(myQueue.peek());
        //Vaciar la lista
        myQueue.makeEmpty();
        System.out.println(myQueue.count());    */   
        
            
    }
}
