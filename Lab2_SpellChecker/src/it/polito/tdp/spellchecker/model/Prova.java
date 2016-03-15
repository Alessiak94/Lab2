package it.polito.tdp.spellchecker.model;
import java.util.*;

public class Prova {

	public static void main(String[] args) {

		
		Dictionary d= new EnglishDictionary();
		List<String> lista =new LinkedList();
		lista.add("abase");
		lista.add("aabbababa");
		d.loadDictionary();
		
		System.out.println(d.spellCheckText(lista));
	}

}
