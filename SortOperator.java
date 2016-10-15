package cs4321_p2;

import java.util.ArrayList;
import java.util.List;

import net.sf.jsqlparser.statement.select.OrderByElement;

public class SortOperator extends Operator{

	
	private List<Tuple> tuples;
	private List<Integer> order;
	private int index;
	private ScanOperator child;
	
	
	@Override
	public Tuple getnextTuple() {
		// TODO Auto-generated method stub
		if(index >= this.tuples.size())
			return null;
		Tuple tmp = this.tuples.get(index);
		index ++;
		return tmp;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		index = 0;
	}

	
	SortOperator (ScanOperator child, List<OrderByElement> order){
		this.index = 0;
		this.child = child;
		List<Tuple> tmp = new ArrayList<Tuple>();
		Tuple tp = null;
		this.child.reset();
		while((tp = this.child.getnextTuple()) != null){
			tmp.add(tp);
		}
		this.child.reset();
		
		for(OrderByElement oe : order){
			int i = child.getschema().indexOf(oe.toString());
			this.order.add(i);
			for(int k = 0; k < tmp.size() - 1; k ++){
				for(int m = 0; m < tmp.size(); m++){
					if(Integer.parseInt(tmp.get(m).get(i)) >  Integer.parseInt(tmp.get(k).get(i))){
						Tuple temp = tmp.get(k);
						tmp.set(k , tmp.get(m));
						tmp.set(m, temp);
					}
				}
			}
		}
		this.tuples = tmp;
	}
}
