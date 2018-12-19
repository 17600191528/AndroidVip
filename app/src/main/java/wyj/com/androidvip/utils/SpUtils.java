package wyj.com.androidvip.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import wyj.com.androidvip.entity.LoginBean;

import static android.content.Context.MODE_PRIVATE;

/**
 * @Description：我自己封装的sp
 * @Author：执念
 * @Date：2018/12/19 11:16
 */

public class SpUtils {
    private static SharedPreferences sp;
    private static String flag="wyj";

    /**
     * 存储
     */
    public static void putLoginBean(Context context, LoginBean bean) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(bean);
        editor.putString(flag, json);
        editor.commit();
    }

    public static LoginBean getLoginBean(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", MODE_PRIVATE);
        }
        Gson gson = new Gson();
        String json = sp.getString(flag, null);
        Type type = new TypeToken<LoginBean>() {
        }.getType();
        LoginBean bean = gson.fromJson(json, type);
        return bean;
    }
}
