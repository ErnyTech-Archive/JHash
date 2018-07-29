package jhash.util;

import com.rfksystems.blake2b.security.Blake2bProvider;
import jhash.JHashApi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class GenericMessageDigestSum implements JHashApi {
    private String algorithm;
    private File file;
    private String text;
    private final int BUFFER_SIZE = 8192;

    public GenericMessageDigestSum(String algorithm, String text) {
        this.algorithm = algorithm;
        this.text = text;
    }

    public GenericMessageDigestSum(String algorithm, File file) {
        this.algorithm = algorithm;
        this.file = file;
    }

    public GenericMessageDigestSum(String algorithm, Path path) {
        this.algorithm = algorithm;
        this.file = path.toFile();
    }

    @Override
    public byte[] getBytes() {
        return hash();
    }

    @Override
    public String getHex() {
        byte hash[] = hash();
        BytesToHex bytestohex = new BytesToHex(hash);
        return bytestohex.toString();
    }

    private byte[] hash()  {
        setProvider();

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
        MessageDigest digest = MessageDigest.getInstance(this.algorithm);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(this.file));
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
        MessageDigest digest = MessageDigest.getInstance(this.algorithm);
        return digest.digest(this.text.getBytes(StandardCharsets.UTF_8));
    }

    private void setProvider() {
        Security.addProvider(new Blake2bProvider());
    }
}
