package ru.tattelecom.feature.call_history.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import ru.tattelecom.feature.call_history.R;

/* loaded from: classes5.dex */
public final class ItemEventBinding implements ViewBinding {
    public final ConstraintLayout clRoot;
    public final MaterialCardView cvRoot;
    public final ShapeableImageView ivSnapshot;
    private final MaterialCardView rootView;
    public final TextView tvAddress;
    public final TextView tvEvent;
    public final TextView tvName;
    public final TextView tvTime;

    private ItemEventBinding(MaterialCardView materialCardView, ConstraintLayout constraintLayout, MaterialCardView materialCardView2, ShapeableImageView shapeableImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = materialCardView;
        this.clRoot = constraintLayout;
        this.cvRoot = materialCardView2;
        this.ivSnapshot = shapeableImageView;
        this.tvAddress = textView;
        this.tvEvent = textView2;
        this.tvName = textView3;
        this.tvTime = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_event, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemEventBinding bind(View view) {
        int i = R.id.cl_root;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i = R.id.iv_snapshot;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
            if (shapeableImageView != null) {
                i = R.id.tv_address;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_event;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_name;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_time;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new ItemEventBinding(materialCardView, constraintLayout, materialCardView, shapeableImageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
