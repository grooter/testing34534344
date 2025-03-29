package ru.tattelecom.intercom.feature.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.home.R;

/* loaded from: classes6.dex */
public final class FragmentListBinding implements ViewBinding {
    public final ConstraintLayout clEmpty;
    public final Guideline guideline2;
    public final ImageView imageView;
    private final FrameLayout rootView;
    public final RecyclerView rvYards;
    public final SwipeRefreshLayout swipeRefresh;
    public final TextView textView;
    public final TextView textView2;

    private FragmentListBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, Guideline guideline, ImageView imageView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.clEmpty = constraintLayout;
        this.guideline2 = guideline;
        this.imageView = imageView;
        this.rvYards = recyclerView;
        this.swipeRefresh = swipeRefreshLayout;
        this.textView = textView;
        this.textView2 = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentListBinding bind(View view) {
        int i = R.id.cl_empty;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.guideline2;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.imageView;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.rv_yards;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.swipe_refresh;
                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                        if (swipeRefreshLayout != null) {
                            i = R.id.textView;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.textView2;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new FragmentListBinding((FrameLayout) view, constraintLayout, guideline, imageView, recyclerView, swipeRefreshLayout, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
