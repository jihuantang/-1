package mvp;

import com.example.day05.MainActivity;

public interface Cotract {

    interface ILoginModel{
        void getRequest(String url,CallBack callBack);
        interface CallBack{
            void onError();
            void onSuccess(String data);
        }
    }
    interface ILoginView{
        void getPresenter(String data);
    }
    interface ILoginPresenter{
        void getModel(String url);
        void attch(MainActivity mainActivity);
        void detch();
    }
}
