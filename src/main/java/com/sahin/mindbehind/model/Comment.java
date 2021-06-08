package com.sahin.mindbehind.model;

import java.io.Serializable;

/**
 * @author malisahin
 * @since 08-Jun-21
 */

public class Comment implements Serializable {
  private Long id;
  private String body;
  private Long postId;

  public void setId(Long id) {
    this.id = id;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setPostId(Long postId) {
    this.postId = postId;
  }

  @Override
  public String toString() {
    return "id=" + id +
        ", body='" + body + '\'' +
        ", postId=" + postId   ;
  }
}
