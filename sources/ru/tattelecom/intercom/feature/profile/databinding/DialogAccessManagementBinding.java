package ru.tattelecom.intercom.feature.profile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.profile.R;

/* loaded from: classes7.dex */
public final class DialogAccessManagementBinding implements ViewBinding {
    public final ImageView ivBottomSheetTop;
    public final LinearLayout list;
    private final LinearLayout rootView;
    public final TextView tvAddAddress;
    public final TextView tvInviteUser;
    public final TextView tvTemporaryAccess;

    private DialogAccessManagementBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.ivBottomSheetTop = imageView;
        this.list = linearLayout2;
        this.tvAddAddress = textView;
        this.tvInviteUser = textView2;
        this.tvTemporaryAccess = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogAccessManagementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAccessManagementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_access_management, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogAccessManagementBinding bind(View view) {
        int i = R.id.ivBottomSheetTop;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.tv_add_address;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvInviteUser;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_temporary_access;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new DialogAccessManagementBinding(linearLayout, imageView, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
