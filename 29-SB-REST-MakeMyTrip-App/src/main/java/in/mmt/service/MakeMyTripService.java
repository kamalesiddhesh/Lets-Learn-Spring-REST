package in.mmt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.mmt.request.Passenger;
import in.mmt.response.Ticket;
@Service
public class MakeMyTripService {
	
	@Value("${irctc.endpoint.book_ticket}")
	private String IRCTC_BOOK_TICKET_URL;
	
	@Value("${irctc.endpoint.get_ticket}")
	private String IRCTC_GET_TICKET_URL;
	
	public Ticket processTicketBooking(Passenger request) {
		
		//Creating RestTemplate Object which can communicate with Other application using given URL
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(IRCTC_BOOK_TICKET_URL,request,Ticket.class);
		HttpStatus statusCode= (HttpStatus) responseEntity.getStatusCode();
		
		if(statusCode == HttpStatus.OK) {
			Ticket ticket = responseEntity.getBody();
			return ticket;
		}
		return  null;
	}
	
	public Ticket getTicketInfo(String ticketId) {
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(IRCTC_GET_TICKET_URL, Ticket.class,ticketId);
		HttpStatus statusCode =  (HttpStatus) responseEntity.getStatusCode();
		
		if(statusCode == HttpStatus.OK) {
			Ticket ticket = responseEntity.getBody();
			System.out.println(ticket);
			return ticket;
		}
		return null;
	}
	

}
