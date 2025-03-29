package ru.tattelecom.intercom.feature.familyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* loaded from: classes6.dex */
public final class FragmentAddAddressContainerBinding implements ViewBinding {
    public final View divider;
    private final LinearLayout rootView;
    public final TabLayout tabLayout;
    public final MaterialToolbar toolbar;
    public final ViewPager2 viewPager;

    private FragmentAddAddressContainerBinding(LinearLayout linearLayout, View view, TabLayout tabLayout, MaterialToolbar materialToolbar, ViewPager2 viewPager2) {
        this.rootView = linearLayout;
        this.divider = view;
        this.tabLayout = tabLayout;
        this.toolbar = materialToolbar;
        this.viewPager = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddAddressContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAddAddressContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_address_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddAddressContainerBinding bind(View view) {
        int i = R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tabLayout;
            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
            if (tabLayout != null) {
                i = R.id.toolbar;
                MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                if (materialToolbar != null) {
                    i = R.id.viewPager;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                    if (viewPager2 != null) {
                        return new FragmentAddAddressContainerBinding((LinearLayout) view, findChildViewById, tabLayout, materialToolbar, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
