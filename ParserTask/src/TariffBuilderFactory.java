import java.util.ArrayList;


public class TariffBuilderFactory {

		private enum TypeParser {
		SAX, JAXB, DOM, JDOM, EXEL
		}
		public static ArrayList createTariffBuilder(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
		case DOM:
		return new TariffsDOMBuilder().xmlDocumentParser();
		case EXEL:
		return new TariffsEXELBuilder().xmlDocumentParser();
		case JDOM:
		return new TariffsJDOMBuilder().xmlDocumentParser();
		case JAXB:
		return new TariffsJAXBBuilder().xmlDocumentParser();
		case SAX:
		return new TariffsSAXBuilder().xmlDocumentParser();
		default:
		throw new EnumConstantNotPresentException(
		type.getDeclaringClass(), type.name());
		}
		}
		}

