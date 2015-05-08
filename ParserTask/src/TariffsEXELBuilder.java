import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class TariffsEXELBuilder extends AbstractTariffBuilder {

	@Override
	public ArrayList xmlDocumentParser() {
		System.out.println("EXEL parser:");
		  ArrayList<String> roww = new ArrayList<String>();
	        InputStream inputStream = null;
	        HSSFWorkbook workBook = null;
	    
	        try {
	            inputStream = new FileInputStream("pars.xls");
	            workBook = new HSSFWorkbook(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        Sheet sheet = workBook.getSheetAt(0);
	        Iterator<Row> it = sheet.iterator();
	   
	        while (it.hasNext()) {
	            Row row = it.next();
	            
	            Iterator<Cell> cells = row.iterator();
	         
	            while (cells.hasNext()) {
	                Cell cell = cells.next();
	                int cellType = cell.getCellType();
	                switch (cellType) {
	                    case Cell.CELL_TYPE_STRING:                    
	                        roww.add(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                    	roww.add(cell.getStringCellValue());
	                        break;
	                    default:
	                    
	                        break;
	                }

	            }
	         
	            
	            Tariffs t = new Tariffs();
	            t.setName(roww.get(0));
	            t.setOperatorname(roww.get(1));
	            t.setPayroll(roww.get(2));
	            
	            ArrayList<String> callprices = new ArrayList<String>();
                callprices.add("withinthenetwork = "+roww.get(3));
                callprices.add("outnetwork = "+roww.get(4));
                callprices.add("landlines = "+roww.get(5));
                t.setCallprices(callprices);
                  
                ArrayList<String> parameters = new ArrayList<String>();
                parameters.add("favoritenumber = "+roww.get(6));
                parameters.add("billing = "+roww.get(8));
                parameters.add("connectionfee = "+roww.get(7));
                t.setParameters(parameters);
	            
	            
	                     
	            for (int j = 0; j < 10; j++) {
	            	roww.remove(0);
				}
	            
	            tariffs.add(t);
	
	}
	       tariffs.remove(0);
           // System.out.println(roww);
            Collections.sort(tariffs);
	    	return tariffs;
	}
	
}