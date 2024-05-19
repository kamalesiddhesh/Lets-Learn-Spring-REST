package in.erail.request;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Passenger {
	
	private String fname;
	private String lname;
	private String from;
	private String to;
	private String doj;
	private String trainNum;

}
