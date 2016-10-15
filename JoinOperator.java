package cs4321_p2;

import java.util.List;

import net.sf.jsqlparser.expression.Expression;

public class JoinOperator extends Operator {

	private Operator leftchild;
	private Tuple currleft;
	private Operator rightchild;
	private Tuple currright;
	private Expression exp;
	private JoinExpression joinexp;
	private List<String> schema;
	
	@Override
	public Tuple getnextTuple() {
		// TODO Auto-generated method stub
		Tuple res = new Tuple();
		while(currleft != null && currright != null){
			if(exp == null){
				for(int i = 0; i < currleft.size(); i++){
					res.add(this.currleft.get(i));
				}
				for(int j = 0; j < currright.size(); j++){
					res.add(this.currright.get(j));
				}
			}
			else{
				if(this.getres(currleft, currright) == true){
					for(int i = 0; i < currleft.size(); i++){
						res.add(this.currleft.get(i));
					}
					for(int j = 0; j < currright.size(); j++){
						res.add(this.currright.get(j));
					}
				}
			}
			this.loop();
			if(res != null)
				return res;
		}
		return null;
	}
	
	public void loop() {
		if(currleft == null)
			return;
		if(currright != null){
			currright = this.rightchild.getnextTuple();
		}
		if(currright == null){
			currleft = this.leftchild.getnextTuple();
			this.rightchild.reset();
			this.currright = this.rightchild.getnextTuple();
		}
	}

	public JoinOperator(Expression exp, ScanOperator left, ScanOperator right){
		this.exp = exp;
		if(exp == null){
			this.leftchild = left;
			this.rightchild = right;
			this.schema = left.getschema();
			this.schema.addAll(right.getschema());
			this.currleft = leftchild.getnextTuple();
			this.currright = rightchild.getnextTuple();
			this.joinexp = new JoinExpression(null, null, left.getschema(), right.getschema());
					
		}
		else{
			this.leftchild = new SelectOperator(left, this.exp);
			this.rightchild = new SelectOperator(right, this.exp);
			this.schema = ((SelectOperator)leftchild).getschema();
			this.schema.addAll(((SelectOperator)rightchild).getschema());
			this.currleft = leftchild.getnextTuple();
			this.currright = rightchild.getnextTuple();
			this.joinexp = new JoinExpression(null, null, 
					((SelectOperator)leftchild).getschema(), ((SelectOperator)rightchild).getschema());
		}
	}
	
	public boolean getres(Tuple t1, Tuple t2){
		joinexp.setTuple(t1, t2);
		exp.accept(joinexp);
		return joinexp.getResult();
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.leftchild.reset();
		this.rightchild.reset();
	}
	
}
