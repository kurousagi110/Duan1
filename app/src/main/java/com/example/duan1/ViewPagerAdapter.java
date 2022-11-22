package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1.Fragment.LienHe_Fragment;
import com.example.duan1.Fragment.NapTien_Fragment;
import com.example.duan1.Fragment.TaiKhoan_Fragment;
import com.example.duan1.Fragment.ThongKe_Fragment;
import com.example.duan1.Fragment.trang_chu_Fragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {

        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
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
    public int getCount() {
        return 5;
    }
}
