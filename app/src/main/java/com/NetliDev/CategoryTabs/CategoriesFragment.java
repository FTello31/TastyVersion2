package com.NetliDev.CategoryTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.NetliDev.CategoryTabs.DessertsFragment;
import com.NetliDev.CategoryTabs.OthersFragment;
import com.NetliDev.CategoryTabs.SandwichFragment;
import com.NetliDev.CategoryTabs.TabsViewPagerAdapter;
import com.NetliDev.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CategoriesFragment extends Fragment {

    private DessertsFragment dessertsFragment;
    private OthersFragment othersFragment;
    private SandwichFragment sandwichFragment;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dessertsFragment = new DessertsFragment();
        othersFragment = new OthersFragment();
        sandwichFragment = new SandwichFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
        TabsViewPagerAdapter tabsViewPagerAdapter = new TabsViewPagerAdapter(getChildFragmentManager(),0);
        tabsViewPagerAdapter.addFragment(sandwichFragment,"Sandwiches");
        tabsViewPagerAdapter.addFragment(dessertsFragment,"Desserts");
        tabsViewPagerAdapter.addFragment(othersFragment,"Others");
        viewPager.setAdapter(tabsViewPagerAdapter);

//        Icons above tab title
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home_black_24dp);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_home_black_24dp);

//        BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
//        badgeDrawable.setVisible(true);
//        badgeDrawable.setNumber(10);


        return view;
    }


}
