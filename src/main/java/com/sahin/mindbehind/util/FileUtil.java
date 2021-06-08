package com.sahin.mindbehind.util;

import com.sahin.mindbehind.generic.CustomException;

import java.io.*;
import java.util.List;

/**
 * @author malisahin
 * @since 08-Jun-21
 */

public class FileUtil {

  private FileUtil() {
  }

  public static void writeToFile(String filePath, List<String> lines) throws IOException {

    final File fout = new File(filePath);
    final FileOutputStream fos;

    BufferedWriter bw = null;
    try {

      fos = new FileOutputStream(fout);
      bw = new BufferedWriter(new OutputStreamWriter(fos));
      for (String line : lines) {
        bw.write(line);
        bw.newLine();
      }
    } catch (Exception e) {
      throw new CustomException("FILE_ERROR", e.getMessage());
    } finally {
      if (bw != null) {
        bw.close();
      }
    }


  }
}
