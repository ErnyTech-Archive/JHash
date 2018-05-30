package jhash.hash;

import jhash.JHashApi;
import jhash.util.BytesToHex;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md2sum implements JHashApi {
    private File file;
    private String text;
    private final int BUFFER_SIZE = 8192;

    public Md2sum(String text) {
        this.text = text;
    }

    public Md2sum(File file) {
        this.file = file;
    }

    public Md2sum(Path path) {
        this.file = path.toFile();
    }

    @Override
    public byte[] getBytes() {
        return hash();
    }

    @Override
    public String getHex() {
        byte hash[] = hash();
        var bytestohex = new BytesToHex(hash);
        return bytestohex.toString();
    }

    private byte[] hash()  {
        if (this.file != null) {
            try {
                return fileHash();
            } catch (NoSuchAlgorithmException | IOException e) {
                return null;
            }
        }

        if (this.text != null) {
            try {
                return stringHash();
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        }

        return null;
    }

    private byte[] fileHash() throws NoSuchAlgorithmException, IOException {
        var digest = MessageDigest.getInstance("MD2");
        var bis = new BufferedInputStream(new FileInputStream(this.file));
        int cout;
        byte[] buffer = new byte[this.BUFFER_SIZE];

        while (true) {
            cout = bis.read(buffer);

            if (cout <= 0) {
                break;
            }

            if (Thread.currentThread().isInterrupted()) {
                return null;
            }

            digest.update(buffer, 0, cout);
        }

        bis.close();

        return digest.digest();
    }

    private byte[] stringHash() throws NoSuchAlgorithmException {
        var digest = MessageDigest.getInstance("MD2");
        return digest.digest(this.text.getBytes(StandardCharsets.UTF_8));
    }
}
