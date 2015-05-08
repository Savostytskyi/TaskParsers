import java.io.IOException;
import java.util.ArrayList;


public class Runner {
	public static void main(String[] args) throws IOException{
		TariffsJSONUnpars unpars = new TariffsJSONUnpars();
		System.out.println(unpars.unpars());
		
		//System.out.println(TariffBuilderFactory.createTariffBuilder("DOM"));
		//System.out.println(TariffBuilderFactory.createTariffBuilder("JDOM"));
		//System.out.println(TariffBuilderFactory.createTariffBuilder("JAXB"));
				System.out.println(TariffBuilderFactory.createTariffBuilder("SAX"));

		ArrayList<Tariffs> unp = new ArrayList<Tariffs>();
		unp = unpars.unpars();
		unpars.makeJson(unp);
	}
}
