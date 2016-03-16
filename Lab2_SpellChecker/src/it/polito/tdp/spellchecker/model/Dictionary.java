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
		List<RichWord> l= new LinkedList<RichWord>();

		List<RichWord> temp=lista;
		Collections.sort(temp, new ComparatoreParole());
		
		for(int i =0;i<input.size();i++){

			
			int numero=temp.size()/2;
			int inf=0;
			int sup=temp.size();
			while(numero!=0&&numero!=1&&numero!=temp.size()-1&&numero!=temp.size()){
				/*System.out.println("Gradezza Lista: "+temp.size());
				System.out.println("Numero: "+numero);
				System.out.println("inferiore: "+inf+" Superiore: "+sup);
				*/
				if(temp.get(numero).getParola().compareTo(input.get(i).toLowerCase())==0)
					{
					//System.out.println("Trovata");
					numero=0;}
				else if(temp.get(numero).getParola().compareTo(input.get(i))<0){
				
					//System.out.println("Minore");
					sup=numero;
					numero=inf+(sup-inf)/2;
					
				}
				else {
					//System.out.println("Maggiore");
					inf=(numero);
					 numero=(inf+(sup-inf)/2);
					 
				}
			}
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
