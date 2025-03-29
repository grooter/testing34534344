package ru.tattelecom.intercom.feature.face_detect.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.face_detect.R;

/* loaded from: classes6.dex */
public final class FragmentFaceDetectBinding implements ViewBinding {
    public final ImageView btnAddPhoto;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPhotos;
    public final Toolbar toolbar;
    public final TextView tvDescription;

    private FragmentFaceDetectBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.rootView = constraintLayout;
        this.btnAddPhoto = imageView;
        this.rvPhotos = recyclerView;
        this.toolbar = toolbar;
        this.tvDescription = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFaceDetectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFaceDetectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_face_detect, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentFaceDetectBinding bind(View view) {
        int i = R.id.btnAddPhoto;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.rvPhotos;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                if (toolbar != null) {
                    i = R.id.tvDescription;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new FragmentFaceDetectBinding((ConstraintLayout) view, imageView, recyclerView, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
