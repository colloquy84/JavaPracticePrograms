package com.pandeyar.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class FileReadChallange {

    private final String FILE_PATH = "/Users/arunpandey/Documents/workspace/Idea-Workspace/Sample/SampleProgramms/src/main/java/com/pandeyar/file/";
    private final String FILE_NAME = "FileReadChallange.java";
    private final int WORKERS = 2;
    private final int BATCH_SIZE = 50;
    private final String POISON = "quit";
    private final ArrayBlockingQueue<List<String>> queue = new ArrayBlockingQueue<>(1000);
    private int lineCount = 0;
    private final List<String> resultList = Collections.synchronizedList(new ArrayList<>());
    private final String SEARCH_STRING = "File";

    public static void main(String[] args) throws IOException, InterruptedException {
        FileReadChallange m = new FileReadChallange();
        m.run();
    }

    public void run() throws IOException, InterruptedException {
        List<Thread> threads = new ArrayList<>(this.WORKERS);
        for (int i = 0; i < this.WORKERS; i++) {
            Thread processor = new Thread(this::processLines);
            processor.start();
            threads.add(processor);
        }

        try (BufferedReader b = Files.newBufferedReader(Paths.get(FILE_PATH + FILE_NAME))) {
            String readLine = "";
            List<String> lines = new ArrayList<>();

            while ((readLine = b.readLine()) != null) {
                this.lineCount++;
                lines.add(readLine);

                if (this.lineCount % this.BATCH_SIZE == 0) {
                    this.queue.offer(lines);
                    lines = new ArrayList<>();
                }
            }

            List<String> poisonList = new ArrayList<>();
            poisonList.add(POISON);
            for (int i = 0; i < this.WORKERS; i++) {
                this.queue.offer(poisonList);
            }
        }

        for (Thread processor : threads) {
            processor.join();
        }

        System.out.format("Read the file %s completely and found below lines matching to search string %s", FILE_NAME, SEARCH_STRING);
        System.out.println();
        resultList.forEach(System.out::println);
    }

    private void processLines() {
        try {
            while (true) {
                List<String> lines = this.queue.take();

                if (lines.size() == 1 && lines.get(0).equals(POISON)) {
                    return;
                }

                for (String line : lines) {
                    if (line.indexOf(SEARCH_STRING) >= 0) {
                        this.resultList.add(line);
                    }
                }
            }
        } catch (InterruptedException ignored) {
        }
    }
}
