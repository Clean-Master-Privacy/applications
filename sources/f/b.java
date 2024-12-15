    package f;

import androidx.collection.ArrayMap;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.zip.CRC32;

public final class b {
    public static void a(ArrayMap<String, String> arrayMap, File file) {
        String str;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            int size = arrayMap.size();
            long[] jArr = new long[size];
            byte[][] bArr = new byte[size][];
            File[] fileArr = new File[size];
            long[] jArr2 = new long[size];
            byte[] bArr2 = new byte[1048576];
            Iterator<String> it = arrayMap.keySet().iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                String next = it.next();
                File file2 = new File(next);
                String str2 = arrayMap.get(next);
                if ("desc.json".equals(str2)) {
                    str = "desc.json";
                } else {
                    str = str2 + "_" + file2.getName();
                }
                byte[] bytes = new String(str.getBytes("8859_1"), "GB2312").getBytes();
                jArr2[i2] = randomAccessFile.getFilePointer();
                a((DataOutput) randomAccessFile, 67324752);
                a((DataOutput) randomAccessFile, 10);
                a((DataOutput) randomAccessFile, i);
                a((DataOutput) randomAccessFile, i);
                a((DataOutput) randomAccessFile, i);
                a((DataOutput) randomAccessFile, i);
                long filePointer = randomAccessFile.getFilePointer();
                int i3 = i2;
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, file2.length());
                a((DataOutput) randomAccessFile, file2.length());
                a((DataOutput) randomAccessFile, bytes.length);
                a((DataOutput) randomAccessFile, 0);
                randomAccessFile.write(bytes);
                CRC32 crc32 = new CRC32();
                FileInputStream fileInputStream = new FileInputStream(file2);
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr2, 0, read);
                    randomAccessFile.write(bArr2, 0, read);
                    it = it;
                }
                Iterator<String> it2 = it;
                fileInputStream.close();
                long filePointer2 = randomAccessFile.getFilePointer();
                randomAccessFile.seek(filePointer);
                a((DataOutput) randomAccessFile, crc32.getValue());
                randomAccessFile.seek(filePointer2);
                jArr[i3] = crc32.getValue();
                bArr[i3] = bytes;
                fileArr[i3] = file2;
                i2 = i3 + 1;
                it = it2;
                bArr2 = bArr2;
                i = 0;
            }
            ArrayMap<String, String> arrayMap2 = arrayMap;
            long filePointer3 = randomAccessFile.getFilePointer();
            for (int i4 = 0; i4 < size; i4++) {
                a((DataOutput) randomAccessFile, 33639248);
                a((DataOutput) randomAccessFile, 20);
                a((DataOutput) randomAccessFile, 10);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, jArr[i4]);
                a((DataOutput) randomAccessFile, fileArr[i4].length());
                a((DataOutput) randomAccessFile, fileArr[i4].length());
                a((DataOutput) randomAccessFile, bArr[i4].length);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, 0);
                a((DataOutput) randomAccessFile, jArr2[i4]);
                randomAccessFile.write(bArr[i4]);
            }
            long filePointer4 = randomAccessFile.getFilePointer();
            a((DataOutput) randomAccessFile, 101010256);
            a((DataOutput) randomAccessFile, 0);
            a((DataOutput) randomAccessFile, 0);
            a((DataOutput) randomAccessFile, arrayMap.size());
            a((DataOutput) randomAccessFile, arrayMap.size());
            a((DataOutput) randomAccessFile, filePointer4 - filePointer3);
            a((DataOutput) randomAccessFile, filePointer3);
            a((DataOutput) randomAccessFile, 0);
            randomAccessFile.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static long a(DataOutput dataOutput, long j) throws IOException {
        dataOutput.write((int) (255 & j));
        dataOutput.write(((int) (j >> 8)) & 255);
        dataOutput.write(((int) (j >> 16)) & 255);
        dataOutput.write(((int) (j >> 24)) & 255);
        return j;
    }

    private static int a(DataOutput dataOutput, int i) throws IOException {
        dataOutput.write(i & 255);
        dataOutput.write((i >> 8) & 255);
        return i;
    }
}
    
