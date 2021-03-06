package com.example.pattimura.wims;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailProfile extends Fragment implements View.OnClickListener {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;
    ImageView tombol;

    public FragmentDetailProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_profile, container, false);

        tombol = (ImageView) v.findViewById(R.id.btnEditProfile);

        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        tombol.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == tombol) {
            Context context = FragmentDetailProfile.this.getContext();
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle("Update status Profile");
            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);

            final EditText titleBox = new EditText(context);
            titleBox.setHint("Status");
            layout.addView(titleBox);

            final EditText descriptionBox = new EditText(context);
            descriptionBox.setHint("Asal");
            layout.addView(descriptionBox);
            dialog.setView(layout);
            dialog.setPositiveButton("Ubah", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            dialog.create();
            dialog.show();
        }
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentInfoProfile();
                case 1:
                    return new FragmentKontakProfile();

            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "INFO";
                case 1:
                    return "KONTAK";
            }
            return null;
        }
    }

}
