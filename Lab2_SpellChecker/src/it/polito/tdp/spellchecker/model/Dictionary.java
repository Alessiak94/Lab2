package it.polito.tdp.spellchecker.model;
import java.util.*;

public class Dictionary {
	
	private List<RichWord> lista;
	
	public Dictionary(){
		lista=new ArrayList<RichWord>();
	}
	
	public void loadDictionary(){
	}
	
	
	public List<RichWord> ricercaDicotomica(List<String> input){
		List<RichWord> l=new LinkedList<RichWord>();
		
		
		for(int i=0;i<input.size();i++){//System.out.println("Cerca: "+input.get(i));
		boolean a=false;
		int inizio=0;
		int fine= lista.size()-1;
		int centro=0;
		while(inizio<=fine){
			centro=(inizio+fine)/2;// System.out.println("inizio: "+inizio+" fine: "+fine+" centro: "+centro);
			if(lista.get(centro).getParola().compareTo(input.get(i).toLowerCase())>0)
				fine= centro-1;
			else if(lista.get(centro).getParola().compareTo(input.get(i).toLowerCase())<0)
				inizio=centro+1;
			else {//System.out.println("TROVATA");
				a=true;
				break;
			}
		
		}
		if(a==false)
			l.add(new RichWord(input.get(i).toLowerCase(),false));
		}
		
		
		return l;
	}	
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> l= new LinkedList<RichWord>();

		for(int i=0;i<inputTextList.size();i++)
			if(lista.contains(new RichWord(inputTextList.get(i).toLowerCase(), false))==false){
				l.add(new RichWord(inputTextList.get(i).toLowerCase(), false));

				}
		return l;
	}
	
	
	

	public void aggiungiParola(RichWord r){
		lista.add(r);
	}
	
}
