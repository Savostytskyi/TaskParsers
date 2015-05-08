import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
public class TariffsSAXBuilder extends AbstractTariffBuilder{
	Tariffs t;
	
	@Override
	public ArrayList xmlDocumentParser() {
    {
    	System.out.println("SAX parser:");
        try
        {
       
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler defaultHandler = new DefaultHandler()
            {
                boolean bName = false;
                boolean bOperatorname = false;
                boolean bTariff = false;
                boolean bPayroll = false;
                boolean bCallprices = false;
                boolean bSmsprices = false;
	                boolean bWithinthenetwork = false;
	                boolean bOutnetwork = false;
	                boolean bLandlines = false;	                
	            boolean bParameters = false;
		            boolean bFavoritenumber = false;
	                boolean bBilling = false;
	                boolean bConnectionfee = false;
	                
	                
	                List<String> callprices = new ArrayList<String>();
	                List<String> parameters = new ArrayList<String>();
	              
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
                   // System.out.println("Start element: " + qName);
                    if(qName.equalsIgnoreCase("name")){
                    	bName = true;
                    }
                    if(qName.equalsIgnoreCase("tariff")){
                        bTariff = true;
                    }
                    if(qName.equalsIgnoreCase("operatorname")){
                    	bOperatorname = true;
                    }
                    if(qName.equalsIgnoreCase("payroll")){
                    	bPayroll = true;
                    }
                    if(qName.equalsIgnoreCase("smsprice")){
                    	bSmsprices = true;
                    }
                    if(qName.equalsIgnoreCase("callprices")){
                    	bCallprices = true;
                    	   
                    }
		                    if(qName.equalsIgnoreCase("withinthenetwork")){
		                    	bWithinthenetwork = true;
		                    }
		                    if(qName.equalsIgnoreCase("outnetwork")){
		                    	bOutnetwork = true;
		                    }
		                    if(qName.equalsIgnoreCase("landlines")){
		                    	bLandlines = true;
		                    }
		           if(qName.equalsIgnoreCase("parameters")){
		                bParameters = true;
		                    	   
		                    }
				                    if(qName.equalsIgnoreCase("favoritenumber")){
				                    	bFavoritenumber = true;
				                    }
				                    if(qName.equalsIgnoreCase("billing")){
				                    	bBilling = true;
				                    }
				                    if(qName.equalsIgnoreCase("connectionfee")){
				                    	bConnectionfee = true;
				                    }
                }
 
                public void endElement(String uri, String localName, String qName) throws SAXException{
                 //   System.out.println("End element: " + qName);
                }
 
                public void characters(char ch[], int start, int length) throws SAXException{
                 
                    if(bTariff){
                    	t = new Tariffs();
                    	  this.callprices = new ArrayList<String>();
                    	  this.parameters = new ArrayList<String>();  
                        tariffs.add(t);                  
                        bTariff = false;
                    }
                    
                    if(bParameters){                   	
              
                        bParameters = false;
                    }
                    
                    if(bName){
                        t.setName(new String(ch, start, length));
                        bName = false;
                    }    
                   
                    if(bSmsprices){
                        t.setSmsprices(new String(ch, start, length));
                        bSmsprices = false;
                    }  
                    if(bPayroll){
                        t.setPayroll(new String(ch, start, length));
                        bPayroll = false;
                    }
                    if(bOperatorname){
                    	 t.setOperatorname(new String(ch, start, length));
                        bOperatorname = false;
                    }
                    if(bCallprices){
                   	bCallprices = false;
                    }
		                    if(bWithinthenetwork){
		                    
		                    	callprices.add("withinthenetwork = "+ new String(ch, start, length));
		                    	bWithinthenetwork = false;
		                    }
		                    if(bOutnetwork){
		                    	 callprices.add("outnetwork = "+ new String(ch, start, length));
		                    	bOutnetwork = false;
		                    }
		                    if(bLandlines){
		                    	callprices.add("landlines = "+ new String(ch, start, length));
		                    	bLandlines = false;
		                    	t.setCallprices((ArrayList<String>)callprices);
		                    	
		                    }
		                    
		                   
		                    if(bFavoritenumber){
			                    
		                    	parameters.add("favoritenumber = "+new String(ch, start, length));
		                    	bFavoritenumber = false;
		                    }
		                    if(bBilling){
		                    	parameters.add("billing = "+new String(ch, start, length));
		                    	bBilling = false;
		                    }
		                    if(bConnectionfee){
		                    	parameters.add("connectionfee = "+new String(ch, start, length));
		                    	bConnectionfee = false;
		                    	t.setParameters((ArrayList<String>)parameters);
		                    	
		                    }
                                      
                }
       
            };
           
            saxParser.parse("Tariff.xml", defaultHandler);
        	
        }
        catch (Exception ex)
        {
           System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        Collections.sort(tariffs);
    	return tariffs;
    }
	}
}


