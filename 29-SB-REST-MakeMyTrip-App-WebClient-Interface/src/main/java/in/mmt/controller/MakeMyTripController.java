package in.mmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.mmt.request.Passenger;
import in.mmt.response.Ticket;
import in.mmt.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	private MakeMyTripService service;
	
	@Autowired
	private MakeMyTripController(MakeMyTripService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	@PostMapping("/bookTicket")
	public String bookTicket(Passenger request,Model model) {
		Ticket ticketInfo = service.processTicketBooking(request);
		model.addAttribute("ticket",ticketInfo);
		return "success";
	}
	
	@GetMapping("/search")
	public String searchPage() {
		
		return "search";
	}
	
	@GetMapping("/searchTicket")
	public String searchTicket(@RequestParam("ticketId") String ticketId, Model model) {
		System.out.println("Ticket ID :: "+ticketId);
		// logic to get ticket from IRCTC Application
		
		Ticket ticketInfo = service.getTicketInfo(ticketId);
		System.out.println(ticketInfo);
		model.addAttribute("ticket",ticketInfo);
		return "search";
	}
}
