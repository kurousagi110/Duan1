package com.example.duan1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.example.duan1.Fragment.LienHe_Fragment;
import com.example.duan1.Fragment.NapTien_Fragment;
import com.example.duan1.Fragment.TaiKhoan_Fragment;
import com.example.duan1.Fragment.trang_chu_Fragment;


import com.example.duan1.Fragment.ThongKe_Fragment;


public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new trang_chu_Fragment();
            case 1:
                return new NapTien_Fragment();
            case 2:
                return new ThongKe_Fragment();
            case 3:
                return new TaiKhoan_Fragment();
            case 4:
                return new LienHe_Fragment();
            default:
                return new trang_chu_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}