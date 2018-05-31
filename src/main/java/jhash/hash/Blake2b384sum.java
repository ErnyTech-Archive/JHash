package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Blake2b384sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "BLAKE2B-384";

    public Blake2b384sum(String text) {
        super(ALGORITHM, text);
    }

    public Blake2b384sum(File file) {
        super(ALGORITHM, file);
    }

    public Blake2b384sum(Path path) {
        super(ALGORITHM, path);
    }
}
