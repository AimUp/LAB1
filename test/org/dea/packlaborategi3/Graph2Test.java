package org.dea.packlaborategi3;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class Graph2Test {

	Graph2 g2;
	String a1;
	String a2;
	HashMap<String, Integer >th1;
	HashMap<String,Integer> th2;
	ArrayList<Integer>[] adjList1; 
	ArrayList<Integer>[] adjList2;
	

	public void setUp() throws Exception {
		a1 = "Aimar";
		a2 = "Ugarte";
		th1 = new HashMap<String,Integer>();
		th1.put("Aimar", 0);
		th1.put("Ugarte", 1);
		th1.put("Ramia", 2);
		th1.put("Etragu", 3);
		
	
	}

	public void tearDown() throws Exception {
		a1=null;
		a2=null;
		th1=null;
	}

	
	@Test
	public void testAktoreaBadago() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrint() {
		fail("Not yet implemented");
	}

	@Test
	public void testKonektaturikDaude() {
	}

}
