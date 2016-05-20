package commDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Jack on 5/20/2016.
 */
public class HttpIO {

    public static String get(String url, int timeoutMs) throws IOException {

        BufferedReader in=null;
        String result = "";

        try {


            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();

//        Map<String, List<String>> map = connection.getHeaderFields();
//        // 遍历所有的响应头字段
//        for (String key : map.keySet()) {
//            System.out.println(key + "--->" + map.get(key));
//        }

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


            String line;
            while ((line = in.readLine()) != null) {
                result += "\n"+line;
            }

        } finally {

            if (in != null) {

                in.close();

            }

        }

        return result;

    }

}
