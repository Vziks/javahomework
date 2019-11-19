package info.vziks.homework14.FilesManipulation;

import java.io.*;
import java.util.Objects;
import java.util.Vector;

public class AppFiles {
    private ClassLoader loader;
    private File file;
    private long length;
    private long halfPart;
    FileInputStream fileInputStream;
    private long maxBiteFile;


    public AppFiles(String fileName) throws IOException {
        setLoader(AppFiles.class.getClassLoader());
        this.file = new File(Objects.requireNonNull(loader.getResource(fileName)).getFile());
        setFileInputStream(new FileInputStream(getFile()));
        setLength(getFile().length());
        setHalfPart(getLength() / 2 + getLength() % 2);
        maxBiteFile = getFileInputStream().available();
    }

    public AppFiles setLoader(ClassLoader loader) {
        this.loader = loader;
        return this;
    }

    public File getFile() {
        return file;
    }


    public void writeToFiles() throws IOException {

        try (
                FileOutputStream out1 = new FileOutputStream("out1.txt");
                FileOutputStream out2 = new FileOutputStream("out2.txt");

        ) {
            long read = 0;
            int b;
            while ((b = getFileInputStream().read()) > 0) {
                if (++read <= getHalfPart())
                    out1.write(b);
                else
                    out2.write(b);
            }
        }
    }

    public void writeToRandomAccessFiles() throws IOException {

        try (
                RandomAccessFile randomAccessFile1 = new RandomAccessFile(getFile(), "r");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(getFile(), "r");
                FileOutputStream out1 = new FileOutputStream("out1R.txt");
                FileOutputStream out2 = new FileOutputStream("out2R.txt");

        ) {
            int b, d;

            randomAccessFile1.seek(0);
            randomAccessFile2.seek(maxBiteFile / 2 + maxBiteFile % 2);

            while ((b = randomAccessFile1.read()) > 0 && (d = randomAccessFile2.read()) > 0) {
                out1.write(b);
                out2.write(d);
            }
        }
    }


    public void mergeToFiles() throws IOException {
        FileInputStream out1 = new FileInputStream("out1.txt");
        FileInputStream out2 = new FileInputStream("out2.txt");
        Vector<InputStream> inputStreamVector = new Vector<>();
        inputStreamVector.add(out1);
        inputStreamVector.add(out2);
        try (
                FileOutputStream merge = new FileOutputStream("merge.txt");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(merge);
                SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreamVector.elements());
        ) {

            byte[] buff = new byte[1024];
            int data;
            while ((data = sequenceInputStream.read(buff)) > 0) {
                bufferedOutputStream.write(buff, 0, data);
            }
        }
    }

    public AppFiles setLength(long length) {
        this.length = length;
        return this;
    }

    public long getLength() {
        return length;
    }

    public long getHalfPart() {
        return halfPart;
    }

    public AppFiles setHalfPart(long halfPart) {
        this.halfPart = halfPart;
        return this;
    }

    public AppFiles setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
        return this;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }
}
