package mvp;

import com.example.day05.MainActivity;

public class LoginPresenter implements Cotract.ILoginPresenter {

    private LoginModel loginModel;
    private Cotract.ILoginView view;


    @Override
    public void getModel(String url) {
        loginModel.getRequest(url, new Cotract.ILoginModel.CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String data) {
                view.getPresenter(data);
            }
        });
    }

    @Override
    public void attch(MainActivity mainActivity) {
        loginModel = new LoginModel();
        this.view = mainActivity;
    }

    @Override
    public void detch() {
        if (loginModel!=null){
            loginModel=null;
        }
        if (view!=null){
            view=null;
        }
        System.gc();
    }
}
