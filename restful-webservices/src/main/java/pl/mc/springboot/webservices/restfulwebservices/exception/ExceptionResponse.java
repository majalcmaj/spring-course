package pl.mc.springboot.webservices.restfulwebservices.exception;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
