package commDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
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


        System.setProperty("http.maxConnections","1024");
        System.setProperty("http.keepAlive","true");

        BufferedReader in=null;
        HttpURLConnection connection=null;
        String result = "";

        try {


            URL realUrl = new URL(url);

            URLConnection connection1 = realUrl.openConnection();

            connection=(HttpURLConnection)connection1;

            connection.setUseCaches(false);

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            //connection.setRequestProperty("Content-type", "application/x-java-serialized-object");
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(timeoutMs);
            connection.setReadTimeout(timeoutMs);

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

            //connection.disconnect();

        }

        return result;

    }

    public static String post(String url, int timeoutMs,String data) throws IOException {

        System.setProperty("http.maxConnections","1024");
        System.setProperty("http.keepAlive","true");

        BufferedReader in=null;
        PrintWriter out = null;
        HttpURLConnection connection=null;
        String result = "";

        try {


            URL realUrl = new URL(url);

            URLConnection connection1 = realUrl.openConnection();

            connection=(HttpURLConnection)connection1;



            connection.setUseCaches(false);

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            //connection.setRequestProperty("Content-type", "application/x-java-serialized-object");
            connection.setRequestMethod("POST");

            connection.setConnectTimeout(timeoutMs);
            connection.setReadTimeout(timeoutMs);
            connection.setDoOutput(true);
            connection.setDoInput(true);


            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(connection.getOutputStream());
            // 发送请求参数
            out.print(data);
            // flush输出流的缓冲
            out.flush();

            //connection.connect();

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

            //connection.disconnect();

        }

        return result;

    }


}
