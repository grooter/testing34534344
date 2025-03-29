package ru.tattelecom.intercom.feature.gate_widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.gate_widget.R;

/* loaded from: classes6.dex */
public final class ItemSelectGateBinding implements ViewBinding {
    public final LinearLayout llRoot;
    private final LinearLayout rootView;
    public final TextView tvGateName;

    private ItemSelectGateBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.llRoot = linearLayout2;
        this.tvGateName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemSelectGateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSelectGateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_select_gate, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemSelectGateBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.tvGateName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new ItemSelectGateBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
