package ru.tattelecom.intercom.feature.office_map.main;

import android.content.Context;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.customview.ClickableMotionLayout;
import ru.tattelecom.intercom.feature.office_map.databinding.FragmentMapBinding;

/* compiled from: MapFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.office_map.main.MapFragment$provideUiChanges$1$4", f = "MapFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MapFragment$provideUiChanges$1$4 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MapFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MapFragment$provideUiChanges$1$4(MapFragment mapFragment, Continuation<? super MapFragment$provideUiChanges$1$4> continuation) {
        super(2, continuation);
        this.this$0 = mapFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MapFragment$provideUiChanges$1$4 mapFragment$provideUiChanges$1$4 = new MapFragment$provideUiChanges$1$4(this.this$0, continuation);
        mapFragment$provideUiChanges$1$4.L$0 = obj;
        return mapFragment$provideUiChanges$1$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((MapFragment$provideUiChanges$1$4) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentMapBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            binding = this.this$0.getBinding();
            ClickableMotionLayout clickableMotionLayout = binding.motionLayout;
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            Snackbar.make(clickableMotionLayout, StringResourceFinderKt.getMessageText(str, requireContext), -1).show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
