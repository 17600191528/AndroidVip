package wyj.com.androidvip.study.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wyj.com.androidvip.R;
import wyj.com.androidvip.entity.StudyXrvBean;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/18 11:36
 */

public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void itemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private Context mContext;
    private List<StudyXrvBean.ItemsBean> list;

    public StudyAdapter(Context mContext, List<StudyXrvBean.ItemsBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(mContext, R.layout.item_study, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        StudyXrvBean.ItemsBean bean = list.get(position);
        holder.itemStudySdv.setImageURI(Uri.parse(bean.getImage()));
        holder.itemStudyTitle.setText(bean.getTitle());

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

        @BindView(R.id.item_study_sdv)
        SimpleDraweeView itemStudySdv;
        @BindView(R.id.item_study_title)
        TextView itemStudyTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
