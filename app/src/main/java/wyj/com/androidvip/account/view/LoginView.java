package wyj.com.androidvip.account.view;

import wyj.com.androidvip.base.IView;

/**
 * @Description：描述信息
 * @Author：执念
 * @Date：2018/12/17 15:02
 */

public interface LoginView<T> extends IView{
    void onSuccess(T t);
}
