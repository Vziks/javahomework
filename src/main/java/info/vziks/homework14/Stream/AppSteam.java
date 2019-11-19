package info.vziks.homework14.Stream;

import com.github.javafaker.Faker;

import java.io.*;

public class AppSteam {

    static Faker faker = new Faker();
    static private File file = new File("crypt.txt");

    public static void write(File file, boolean append) throws IOException {

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file, append);
                OutputStream outputStream = new BufferedOutputStream(fileOutputStream);
                EncryptOutputStream eos = new EncryptOutputStream(outputStream);
        ) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                sb.append(faker.yoda().quote()).append("\n");
            }

            eos.write(sb.toString().getBytes());
        }
    }

    public static String read(File file) throws IOException {
        String in;
        try (
                InputStream inputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DecryptInputStream decryptInputStream = new DecryptInputStream(inputStream);
        ) {
            byte[] buff = new byte[15];
            int data;
            while ((data = inputStream.read(buff)) > 0) {
                byteArrayOutputStream.write(decryptInputStream.decode(buff), 0, data);
            }
            in = new String(byteArrayOutputStream.toByteArray());
        }

        return in;
    }

    public static File getFile() {
        return file;
    }
}
