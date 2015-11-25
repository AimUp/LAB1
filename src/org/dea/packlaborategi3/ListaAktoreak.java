package org.dea.packlaborategi3;

import java.util.*;

public class ListaAktoreak {
	
	private ArrayList<Aktore> listaA;
	
	public ListaAktoreak(){
		
	}
	
	public void gehituAktorea(Aktore pAktor){
		listaA.add(pAktor);
	}
	
	public ArrayList<Aktore> getLista(){
		return listaA;
	}
	
}
