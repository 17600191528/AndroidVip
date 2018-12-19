package wyj.com.androidvip.live.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import wyj.com.androidvip.R;
import wyj.com.androidvip.entity.LiveInfoBean;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 11:36
 */

public class LiveInfoAdapter extends RecyclerView.Adapter<LiveInfoAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private Context mContext;
    private List<LiveInfoBean.VideoListBean> videoList;

    public LiveInfoAdapter(Context mContext, List<LiveInfoBean.VideoListBean> videoList) {
        this.mContext = mContext;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(mContext, R.layout.item_live_info, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        LiveInfoBean.VideoListBean bean = videoList.get(position);

        holder.itemLiveInfoTxt.setText(bean.getVideo_title());
        holder.itemLiveInfoJcv.backButton.setVisibility(View.INVISIBLE);
        holder.itemLiveInfoJcv.tinyBackImageView.setVisibility(View.INVISIBLE);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_live_info_jcv)
        JCVideoPlayerStandard itemLiveInfoJcv;
        @BindView(R.id.item_live_info_txt)
        TextView itemLiveInfoTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
