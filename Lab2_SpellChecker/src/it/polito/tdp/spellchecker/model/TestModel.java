package it.polito.tdp.spellchecker.model;
import java.util.*;

public class TestModel {

	public static void main(String[] args) {

		
		Dictionary d= new ItalianDictionary();
		
		List<String> lista =new LinkedList<String>();
		lista.add("abbagliare");
		lista.add("abbaliare");
		lista.add("ciao");
		lista.add("hola");
		lista.add("casa");
		d.loadDictionary();
		System.out.println("---"+3/2);
		System.out.println(d.ricercaDicotomica(lista));
	}

}
