package ru.tattelecom.intercom.android.resources.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import ru.tattelecom.intercom.android.resources.R;

/* loaded from: classes5.dex */
public final class AppBarLayoutBinding implements ViewBinding {
    public final CollapsingToolbarLayout collapsingToolbar;
    private final AppBarLayout rootView;

    private AppBarLayoutBinding(AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout) {
        this.rootView = appBarLayout;
        this.collapsingToolbar = collapsingToolbarLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public AppBarLayout getRoot() {
        return this.rootView;
    }

    public static AppBarLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AppBarLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.app_bar_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AppBarLayoutBinding bind(View view) {
        int i = R.id.collapsing_toolbar;
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view, i);
        if (collapsingToolbarLayout != null) {
            return new AppBarLayoutBinding((AppBarLayout) view, collapsingToolbarLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
