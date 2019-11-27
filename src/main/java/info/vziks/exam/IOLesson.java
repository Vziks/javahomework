package info.vziks.exam;

import com.github.javafaker.Faker;

import java.io.*;
import java.util.Locale;
import java.util.Random;
import java.util.Vector;

public class IOLesson {
    static Faker faker = new Faker(new Locale("ru"));
    static Random rand = new Random();

    public static void main(String[] args) {

        InputStream iStream;
        OutputStream oStream;

        File file1 = new File("normal.txt");
        File file2 = new File("buffer.txt");
        File file3 = new File("data.txt");

        File[] files = {file1, file2};

        try {
            IOLesson.write(file1, false);
            System.out.println(IOLesson.read(file1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            IOLesson.writeWithBuffer(file2, false);
            System.out.println(IOLesson.readWithBuffer(files));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            IOLesson.writeReadData(file3, false);
            IOLesson.readData(file3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void write(File file, boolean append) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                sb.append(faker.yoda().quote()).append("\n");
            }

            fileOutputStream.write(sb.toString().getBytes());
        }
    }

    public static String read(File file) throws IOException {

        String in = null;

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ) {
            System.out.println(fileInputStream.available());
            byte[] buff = new byte[15];
            int data;
            while ((data = fileInputStream.read(buff)) > 0) {
                byteArrayOutputStream.write(buff, 0, data);
            }
            in = new String(byteArrayOutputStream.toByteArray());
        }

        return in;
    }

    public static void writeWithBuffer(File file, boolean append) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            for (int i = 0; i < 5_000; i++) {
                bufferedOutputStream.write((faker.yoda().quote() + "\n").getBytes());
                bufferedOutputStream.write((faker.yoda().quote() + "\n").getBytes());
            }
        }
    }

    public static String readWithBuffer(File[] files) throws IOException {
        String in = null;
        Vector<InputStream> inputStreamVector = new Vector<>();
        for (File file : files) {
            InputStream inputStream = new FileInputStream(file);
            inputStreamVector.add(inputStream);
        }

        try (
                SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreamVector.elements());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ) {
            byte[] buff = new byte[15];
            int data;
            while ((data = sequenceInputStream.read(buff)) > 0) {
                byteArrayOutputStream.write(buff, 0, data);
            }
            in = new String(byteArrayOutputStream.toByteArray());
        }

        return in;
    }


    public static void writeReadData(File file, boolean append) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)
        ) {
            dataOutputStream.write(10);
            dataOutputStream.writeUTF(faker.yoda().quote());
            dataOutputStream.writeBoolean(rand.nextBoolean());
            dataOutputStream.writeFloat(rand.nextFloat());
        }
    }


    public static void readData(File file) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream dataInputStream = new DataInputStream(fileInputStream)
        ) {
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.read());
        }
    }

}
