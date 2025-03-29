package ru.tattelecom.intercom.feature.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import ru.tattelecom.intercom.android.resources.customview.SupportContactView;
import ru.tattelecom.intercom.feature.home.R;

/* loaded from: classes6.dex */
public final class FragmentHomeBinding implements ViewBinding {
    public final MaterialButton btnAddAddress;
    public final ImageView btnBannerClose;
    public final MaterialButton btnBannerOpen;
    public final MaterialButton btnLeaveRequest;
    public final TextView btnTrial;
    public final TextView btnTrialExtend;
    public final MaterialButton btnUpdate;
    public final MaterialCardView cardBanner;
    public final LinearLayout clParent;
    public final ConstraintLayout clTrial;
    public final SupportContactView cvSupport;
    public final View divider;
    public final Guideline guideline;
    public final Guideline guidelineVertical;
    public final ImageView ivAdvIcon;
    public final ImageView ivState;
    public final ProgressBar progress;
    private final LinearLayout rootView;
    public final SwipeRefreshLayout swipeRefresh;
    public final TabLayout tabLayout;
    public final MaterialToolbar toolbar;
    public final TextView tvBannerDescription;
    public final TextView tvBannerTitle;
    public final TextView tvLeaveRequest;
    public final TextView tvMessage;
    public final TextView tvTitle;
    public final TextView tvTrial;
    public final ViewPager2 viewPager;

    private FragmentHomeBinding(LinearLayout linearLayout, MaterialButton materialButton, ImageView imageView, MaterialButton materialButton2, MaterialButton materialButton3, TextView textView, TextView textView2, MaterialButton materialButton4, MaterialCardView materialCardView, LinearLayout linearLayout2, ConstraintLayout constraintLayout, SupportContactView supportContactView, View view, Guideline guideline, Guideline guideline2, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, SwipeRefreshLayout swipeRefreshLayout, TabLayout tabLayout, MaterialToolbar materialToolbar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ViewPager2 viewPager2) {
        this.rootView = linearLayout;
        this.btnAddAddress = materialButton;
        this.btnBannerClose = imageView;
        this.btnBannerOpen = materialButton2;
        this.btnLeaveRequest = materialButton3;
        this.btnTrial = textView;
        this.btnTrialExtend = textView2;
        this.btnUpdate = materialButton4;
        this.cardBanner = materialCardView;
        this.clParent = linearLayout2;
        this.clTrial = constraintLayout;
        this.cvSupport = supportContactView;
        this.divider = view;
        this.guideline = guideline;
        this.guidelineVertical = guideline2;
        this.ivAdvIcon = imageView2;
        this.ivState = imageView3;
        this.progress = progressBar;
        this.swipeRefresh = swipeRefreshLayout;
        this.tabLayout = tabLayout;
        this.toolbar = materialToolbar;
        this.tvBannerDescription = textView3;
        this.tvBannerTitle = textView4;
        this.tvLeaveRequest = textView5;
        this.tvMessage = textView6;
        this.tvTitle = textView7;
        this.tvTrial = textView8;
        this.viewPager = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHomeBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btn_add_address;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btnBannerClose;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btnBannerOpen;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.btn_leave_request;
                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton3 != null) {
                        i = R.id.btnTrial;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.btnTrialExtend;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.btn_update;
                                MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                if (materialButton4 != null) {
                                    i = R.id.cardBanner;
                                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                                    if (materialCardView != null) {
                                        LinearLayout linearLayout = (LinearLayout) view;
                                        i = R.id.clTrial;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout != null) {
                                            i = R.id.cv_support;
                                            SupportContactView supportContactView = (SupportContactView) ViewBindings.findChildViewById(view, i);
                                            if (supportContactView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                                                i = R.id.guideline;
                                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline != null) {
                                                    i = R.id.guideline_vertical;
                                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline2 != null) {
                                                        i = R.id.ivAdvIcon;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView2 != null) {
                                                            i = R.id.iv_state;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView3 != null) {
                                                                i = R.id.progress;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                if (progressBar != null) {
                                                                    i = R.id.swipe_refresh;
                                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (swipeRefreshLayout != null) {
                                                                        i = R.id.tab_layout;
                                                                        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (tabLayout != null) {
                                                                            i = R.id.toolbar;
                                                                            MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                                                                            if (materialToolbar != null) {
                                                                                i = R.id.tvBannerDescription;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.tvBannerTitle;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.tv_leave_request;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.tv_message;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView6 != null) {
                                                                                                i = R.id.tv_title;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.tvTrial;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.view_pager;
                                                                                                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                                                                        if (viewPager2 != null) {
                                                                                                            return new FragmentHomeBinding(linearLayout, materialButton, imageView, materialButton2, materialButton3, textView, textView2, materialButton4, materialCardView, linearLayout, constraintLayout, supportContactView, findChildViewById, guideline, guideline2, imageView2, imageView3, progressBar, swipeRefreshLayout, tabLayout, materialToolbar, textView3, textView4, textView5, textView6, textView7, textView8, viewPager2);
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
