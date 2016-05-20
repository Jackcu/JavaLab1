package commDemo;

import java.io.*;

/**
 * Created by Jack on 5/20/2016.
 */
public class FileIO {

    /**
     * 写入
     *
     * @param fileName
     * @param str
     */
    public static void wt(String fileName, String str) throws IOException {

        File file = new File(fileName);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file, false); //如果追加方式用true
        StringBuffer sb = new StringBuffer();
        out.write(str.getBytes("UTF-8"));
        out.close();

    }

    /**
     * 读取文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String rt(String fileName) throws IOException {

        //获取文件
        File file = new File(fileName);
        if (!(file.isFile() && file.exists())) return null;

        //读取文件
        Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        StringBuffer sb = new StringBuffer();
        int tempchar;
        while ((tempchar = reader.read()) != -1) {
            sb.append((char) tempchar);
        }

        reader.close();
        String result = sb.toString();

        return result;

    }


}
