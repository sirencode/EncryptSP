package com.syh.diablo.encryptsp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Diablo on 2017/12/11.
 */

public class SafeSharedpreferences {
    public static void saveSafeString(Context context, String key, String text) {
        String info = AESUtil.encrypt(text, AESUtil.AESPASSWORD);
        SharedPreferences sharedPreferences = context.getSharedPreferences("cached_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(AESUtil.md5(key), info);
        editor.commit();
    }

    public static String getSafeString(Context context, String key, String defaltValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cached_data", Context.MODE_PRIVATE);
        String info = sharedPreferences.getString(AESUtil.md5(key), defaltValue);
        return info.equals(defaltValue) ? defaltValue : AESUtil.decrypt(info, AESUtil.AESPASSWORD);
    }
}
