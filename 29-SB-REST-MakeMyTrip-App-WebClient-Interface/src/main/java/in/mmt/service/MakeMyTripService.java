package in.mmt.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

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
		/*
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(IRCTC_BOOK_TICKET_URL,request,Ticket.class);
		HttpStatus statusCode= (HttpStatus) responseEntity.getStatusCode();
		
		if(statusCode == HttpStatus.OK) {
			Ticket ticket = responseEntity.getBody();
			return ticket;
		}
		return  null;
		*/
//#############################################################################################################33
		// Using WebClient Interface(spring-boot-starter-webflux)
		
		WebClient webClient = WebClient.create(); // get WebClient Instance
		
		Ticket ticket = webClient.post()
				 				 .uri(IRCTC_BOOK_TICKET_URL)
				 				 .body(BodyInserters.fromValue(request))
				 				 .header("Content-Type","application/json")
				 				 .accept(MediaType.APPLICATION_JSON)
				 				 .retrieve()
				 				 .bodyToMono(Ticket.class)
				 				 .block();
		
		if(ticket !=null) {
			return ticket;
		}
		
		return null;
	}
	
	public Ticket getTicketInfo(String ticketId) {
		
		//Creating RestTemplate Object which can communicate with Other application using given URL
		/*
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(IRCTC_GET_TICKET_URL, Ticket.class,ticketId);
		HttpStatus statusCode =  (HttpStatus) responseEntity.getStatusCode();
		
		if(statusCode == HttpStatus.OK) {
			Ticket ticket = responseEntity.getBody();
			System.out.println(ticket);
			return ticket;
		}
		return null;
		*/
//##########################################################################################################################	
		
		// Using WebClient Interface(spring-boot-starter-webflux)
		WebClient webClient = WebClient.create(); // get WebClient instance
		Ticket ticket = webClient.get() // represents GET request
								.uri(IRCTC_GET_TICKET_URL, ticketId)// ENDPOINT URL
								.accept(MediaType.APPLICATION_JSON)
								.retrieve() // Take Data from response body
								.bodyToMono(Ticket.class) // bind response body data to java object 
								.block(); // Make Sync Call to wait
		if(ticket != null) {
			return ticket;
		}		
		return null;
	}		
		

}
