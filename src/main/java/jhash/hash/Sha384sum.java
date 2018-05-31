package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Sha384sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "SHA-384";

    public Sha384sum(String text) {
        super(ALGORITHM, text);
    }

    public Sha384sum(File file) {
        super(ALGORITHM, file);
    }

    public Sha384sum(Path path) {
        super(ALGORITHM, path);
    }
}