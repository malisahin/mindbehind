package com.sahin.mindbehind.aspect;

import com.sahin.mindbehind.generic.ControllerResponse;
import com.sahin.mindbehind.generic.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author malisahin
 * @since 08-Jun-21
 */

@RestControllerAdvice
public class ExceptionHandler {


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @org.springframework.web.bind.annotation.ExceptionHandler({CustomException.class})
  public ControllerResponse<Void> customException(CustomException exception) {

    return ControllerResponse.withError(exception.getErrorCode(), exception.getMessage());
  }


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
  public ControllerResponse<Void> generalException(Exception exception) {

    if (exception instanceof CustomException)
      return customException((CustomException) exception);


    return ControllerResponse.withError(null, exception.getMessage());
  }


}
