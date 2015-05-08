import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TariffsJAXBBuilder extends AbstractTariffBuilder {
	
	
	
	@Override
	public ArrayList xmlDocumentParser() {
		System.out.println("JAXB parser:");
		 try
	        {
	            File file = new File("jaxbTariff.xml");
	            JAXBContext jaxbContext = JAXBContext.newInstance(Tariffs.class);
	 
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	              Tariffs tarr = (Tariffs)jaxbUnmarshaller.unmarshal(file);

	              
	            Tariffs t = new Tariffs();
	            List<String> callprices = new ArrayList<String>();
             List<String> parameters = new ArrayList<String>();
	            t.setName(tarr.getName());
	            t.setOperatorname(tarr.getOperatorname());
	            t.setPayroll(tarr.getPayroll());
	            t.setSmsprices(tarr.getSmsprices());

	            tariffs.add(t);

	        }
	        catch (JAXBException jaxbe)
	        {
	            System.out.println(jaxbe.getLocalizedMessage());
	            jaxbe.printStackTrace();
	        }
	return tariffs;
}
}