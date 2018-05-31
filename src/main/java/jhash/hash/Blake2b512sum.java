package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Blake2b512sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "BLAKE2B-512";

    public Blake2b512sum(String text) {
        super(ALGORITHM, text);
    }

    public Blake2b512sum(File file) {
        super(ALGORITHM, file);
    }

    public Blake2b512sum(Path path) {
        super(ALGORITHM, path);
    }
}
