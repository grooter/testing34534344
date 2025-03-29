package ru.tattelecom.intercom.feature.videoplayer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import ru.tattelecom.intercom.feature.videoplayer.R;

/* loaded from: classes8.dex */
public final class DialogDownloadBinding implements ViewBinding {
    public final MaterialButton btnCancel;
    public final MaterialButton btnDownload;
    public final ImageView ivArrowDate;
    public final ImageView ivArrowDuration;
    public final ImageView ivArrowStartTime;
    public final ImageView ivDownloadInfo;
    public final LinearLayout llDownloadInfo;
    public final LinearLayout llDownloadSetting;
    public final ProgressBar pbDownload;
    private final FrameLayout rootView;
    public final TextInputLayout tilSelectDate;
    public final TextInputLayout tilSelectDuration;
    public final TextInputLayout tilSelectStartTime;
    public final TextView tvDateError;
    public final TextView tvDownloadProgress;
    public final TextView tvDurationError;
    public final TextView tvInfoContent;
    public final TextView tvInfoTitle;
    public final MaterialAutoCompleteTextView tvSelectDate;
    public final MaterialAutoCompleteTextView tvSelectDuration;
    public final MaterialAutoCompleteTextView tvSelectStartTime;
    public final TextView tvStartTimeError;

    private DialogDownloadBinding(FrameLayout frameLayout, MaterialButton materialButton, MaterialButton materialButton2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, MaterialAutoCompleteTextView materialAutoCompleteTextView, MaterialAutoCompleteTextView materialAutoCompleteTextView2, MaterialAutoCompleteTextView materialAutoCompleteTextView3, TextView textView6) {
        this.rootView = frameLayout;
        this.btnCancel = materialButton;
        this.btnDownload = materialButton2;
        this.ivArrowDate = imageView;
        this.ivArrowDuration = imageView2;
        this.ivArrowStartTime = imageView3;
        this.ivDownloadInfo = imageView4;
        this.llDownloadInfo = linearLayout;
        this.llDownloadSetting = linearLayout2;
        this.pbDownload = progressBar;
        this.tilSelectDate = textInputLayout;
        this.tilSelectDuration = textInputLayout2;
        this.tilSelectStartTime = textInputLayout3;
        this.tvDateError = textView;
        this.tvDownloadProgress = textView2;
        this.tvDurationError = textView3;
        this.tvInfoContent = textView4;
        this.tvInfoTitle = textView5;
        this.tvSelectDate = materialAutoCompleteTextView;
        this.tvSelectDuration = materialAutoCompleteTextView2;
        this.tvSelectStartTime = materialAutoCompleteTextView3;
        this.tvStartTimeError = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_download, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogDownloadBinding bind(View view) {
        int i = R.id.btnCancel;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btnDownload;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton2 != null) {
                i = R.id.ivArrowDate;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.ivArrowDuration;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.ivArrowStartTime;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.ivDownloadInfo;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.llDownloadInfo;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.llDownloadSetting;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.pbDownload;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar != null) {
                                            i = R.id.tilSelectDate;
                                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                            if (textInputLayout != null) {
                                                i = R.id.tilSelectDuration;
                                                TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                if (textInputLayout2 != null) {
                                                    i = R.id.tilSelectStartTime;
                                                    TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                    if (textInputLayout3 != null) {
                                                        i = R.id.tvDateError;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.tvDownloadProgress;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tvDurationError;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tvInfoContent;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tvInfoTitle;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tvSelectDate;
                                                                            MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                            if (materialAutoCompleteTextView != null) {
                                                                                i = R.id.tvSelectDuration;
                                                                                MaterialAutoCompleteTextView materialAutoCompleteTextView2 = (MaterialAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                                if (materialAutoCompleteTextView2 != null) {
                                                                                    i = R.id.tvSelectStartTime;
                                                                                    MaterialAutoCompleteTextView materialAutoCompleteTextView3 = (MaterialAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (materialAutoCompleteTextView3 != null) {
                                                                                        i = R.id.tvStartTimeError;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            return new DialogDownloadBinding((FrameLayout) view, materialButton, materialButton2, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, progressBar, textInputLayout, textInputLayout2, textInputLayout3, textView, textView2, textView3, textView4, textView5, materialAutoCompleteTextView, materialAutoCompleteTextView2, materialAutoCompleteTextView3, textView6);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
