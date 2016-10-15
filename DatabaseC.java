package cs4321_p2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Store all the locations of the table and the location of scheme file. 
 * Store the schema for each table in a list
 * @author Sylvie
 *
 */
public class DatabaseC {
	
	public  static DatabaseC instance;
	private static String schemalocation = "";
	private static String tablelocation = "";
	
	private static String input = "";
	private static String output = "";
	
	private static Map<String, schema> map;
	               
	
	
	/**
	 * add new table to schema
	 * @param e
	 */
	
	public static String getschemalocation(){
		return schemalocation;
	}
	
	public static String gettablelocation(){
		return tablelocation;
	}
	
	
	public void setlocation(String in, String out){
		output = output + out;
		input = input + in;
		schemalocation = input + "db" + File.separator + "schema.txt";
		tablelocation = input + "db" + File.separator +"data" + File.separator;
	}
	
	public void setschema(){
		try {
			List<String> lines = Files.readAllLines
					(Paths.get(schemalocation + File.separator + "schema.txt"));
			for(String s : lines){
				String[] tmp = s.split(" ");
				map.put(tmp[0], new schema(tmp[0]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
