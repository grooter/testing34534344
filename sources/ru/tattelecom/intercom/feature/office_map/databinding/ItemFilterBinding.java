package ru.tattelecom.intercom.feature.office_map.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.office_map.R;

/* loaded from: classes7.dex */
public final class ItemFilterBinding implements ViewBinding {
    public final FrameLayout itemContainer;
    private final FrameLayout rootView;
    public final TextView spendingName;

    private ItemFilterBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView) {
        this.rootView = frameLayout;
        this.itemContainer = frameLayout2;
        this.spendingName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemFilterBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.spendingName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new ItemFilterBinding(frameLayout, frameLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
