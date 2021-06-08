package com.sahin.mindbehind.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author malisahin
 * @since 08-Jun-21
 */


public class ApiUtil {

  private static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  private ApiUtil() {
  }

  public static <T extends Serializable> List<T> getForListEntity(String uri, Class<T> clazz) {
    final RestTemplate restTemplate = new RestTemplate();
    final ResponseEntity<ArrayList> response = restTemplate.getForEntity(uri, ArrayList.class);

    return (List<T>) Optional.ofNullable(response)
        .map(res -> res.getBody())
        .orElse(new ArrayList(0))
        .stream()
        .map(item -> mapper.convertValue(item, clazz))
        .collect(Collectors.toList());
  }
}
