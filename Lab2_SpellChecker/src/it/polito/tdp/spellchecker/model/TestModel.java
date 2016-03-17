package it.polito.tdp.spellchecker.model;
import java.util.*;

public class TestModel {

	public static void main(String[] args) {

		
		Dictionary d= new ItalianDictionary();
		
		List<String> lista =new LinkedList<String>();
		lista.add("aaads");
		lista.add("abbagliare");
		lista.add("abbaliare");
		lista.add("acassdsdsa");
		lista.add("aciaone");
		lista.add("acronimo");
		lista.add("ammoree");
		lista.add("asticela");
		lista.add("ciao");
		lista.add("cuore");
		lista.add("fiore");
		lista.add("hola");
		lista.add("malol");
		lista.add("sole");
	//	d.loadDictionary();
		
		d.aggiungiParola(new RichWord("ciao",true));
		d.aggiungiParola(new RichWord("cuore",true));
		d.aggiungiParola(new RichWord("fiore",true));
		d.aggiungiParola(new RichWord("hola",true));
		d.aggiungiParola(new RichWord("malol",true));
		d.aggiungiParola(new RichWord("sole",true));
		
		System.out.println(d.ricercaDicotomica(lista));
	}

}
