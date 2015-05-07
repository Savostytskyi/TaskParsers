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
		 try {
			 
				File file = new File("jaxbTariff.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Tariffs.class);
		 
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Tariffs tarif = (Tariffs) jaxbUnmarshaller.unmarshal(file);
				System.out.println(tarif);
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }


	return null;
}
}