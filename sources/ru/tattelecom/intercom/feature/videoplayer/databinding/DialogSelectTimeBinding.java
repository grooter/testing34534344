package ru.tattelecom.intercom.feature.videoplayer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.aigestudio.wheelpicker.WheelPicker;
import ru.tattelecom.intercom.feature.videoplayer.R;

/* loaded from: classes8.dex */
public final class DialogSelectTimeBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnOk;
    public final LinearLayout divider1;
    public final View divider11;
    public final LinearLayout divider2;
    public final View divider22;
    public final LinearLayout divider3;
    public final View divider33;
    public final LinearLayout divider4;
    public final View divider44;
    public final LinearLayout divider5;
    public final View divider55;
    public final LinearLayout divider6;
    public final View divider66;
    public final LinearLayout llSelectTime;
    public final WheelPicker pickerHours;
    public final WheelPicker pickerMinutes;
    public final WheelPicker pickerSeconds;
    private final LinearLayout rootView;
    public final TextView textView60;
    public final TextView textView61;
    public final TextView tvTitle;

    private DialogSelectTimeBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, View view, LinearLayout linearLayout3, View view2, LinearLayout linearLayout4, View view3, LinearLayout linearLayout5, View view4, LinearLayout linearLayout6, View view5, LinearLayout linearLayout7, View view6, LinearLayout linearLayout8, WheelPicker wheelPicker, WheelPicker wheelPicker2, WheelPicker wheelPicker3, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnCancel = textView;
        this.btnOk = textView2;
        this.divider1 = linearLayout2;
        this.divider11 = view;
        this.divider2 = linearLayout3;
        this.divider22 = view2;
        this.divider3 = linearLayout4;
        this.divider33 = view3;
        this.divider4 = linearLayout5;
        this.divider44 = view4;
        this.divider5 = linearLayout6;
        this.divider55 = view5;
        this.divider6 = linearLayout7;
        this.divider66 = view6;
        this.llSelectTime = linearLayout8;
        this.pickerHours = wheelPicker;
        this.pickerMinutes = wheelPicker2;
        this.pickerSeconds = wheelPicker3;
        this.textView60 = textView3;
        this.textView61 = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSelectTimeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSelectTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_select_time, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSelectTimeBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        View findChildViewById6;
        int i = R.id.btnCancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btnOk;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.divider1;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider11))) != null) {
                    i = R.id.divider2;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.divider22))) != null) {
                        i = R.id.divider3;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.divider33))) != null) {
                            i = R.id.divider4;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.divider44))) != null) {
                                i = R.id.divider5;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout5 != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.divider55))) != null) {
                                    i = R.id.divider6;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout6 != null && (findChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.divider66))) != null) {
                                        LinearLayout linearLayout7 = (LinearLayout) view;
                                        i = R.id.pickerHours;
                                        WheelPicker wheelPicker = (WheelPicker) ViewBindings.findChildViewById(view, i);
                                        if (wheelPicker != null) {
                                            i = R.id.pickerMinutes;
                                            WheelPicker wheelPicker2 = (WheelPicker) ViewBindings.findChildViewById(view, i);
                                            if (wheelPicker2 != null) {
                                                i = R.id.pickerSeconds;
                                                WheelPicker wheelPicker3 = (WheelPicker) ViewBindings.findChildViewById(view, i);
                                                if (wheelPicker3 != null) {
                                                    i = R.id.textView60;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.textView61;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.tvTitle;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                return new DialogSelectTimeBinding(linearLayout7, textView, textView2, linearLayout, findChildViewById, linearLayout2, findChildViewById2, linearLayout3, findChildViewById3, linearLayout4, findChildViewById4, linearLayout5, findChildViewById5, linearLayout6, findChildViewById6, linearLayout7, wheelPicker, wheelPicker2, wheelPicker3, textView3, textView4, textView5);
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
