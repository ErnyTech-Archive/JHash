package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Sha512sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "SHA-512";

    public Sha512sum(String text) {
        super(ALGORITHM, text);
    }

    public Sha512sum(File file) {
        super(ALGORITHM, file);
    }

    public Sha512sum(Path path) {
        super(ALGORITHM, path);
    }
}