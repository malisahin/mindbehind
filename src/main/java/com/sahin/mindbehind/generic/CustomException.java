package com.sahin.mindbehind.generic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author malisahin
 * @since 08-Jun-21
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException {

  private final String errorCode;

  public CustomException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode;
  }
}
