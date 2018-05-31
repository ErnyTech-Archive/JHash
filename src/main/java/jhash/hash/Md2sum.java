package jhash.hash;

import jhash.util.GenericMessageDigestSum;

import java.io.File;
import java.nio.file.Path;

public class Md2sum extends GenericMessageDigestSum {
    private final static String ALGORITHM = "MD2";

    public Md2sum(String text) {
        super(ALGORITHM, text);
    }

    public Md2sum(File file) {
        super(ALGORITHM, file);
    }

    public Md2sum(Path path) {
        super(ALGORITHM, path);
    }
}