package org.dea.packlaborategi3;

import java.util.*;

import java.util.*;

public class Graph2 {
      HashMap<String, Integer> th;
      String[] keys;
      ArrayList<Integer>[] adjList;
      static Graph2 nireGrafoa;
      
   private Graph2(ArrayList<Aktore> pL){
	   grafoaSortu(pL);
   }
      
   public static synchronized Graph2 getNireGrapfoa(ArrayList<Aktore> pL){
	   if(nireGrafoa == null){
		   nireGrafoa = new Graph2(pL);
	   }
	   return nireGrafoa;
   }
   
    public boolean aktoreaBadago(String pIzen1, String pIzen2){
    	boolean badago = false;
    	if(th.containsKey(pIzen1) && th.containsKey(pIzen2)){
    		badago = true;
    	}
    	return badago;
    }
      
	private void grafoaSortu(ArrayList<Aktore> lAktoreak){
		// Post: aktoreen zerrendatik grafoa sortzen du
		//       Adabegiak aktoreen izenak eta pelikulen izenburuak dira 
		
		// 1. pausoa: th bete
	 	int kont = 0;
	 	th = new HashMap<String, Integer>();
		//for(Aktore a: lAktoreak){
		for(int o=0; o<lAktoreak.size(); o++){
	 		Aktore hunekoAktore = lAktoreak.get(o);
			th.put(hunekoAktore.getIzena(), kont++);
			for(Pelikula p: hunekoAktore.getListaP()){
				if(!th.containsKey(p.getIzenburua())){
					th.put(p.getIzenburua(), kont++);
				}
			}
		}
            // 2. pausoa: keys bete
			keys = new String[th.size()];
			for(String k: th.keySet()){
				keys[th.get(k)] = k;
			}
	
			
            // 3. pausoa: adjLista bete
			adjList = (ArrayList<Integer>[])new ArrayList[th.size()];
			for(int i=0; i<th.size(); i++){
				adjList[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<lAktoreak.size(); i++){
				
				ArrayList<Pelikula> nireListaP = lAktoreak.get(i).getListaP();
				int aktoreZenb = th.get(lAktoreak.get(i).getIzena());
				for(int j=0; j<nireListaP.size(); j++){
					int pelikulaZenb = th.get(nireListaP.get(j).getIzenburua());
					adjList[aktoreZenb].add(pelikulaZenb);
					adjList[pelikulaZenb].add(aktoreZenb);
				}
			}
		
	}
	
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean konektaturikDaude(String a1, String a2){
		boolean aurkitua = false;
		boolean bukaera = false;
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		if(!th.containsKey(a1) || !th.containsKey(a2)){
			System.out.println("Aktoreetako bat ez dago datu basean, sartu aktoreak berriro.");
			String[] izenak = new String[2];
			izenak = Teklatua.getTeklatua().izenakEskatu();
			konektaturikDaude(izenak[0], izenak[2]);
		}
		else{
			int pos1 = th.get(a1);
			int pos2 = th.get(a2);
			boolean[] aztertuak = new boolean[th.size()];
			Queue<Integer> aztertuGabeak = new Queue<>();
		 // KODEA OSATU
		}
		return aurkitua;

	}
}
