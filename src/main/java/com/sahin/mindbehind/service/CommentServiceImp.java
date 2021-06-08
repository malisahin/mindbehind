package com.sahin.mindbehind.service;

import com.sahin.mindbehind.model.Comment;
import com.sahin.mindbehind.util.ApiUtil;
import com.sahin.mindbehind.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author malisahin
 * @since 08-Jun-21
 */

@Service
public class CommentServiceImp implements CommentService {

  @Value("${comments.uri}")
  private String commentUri;


  @Override
  public void getComments() throws IOException {
    final List<Comment> commentList = ApiUtil.getForListEntity(commentUri, Comment.class);
    writeToFile(commentList);
  }

  private void writeToFile(List<Comment> commentList) throws IOException {
    final List<String> stringList = Optional.ofNullable(commentList)
        .orElse(new ArrayList<>(0))
        .stream()
        .map(Comment::toString)
        .collect(Collectors.toList());

    FileUtil.writeToFile("comments.csv", stringList);
  }
}
