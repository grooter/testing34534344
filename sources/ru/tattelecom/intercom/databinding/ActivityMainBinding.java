package ru.tattelecom.intercom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import ru.tattelecom.intercom.R;

/* loaded from: classes5.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final BottomNavigationView bottomNav;
    public final ConstraintLayout clRoot;
    public final View divider;
    public final FragmentContainerView navHost;
    private final ConstraintLayout rootView;

    private ActivityMainBinding(ConstraintLayout rootView, BottomNavigationView bottomNav, ConstraintLayout clRoot, View divider, FragmentContainerView navHost) {
        this.rootView = rootView;
        this.bottomNav = bottomNav;
        this.clRoot = clRoot;
        this.divider = divider;
        this.navHost = navHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View rootView) {
        int i = R.id.bottom_nav;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(rootView, R.id.bottom_nav);
        if (bottomNavigationView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.divider;
            View findChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider);
            if (findChildViewById != null) {
                i = R.id.nav_host;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(rootView, R.id.nav_host);
                if (fragmentContainerView != null) {
                    return new ActivityMainBinding(constraintLayout, bottomNavigationView, constraintLayout, findChildViewById, fragmentContainerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
