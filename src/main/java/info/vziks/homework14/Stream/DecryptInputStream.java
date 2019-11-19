package info.vziks.homework14.Stream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream implements CryptStreamInterface {


    public DecryptInputStream(InputStream in) {
        super(in);
    }

    public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }
    public byte[] decode(byte b[]) {
        byte[] res = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            System.out.println((char) (b[i] ^ XOR_VALUE));
            res[i] = (byte) (b[i] ^ XOR_VALUE);
        }
        return res;
    }
}
