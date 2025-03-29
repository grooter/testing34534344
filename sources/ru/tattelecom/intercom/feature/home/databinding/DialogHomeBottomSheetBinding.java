package ru.tattelecom.intercom.feature.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.home.R;

/* loaded from: classes6.dex */
public final class DialogHomeBottomSheetBinding implements ViewBinding {
    public final MaterialButton button;
    public final ConstraintLayout clContent;
    public final ConstraintLayout clRoot;
    public final ImageView ivAdvImage;
    public final ImageView ivClose;
    private final NestedScrollView rootView;
    public final TextView tvDescription;
    public final TextView tvTitle;
    public final View vContentBg;

    private DialogHomeBottomSheetBinding(NestedScrollView nestedScrollView, MaterialButton materialButton, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, View view) {
        this.rootView = nestedScrollView;
        this.button = materialButton;
        this.clContent = constraintLayout;
        this.clRoot = constraintLayout2;
        this.ivAdvImage = imageView;
        this.ivClose = imageView2;
        this.tvDescription = textView;
        this.tvTitle = textView2;
        this.vContentBg = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogHomeBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogHomeBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_home_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogHomeBottomSheetBinding bind(View view) {
        View findChildViewById;
        int i = R.id.button;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.clContent;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.clRoot;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.ivAdvImage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.ivClose;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.tvDescription;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tvTitle;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.vContentBg))) != null) {
                                    return new DialogHomeBottomSheetBinding((NestedScrollView) view, materialButton, constraintLayout, constraintLayout2, imageView, imageView2, textView, textView2, findChildViewById);
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
