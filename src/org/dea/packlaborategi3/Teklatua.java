package org.dea.packlaborategi3;

import java.util.*;
import java.io.*;

public class Teklatua {

	private ListaPelikulak listaP;
	private ListaAktoreak listaA;
	
	private String fitxategiarenHelbidea(){
		String itzuli;
		System.out.println("Idatzi kargatu nahi den fitxategiaren helbidea:");
		Scanner helbidea = new Scanner(System.in);
		itzuli = helbidea.nextLine();
		return itzuli;
	}
	
	public void listakKargatu(){
		String pFitxategia = fitxategiarenHelbidea();
		try{
			Scanner fitxategia = new Scanner(new FileReader(pFitxategia));
			String linea;
			while(fitxategia.hasNext()){
				linea = fitxategia.nextLine();
				String[] items = linea.split("\\s*###\\s*");
				Aktore nireAktorea = new Aktore(items[0]);
				for(int i=1; i < items.length; i++){
					if(Pelikula ez da existitzen){
						Pelikula nirePelikula = new Pelikula(items[i]);
						nireAktorea.getListaP().add(nirePelikula);
						nirePelikula.getListaA().add(nireAktorea);
					}
					else{
						nireAktorea.getListaP().add(geneukan pelikula);
						geneukan pelikula.getListaA().add(nireAktorea);
					}
				}
				listaA.getListA().add(nireAktorea);
			}
			fitxategia.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
}
