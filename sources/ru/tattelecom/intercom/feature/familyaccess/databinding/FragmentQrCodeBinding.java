package ru.tattelecom.intercom.feature.familyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* loaded from: classes6.dex */
public final class FragmentQrCodeBinding implements ViewBinding {
    public final MaterialButton btnClose;
    public final ImageView ivCamera;
    public final ImageView ivQRCode;
    public final ImageView ivQRCodeFrame;
    public final View qrCodeBackground;
    private final ConstraintLayout rootView;
    public final TextView textView;

    private FragmentQrCodeBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, ImageView imageView, ImageView imageView2, ImageView imageView3, View view, TextView textView) {
        this.rootView = constraintLayout;
        this.btnClose = materialButton;
        this.ivCamera = imageView;
        this.ivQRCode = imageView2;
        this.ivQRCodeFrame = imageView3;
        this.qrCodeBackground = view;
        this.textView = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentQrCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentQrCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_qr_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentQrCodeBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btnClose;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.ivCamera;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.ivQRCode;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.ivQRCodeFrame;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.qrCodeBackground))) != null) {
                        i = R.id.textView;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new FragmentQrCodeBinding((ConstraintLayout) view, materialButton, imageView, imageView2, imageView3, findChildViewById, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
