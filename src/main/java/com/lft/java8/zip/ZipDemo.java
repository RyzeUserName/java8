package com.lft.java8.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 描述
 * @author Ryze
 * @date 2019/11/28 21:14
 */
public class ZipDemo {
    public static void main(String[] args) throws Exception {
        test1("C:\\Users\\Ryze\\Desktop\\1.zip", "C:\\Users\\Ryze\\Desktop\\xxx\\");

    }

    public static void test1(String zipPath, String descDir) throws Exception {
        File zipFile = new File(zipPath);
        File pathFile = new File(descDir);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        //防止中文目录，乱码
        ZipFile zip = new ZipFile(zipFile, Charset.forName("gbk"));
        for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            //指定解压后的文件夹+当前zip文件的名称
            String outPath = (descDir + zipEntryName).replace("/", File.separator);
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
            if (!file.exists()) {
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            //保存文件路径信息（可利用md5.zip名称的唯一性，来判断是否已经解压）
            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[2048];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        //必须关闭，要不然这个zip文件一直被占用着，要删删不掉，改名也不可以，移动也不行，整多了，系统还崩了。
        zip.close();
    }
}
