package programming.practise.interview;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Interview {

  // TDD
  // Simple Design
      // testing
      // keduxing, chongfuxing
      // zuishaoyuanshu

  // 读取超大文件10G
  public static void main(String[] args) {}

  public void readFile(String fileName) throws IOException {
    RandomAccessFile memoryMappedFile = new RandomAccessFile(fileName, "rw");
    long readFileSizeEachTime = 1024 * 1024 * 1024; // 1GB size
    long currentFileSize = 0;

    while (currentFileSize < memoryMappedFile.length()) {
      MappedByteBuffer out =
          memoryMappedFile
              .getChannel()
              .map(FileChannel.MapMode.READ_WRITE, currentFileSize, readFileSizeEachTime);
      handleFile(out);
      currentFileSize += readFileSizeEachTime;
    }
  }

  private void handleFile(MappedByteBuffer out) {
    while (out.hasRemaining()) {
      System.out.println(out.get());
    }
  }
}
