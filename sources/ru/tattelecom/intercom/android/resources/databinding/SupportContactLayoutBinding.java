package ru.tattelecom.intercom.android.resources.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.android.resources.R;

/* loaded from: classes5.dex */
public final class SupportContactLayoutBinding implements ViewBinding {
    public final ImageView ivCallContact;
    public final ImageView ivChatContact;
    public final ImageView ivTelegramContact;
    private final View rootView;
    public final ConstraintLayout supportIcons;
    public final TextView tvSupport;

    private SupportContactLayoutBinding(View view, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = view;
        this.ivCallContact = imageView;
        this.ivChatContact = imageView2;
        this.ivTelegramContact = imageView3;
        this.supportIcons = constraintLayout;
        this.tvSupport = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static SupportContactLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.support_contact_layout, viewGroup);
        return bind(viewGroup);
    }

    public static SupportContactLayoutBinding bind(View view) {
        int i = R.id.ivCallContact;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ivChatContact;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.ivTelegramContact;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.supportIcons;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.tvSupport;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new SupportContactLayoutBinding(view, imageView, imageView2, imageView3, constraintLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
