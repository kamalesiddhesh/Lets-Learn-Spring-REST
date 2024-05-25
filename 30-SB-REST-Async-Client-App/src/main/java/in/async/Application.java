package in.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.async.service.MakeMyTripService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		MakeMyTripService bean = context.getBean(MakeMyTripService.class);
		//bean.getTicketInfoSync(-1970202118);
		bean.getTicketInfoAsync(-1970202118);
		
	}

}
