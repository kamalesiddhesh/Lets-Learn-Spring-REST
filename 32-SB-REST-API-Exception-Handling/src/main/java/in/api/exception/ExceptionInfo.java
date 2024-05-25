package in.api.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionInfo {
	private String Code;
	private String Msg;
	private LocalDateTime date;
}
