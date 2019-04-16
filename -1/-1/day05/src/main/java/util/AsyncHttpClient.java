package util;

import android.os.AsyncTask;
import android.util.Log;

import com.google.common.io.ByteStreams;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncHttpClient {
    private static final AsyncHttpClient ourInstance = new AsyncHttpClient();

    public static AsyncHttpClient getInstance() {
        return ourInstance;
    }

    private AsyncHttpClient() {
    }
    //暴露方法
    public void getData(String url, final CallBack callBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return getAsync(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.onSuccess(s);
            }
        }.execute(url);
    }

    private String getAsync(String url) {
        HttpURLConnection connection;
        try {
            URL url1 = new URL(url);
            connection = (HttpURLConnection) url1.openConnection();

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");

            if (connection.getResponseCode()==200){
                InputStream inputStream = connection.getInputStream();
                String s = new String(ByteStreams.toByteArray(inputStream));
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //定义接口
    public interface CallBack{
        void onError();
        void onSuccess(String result);
    }
}
