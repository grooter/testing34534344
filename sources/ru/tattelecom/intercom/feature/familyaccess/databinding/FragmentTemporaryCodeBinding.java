package ru.tattelecom.intercom.feature.familyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* loaded from: classes6.dex */
public final class FragmentTemporaryCodeBinding implements ViewBinding {
    public final ConstraintLayout clRoot;
    public final LinearLayout llTemporaryCode;
    private final ConstraintLayout rootView;
    public final RecyclerView rvTemporaryCodes;
    public final SwipeRefreshLayout swipeRefresh;
    public final MaterialToolbar toolbar;
    public final TextView tvEmpty;

    private FragmentTemporaryCodeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar, TextView textView) {
        this.rootView = constraintLayout;
        this.clRoot = constraintLayout2;
        this.llTemporaryCode = linearLayout;
        this.rvTemporaryCodes = recyclerView;
        this.swipeRefresh = swipeRefreshLayout;
        this.toolbar = materialToolbar;
        this.tvEmpty = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTemporaryCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTemporaryCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_temporary_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTemporaryCodeBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ll_temporary_code;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.rv_temporary_codes;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.swipe_refresh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                if (swipeRefreshLayout != null) {
                    i = R.id.toolbar;
                    MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                    if (materialToolbar != null) {
                        i = R.id.tv_empty;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new FragmentTemporaryCodeBinding(constraintLayout, constraintLayout, linearLayout, recyclerView, swipeRefreshLayout, materialToolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
