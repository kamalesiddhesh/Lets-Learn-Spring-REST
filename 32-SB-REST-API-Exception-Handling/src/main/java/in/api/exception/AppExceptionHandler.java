package in.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppExceptionHandler {
	// Global Exception Handling 
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handleCustomerNotFound(CustomerNotFoundException cnfe){
		
		ExceptionInfo info = new ExceptionInfo();
		info.setCode("EX0011");
		info.setMsg(cnfe.getMessage());
		info.setDate(LocalDateTime.now());
		
		return new ResponseEntity(info,HttpStatus.BAD_REQUEST);
		
	}

}
