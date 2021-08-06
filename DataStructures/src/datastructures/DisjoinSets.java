package datastructures;

public class DisjoinSets {
    private static final Integer size  = 100; // Máximo tamaño del arreglo
    private final Integer parent[]; 
    private final Integer rank[]; 
	
    public DisjoinSets() {
	this.parent = new Integer[size];
	this.rank = new Integer[size];
    }
	
    //Creación de los conjuntos
    public void makeSet(Integer data) {
	parent[data] = data;
	rank[data] = 0;
    }
	
    //Encontrar el ID de un conjunto
    public Integer find(Integer data) {
	if(data == parent[data]) {//mejor equals
		return data;
	}
        else {
            parent[data] = find(parent[data]);
	    return parent[data];                //Compresión de Caminos
	}	
    }
	
    //Union de los conjuntos por Rango
    public void union (Integer x, Integer y) {
	Integer x_id = find(x);
	Integer y_id = find(y);
		
	if(this.rank[x_id] > this.rank[y_id]) {
            parent[y_id] = x_id;
	}
	else {
	    parent[x_id] = y_id;
            if(this.rank[x_id] == this.rank[y_id]) {//mejor equals
		this.rank[y_id]++;
	    }
	}
    }
}
