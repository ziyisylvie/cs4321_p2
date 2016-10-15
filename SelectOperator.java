package cs4321_p2;

import java.util.List;

import net.sf.jsqlparser.expression.Expression;

/**
 * 
 * @author Ziyi Wang(zw376)
 *
 */

public class SelectOperator extends Operator{
	
	private ScanOperator child;
	private Expression exp;
	private SelectExpression se;
	
	
	SelectOperator (ScanOperator child, Expression exp){
		this.child = child;
		this.exp = exp;
		se = new SelectExpression(child.getschema());
	}

	@Override
	public Tuple getnextTuple() {
		Tuple tuple = child.getnextTuple();
		while(tuple != null){
			if(this.exp == null)
				return tuple;
			else{
				if(this.getres(tuple))
					return tuple;
			}
		}
		return null;
	}
	
	public boolean getres(Tuple t){
		se.setTuple(t);
		exp.accept(se);
		return se.getResult();
	}

	@Override
	public void reset() {
		child.reset();
		
	}
	
	public List<String> getschema(){
		return this.child.getschema();
	}

}

