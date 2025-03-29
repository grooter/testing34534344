package ru.tattelecom.intercom.feature.tutorial.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import ru.tattelecom.intercom.feature.tutorial.R;

/* loaded from: classes8.dex */
public final class FragmentTutorialBinding implements ViewBinding {
    public final ImageButton ibClose;
    private final ConstraintLayout rootView;
    public final TabLayout tlTips;
    public final ViewPager2 vpTips;

    private FragmentTutorialBinding(ConstraintLayout constraintLayout, ImageButton imageButton, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.ibClose = imageButton;
        this.tlTips = tabLayout;
        this.vpTips = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTutorialBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTutorialBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tutorial, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTutorialBinding bind(View view) {
        int i = R.id.ibClose;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.tlTips;
            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
            if (tabLayout != null) {
                i = R.id.vpTips;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                if (viewPager2 != null) {
                    return new FragmentTutorialBinding((ConstraintLayout) view, imageButton, tabLayout, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
