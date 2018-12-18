package wyj.com.androidvip.base;

import android.content.Context;

/**
 * Created by lenovo on 2018/11/6.
 */

public interface IView {
    Context context();
    void onFailed(Throwable t);
}
