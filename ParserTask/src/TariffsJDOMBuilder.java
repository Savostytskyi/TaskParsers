import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
 
 
public class TariffsJDOMBuilder extends AbstractTariffBuilder {
 
	public ArrayList xmlDocumentParser() {
		System.out.println("JDOM parser:");
        final String fileName = "Tariff.xml";
        org.jdom2.Document jdomDoc;
        try {
            jdomDoc = useDOMParser(fileName);
            Element root = jdomDoc.getRootElement();
            List<Element> tariffListElements = root.getChildren("tariff");
   
            for (Element tariffElement : tariffListElements) {
            	Tariffs t = new Tariffs();

                t.setName(tariffElement.getChildText("name"));
                t.setOperatorname(tariffElement.getChildText("operatorname"));
                ArrayList<String> callprices = new ArrayList<String>();                         
                callprices.add("withinthenetwork = "+tariffElement.getChild("callprices").getChildText("withinthenetwork"));
                callprices.add("outnetwork = "+tariffElement.getChild("callprices").getChildText("outnetwork"));
                callprices.add("landlines = "+tariffElement.getChild("callprices").getChildText("landlines"));
                t.setCallprices(callprices);
                
                t.setSmsprices(tariffElement.getChildText("smsprice"));
                t.setPayroll(tariffElement.getChildText("payroll"));   

                
                ArrayList<String> parameters = new ArrayList<String>();
                parameters.add("favoritenumber = "+tariffElement.getChild("parameters").getChildText("favoritenumber"));
                parameters.add("billing = "+tariffElement.getChild("parameters").getChildText("billing"));
                parameters.add("connectionfee = "+tariffElement.getChild("parameters").getChildText("connectionfee"));
                t.setParameters(parameters);
                
            
                tariffs.add(t);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
 return tariffs;
    }

    private static org.jdom2.Document useDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);
 
    }
}
