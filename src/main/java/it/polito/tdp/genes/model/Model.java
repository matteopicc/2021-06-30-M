package it.polito.tdp.genes.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {
	private GenesDao dao;
	private Graph<Integer,DefaultWeightedEdge>grafo;
	
	public Model() {
		this.dao = new GenesDao();
	}
	
	public void creaGrafo() {
		this.grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		//aggiunta vertici
		Graphs.addAllVertices(this.grafo, dao.getAllChromosome());
		
		//aggiunta archi
		for(Adiacenza a : dao.getArchi()) {
			Graphs.addEdgeWithVertices(this.grafo, a.getCromo1(), a.getCromo2(), a.getPeso());
		}
	}
	
	public int getnVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int getnArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public boolean grafoCreato() {
		if(this.grafo == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public double getPmax() {
		double pmax = -1;
		for(Adiacenza a: dao.getArchi()) {
			if(a.getPeso()>pmax) {
				pmax = a.getPeso();
			}
		}
		return pmax;
	}
	
    public double getPmin() {
    	double pmin = 100;
		for(Adiacenza a: dao.getArchi()) {
			if(a.getPeso()<pmin) {
				pmin = a.getPeso();
			}
		}
		return pmin;
	}
    
    public int nSU(Double soglia) {
    	int n = 0;
    	for(Adiacenza a: dao.getArchi()) {
			if(a.getPeso()>soglia ) {
				n++;
			}
		}
		return n;
    	
    }
    
    public int nGIU(Double soglia) {
	   int n = 0;
	   for(Adiacenza a: dao.getArchi()) {
		   if(a.getPeso()<soglia ) {
			   n++;
		   }
	     }
	    return n;
    }
    
  

	
	

}