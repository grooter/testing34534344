package ru.tattelecom.intercom.feature.player.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import ru.tattelecom.intercom.feature.player.R;

/* loaded from: classes7.dex */
public final class ActivityLeaveOrderBinding implements ViewBinding {
    public final FragmentContainerView fragment;
    private final FragmentContainerView rootView;

    private ActivityLeaveOrderBinding(FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2) {
        this.rootView = fragmentContainerView;
        this.fragment = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FragmentContainerView getRoot() {
        return this.rootView;
    }

    public static ActivityLeaveOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLeaveOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_leave_order, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLeaveOrderBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view;
        return new ActivityLeaveOrderBinding(fragmentContainerView, fragmentContainerView);
    }
}
