package cs4321_p2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class schema {
	
	private String tablename;

	
	schema(String t){
		this.tablename = t;

	}
	
	public String gettablename(){
		return this.tablename;
	}
	
	public List<String> getschema(){
		List<String> res = new ArrayList<String>();
			try {
				List<String> lines = Files.readAllLines
						(Paths.get(DatabaseC.getschemalocation() + File.separator + "schema.txt"));
				for(String s : lines){
					String[] tmp = s.split(" ");
					if(tmp[0] == tablename){
						for(int i = 1; i < tmp.length; i++){
							res.add(tmp[i]);
						}
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;

		}
		
	}

