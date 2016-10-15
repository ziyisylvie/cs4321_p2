package cs4321_p2;

import java.util.List;

import net.sf.jsqlparser.schema.Column;

public class JoinExpression extends Exp{

	
	private Tuple t1;
	private Tuple t2;
	private List<String> schema1;
	private List<String> schema2;
	
	JoinExpression(Tuple t1, Tuple t2, List<String> s1, List<String> s2){
		this.t1 = t1;
		this.t2 = t2;
		this.schema1 = s1;
		this.schema2 = s2;
	}
	
	public void setTuple(Tuple t1, Tuple t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public Long getcol(Tuple tuple, String s, List<String> schema){
		int index = schema.indexOf(s);
		if(index != -1)
			return (long)Integer.parseInt(tuple.get(index));
		else
			return null;
	}
	
	@Override
	public void visit(Column arg0) {
		// TODO Auto-generated method stub
		Long curr = getcol(t1, arg0.toString(), schema1);
		if(curr == null)
			curr = getcol(t2, arg0.toString(), schema2);
		this.currnumber = curr;
	}

}
