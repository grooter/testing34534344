package ru.tattelecom.intercom.feature.player.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import ru.tattelecom.intercom.feature.player.R;

/* loaded from: classes7.dex */
public final class FragmentVideoDownloadBinding implements ViewBinding {
    public final MaterialButton btnClose;
    public final MaterialButton btnDownload;
    public final ImageView ivArrowDate;
    public final ImageView ivArrowDuration;
    public final ImageView ivArrowTime;
    public final ImageView ivDownloadSuccessful;
    public final LinearLayout llDownloadInfo;
    public final LinearLayout llDownloadSetting;
    private final NestedScrollView rootView;
    public final TextInputLayout tilSelectDate;
    public final TextInputLayout tilSelectDuration;
    public final TextInputLayout tilSelectTime;
    public final TextView tvDateError;
    public final TextView tvDurationError;
    public final TextView tvInfoContent;
    public final TextView tvInfoTitle;
    public final MaterialAutoCompleteTextView tvSelectDate;
    public final MaterialAutoCompleteTextView tvSelectDuration;
    public final MaterialAutoCompleteTextView tvSelectTime;
    public final TextView tvTimeError;

    private FragmentVideoDownloadBinding(NestedScrollView nestedScrollView, MaterialButton materialButton, MaterialButton materialButton2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, MaterialAutoCompleteTextView materialAutoCompleteTextView, MaterialAutoCompleteTextView materialAutoCompleteTextView2, MaterialAutoCompleteTextView materialAutoCompleteTextView3, TextView textView5) {
        this.rootView = nestedScrollView;
        this.btnClose = materialButton;
        this.btnDownload = materialButton2;
        this.ivArrowDate = imageView;
        this.ivArrowDuration = imageView2;
        this.ivArrowTime = imageView3;
        this.ivDownloadSuccessful = imageView4;
        this.llDownloadInfo = linearLayout;
        this.llDownloadSetting = linearLayout2;
        this.tilSelectDate = textInputLayout;
        this.tilSelectDuration = textInputLayout2;
        this.tilSelectTime = textInputLayout3;
        this.tvDateError = textView;
        this.tvDurationError = textView2;
        this.tvInfoContent = textView3;
        this.tvInfoTitle = textView4;
        this.tvSelectDate = materialAutoCompleteTextView;
        this.tvSelectDuration = materialAutoCompleteTextView2;
        this.tvSelectTime = materialAutoCompleteTextView3;
        this.tvTimeError = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentVideoDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVideoDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_video_download, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentVideoDownloadBinding bind(View view) {
        int i = R.id.btnClose;
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
                        i = R.id.ivArrowTime;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.ivDownloadSuccessful;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.llDownloadInfo;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.llDownloadSetting;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.tilSelectDate;
                                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                        if (textInputLayout != null) {
                                            i = R.id.tilSelectDuration;
                                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                            if (textInputLayout2 != null) {
                                                i = R.id.tilSelectTime;
                                                TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                if (textInputLayout3 != null) {
                                                    i = R.id.tvDateError;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        i = R.id.tvDurationError;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.tvInfoContent;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R.id.tvInfoTitle;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.tvSelectDate;
                                                                    MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                    if (materialAutoCompleteTextView != null) {
                                                                        i = R.id.tvSelectDuration;
                                                                        MaterialAutoCompleteTextView materialAutoCompleteTextView2 = (MaterialAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                        if (materialAutoCompleteTextView2 != null) {
                                                                            i = R.id.tvSelectTime;
                                                                            MaterialAutoCompleteTextView materialAutoCompleteTextView3 = (MaterialAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                            if (materialAutoCompleteTextView3 != null) {
                                                                                i = R.id.tvTimeError;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    return new FragmentVideoDownloadBinding((NestedScrollView) view, materialButton, materialButton2, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, textInputLayout, textInputLayout2, textInputLayout3, textView, textView2, textView3, textView4, materialAutoCompleteTextView, materialAutoCompleteTextView2, materialAutoCompleteTextView3, textView5);
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
