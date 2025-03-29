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
public final class DialogSelectItemBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnOk;
    public final LinearLayout divider1;
    public final View divider11;
    public final LinearLayout divider2;
    public final View divider22;
    public final LinearLayout llSelectTime;
    public final WheelPicker picker;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private DialogSelectItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, View view, LinearLayout linearLayout3, View view2, LinearLayout linearLayout4, WheelPicker wheelPicker, TextView textView3) {
        this.rootView = linearLayout;
        this.btnCancel = textView;
        this.btnOk = textView2;
        this.divider1 = linearLayout2;
        this.divider11 = view;
        this.divider2 = linearLayout3;
        this.divider22 = view2;
        this.llSelectTime = linearLayout4;
        this.picker = wheelPicker;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSelectItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_select_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSelectItemBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
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
                        LinearLayout linearLayout3 = (LinearLayout) view;
                        i = R.id.picker;
                        WheelPicker wheelPicker = (WheelPicker) ViewBindings.findChildViewById(view, i);
                        if (wheelPicker != null) {
                            i = R.id.tvTitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new DialogSelectItemBinding(linearLayout3, textView, textView2, linearLayout, findChildViewById, linearLayout2, findChildViewById2, linearLayout3, wheelPicker, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
