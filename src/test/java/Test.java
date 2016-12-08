import org.wstorm.tools.gzip.GZipUtils;
import org.wstorm.tools.tar.TarUtils;

import java.io.File;


public class Test {

    String baseDir = "/Volumes/work";

    String needCompressPathDir = baseDir + "/未命名文件夹";

    @org.junit.Test
    public void testTarUtils() throws Exception {

        File tarFile = new File(baseDir + "/my.tar");
        TarUtils.archive(new File(needCompressPathDir), tarFile);
        System.out.println(needCompressPathDir + "压缩成:" + tarFile);
        File gzFile = new File(baseDir + "/my.tar.gz");
        GZipUtils.compress(tarFile, gzFile);
        System.out.println(tarFile + "再压缩成:" + gzFile);

        //解压:
        File desTar = new File(baseDir + "/desMy.tar");
        GZipUtils.decompress(gzFile, desTar);
        TarUtils.dearchive(desTar, new File(baseDir + "/unpack"));
    }
}