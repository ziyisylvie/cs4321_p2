package cs4321_p2;

import java.util.List;

public class Tuple {
	private List<String> tuple;
	
	Tuple (String t){
		String[] tmp = t.split(",");
		for(String i : tmp){
			tuple.add(i);
		}
	}
	
	Tuple(){
		
	};
	
	public List<String> getTuple(){
		return this.tuple;
	}
	
	public String get(int index){
		return tuple.get(index);
	}
	
	public void add(String s){
		tuple.add(s);
	}
	
	public int find(String s){
		return tuple.indexOf(s);
	}
	
	public int size(){
		return tuple.size();
	}
}
