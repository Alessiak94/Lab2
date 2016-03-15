package it.polito.tdp.spellchecker.model;
import java.util.*;

public class Dictionary {
	
	private List<RichWord> lista;
	
	public Dictionary(){
		lista=new ArrayList<RichWord>();
	}
	
	public String loadDictionary(){
		return "";
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> l= new LinkedList<RichWord>();
		for(int i=0;i<inputTextList.size();i++)
			if(lista.equals(inputTextList.get(i).toLowerCase())==false){
				l.add(new RichWord(inputTextList.get(i).toLowerCase(), false));
				}
		return l;
	}

	public void aggiungiParola(RichWord r){
		lista.add(r);
	}
	
}
