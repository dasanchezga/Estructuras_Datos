package datastructures;

class AVL <DataType extends Comparable<? super DataType>> {
	private BinaryTreeNode<DataType> root;
	
	public AVL() {
		this.root = null;
	}
	
	public BinaryTreeNode<DataType> getRoot() {
		return this.root;
	}
	
	public void makeEmpty() {
		this.root = null;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	//ALTURA DEL ARBOL
	private void updateHeight(BinaryTreeNode<DataType>aux) {
		aux.height = 1 + Math.max(auxHeight(aux.leftSon), auxHeight(aux.rightSon));
	}
	
	private int auxHeight(BinaryTreeNode<DataType>aux) {
		return aux == null ? -1 : aux.height;
	}
	
	public int height() {
		return auxHeight(this.getRoot());
	}
	
	//ROTACIONES
	private BinaryTreeNode<DataType	> leftRotate(BinaryTreeNode<DataType> aux) {
		BinaryTreeNode<DataType> x = aux.rightSon;
		BinaryTreeNode<DataType> z = x.leftSon;
		x.leftSon = aux;
		aux.rightSon = z;
		updateHeight(aux);
		updateHeight(x);
		return x;
	}
	
	private BinaryTreeNode<DataType	>  rightRotate(BinaryTreeNode<DataType> aux) {
		BinaryTreeNode<DataType> x = aux.leftSon;
        BinaryTreeNode<DataType> z = x.rightSon;
        x.rightSon = aux;
        aux.leftSon = z;
        updateHeight(aux);
        updateHeight(x);
        return x;
	}
	
	private BinaryTreeNode<DataType> DoubleRotateLR(BinaryTreeNode<DataType> aux) {
		aux.leftSon = leftRotate(aux.leftSon);
		aux = rightRotate(aux);
		return aux;
	}
	
	private BinaryTreeNode<DataType> DoubleRotateRL(BinaryTreeNode<DataType> aux) {
		aux.rightSon = rightRotate(aux.rightSon);
	    aux = leftRotate(aux);
		return aux;
	}
	
	//REBALANCE
	private int getBalance(BinaryTreeNode<DataType> aux) {
		return (aux == null) ? 0: auxHeight(aux.rightSon) - auxHeight(aux.leftSon);
	}
	
	private BinaryTreeNode<DataType> rebalance(BinaryTreeNode<DataType> aux){
		updateHeight(aux);
		int balance = getBalance(aux);
		if(balance>1) {
			if(auxHeight(aux.rightSon.rightSon)> auxHeight(aux.rightSon.leftSon)) {
				aux = leftRotate(aux);
			}
			else {
				aux = DoubleRotateRL(aux);
				}			
		}
		else if(balance <-1) {
			if(auxHeight(aux.leftSon.leftSon)> auxHeight(aux.leftSon.rightSon)) {
				aux = rightRotate(aux);
			}
			else {				
				aux = DoubleRotateLR(aux);
			}
		}
		return aux;
	}
	
	//EL ÁRBOL CONTIENE ALGÚN DATO
	public boolean contains(DataType toSearch) {
		return this.auxContains(toSearch, this.root);
	}
	
	private boolean auxContains(DataType toSearch, BinaryTreeNode<DataType> aux) {
		if(aux == null) {
			return false;
		}
		int compareResult = toSearch.compareTo(aux.data);
		if(compareResult<0) {
			return auxContains(toSearch, aux.leftSon);
		}
		else if(compareResult>0) {
			return auxContains(toSearch, aux.rightSon);
		}
		else {
			return true;
		}
	}
	
	//ENCONTRAR EL MÍNIMO
	public DataType findMin() {
		return this.auxFindMin(this.root);
	}
	
	private DataType auxFindMin(BinaryTreeNode<DataType> aux) {
		if(aux == null) {
			System.out.println("El árbol está vacío");
			return null;
		}
		if(aux.leftSon == null) {
			return aux.data;
		}
		return auxFindMin(aux.leftSon);
	}
	
	//ENCONTRAR EL MÁXIMO	
	public DataType findMax() {
		return this.auxFindMax(this.root);
	}
	
	private DataType auxFindMax(BinaryTreeNode<DataType> aux) {
		if(aux == null) {
			System.out.println("El árbol está vacío");
			return null;
		}
		if(aux.rightSon == null) {
			return aux.data;
		}
		return auxFindMax(aux.rightSon);
	}
	
	//INSERTAR UN NUEVO DATO
	public void insert(DataType newData) {
		this.root = this.auxInsert(newData,this.root);
	}
	
	private BinaryTreeNode<DataType> auxInsert(DataType newData, BinaryTreeNode<DataType> aux){
		if(aux == null) {
			return new BinaryTreeNode<>(newData);
		}
		int compareResult =newData.compareTo(aux.data);
		if(compareResult<0) {
			aux.leftSon = auxInsert(newData,aux.leftSon);
		}
		else if(compareResult>0) {
			aux.rightSon = auxInsert(newData,aux.rightSon);
		}
		else {
			System.out.println("No se permiten valores repetidos.");
		}
		return rebalance(aux);
	}
	
	//ELIMINAR UN DATO
	public void remove(DataType toDelete) {
		this.root = this.auxRemove(toDelete, root);
	}
	
	private BinaryTreeNode<DataType> auxRemove(DataType toDelete, BinaryTreeNode<DataType> aux){
		if(aux == null) {
			System.out.println("No existe ningún dato en el árbol");
			return aux;
		}
		int compareResult = toDelete.compareTo(aux.data);
		if(compareResult <0) {
			aux.leftSon = this.auxRemove(toDelete, aux.leftSon);
		}
		else if(compareResult>0) {
			aux.rightSon = this.auxRemove(toDelete, aux.rightSon);
		}
		//NODO CON DOS HIJOS
		else if(aux.leftSon != null && aux.rightSon != null) {
			DataType succesor = this.auxFindMin(aux.rightSon);
			aux.data = succesor;
			aux.rightSon = auxRemove(succesor, aux.rightSon);
		}
		else {
			aux = (aux.leftSon != null) ? aux.leftSon : aux.rightSon;
		}
		if(aux != null) {
			aux = rebalance(aux);
		}
		return aux;
	}
	
	//PREORDER
	public void preorder() {
		this.auxPreorder(this.root);
		System.out.println("");
	}

	private void auxPreorder(BinaryTreeNode<DataType> aux) {
		if(aux != null) {
			System.out.print(aux.data +" " );
			this.auxPreorder(aux.leftSon);
			this.auxPreorder(aux.rightSon);
		}
	}
	
	//POSORDER
	public void posorder() {
		this.auxPosorder(this.root);
		System.out.println("");
	}
	private void auxPosorder(BinaryTreeNode<DataType> aux) {
		if(aux != null) {
			this.auxPosorder(aux.leftSon);
			this.auxPosorder(aux.rightSon);
			System.out.print(aux.data + " ");
		}
	}
	
	//INORDER
	public void inorder() {
		this.auxInorder(this.root);
		System.out.println("");
	}
	private void auxInorder(BinaryTreeNode<DataType> aux) {
		if(aux != null) {
			this.auxInorder(aux.leftSon);
			System.out.print(aux.data + " ");
			this.auxInorder(aux.rightSon);
		}
	}
	
	//LEVELS
	public void levels() {
		this.auxLevels(this.root);
		System.out.println("");
	}
	private void auxLevels(BinaryTreeNode<DataType> aux) {
		if(aux == null) {
			System.out.println("El árbol está vacío");
		}
		else {
			Queue<BinaryTreeNode<DataType>> auxQ = new Queue<>();
			BinaryTreeNode<DataType> auxNodo = aux;
			auxQ.enqueue(aux);
			while (!auxQ.isEmpty()) {
				auxNodo = auxQ.peek();
				auxQ.push();
				System.out.print(auxNodo.data +" ");
				if(auxNodo.leftSon != null) {
					auxQ.enqueue(auxNodo.leftSon);
				}
				if(auxNodo.rightSon != null) {
					auxQ.enqueue(auxNodo.rightSon);
				}
			}
		}
	}
	
}
