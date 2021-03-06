package pcsalt.example.xmlparsingsaxdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Krrishnaaaa on Jan 01, 2015
 */
public class PostBaseAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<PostValue> postValueArrayList;

    public PostBaseAdapter(Context context, ArrayList<PostValue> postValueArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.postValueArrayList = postValueArrayList;

    }

    @Override
    public int getCount() {
        return postValueArrayList.size();
    }

    @Override
    public PostValue getItem(int position) {
        return postValueArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_post, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PostValue postValue = getItem(position);

        viewHolder.tvTitle.setText(postValue.getTitle());
        viewHolder.tvPublishDate.setText(postValue.getDate());

        return convertView;
    }

    private class ViewHolder {
        TextView tvTitle, tvPublishDate;

        public ViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.tvTitle);
            tvPublishDate = (TextView) item.findViewById(R.id.tvPublishDate);
        }
    }
}
