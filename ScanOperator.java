package cs4321_p2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScanOperator extends Operator{
	

	private String tablename;
	private int index;
	private List<String> data;
	
	ScanOperator (String table){
		this.tablename = table;
		this.index = 0;
		try {
			this.data = Files.readAllLines
					(Paths.get(DatabaseC.gettablelocation() + File.separator + tablename + ".txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Tuple getnextTuple() {
		Tuple res = new Tuple(data.get(index));
		index = index + 1;
		return res;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		index = 0;
	}
	
	public List<String> getschema(){
		schema s = new schema(tablename);
		List<String> l = s.getschema();
		List<String> res = new ArrayList<String>();
		for(String st : l){
			res.add(tablename + "." + st);
		}
		return res;
	}
}
