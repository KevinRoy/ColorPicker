package com.kevin.colorpicker.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.kevin.colorpicker.R;

import java.util.ArrayList;
import java.util.List;

import br.liveo.interfaces.NavigationLiveoListener;
import br.liveo.navigationliveo.NavigationLiveo;


public class MainActivity extends NavigationLiveo implements NavigationLiveoListener {

    @Override
    public void onUserInformation() {
        this.mUserName.setText("Kevin");
        this.mUserEmail.setText("luozheng216@gmail.com");
        this.mUserPhoto.setImageResource(R.drawable.ic_rudsonlive);
        this.mUserBackground.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void onInt(Bundle bundle) {
        this.setNavigationListener(this);

        /**
         *  set item name
         */
        List<String> listNameItem = new ArrayList<>();
        listNameItem.add(0, getString(R.string.take_phone));
        listNameItem.add(1, getString(R.string.take_phone));
        listNameItem.add(2, getString(R.string.take_phone));

        /**
         *  set item icon
         */
        List<Integer> listIconItem = new ArrayList<>();
        listIconItem.add(0, R.drawable.ic_action_send);
        listIconItem.add(1, R.drawable.ic_action_send);
        listIconItem.add(2, R.drawable.ic_action_send);

        /**
         *  set item title
         */
        List<Integer> istHeaderItem = new ArrayList<>();

        /**
         *  set item number
         */
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(0, 7);

        this.setDefaultStartPositionNavigation(0);
        this.setFooterInformationDrawer(R.string.settings, R.drawable.ic_launcher);
        this.setNavigationAdapter(listNameItem, listIconItem, istHeaderItem, sparseIntArray);
    }

    @Override
    public void onItemClickNavigation(int position, int layoutContainerId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mFragment = new MainFragment();

        if (mFragment != null) {
            if (position == 0) {
                fragmentManager.beginTransaction().replace(layoutContainerId, mFragment).commit();
            }
        }
    }

    @Override
    public void onPrepareOptionsMenuNavigation(Menu menu, int i, boolean b) {

    }

    @Override
    public void onClickFooterItemNavigation(View view) {

    }

    @Override
    public void onClickUserPhotoNavigation(View view) {

    }
}
