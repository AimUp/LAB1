package org.dea.packlaborategi3;

import java.util.*;

public class Aktore {
	private String izena;
	private ArrayList<Pelikula> listaP;

	public Aktore(String pIzena){
		izena = pIzena;	
	}
	
	public String getIzena(){
		return izena;
	}
	
	public ArrayList<Pelikula> getListaP(){
		return listaP;
	}
}
