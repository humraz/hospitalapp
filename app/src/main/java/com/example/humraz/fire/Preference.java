package com.example.humraz.fire;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Explore on 10/7/2016.
 */

public class Preference {
    SharedPreferences pref;
    SharedPreferences doc;
    SharedPreferences.Editor editor;
    Context context;

    int private_mod =0;

    private static final String pref_name ="welcome";
    private static final String first_time = "IsFirstTimeLaunch";
    private static final String is_doc = "IsDoc";
    private static final String is_pat = "IsPat";

    public Preference(Context context){
        this.context = context;
        pref = context.getSharedPreferences(pref_name,private_mod);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(first_time, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(first_time, true);
    }

    public void setDoc(boolean isDoc){
        editor.putBoolean(is_doc,isDoc);
        editor.commit();
    }
    public void setPat(boolean isPat){
        editor.putBoolean(is_pat,isPat);
        editor.commit();
    }

    public boolean isDoc(){
        return pref.getBoolean(is_doc,true);
    }
    public boolean isPat(){
        return pref.getBoolean(is_pat,true);
    }

}
