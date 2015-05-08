import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File; 
import java.util.ArrayList;
import java.util.Collections;
	
public class TariffsDOMBuilder extends AbstractTariffBuilder {

	@Override
	public ArrayList xmlDocumentParser() {
		System.out.println("DOM parser:");
		 try
	        {
	            File xmlFile = new File("Tariff.xml");
	            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	            Document document = documentBuilder.parse(xmlFile);
	            document.getDocumentElement().normalize();
	          
	            
	            
	            NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
	  
	            for(int tmp = 0; tmp < nodeList.getLength(); tmp++)
	            {
	                Node node = nodeList.item(tmp);
	                if(node.getNodeType() == Node.ELEMENT_NODE)
	                {
	                	
	                    Element element = (Element)node;
	                    Tariffs t = new Tariffs();
	                    t.setName(element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
	                    t.setOperatorname(element.getElementsByTagName("operatorname").item(0).getChildNodes().item(0).getNodeValue());
	                    ArrayList<String> callprices = new ArrayList<String>();
	                    callprices.add("withinthenetwork = "+element.getElementsByTagName("withinthenetwork").item(0).getChildNodes().item(0).getNodeValue());
	                    callprices.add("outnetwork = "+ element.getElementsByTagName("outnetwork").item(0).getChildNodes().item(0).getNodeValue());
	                    callprices.add("landlines = "+element.getElementsByTagName("landlines").item(0).getChildNodes().item(0).getNodeValue());
	                    t.setCallprices(callprices);
	                    t.setSmsprices(element.getElementsByTagName("smsprice").item(0).getChildNodes().item(0).getNodeValue());
	                    t.setPayroll(element.getElementsByTagName("payroll").item(0).getChildNodes().item(0).getNodeValue());                  
	                    ArrayList<String> parameters = new ArrayList<String>();
	                    parameters.add("favoritenumber = "+ element.getElementsByTagName("favoritenumber").item(0).getChildNodes().item(0).getNodeValue());
	                    parameters.add("billing = "+element.getElementsByTagName("billing").item(0).getChildNodes().item(0).getNodeValue());
	                    parameters.add("connectionfee = "+element.getElementsByTagName("connectionfee").item(0).getChildNodes().item(0).getNodeValue());
	                    t.setParameters(parameters);
	                    tariffs.add(t);
	                }
	            }
	 
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getLocalizedMessage());
	            e.printStackTrace();
	        }	
		 Collections.sort(tariffs);
		return tariffs;
	}
	
}


