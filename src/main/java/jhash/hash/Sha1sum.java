package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Sha1sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "SHA-1";

    public Sha1sum(String text) {
        super(ALGORITHM, text);
    }

    public Sha1sum(File file) {
        super(ALGORITHM, file);
    }

    public Sha1sum(Path path) {
        super(ALGORITHM, path);
    }
}