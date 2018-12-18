package wyj.com.androidvip.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreUtils {
    private static final String PREFERENCES = "wyj";
    private static SharedPreferences sp;

    public static void put(Context context, String key, Object value) {

        final SharedPreferences preferences = getPreferences(context);
        final SharedPreferences.Editor editor = preferences.edit();
        if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        }
        editor.commit();
    }

    private static SharedPreferences getPreferences(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(PREFERENCES, 0);
        }
        return sp;
    }

    public static String getString(Context context, String key) {
        return getString(context, key, "");
    }

    public static String getString(Context context, String key, String defaultVal) {
        return getPreferences(context).getString(key, defaultVal);
    }

    public static long getLong(Context context, String key) {
        return getPreferences(context).getLong(key, -1);
    }

    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);
    }

    public static int getInt(Context context, String key, int defaultVal) {
        return getPreferences(context).getInt(key, defaultVal);
    }

    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultVal) {
        return getPreferences(context).getBoolean(key, defaultVal);
    }

}
