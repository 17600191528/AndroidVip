package wyj.com.androidvip.live.view;

import wyj.com.androidvip.base.IView;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 19:34
 */

public interface LiveView<T> extends IView {
    void onSuccess(T t);
}
