package wyj.com.androidvip.live.adapter;

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
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import wyj.com.androidvip.R;
import wyj.com.androidvip.entity.LiveIndexBean;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 11:36
 */

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private Context mContext;
    private List<LiveIndexBean.ItemsBean> list;

    public LiveAdapter(Context mContext, List<LiveIndexBean.ItemsBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(mContext, R.layout.item_live, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final int pos = position + 1;
        LiveIndexBean.ItemsBean bean = list.get(pos);
        holder.itemLiveSdv.setImageURI(bean.getImage());
        holder.itemLiveTxt.setText(bean.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() - 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_live_adv)
        SimpleDraweeView itemLiveSdv;
        @BindView(R.id.item_live_txt)
        TextView itemLiveTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
