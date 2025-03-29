package ru.tattelecom.intercom.feature.familyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* loaded from: classes6.dex */
public final class ItemTemporaryCodeBinding implements ViewBinding {
    public final ImageButton btnDeleteCode;
    public final MaterialButton btnGenerateCode;
    public final ImageButton btnRegenerateCode;
    public final ImageButton btnShareCode;
    public final ProgressBar progress;
    private final ConstraintLayout rootView;
    public final TextView tvAddress;
    public final TextView tvEntrance;
    public final TextView tvTimeCode;

    private ItemTemporaryCodeBinding(ConstraintLayout constraintLayout, ImageButton imageButton, MaterialButton materialButton, ImageButton imageButton2, ImageButton imageButton3, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnDeleteCode = imageButton;
        this.btnGenerateCode = materialButton;
        this.btnRegenerateCode = imageButton2;
        this.btnShareCode = imageButton3;
        this.progress = progressBar;
        this.tvAddress = textView;
        this.tvEntrance = textView2;
        this.tvTimeCode = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTemporaryCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemTemporaryCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_temporary_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTemporaryCodeBinding bind(View view) {
        int i = R.id.btn_delete_code;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.btn_generate_code;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.btn_regenerate_code;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
                if (imageButton2 != null) {
                    i = R.id.btn_share_code;
                    ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i);
                    if (imageButton3 != null) {
                        i = R.id.progress;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R.id.tv_address;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_entrance;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_time_code;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new ItemTemporaryCodeBinding((ConstraintLayout) view, imageButton, materialButton, imageButton2, imageButton3, progressBar, textView, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
