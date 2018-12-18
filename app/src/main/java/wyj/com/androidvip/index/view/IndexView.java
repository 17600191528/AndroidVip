package wyj.com.androidvip.index.view;

import wyj.com.androidvip.base.IView;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 19:34
 */

public interface IndexView<T, Q> extends IView {
    void onSuccess1(T t);
    void onSuccess2(Q q);
}
