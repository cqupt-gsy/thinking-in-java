package programming.practise.concurrency.examples.printer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {
    private int count = 0;
    private int currentThreadNumber = 1;
    private int currentFileNumber = 0;


    public void writeFile(char value, int threadNumber) {
        generateNextFileNumber();
        String fileName = "file" + currentFileNumber + ".txt";
        FileWriter writer = null;
        try {
            System.out.println(String.format("Thread %d write %s to %s", threadNumber, value, fileName));
            writer = new FileWriter(fileName, true);
            writer.write(value);
            writer.flush();
            count++;
            currentThreadNumber = threadNumber;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            generateNextThreadNumber();
        }
    }

    public int getCurrentThreadNumber() {
        return currentThreadNumber;
    }

    private void generateNextThreadNumber() {
        if (count % 4 == 0) {
            if (currentThreadNumber < 3) {
                currentThreadNumber += 2;
            } else {
                currentThreadNumber = (currentThreadNumber + 2) % 4;
            }
        } else {
            if (currentThreadNumber == 4) {
                currentThreadNumber = 1;
            } else {
                currentThreadNumber++;
            }
        }

    }

    private void generateNextFileNumber() {
        if (currentFileNumber % 4 == 0) {
            currentFileNumber = 1;
        } else {
            currentFileNumber++;
        }
    }

}
