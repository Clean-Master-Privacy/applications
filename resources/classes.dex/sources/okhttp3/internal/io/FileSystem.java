    package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.p;
import okio.q;

public interface FileSystem {
    public static final FileSystem SYSTEM = new 1();

    p appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    p sink(File file) throws FileNotFoundException;

    long size(File file);

    q source(File file) throws FileNotFoundException;
}
    
