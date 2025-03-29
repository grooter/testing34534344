package ru.tattelecom.intercom.feature.welcome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.welcome.R;

/* loaded from: classes8.dex */
public final class FragmentWelcomeBinding implements ViewBinding {
    public final MaterialButton btnStart;
    private final ConstraintLayout rootView;

    private FragmentWelcomeBinding(ConstraintLayout constraintLayout, MaterialButton materialButton) {
        this.rootView = constraintLayout;
        this.btnStart = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWelcomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_welcome, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentWelcomeBinding bind(View view) {
        int i = R.id.btnStart;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            return new FragmentWelcomeBinding((ConstraintLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
