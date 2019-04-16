package mvp;

import util.AsyncHttpClient;

public class LoginModel implements Cotract.ILoginModel {
    @Override
    public void getRequest(String url, final CallBack callBack) {
        AsyncHttpClient.getInstance().getData(url, new AsyncHttpClient.CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }
        });
    }
}
