package com.example.day05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.MyBaseAdapter;
import bean.Resu;
import mvp.Cotract;
import mvp.LoginPresenter;

public class MainActivity extends AppCompatActivity implements Cotract.ILoginView {

    private LoginPresenter loginPresenter;
    private String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=%E7%94%B7%E9%9E%8B";
    private GridView gridView;
    private List<Resu.Result> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPresenter = new LoginPresenter();
        loginPresenter.attch(this);
        loginPresenter.getModel(url);

        gridView = findViewById(R.id.gridview);
    }

    @Override
    public void getPresenter(String data) {
        Gson gson = new Gson();
        Resu resu = gson.fromJson(data, Resu.class);
        List<Resu.Result> result = resu.result;
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(result,MainActivity.this);
        gridView.setAdapter(myBaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detch();
    }
}
