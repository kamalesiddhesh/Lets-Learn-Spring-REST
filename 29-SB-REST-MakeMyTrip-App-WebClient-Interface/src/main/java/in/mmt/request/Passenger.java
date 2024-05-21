package in.mmt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Passenger {
	

	private String fname;
	private String lname;
	private String from;
	private String to;
	private String doj;
	private String trainNum;


}
