package ru.tattelecom.intercom.android.resources.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.android.resources.R;

/* loaded from: classes5.dex */
public final class TooltipLayoutBinding implements ViewBinding {
    public final CardView cvContainer;
    public final ImageView ivArrowBottom;
    public final ImageView ivArrowTop;
    public final ImageView ivClose;
    private final LinearLayout rootView;
    public final TextView tvText;

    private TooltipLayoutBinding(LinearLayout linearLayout, CardView cardView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = linearLayout;
        this.cvContainer = cardView;
        this.ivArrowBottom = imageView;
        this.ivArrowTop = imageView2;
        this.ivClose = imageView3;
        this.tvText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TooltipLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TooltipLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.tooltip_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TooltipLayoutBinding bind(View view) {
        int i = R.id.cvContainer;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.ivArrowBottom;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.ivArrowTop;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.ivClose;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.tvText;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new TooltipLayoutBinding((LinearLayout) view, cardView, imageView, imageView2, imageView3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
