package org.dea.packlaborategi3;

import java.util.*;
 
public class Graph1 {

	HashMap<String, ArrayList<String>> g;
	static Graph1 nireGraph1 = null;
	
	private Graph1(){
		g = new HashMap<String, ArrayList<String>>();
	}
	
	public static synchronized Graph1 getGraph1(){
		if(nireGraph1==null){
			nireGraph1 = new Graph1();
		}
		return nireGraph1;
	}
	
	public boolean aktoreaBadago(String pIzen1, String pIzen2){
	    boolean badago = false;
	    if(g.containsKey(pIzen1) && g.containsKey(pIzen2)){
	   		badago = true;
	   	}
	   	return badago;
	 }
	
	public void grafoaSortu(ArrayList<Aktore> lAktoreak){
	// Post: aktoreen zerrendatik grafoa sortzen du
	//       Adabegiak aktoreen izenak eta pelikulen izenburuak dira 
        
            for(Aktore a: lAktoreak){
            	ArrayList<String> stringListaPeli = new ArrayList<String>();
            	for(int i=0; i < a.getListaP().size(); i++){
            		Pelikula hunekoa = a.getListaP().get(i);
            		stringListaPeli.add(hunekoa.getIzenburua());
            	}
            	g.put(a.getIzena(), stringListaPeli);
            	for(int j=0; j<a.getListaP().size(); j++){
            		if(!g.containsKey(a.getListaP().get(j).getIzenburua())){
            			Pelikula p = a.getListaP().get(j);
            			ArrayList<String> stringListaAktore = new ArrayList<String>();
            			for(int k=0; k<p.getListaAktore().size(); k++){
            				stringListaAktore.add(p.getListaAktore().get(k).getIzena());
            			}
            			g.put(p.getIzenburua(), stringListaAktore);
            		}
            	}
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
		String aztertzeko;
		Queue<String> aztertuGabeak = new LinkedList<String>();
		HashMap<String, Boolean> aztertuak = new HashMap<String, Boolean>();
		aztertuGabeak.add(a1);
        while(!konektatuak && !aztertuGabeak.isEmpty()){
        	aztertzeko = aztertuGabeak.remove();
        	aztertuak.put(aztertzeko, true);
        	if(aztertzeko.equals(a2)){
        		konektatuak=true;
        	}
        	else{
        		ArrayList<String> listaBerria = g.get(aztertzeko);
        		String b;
        		for(int x=0; x<listaBerria.size(); x++){
        			b = listaBerria.get(x);
        			if(!aztertuGabeak.contains(b) && !aztertuak.containsKey(b)){
        				aztertuGabeak.add(b);
        			}
        		}        			
        	}
        }
		return konektatuak;
	}
}
