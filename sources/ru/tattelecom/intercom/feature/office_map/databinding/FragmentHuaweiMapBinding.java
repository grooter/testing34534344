package ru.tattelecom.intercom.feature.office_map.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.android.resources.customview.ClickableMotionLayout;
import ru.tattelecom.intercom.feature.office_map.R;

/* loaded from: classes7.dex */
public final class FragmentHuaweiMapBinding implements ViewBinding {
    public final ConstraintLayout bottomSheet;
    public final ImageView btnLocation;
    public final TextView btnPhoneNumber;
    public final ImageView btnRoute;
    public final ImageView btnZoomMinus;
    public final ImageView btnZoomPlus;
    public final ImageView ivBottomSheetTop;
    public final ListView lvServicesList;
    public final ClickableMotionLayout motionLayout;
    private final ClickableMotionLayout rootView;
    public final RecyclerView rvFilter;
    public final View shadow;
    public final Toolbar toolbar;
    public final TextView tvAddress;
    public final TextView tvDistance;
    public final TextView tvOfficeName;
    public final TextView tvOpenStatus;
    public final TextView tvPhone;
    public final TextView tvSaturday;
    public final TextView tvSaturdayTime;
    public final TextView tvSchedule;
    public final TextView tvServices;
    public final TextView tvSunday;
    public final TextView tvSundayTime;
    public final TextView tvWorkWeekday;
    public final TextView tvWorkWeekdayTime;
    public final LinearLayout zoomContainer;

    private FragmentHuaweiMapBinding(ClickableMotionLayout clickableMotionLayout, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ListView listView, ClickableMotionLayout clickableMotionLayout2, RecyclerView recyclerView, View view, Toolbar toolbar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, LinearLayout linearLayout) {
        this.rootView = clickableMotionLayout;
        this.bottomSheet = constraintLayout;
        this.btnLocation = imageView;
        this.btnPhoneNumber = textView;
        this.btnRoute = imageView2;
        this.btnZoomMinus = imageView3;
        this.btnZoomPlus = imageView4;
        this.ivBottomSheetTop = imageView5;
        this.lvServicesList = listView;
        this.motionLayout = clickableMotionLayout2;
        this.rvFilter = recyclerView;
        this.shadow = view;
        this.toolbar = toolbar;
        this.tvAddress = textView2;
        this.tvDistance = textView3;
        this.tvOfficeName = textView4;
        this.tvOpenStatus = textView5;
        this.tvPhone = textView6;
        this.tvSaturday = textView7;
        this.tvSaturdayTime = textView8;
        this.tvSchedule = textView9;
        this.tvServices = textView10;
        this.tvSunday = textView11;
        this.tvSundayTime = textView12;
        this.tvWorkWeekday = textView13;
        this.tvWorkWeekdayTime = textView14;
        this.zoomContainer = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ClickableMotionLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHuaweiMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHuaweiMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_huawei_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHuaweiMapBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bottomSheet;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.btnLocation;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btnPhoneNumber;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.btnRoute;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.btnZoomMinus;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.btnZoomPlus;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.ivBottomSheetTop;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView5 != null) {
                                    i = R.id.lvServicesList;
                                    ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                                    if (listView != null) {
                                        ClickableMotionLayout clickableMotionLayout = (ClickableMotionLayout) view;
                                        i = R.id.rvFilter;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.shadow))) != null) {
                                            i = R.id.toolbar;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                            if (toolbar != null) {
                                                i = R.id.tvAddress;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tvDistance;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tvOfficeName;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.tvOpenStatus;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.tvPhone;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.tvSaturday;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.tvSaturdayTime;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.tvSchedule;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.tvServices;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.tvSunday;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.tvSundayTime;
                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView12 != null) {
                                                                                            i = R.id.tvWorkWeekday;
                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.tvWorkWeekdayTime;
                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView14 != null) {
                                                                                                    i = R.id.zoomContainer;
                                                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout != null) {
                                                                                                        return new FragmentHuaweiMapBinding(clickableMotionLayout, constraintLayout, imageView, textView, imageView2, imageView3, imageView4, imageView5, listView, clickableMotionLayout, recyclerView, findChildViewById, toolbar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, linearLayout);
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
