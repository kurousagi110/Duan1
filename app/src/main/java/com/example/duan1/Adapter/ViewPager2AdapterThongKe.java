package com.example.duan1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1.Fragment.ThongKe_ThuChi_Fragment;
import com.example.duan1.Fragment.ThongKe_thang_Fragment;
import com.example.duan1.Fragment.Thongke_nam_fragment;

public class ViewPager2AdapterThongKe extends FragmentStateAdapter {


    public ViewPager2AdapterThongKe(@NonNull FragmentActivity fragmentActivity) {

        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ThongKe_ThuChi_Fragment();
            case 1:
                return new ThongKe_thang_Fragment();
            case 2:
                return new Thongke_nam_fragment();

            default:
                return new ThongKe_ThuChi_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}