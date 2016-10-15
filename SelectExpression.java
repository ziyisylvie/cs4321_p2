package cs4321_p2;

import java.util.List;

import net.sf.jsqlparser.schema.Column;

public class SelectExpression extends Exp{

	private Tuple t;
	private List<String> s;
	
	SelectExpression(List<String> s){
		this.s = s;
	}
	
	public void setTuple(Tuple t){
		this.t = t;
	}

	
	public Long getcol(Tuple tuple, String s, List<String> schema){
		int index = schema.indexOf(s);
		if(index != -1)
			return (long)Integer.parseInt(tuple.get(index));
		else{
			for(int i = 0; i < schema.size(); i++){
				String col = schema.get(i).split(".")[1];
				if(col == s)
					return (long)Integer.parseInt(tuple.get(i));
			}
			return null;
		}
		
	}
	
	
	
	@Override
	public void visit(Column arg0) {
		// TODO Auto-generated method stub
		this.currnumber = getcol(this.t, arg0.toString(), this.s);
		
	}

	
}
