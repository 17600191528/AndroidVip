package wyj.com.androidvip.gan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wyj.com.androidvip.R;
import wyj.com.androidvip.entity.IndexNewsBean;
import wyj.com.androidvip.entity.StudyXrvBean;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 11:36
 */

public class GanAdapter extends RecyclerView.Adapter<GanAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private Context mContext;
    private List<IndexNewsBean.ItemsBean> list;

    public GanAdapter(Context mContext, List<IndexNewsBean.ItemsBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(mContext, R.layout.index_item_news, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        IndexNewsBean.ItemsBean bean = list.get(position);
        holder.itemSdv.setImageURI(bean.getNews_image());
        holder.itemNewsTitle.setText(bean.getNews_title());
        holder.itemNewsDesc.setText(bean.getNews_desc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_news_sdv)
        SimpleDraweeView itemSdv;
        @BindView(R.id.item_news_title)
        TextView itemNewsTitle;
        @BindView(R.id.item_news_desc)
        TextView itemNewsDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
