package com.sahin.mindbehind.controller;

import com.sahin.mindbehind.generic.ControllerResponse;
import com.sahin.mindbehind.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author malisahin
 * @since 08-Jun-21
 */

@RestController
public class CommentController {

  @Autowired
  private CommentService commentService;

  @GetMapping("/getComments")
  public ControllerResponse<Void> getComments() throws IOException {
    commentService.getComments();

    return ControllerResponse.empty();
  }
}
