package info.vziks.exam.multithreading;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Works {

    private static LinkedBlockingDeque<String> commands = new LinkedBlockingDeque<>();
    private static Map<String, Runnable> stringRunnableHashMap = new HashMap<>();

    public static void main(String[] args) {

        stringRunnableHashMap.put("time", new TimeCommand());
        stringRunnableHashMap.put("help", new HelpCommand());
        stringRunnableHashMap.put("file", new FileCommand());
        stringRunnableHashMap.put("exit", new ExitCommand());

        Thread readThread = new Thread(new Reader());

        new Thread(new Reader()).start();
        readThread.setDaemon(true);
        readThread.start();
        Scanner scanner = new Scanner(System.in);
        String text;
        do {
            System.out.println("Enter command");
            text = scanner.next();

            if ((text != null && !text.isEmpty())) {
                try {
                    commands.put(text.toLowerCase());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (true);
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            ExecutorService executorService = Executors.newFixedThreadPool(3);

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Runnable task = stringRunnableHashMap.get(commands.take());
                    executorService.execute(task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            executorService.shutdown();
        }
    }

    static class TimeCommand implements Runnable {
        @Override
        public void run() {
            System.out.println(LocalDateTime.now());
        }
    }

    static class HelpCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("Help");
        }
    }

    static class FileCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("File");
        }
    }

    static class ExitCommand implements Runnable {
        @Override
        public void run() {
            System.exit(0);
        }
    }
}
