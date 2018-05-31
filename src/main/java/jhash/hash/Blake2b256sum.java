package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Blake2b256sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "BLAKE2B-256";

    public Blake2b256sum(String text) {
        super(ALGORITHM, text);
    }

    public Blake2b256sum(File file) {
        super(ALGORITHM, file);
    }

    public Blake2b256sum(Path path) {
        super(ALGORITHM, path);
    }
}

