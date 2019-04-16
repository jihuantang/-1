package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day05.R;

import java.util.List;

import bean.Resu;

public class MyBaseAdapter extends BaseAdapter {

    private List<Resu.Result> list;
    private Context context;
    private ViewHolder viewHolder;

    public MyBaseAdapter(List<Resu.Result> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view = View.inflate(context, R.layout.result,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.image);
            viewHolder.textView1 = view.findViewById(R.id.text1);
            viewHolder.textView2 = view.findViewById(R.id.text2);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(list.get(i).commodityName);
        viewHolder.textView2.setText(list.get(i).price);
        Glide.with(context).load(list.get(i).masterPic).into(viewHolder.imageView);
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }
}
