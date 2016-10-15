package cs4321_p2;
import java.util.List;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;

public class ProjectionOperator extends Operator {

	private Operator child;
	private Expression exp;
	private List<String> schema;
	
	@Override
	public Tuple getnextTuple() {
		if(this.child instanceof ScanOperator){
			return this.child.getnextTuple();
		}
		else{
			Tuple tmp = this.child.getnextTuple();
			Tuple t = new Tuple();
			List<String> l = ((SelectOperator)child).getschema();
			for(int i = 0; i < this.schema.size(); i++){
				int index = l.indexOf(schema.get(i));
				t.add(tmp.get(index));
			}
			if(((SelectOperator)child).getres(t) == true)
				return t;
			else
				return null;
		}
	}

	@Override
	public void reset() {
		this.child.reset();
	}
	
	ProjectionOperator(String t, List<SelectItem> select, ScanOperator child, Expression exp){
		this.exp = exp;
		if(this.exp == null){
			this.child = child;
		}else{
			this.child = new SelectOperator(child, this.exp);
		}
		for(SelectItem s : select){
			if(s instanceof AllTableColumns){
				this.schema = child.getschema();
			}
			else{
				Column col = (Column) ((SelectExpressionItem) s).getExpression();
				this.schema.add(col.getTable().toString() + "." + col.getColumnName());
			}
		}
		
	}
}
