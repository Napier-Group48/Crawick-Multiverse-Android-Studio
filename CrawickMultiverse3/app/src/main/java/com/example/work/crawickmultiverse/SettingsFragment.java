package com.example.work.crawickmultiverse;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.MenuItem;
import com.takisoft.fix.support.v7.preference.PreferenceFragmentCompat;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragmentCompat {


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferencesFix(@Nullable Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_main);
    }


    //@Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container,
      //                       Bundle savedInstanceState) {
      //  // Inflate the layout for this fragment
       // View v = inflater.inflate(R.layout.fragment_settings, container, false);
       // return v;
    }


