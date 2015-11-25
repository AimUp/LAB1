package org.dea.packlaborategi3;

import java.util.*;
 
public class Graph1 {

	HashMap<String, ArrayList<String>> g;
	
	public void grafoaSortu(ArrayList<Aktore> lAktoreak){
	// Post: aktoreen zerrendatik grafoa sortzen du
	//       Adabegiak aktoreen izenak eta pelikulen izenburuak dira 
        
            for(Aktore a: lAktoreak){
            	ArrayList<String> stringLista = new ArrayList<String>();
            	for(int i=0; i < a.getListaP().size(); i++){
            		Pelikula hunekoa = a.getListaP().get(i);
            		stringLista.add(hunekoa.getIzenburua());
            	}
            	g.put(a.getIzena(), stringLista);
            } 	
	}
	
	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	
	public boolean konektatuta(String a1, String a2){
        boolean konektatuak = false;
        Ilara<Integer> aztertuGabeak = new;
        aztertuGabeak.insert(h);
        while(!bukaera && !aztertuGabeak.isEmpty()){
        	x=aztertuGabeak.remove();
        	if(x=b){
        		bukaera=true;
        	}
        	else{
        		//x-tik aztertzen den y bakoitzeko
        		if(//){
        			
        		}
        	}
        }
		return konektatuak;
	}
}
