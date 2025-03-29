package ru.tattelecom.intercom.feature.call_settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import ru.tattelecom.intercom.feature.call_settings.R;

/* loaded from: classes6.dex */
public final class DialogCallSettingsBinding implements ViewBinding {
    public final LinearLayout llDoNotDisturb;
    public final ProgressBar progressDoNotDisturb;
    public final RadioGroup rgRingtone;
    private final LinearLayout rootView;
    public final SwitchMaterial switchDoNotDisturb;

    private DialogCallSettingsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RadioGroup radioGroup, SwitchMaterial switchMaterial) {
        this.rootView = linearLayout;
        this.llDoNotDisturb = linearLayout2;
        this.progressDoNotDisturb = progressBar;
        this.rgRingtone = radioGroup;
        this.switchDoNotDisturb = switchMaterial;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogCallSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCallSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_call_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogCallSettingsBinding bind(View view) {
        int i = R.id.ll_do_not_disturb;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.progress_do_not_disturb;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                i = R.id.rg_ringtone;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                if (radioGroup != null) {
                    i = R.id.switch_do_not_disturb;
                    SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                    if (switchMaterial != null) {
                        return new DialogCallSettingsBinding((LinearLayout) view, linearLayout, progressBar, radioGroup, switchMaterial);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
