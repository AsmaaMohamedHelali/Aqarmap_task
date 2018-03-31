package com.example.android.aqarmaptask.utils;

import android.content.Context;
import android.content.res.Configuration;


import java.util.Locale;


/**
 * Created by ahmed on 1/31/16.
 */
public class Localization {

    /**
     * Change application locale.
     *
     * @param context Application context.
     * @param lang    Desired language to change locale.
     */
    public static void setLocale(Context context, String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,
                context.getResources().getDisplayMetrics());

        SharedPrefUtil.getInstance(context).write("currentLang", lang);
    }

    public static String getLocale(Context ctx) {

        return SharedPrefUtil.getInstance(ctx).read("currentLang", "ar");
    }
}
