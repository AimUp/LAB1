package org.dea.packlaborategi3;

import java.util.*;
import java.io.*;

public class Teklatua {

	//ATRIBUTUAK
	private ListaPelikulak listaP;
	private ListaAktoreak listaA;
	private static Teklatua nireTeklatua = null;
	
	
	private Teklatua(){
		listaA = new ListaAktoreak();
		listaP = new ListaPelikulak();
	}
	
	public static synchronized Teklatua getTeklatua(){
		if(nireTeklatua == null){
			nireTeklatua = new Teklatua();
		}
		return nireTeklatua;
	}
	
	private String fitxategiarenHelbidea(){
		String itzuli;
		System.out.println("Idatzi kargatu nahi den fitxategiaren helbidea:");
		System.out.println("Adibidez: C://aktore-lista");
		Scanner helbidea = new Scanner(System.in);
		itzuli = helbidea.nextLine();
		return itzuli;
	}
	
	public void listaKargatu(){
		String pFitxategia = fitxategiarenHelbidea();
		try{
			Scanner fitxategia = new Scanner(new FileReader(pFitxategia));
			String linea;
			while(fitxategia.hasNext()){
				linea = fitxategia.nextLine();
				String[] items = linea.split("\\s*###\\s*");
				Aktore nireAktorea = new Aktore(items[0]);
				for(int i=1; i < items.length; i++){
					if(!listaP.contains(items[i])){
						Pelikula nirePelikula = new Pelikula(items[i]);
						listaP.addHash(items[i], nirePelikula);
						nireAktorea.gehituPelikula(nirePelikula);
						nirePelikula.geituAktore(nireAktorea);
					}
					else{
						nireAktorea.gehituPelikula(listaP.getPeli(items[i]));
						listaP.getPeli(items[i]).geituAktore(nireAktorea);;
					}
				}
				listaA.gehituAktorea(nireAktorea);
			}
			fitxategia.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String[] izenakEskatu(){
		Scanner sc = new Scanner(System.in);
		String izen1, izen2;
		String[] arraya = new String[2];
		
		System.out.println("Bi aktore konektatuta dauden jakiteko bi akotoreren izenak beharko ditugu.");
		System.out.println("Idatzi lehenengo aktorearen izena:");
		
		izen1 = sc.nextLine();
				
		System.out.println("Orain zartu bigarren aktorearen izena:");
		
		izen2 = sc.nextLine();
		
		arraya[1] = izen1;
		arraya[2] = izen2;
		return arraya;
	}
	
	
}
