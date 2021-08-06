package datastructures;

public class BinaryHeap <DataType extends Comparable<? super DataType>>{
    private static final Integer defaultCap = 10;
    private Integer size;
    private DataType[] array;
    
    //Constructor con Capacidad por Defecto
    public BinaryHeap() {
	this(defaultCap);
    }
    //Constructor pasandole la capacidad del Heap
    public BinaryHeap(Integer capacity) {
	this.size = 0;
	this.array = (DataType[]) new Comparable[capacity +1] ;
    }
	
    public Integer getSize() {
	return this.size;
    }
    
    public void setSize(Integer size) {
    	this.size = size;
    }
     
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public void makeEmpty() {
    	this.size = 0;
    }
    
    //Actualizar el tamaño del arreglo
    private void enlargeSize( Integer newSize) {
    	DataType [] aux = array;
    	array = (DataType[]) new Comparable [newSize];
    	for(int i = 0; i<aux.length; i++) {
    		array[i] = aux[i];
    	}
    }
    
    //Insertar un nuevo dato
    public void insert(DataType data) {
    	if(this.size == this.array.length -1) {
    		enlargeSize(array.length * 2 +1);
    	}
    	
    	Integer hole = ++this.size;	
    	for(array [0] = data;  data.compareTo(array[hole/2])<0; hole /= 2) {
    		array[hole] = array [hole/2];
    	}
    	array[hole] = data;
    }
    
    //Encontrar el mínimo del Heap
    public DataType findMin() {
    	if(isEmpty()) {
    		System.out.println("El heap no contiene datos.");
    	}
    	return array[1];
    }
    
    //Percolate Down en el Heap
    private void percolateDown(Integer hole) {
    	Integer child;
    	DataType aux = array[hole];
    	for(; hole *2 <= this.size; hole = child) {
    		child = hole *2;
    		if(child != this.size && array[child +1 ].compareTo(array[child])<0) {
    			child ++;
    		}
    		if(array [child].compareTo(aux) <0) {
    			array [hole] = array[child];
    		}
    		else {
    			break;
    		}
    	}
    	array[hole] = aux;
    }
    
    //Eliminar el mínimo del Heap
    public DataType deleteMin() {
    	if(isEmpty()) {
    		System.out.println("El Heap está vacío.");
    	}
    	DataType min =findMin();
    	array[1] = array[this.size--];
    	percolateDown(1);
    	
    	return min;
    }
    
    //Mostrar El Heap
    public void showHeap() {
    	DataType[] array = this.array;
    	StringBuilder aux  = new StringBuilder();
    	for(int i = 1;i<array.length;i++) {
    		if(array[i]!= null) {
    		    aux.append(array[i] + " ");
    		}    
    	}
    	System.out.println(aux);
    }
}
