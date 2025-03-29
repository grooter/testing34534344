package ru.tattelecom.intercom.feature.profile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.android.resources.customview.SupportContactView;
import ru.tattelecom.intercom.feature.profile.R;

/* loaded from: classes7.dex */
public final class FragmentProfileBinding implements ViewBinding {
    public final MaterialButton btnMoreServices;
    public final ImageView btnProfileDetails;
    public final SupportContactView cvSupport;
    public final LinearLayout llNavigation;
    public final ConstraintLayout llProfile;
    public final NestedScrollView nestedScroll;
    public final ProgressBar progress;
    private final ConstraintLayout rootView;
    public final Space sVersion;
    public final MaterialToolbar toolbar;
    public final TextView tvAbout;
    public final TextView tvAccessManagement;
    public final TextView tvAppVersion;
    public final TextView tvCallSettings;
    public final TextView tvLeaveRequest;
    public final TextView tvLogOut;
    public final TextView tvOfficeMap;

    private FragmentProfileBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, ImageView imageView, SupportContactView supportContactView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, NestedScrollView nestedScrollView, ProgressBar progressBar, Space space, MaterialToolbar materialToolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.btnMoreServices = materialButton;
        this.btnProfileDetails = imageView;
        this.cvSupport = supportContactView;
        this.llNavigation = linearLayout;
        this.llProfile = constraintLayout2;
        this.nestedScroll = nestedScrollView;
        this.progress = progressBar;
        this.sVersion = space;
        this.toolbar = materialToolbar;
        this.tvAbout = textView;
        this.tvAccessManagement = textView2;
        this.tvAppVersion = textView3;
        this.tvCallSettings = textView4;
        this.tvLeaveRequest = textView5;
        this.tvLogOut = textView6;
        this.tvOfficeMap = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentProfileBinding bind(View view) {
        int i = R.id.btn_more_services;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btn_profile_details;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.cv_support;
                SupportContactView supportContactView = (SupportContactView) ViewBindings.findChildViewById(view, i);
                if (supportContactView != null) {
                    i = R.id.ll_navigation;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.nested_scroll;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                        if (nestedScrollView != null) {
                            i = R.id.progress;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = R.id.s_version;
                                Space space = (Space) ViewBindings.findChildViewById(view, i);
                                if (space != null) {
                                    i = R.id.toolbar;
                                    MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                                    if (materialToolbar != null) {
                                        i = R.id.tv_about;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_access_management;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_app_version;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_call_settings;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_leave_request;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_log_out;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_office_map;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    return new FragmentProfileBinding(constraintLayout, materialButton, imageView, supportContactView, linearLayout, constraintLayout, nestedScrollView, progressBar, space, materialToolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
