import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class Tariffs {

	private String name;
	private String operatorname;
	private String payroll;
	private ArrayList<String>callprices= new ArrayList<String>();
	private String smsprices;
	private ArrayList<String>parameters= new ArrayList<String>();
	

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOperatorname() {
		return operatorname;
	}
	@XmlElement

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public String getPayroll() {
		return payroll;
	}
	@XmlElement

	public void setPayroll(String payroll) {
		this.payroll = payroll;
	}
	public ArrayList<String> getCallprices() {
		return callprices;
	}
	@XmlElement

	public void setCallprices(ArrayList<String> callprices) {
		this.callprices = callprices;
	}
	
	public String getSmsprices() {
		return smsprices;
	}
	@XmlElement

	public void setSmsprices(String smsprices) {
		this.smsprices = smsprices;
	}

	public ArrayList<String> getParameters() {
		return parameters;
	}
	@XmlElement

	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public String toString() {
		return "\n Tariffs [name=" + name + ", operatorname=" + operatorname
				+ ", payroll=" + payroll + ", callprices=" + callprices
				+ ", smsprices=" + smsprices + ", parameters=" + parameters
				+ "]";
	}
	
	
	
	
}
