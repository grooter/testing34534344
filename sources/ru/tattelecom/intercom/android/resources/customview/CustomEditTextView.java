package ru.tattelecom.intercom.android.resources.customview;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomEditTextView.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000eH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J&\u0010\u0011\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013J0\u0010\u0011\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J+\u0010\u001d\u001a\u00020\r2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\r0\u000eH\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/CustomEditTextView;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "originalLeftPadding", "", "rightDrawables", "afterTextChanged", "", "Lkotlin/Function1;", "", "calculatePrefix", "makeClearableEditText", "onIsNotEmpty", "Lkotlin/Function0;", "onCanceled", "clearDrawable", "Landroid/graphics/drawable/Drawable;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRightDrawableClicked", "onClicked", "Landroid/widget/EditText;", "Lkotlin/ParameterName;", "name", "view", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomEditTextView extends AppCompatEditText {
    private float originalLeftPadding;
    private final int rightDrawables;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomEditTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomEditTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomEditTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.originalLeftPadding = -1.0f;
        this.rightDrawables = 2;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        calculatePrefix();
    }

    private final void calculatePrefix() {
        if (this.originalLeftPadding != -1.0f || getTag() == null) {
            return;
        }
        Object tag = getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
        String str = (String) tag;
        int length = str.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(str, fArr);
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i];
        }
        float compoundPaddingLeft = getCompoundPaddingLeft();
        this.originalLeftPadding = compoundPaddingLeft;
        setPadding((int) (f + compoundPaddingLeft), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (getTag() != null) {
            Object tag = getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            TextPaint paint = getPaint();
            paint.setColor(ContextCompat.getColor(getContext(), ru.tattelecom.intercom.android.resources.R.color.primary));
            canvas.drawText((String) tag, this.originalLeftPadding, getLineBounds(0, null), paint);
        }
    }

    private final void afterTextChanged(final Function1<? super String, Unit> afterTextChanged) {
        addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.android.resources.customview.CustomEditTextView$afterTextChanged$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                afterTextChanged.invoke(String.valueOf(editable));
            }
        });
    }

    private final void makeClearableEditText(final Function0<Unit> onIsNotEmpty, final Function0<Unit> onCanceled, final Drawable clearDrawable) {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: ru.tattelecom.intercom.android.resources.customview.CustomEditTextView$makeClearableEditText$updateRightDrawable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CustomEditTextView customEditTextView = CustomEditTextView.this;
                Editable text = customEditTextView.getText();
                customEditTextView.setCompoundDrawables(null, null, (text == null || text.length() == 0) ? null : clearDrawable, null);
            }
        };
        function0.invoke();
        afterTextChanged(new Function1<String, Unit>() { // from class: ru.tattelecom.intercom.android.resources.customview.CustomEditTextView$makeClearableEditText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Function0<Unit> function02;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.length() > 0 && (function02 = onIsNotEmpty) != null) {
                    function02.invoke();
                }
                function0.invoke();
            }
        });
        onRightDrawableClicked(new Function1<EditText, Unit>() { // from class: ru.tattelecom.intercom.android.resources.customview.CustomEditTextView$makeClearableEditText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditText editText) {
                invoke2(editText);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EditText it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Editable text = CustomEditTextView.this.getText();
                if (text != null) {
                    text.clear();
                }
                CustomEditTextView.this.setCompoundDrawables(null, null, null, null);
                Function0<Unit> function02 = onCanceled;
                if (function02 != null) {
                    function02.invoke();
                }
                CustomEditTextView.this.requestFocus();
            }
        });
    }

    public final void makeClearableEditText(Function0<Unit> onIsNotEmpty, Function0<Unit> onCanceled) {
        Drawable drawable = getCompoundDrawables()[this.rightDrawables];
        if (drawable != null) {
            makeClearableEditText(onIsNotEmpty, onCanceled, drawable);
        }
    }

    public final void onRightDrawableClicked(final Function1<? super EditText, Unit> onClicked) {
        Intrinsics.checkNotNullParameter(onClicked, "onClicked");
        setOnTouchListener(new View.OnTouchListener() { // from class: ru.tattelecom.intercom.android.resources.customview.CustomEditTextView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onRightDrawableClicked$lambda$1;
                onRightDrawableClicked$lambda$1 = CustomEditTextView.onRightDrawableClicked$lambda$1(CustomEditTextView.this, onClicked, view, motionEvent);
                return onRightDrawableClicked$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onRightDrawableClicked$lambda$1(CustomEditTextView this$0, Function1 onClicked, View view, MotionEvent motionEvent) {
        Drawable drawable;
        Drawable drawable2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onClicked, "$onClicked");
        boolean z = false;
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (motionEvent.getX() >= editText.getWidth() - editText.getTotalPaddingRight() && motionEvent.getX() <= editText.getWidth() - editText.getPaddingRight() && motionEvent.getY() <= editText.getHeight() - editText.getTotalPaddingTop() && motionEvent.getY() >= editText.getTotalPaddingTop()) {
                if (motionEvent.getAction() == 0 && (drawable2 = this$0.getCompoundDrawables()[this$0.rightDrawables]) != null) {
                    drawable2.setAlpha(100);
                }
                if (motionEvent.getAction() == 1) {
                    Drawable drawable3 = this$0.getCompoundDrawables()[this$0.rightDrawables];
                    if (drawable3 != null) {
                        drawable3.setAlpha(255);
                    }
                    onClicked.invoke(this$0);
                }
                z = true;
            }
            if (motionEvent.getAction() == 1 && (drawable = this$0.getCompoundDrawables()[this$0.rightDrawables]) != null) {
                drawable.setAlpha(255);
            }
        }
        return z;
    }
}
