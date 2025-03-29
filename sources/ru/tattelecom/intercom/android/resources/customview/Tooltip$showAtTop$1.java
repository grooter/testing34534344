package ru.tattelecom.intercom.android.resources.customview;

import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.android.resources.customview.Tooltip$showAtTop$1", f = "Tooltip.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class Tooltip$showAtTop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $xOffset;
    final /* synthetic */ int $yOffset;
    int label;
    final /* synthetic */ Tooltip this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Tooltip$showAtTop$1(Tooltip tooltip, int i, int i2, Continuation<? super Tooltip$showAtTop$1> continuation) {
        super(2, continuation);
        this.this$0 = tooltip;
        this.$xOffset = i;
        this.$yOffset = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Tooltip$showAtTop$1(this.this$0, this.$xOffset, this.$yOffset, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Tooltip$showAtTop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        View view;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        View view2;
        View view3;
        PopupWindow popupWindow3;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!this.this$0.isShowing()) {
            view = this.this$0.mAnchorView;
            Intrinsics.checkNotNull(view);
            if (view.isShown()) {
                popupWindow = this.this$0.mPopupWindow;
                Intrinsics.checkNotNull(popupWindow);
                popupWindow.getContentView().measure(-2, -2);
                popupWindow2 = this.this$0.mPopupWindow;
                Intrinsics.checkNotNull(popupWindow2);
                view2 = this.this$0.mAnchorView;
                int i3 = this.$xOffset;
                int i4 = this.$yOffset;
                view3 = this.this$0.mAnchorView;
                Intrinsics.checkNotNull(view3);
                int measuredHeight = i4 - view3.getMeasuredHeight();
                popupWindow3 = this.this$0.mPopupWindow;
                Intrinsics.checkNotNull(popupWindow3);
                int measuredHeight2 = measuredHeight - popupWindow3.getContentView().getMeasuredHeight();
                i = this.this$0.mGravity;
                popupWindow2.showAsDropDown(view2, i3, measuredHeight2, i | 48);
            } else {
                Log.e("TOOLTIP_INFO", "Tooltip cannot be shown, root view is invalid or has been closed");
            }
        }
        return Unit.INSTANCE;
    }
}
