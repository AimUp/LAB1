package org.dea.packlaborategi3;

import java.util.*;
import java.io.*;

public class Teklatua {

	private ListaPelikulak listaP;
	private ListaAktoreak listaA;
	private static Teklatua nireTeklatua = null;
	private String[] izenak;
	private Graph1 metodo1;
	private Graph2 metodo2;
	private Scanner sc;
	
	private Teklatua(){
		listaA = new ListaAktoreak();
		listaP = new ListaPelikulak();
		izenak = new String[2];
		sc = new Scanner(System.in);
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
			metodo2.grafoaSortu(listaA.getLista());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void izenakEskatu(){
		String izen1, izen2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bi aktore konektatuta dauden jakiteko bi akotoreren izenak beharko ditugu.");
		System.out.println("Idatzi lehenengo aktorearen izena:");
		
		izen1 = sc.nextLine();
				
		System.out.println("Orain zartu bigarren aktorearen izena:");
		
		izen2 = sc.nextLine();
		if(!metodo2.aktoreaBadago(izen1, izen2)){
			izenak[0] = izen1;
			izenak[1] = izen2;
		}
		else{
			System.out.println("Aktoreetako bat gutxienez ez dago datu basean, idatzi izenak berriro:");
			izenakEskatu();
		}
	}
	
	private int zenbakiaSartu(){
		int zenb;
		
		System.out.println("1-> Bi aktore konektatuta dauden jakin.");
		System.out.println("2-> ...");

		System.out.println("0-> Irten.");
		
		
		zenb = sc.nextInt();
		if(0>zenb || 2<zenb){
			System.out.println("Zenbaki okerra sartu da. Aukeratu menuko zenbaki bat:");
			zenb = zenbakiaSartu();
		}
		return zenb;
	}
	
	private void letraSartu(){
		String letra = null;
		
		System.out.println();
		System.out.println();
		System.out.println("Beste eragiketarik egin nahi?");
		System.out.println("B-> Bai");
		System.out.println("E-> Ez");
		
		letra = sc.nextLine();
		
		if(letra.equals("B") || letra.equals("b")){
			nireTeklatua.menua();
		}
		else if(letra.equals("E") || letra.equals("e")){
				System.out.println("Programa bukatuko da.");
			}
			else{
				System.out.println("Letra ez egokia, berriro erantzun.");
				letraSartu();
			}
	}
	
	
	public void menua(){
		Scanner sc = new Scanner(System.in);
		int menuZenb;
		String menuLetra;
		
		System.out.println("Aukeratu egin nahi duzun eragiketa:");
		System.out.println();
		menuZenb = zenbakiaSartu();
		
		if(menuZenb == 1){
			boolean konektatuak = false;
			izenakEskatu();
			konektatuak = metodo2.konektaturikDaude(izenak[0], izenak[1]);
			if(konektatuak){
				System.out.println("AKTOREAK KONEKTATURIK DAUDE!");
			}
			else{
				System.out.println("AKTOREAK EZ DAUDE KONEKTATURIK!");
			}
		}
		if(menuZenb == 2){
			//EGITEKO
		}
		sc.nextLine();
		letraSartu();
		
	}
	
	
}
