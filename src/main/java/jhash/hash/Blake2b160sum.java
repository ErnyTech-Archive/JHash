package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Blake2b160sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "BLAKE2B-160";

    public Blake2b160sum(String text) {
        super(ALGORITHM, text);
    }

    public Blake2b160sum(File file) {
        super(ALGORITHM, file);
    }

    public Blake2b160sum(Path path) {
        super(ALGORITHM, path);
    }
}
