package ru.tattelecom.feature.call_history.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import ru.tattelecom.feature.call_history.R;

/* loaded from: classes5.dex */
public final class ItemBannerBinding implements ViewBinding {
    public final TextView btnBecomeSubscriber;
    public final ImageView btnClose;
    public final ConstraintLayout clBanner;
    public final MaterialCardView cvRoot;
    private final MaterialCardView rootView;
    public final TextView tvAttentionInfo;
    public final TextView tvAttentionTitle;

    private ItemBannerBinding(MaterialCardView materialCardView, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, MaterialCardView materialCardView2, TextView textView2, TextView textView3) {
        this.rootView = materialCardView;
        this.btnBecomeSubscriber = textView;
        this.btnClose = imageView;
        this.clBanner = constraintLayout;
        this.cvRoot = materialCardView2;
        this.tvAttentionInfo = textView2;
        this.tvAttentionTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_banner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemBannerBinding bind(View view) {
        int i = R.id.btn_become_subscriber;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.cl_banner;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    MaterialCardView materialCardView = (MaterialCardView) view;
                    i = R.id.tv_attention_info;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_attention_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new ItemBannerBinding(materialCardView, textView, imageView, constraintLayout, materialCardView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
