package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.*;
import java.nio.file.Path;

public class Sha256sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "SHA-256";

    public Sha256sum(String text) {
        super(ALGORITHM, text);
    }

    public Sha256sum(File file) {
        super(ALGORITHM, file);
    }

    public Sha256sum(Path path) {
        super(ALGORITHM, path);
    }
}
