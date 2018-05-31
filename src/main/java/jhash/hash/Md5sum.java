package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Md5sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "MD5";

    public Md5sum(String text) {
        super(ALGORITHM, text);
    }

    public Md5sum(File file) {
        super(ALGORITHM, file);
    }

    public Md5sum(Path path) {
        super(ALGORITHM, path);
    }
}