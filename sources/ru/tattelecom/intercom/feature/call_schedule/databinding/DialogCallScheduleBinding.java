package ru.tattelecom.intercom.feature.call_schedule.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import ru.tattelecom.intercom.android.resources.timerangepicker.TimeSliderRangePicker;
import ru.tattelecom.intercom.feature.call_schedule.R;

/* loaded from: classes6.dex */
public final class DialogCallScheduleBinding implements ViewBinding {
    public final ConstraintLayout bottomSheetNotificationSettings;
    public final ImageView btnReset;
    public final MaterialButton btnSave;
    public final ChipGroup cgDays;
    public final Chip chFriday;
    public final Chip chMonday;
    public final Chip chSaturday;
    public final Chip chSunday;
    public final Chip chThursday;
    public final Chip chTuesday;
    public final Chip chWednesday;
    public final HorizontalScrollView hsDays;
    public final ProgressBar pbSave;
    private final ConstraintLayout rootView;
    public final TimeSliderRangePicker timePicker;
    public final TextView tvFromTime;
    public final TextView tvFromTitle;
    public final TextView tvNotificationSettings;
    public final TextView tvToTime;
    public final TextView tvToTitle;

    private DialogCallScheduleBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, MaterialButton materialButton, ChipGroup chipGroup, Chip chip, Chip chip2, Chip chip3, Chip chip4, Chip chip5, Chip chip6, Chip chip7, HorizontalScrollView horizontalScrollView, ProgressBar progressBar, TimeSliderRangePicker timeSliderRangePicker, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.bottomSheetNotificationSettings = constraintLayout2;
        this.btnReset = imageView;
        this.btnSave = materialButton;
        this.cgDays = chipGroup;
        this.chFriday = chip;
        this.chMonday = chip2;
        this.chSaturday = chip3;
        this.chSunday = chip4;
        this.chThursday = chip5;
        this.chTuesday = chip6;
        this.chWednesday = chip7;
        this.hsDays = horizontalScrollView;
        this.pbSave = progressBar;
        this.timePicker = timeSliderRangePicker;
        this.tvFromTime = textView;
        this.tvFromTitle = textView2;
        this.tvNotificationSettings = textView3;
        this.tvToTime = textView4;
        this.tvToTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogCallScheduleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCallScheduleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_call_schedule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogCallScheduleBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.btn_reset;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_save;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.cg_days;
                ChipGroup chipGroup = (ChipGroup) ViewBindings.findChildViewById(view, i);
                if (chipGroup != null) {
                    i = R.id.ch_friday;
                    Chip chip = (Chip) ViewBindings.findChildViewById(view, i);
                    if (chip != null) {
                        i = R.id.ch_monday;
                        Chip chip2 = (Chip) ViewBindings.findChildViewById(view, i);
                        if (chip2 != null) {
                            i = R.id.ch_saturday;
                            Chip chip3 = (Chip) ViewBindings.findChildViewById(view, i);
                            if (chip3 != null) {
                                i = R.id.ch_sunday;
                                Chip chip4 = (Chip) ViewBindings.findChildViewById(view, i);
                                if (chip4 != null) {
                                    i = R.id.ch_thursday;
                                    Chip chip5 = (Chip) ViewBindings.findChildViewById(view, i);
                                    if (chip5 != null) {
                                        i = R.id.ch_tuesday;
                                        Chip chip6 = (Chip) ViewBindings.findChildViewById(view, i);
                                        if (chip6 != null) {
                                            i = R.id.ch_wednesday;
                                            Chip chip7 = (Chip) ViewBindings.findChildViewById(view, i);
                                            if (chip7 != null) {
                                                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.hs_days);
                                                i = R.id.pb_save;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                if (progressBar != null) {
                                                    i = R.id.time_picker;
                                                    TimeSliderRangePicker timeSliderRangePicker = (TimeSliderRangePicker) ViewBindings.findChildViewById(view, i);
                                                    if (timeSliderRangePicker != null) {
                                                        i = R.id.tv_from_time;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.tv_from_title;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_notification_settings;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_to_time;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_to_title;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            return new DialogCallScheduleBinding(constraintLayout, constraintLayout, imageView, materialButton, chipGroup, chip, chip2, chip3, chip4, chip5, chip6, chip7, horizontalScrollView, progressBar, timeSliderRangePicker, textView, textView2, textView3, textView4, textView5);
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
