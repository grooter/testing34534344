package ru.tattelecom.intercom.feature.tutorial.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.tutorial.R;

/* loaded from: classes8.dex */
public final class ItemTipBinding implements ViewBinding {
    public final MaterialButton btnContinue;
    public final ImageView ivImage;
    private final ConstraintLayout rootView;

    private ItemTipBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, ImageView imageView) {
        this.rootView = constraintLayout;
        this.btnContinue = materialButton;
        this.ivImage = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTipBinding bind(View view) {
        int i = R.id.btnContinue;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.ivImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new ItemTipBinding((ConstraintLayout) view, materialButton, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
