package ru.tattelecom.intercom.android.resources;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.DynamicDrawableSpan;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u001a\f\u0010\u000e\u001a\u00020\u0007*\u00020\u000fH\u0007\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007\u001a\u0012\u0010\u0014\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007\u001a1\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0000\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00170\u00162\u0006\u0010\u0018\u001a\u0002H\u00172\u0006\u0010\u0019\u001a\u0002H\u0017¢\u0006\u0002\u0010\u001a\u001a#\u0010\u001b\u001a\u00020\u0011*\u00020\u000f2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00110\u001d¢\u0006\u0002\b\u001f\u001a\n\u0010 \u001a\u00020\u0011*\u00020\u000f\u001a\u0014\u0010!\u001a\u00020\u0011*\u00020\"2\b\b\u0002\u0010#\u001a\u00020$\u001a\u001a\u0010%\u001a\u00020\u0011*\u00020\u00122\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0004\u001a\n\u0010(\u001a\u00020\u0011*\u00020\u0012\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006)"}, d2 = {"dp", "", "getDp", "(F)F", "", "(I)I", "format", "", "Ljava/util/Date;", "pattern", "timeZone", "Ljava/util/TimeZone;", "locale", "Ljava/util/Locale;", "getDeviceCode", "Landroidx/fragment/app/Fragment;", "hideProgress", "", "Lcom/google/android/material/button/MaterialButton;", "buttonText", "hideProgressAllCaps", "mapButReplace", "", ExifInterface.GPS_DIRECTION_TRUE, "targetItem", "newItem", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "registerOnBackPressedCallback", "onBackPressed", "Lkotlin/Function1;", "Landroidx/activity/OnBackPressedCallback;", "Lkotlin/ExtensionFunctionType;", "setExitAppActionForBackPressedCallback", "setExpandedState", "Landroid/app/Dialog;", "isDraggable", "", "setProgress", "isLoading", "textId", "showProgress", "android-resources_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExtensionsKt {
    public static final void setExitAppActionForBackPressedCallback(final Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        OnBackPressedDispatcher onBackPressedDispatcher = fragment.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, new OnBackPressedCallback() { // from class: ru.tattelecom.intercom.android.resources.ExtensionsKt$setExitAppActionForBackPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                Fragment.this.requireActivity().finish();
            }
        });
    }

    public static final void registerOnBackPressedCallback(Fragment fragment, final Function1<? super OnBackPressedCallback, Unit> onBackPressed) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        OnBackPressedDispatcher onBackPressedDispatcher = fragment.requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, fragment, false, new Function1<OnBackPressedCallback, Unit>() { // from class: ru.tattelecom.intercom.android.resources.ExtensionsKt$registerOnBackPressedCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                onBackPressed.invoke(addCallback);
            }
        }, 2, null);
    }

    public static final int getDp(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static final float getDp(float f) {
        return f * Resources.getSystem().getDisplayMetrics().density;
    }

    public static /* synthetic */ void setExpandedState$default(Dialog dialog, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        setExpandedState(dialog, z);
    }

    public static final void setExpandedState(Dialog dialog, final boolean z) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        View findViewById = ((BottomSheetDialog) dialog).findViewById(R.id.design_bottom_sheet);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        final BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) findViewById);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: ru.tattelecom.intercom.android.resources.ExtensionsKt$setExpandedState$behavior$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 4) {
                    from.setState(5);
                }
                if (z || newState != 1) {
                    return;
                }
                from.setState(3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(from, "apply(...)");
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ru.tattelecom.intercom.android.resources.ExtensionsKt$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ExtensionsKt.setExpandedState$lambda$1(BottomSheetBehavior.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setExpandedState$lambda$1(BottomSheetBehavior behavior, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(behavior, "$behavior");
        behavior.setState(3);
    }

    public static final void showProgress(final MaterialButton materialButton) {
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        materialButton.setEnabled(false);
        final CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(materialButton.getContext());
        circularProgressDrawable.setStyle(0);
        circularProgressDrawable.setColorSchemeColors(materialButton.getTextColors().getDefaultColor());
        int centerRadius = (int) (circularProgressDrawable.getCenterRadius() + circularProgressDrawable.getStrokeWidth());
        circularProgressDrawable.setBounds(0, 0, centerRadius, centerRadius);
        DynamicDrawableSpan dynamicDrawableSpan = new DynamicDrawableSpan() { // from class: ru.tattelecom.intercom.android.resources.ExtensionsKt$showProgress$drawableSpan$1
            @Override // android.text.style.DynamicDrawableSpan
            public CircularProgressDrawable getDrawable() {
                return CircularProgressDrawable.this;
            }
        };
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(dynamicDrawableSpan, spannableString.length() - 1, spannableString.length(), 33);
        circularProgressDrawable.start();
        circularProgressDrawable.setCallback(new Drawable.Callback() { // from class: ru.tattelecom.intercom.android.resources.ExtensionsKt$showProgress$1$1
            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable who, Runnable what, long when) {
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable who, Runnable what) {
                Intrinsics.checkNotNullParameter(who, "who");
                Intrinsics.checkNotNullParameter(what, "what");
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable who) {
                Intrinsics.checkNotNullParameter(who, "who");
                MaterialButton.this.invalidate();
            }
        });
        materialButton.setAllCaps(false);
        materialButton.setText(spannableString);
    }

    public static final void hideProgressAllCaps(MaterialButton materialButton, String buttonText) {
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        materialButton.setEnabled(true);
        materialButton.setText(buttonText);
    }

    public static final void hideProgress(MaterialButton materialButton, String buttonText) {
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        materialButton.setEnabled(true);
        materialButton.setText(buttonText);
    }

    public static final void setProgress(MaterialButton materialButton, boolean z, int i) {
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        if (z) {
            showProgress(materialButton);
            return;
        }
        String string = materialButton.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        hideProgressAllCaps(materialButton, string);
    }

    public static /* synthetic */ String format$default(Date date, String str, TimeZone timeZone, Locale locale, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
        }
        if ((i & 4) != 0) {
            locale = new Locale("ru", "RU");
        }
        return format(date, str, timeZone, locale);
    }

    public static final String format(Date date, String pattern, TimeZone timeZone, Locale locale) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(locale, "locale");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final <T> List<T> mapButReplace(List<? extends T> list, T t, T t2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t3 : list2) {
            if (Intrinsics.areEqual(t3, t)) {
                t3 = t2;
            }
            arrayList.add(t3);
        }
        return arrayList;
    }

    public static final String getDeviceCode(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        String string = activity != null ? Settings.Secure.getString(activity.getContentResolver(), "android_id") : null;
        return string == null ? "" : string;
    }
}
