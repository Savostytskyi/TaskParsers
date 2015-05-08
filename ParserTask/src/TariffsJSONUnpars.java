import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;






import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;


public class TariffsJSONUnpars {

private static final String filePath = "Tariff.json";
	
public ArrayList unpars(){
	System.out.println("JSON parser:");
	  ArrayList<Tariffs> tariffs = new ArrayList<Tariffs>();

	try {
		
		FileReader reader = new FileReader(filePath);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

JSONArray tariff= (JSONArray) jsonObject.get("tariff");


Iterator i = tariff.iterator();

		while (i.hasNext()) {
			List<String> parameters = new ArrayList<String>();
			List<String> callprices = new ArrayList<String>();
			Tariffs t = new Tariffs();
			JSONObject innerObj = (JSONObject) i.next();
			t.setName((String) innerObj.get("name"));
			t.setOperatorname((String) innerObj.get("operatorname"));
			t.setPayroll((String) innerObj.get("payroll"));
			t.setSmsprices((String) innerObj.get("smsprice"));
			
			JSONObject ob2 = (JSONObject) innerObj.get("callprices");	
			callprices.add("outnetwork: "+ob2.get("outnetwork"));
			callprices.add("landlines: "+ob2.get("landlines"));
			callprices.add("withinthenetwork: "+ob2.get("withinthenetwork"));
			t.setCallprices((ArrayList<String>) callprices);

		
			JSONObject ob3 = (JSONObject) innerObj.get("parameters");
			parameters.add("favoritenumber: "+ob3.get("favoritenumber"));
			parameters.add("billing: "+ob3.get("billing"));
			parameters.add("connectionfee: "+ob3.get("connectionfee"));
			t.setParameters((ArrayList<String>) parameters);

	
		
		tariffs.add(t);
			}

	} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	Collections.sort(tariffs);
return tariffs;
	}


public void makeJson(ArrayList<Tariffs> unp) throws IOException {
String temp = "";
	for (Tariffs tariffs : unp) {
		Tariffs truck = new Tariffs();
		 truck = tariffs;

 Gson gson = new Gson();

 String json = gson.toJson(truck); 
 temp= temp+json;
 FileWriter file = new FileWriter("NewJson.json");
 try {
	 file.append(temp);
 } catch (IOException e) {
     e.printStackTrace();

 } finally {
     file.flush();
     file.close();
 }
	}
	 System.out.println("Successfully Copied JSON Object to File NewJson.json");

}


}
