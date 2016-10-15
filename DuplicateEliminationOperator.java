package cs4321_p2;

public class DuplicateEliminationOperator extends Operator{

	private ScanOperator child;
	Tuple last;
	@Override
	public Tuple getnextTuple() {
		// TODO Auto-generated method stub
		if(last == null){
			last = child.getnextTuple();
			return last;
		}
		else{
			Tuple t = null;
			while((t = child.getnextTuple()) != null){
				if(t.getTuple() == last.getTuple())
					break;
			}
			last = t;
			return t;
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.child.reset();
	}
	
	DuplicateEliminationOperator(ScanOperator child){
		this.child = child;
		this.last = null;
	}

}
