package app.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;

/**
 * 读取文件的工具类
 */
public class FileUtils {

    private static Logger log = Logger.getLogger(FileUtils.class);
    /**
     * 获取文件内容
     *
     * @param uri
     * @return
     */
    public static String getFileConent(String uri) {
        InputStream inputStream = null;
        try {
            URL url = FileUtils.class.getResource(uri);
            if (url != null) inputStream = new FileInputStream(url.getFile());
        } catch (IOException e) {
            log.info("未读取到classpath文件，开始读取jar包内文件,文件名{},IO堆栈:".replace("{}",uri), e);
        }
        try {
            if (inputStream == null || inputStream.available() <= 0) {
                inputStream = FileUtils.class.getResourceAsStream(uri);
            }
        } catch (IOException e) {
            log.info("未读取到jar包内文件，文件不存在,文件名{},IO堆栈:".replace("{}", uri), e);
        }
        try {
            if (inputStream != null && inputStream.available() > 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder strb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    strb.append(line);
                }
                reader.close();
                return strb.toString();
            }
        } catch (IOException e) {
            log.error("已获取到文件但文件读取失败，文件名:{},IO堆栈：".replace("{}", uri), e);
        }
        return null;
    }
}
