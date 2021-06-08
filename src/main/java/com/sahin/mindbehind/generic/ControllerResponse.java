package com.sahin.mindbehind.generic;

import java.io.Serializable;

/**
 * @author malisahin
 * @since 08-Jun-21
 */

public class ControllerResponse<T> implements Serializable {

  private T body;
  private String errorCode;
  private String errorMessage;


  private ControllerResponse() {

  }

  public static <T> ControllerResponse<T> empty() {
    return new ControllerResponse<>();
  }

  public static <T> ControllerResponse<T> withBody(T body) {
    final ControllerResponse<T> response = new ControllerResponse<>();
    response.setBody(body);
    return response;
  }

  public static <T> ControllerResponse<T> withError(String code, String message) {
    final ControllerResponse<T> response = new ControllerResponse<>();
    response.setErrorCode(code);
    response.setErrorMessage(message);
    return response;
  }

  public T getBody() {
    return body;
  }

  public void setBody(T body) {
    this.body = body;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
