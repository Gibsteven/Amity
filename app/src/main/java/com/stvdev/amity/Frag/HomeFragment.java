package com.stvdev.amity.Frag;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.stvdev.amity.Adapters.AdapterViewPager;
import com.stvdev.amity.Adapters.AdapterViewPager2;
import com.stvdev.amity.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> fragmentTitleList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager2 = view.findViewById(R.id.view_pager);

        fragmentArrayList.add(new TimeLineFragment());

        fragmentTitleList.add("TIMELINE");

        AdapterViewPager2 adapterViewPager = new AdapterViewPager2(requireActivity(), fragmentArrayList);
        viewPager2.setAdapter(adapterViewPager);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(fragmentTitleList.get(position))).attach();

        return view;
    }
}
