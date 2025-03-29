package ru.tattelecom.intercom.feature.face_detect.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import ru.tattelecom.intercom.feature.face_detect.R;

/* loaded from: classes6.dex */
public final class ItemPhotoBinding implements ViewBinding {
    public final MaterialCardView cvRoot;
    public final ImageView ivSnapshot;
    private final MaterialCardView rootView;

    private ItemPhotoBinding(MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView) {
        this.rootView = materialCardView;
        this.cvRoot = materialCardView2;
        this.ivSnapshot = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPhotoBinding bind(View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i = R.id.ivSnapshot;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new ItemPhotoBinding(materialCardView, materialCardView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
