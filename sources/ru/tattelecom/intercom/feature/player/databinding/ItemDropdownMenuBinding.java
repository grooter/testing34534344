package ru.tattelecom.intercom.feature.player.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import ru.tattelecom.intercom.feature.player.R;

/* loaded from: classes7.dex */
public final class ItemDropdownMenuBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvText;

    private ItemDropdownMenuBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ItemDropdownMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDropdownMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_dropdown_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemDropdownMenuBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new ItemDropdownMenuBinding(textView, textView);
    }
}
