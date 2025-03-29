package ru.tattelecom.intercom.feature.profile_details.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import ru.tattelecom.intercom.feature.profile_details.R;

/* loaded from: classes7.dex */
public final class FragmentProfileDetailsBinding implements ViewBinding {
    public final ProfileDetailsItemBinding faceItem;
    public final ProfileDetailsItemBinding phoneItem;
    private final LinearLayout rootView;
    public final MaterialToolbar toolbar;

    private FragmentProfileDetailsBinding(LinearLayout linearLayout, ProfileDetailsItemBinding profileDetailsItemBinding, ProfileDetailsItemBinding profileDetailsItemBinding2, MaterialToolbar materialToolbar) {
        this.rootView = linearLayout;
        this.faceItem = profileDetailsItemBinding;
        this.phoneItem = profileDetailsItemBinding2;
        this.toolbar = materialToolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentProfileDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentProfileDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile_details, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentProfileDetailsBinding bind(View view) {
        int i = R.id.faceItem;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            ProfileDetailsItemBinding bind = ProfileDetailsItemBinding.bind(findChildViewById);
            int i2 = R.id.phoneItem;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i2);
            if (findChildViewById2 != null) {
                ProfileDetailsItemBinding bind2 = ProfileDetailsItemBinding.bind(findChildViewById2);
                int i3 = R.id.toolbar;
                MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i3);
                if (materialToolbar != null) {
                    return new FragmentProfileDetailsBinding((LinearLayout) view, bind, bind2, materialToolbar);
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
