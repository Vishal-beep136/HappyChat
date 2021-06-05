package kaitka.vishal.meeta.happychat.Adapters;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import kaitka.vishal.meeta.happychat.Fragments.CallsFragment;
import kaitka.vishal.meeta.happychat.Fragments.ChatsFragment;
import kaitka.vishal.meeta.happychat.Fragments.StatusFragment;

public class FragmentAdapters extends FragmentPagerAdapter {
    public FragmentAdapters(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new ChatsFragment();
            case 1: return new StatusFragment();
            case 2: return new CallsFragment();
            default: return new ChatsFragment();

        }//switch

    }//fragment

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
            title = "CHATS";
        }
        if (position==1){
            title = "STATUS";
        }
        if (position==2){
            title = "CALLS";
        }
        return title;
    }
}
