package ru.tattelecom.feature.call_history.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import ru.tattelecom.feature.call_history.R;

/* loaded from: classes5.dex */
public final class FragmentEventLogBinding implements ViewBinding {
    public final TextView btnAllHistory;
    public final TextView btnCallHistory;
    public final TextView btnCodePassHistory;
    public final TextView btnKeyHistory;
    public final ConstraintLayout clRoot;
    public final View divider;
    public final HorizontalScrollView hsvFilter;
    public final LinearLayout llFilter;
    public final ProgressBar progress;
    private final ConstraintLayout rootView;
    public final RecyclerView rvEventLog;
    public final SwipeRefreshLayout swipeRefreshLog;
    public final MaterialToolbar toolbar;
    public final TextView tvEmptyLogMessage;
    public final TextView tvEmptyLogTitle;

    private FragmentEventLogBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, View view, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.btnAllHistory = textView;
        this.btnCallHistory = textView2;
        this.btnCodePassHistory = textView3;
        this.btnKeyHistory = textView4;
        this.clRoot = constraintLayout2;
        this.divider = view;
        this.hsvFilter = horizontalScrollView;
        this.llFilter = linearLayout;
        this.progress = progressBar;
        this.rvEventLog = recyclerView;
        this.swipeRefreshLog = swipeRefreshLayout;
        this.toolbar = materialToolbar;
        this.tvEmptyLogMessage = textView5;
        this.tvEmptyLogTitle = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEventLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentEventLogBinding bind(View view) {
        int i = R.id.btn_all_history;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_call_history;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.btn_code_pass_history;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.btn_key_history;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.divider;
                        View findChildViewById = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById != null) {
                            i = R.id.hsv_filter;
                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                            if (horizontalScrollView != null) {
                                i = R.id.ll_filter;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.progress;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                    if (progressBar != null) {
                                        i = R.id.rv_event_log;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            i = R.id.swipe_refresh_log;
                                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                            if (swipeRefreshLayout != null) {
                                                i = R.id.toolbar;
                                                MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                                                if (materialToolbar != null) {
                                                    i = R.id.tv_empty_log_message;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_empty_log_title;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            return new FragmentEventLogBinding(constraintLayout, textView, textView2, textView3, textView4, constraintLayout, findChildViewById, horizontalScrollView, linearLayout, progressBar, recyclerView, swipeRefreshLayout, materialToolbar, textView5, textView6);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
