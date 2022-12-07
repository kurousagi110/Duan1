package com.example.duan1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1.Fragment.KhoanKeHoachFragment;
import com.example.duan1.Fragment.KhoanThuFragment;
import com.example.duan1.Fragment.LoaiChiFragment;
import com.example.duan1.Fragment.LoaiKeHoachFragment;
import com.example.duan1.Fragment.LoaiThuFragment;

public class ViewPagerAdapterKeHoach extends FragmentStateAdapter {

    public ViewPagerAdapterKeHoach(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LoaiKeHoachFragment();
            case 1:
                return new KhoanKeHoachFragment();
            default:
                return new LoaiKeHoachFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
