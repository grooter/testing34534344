package ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode;

import android.content.Context;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragmentKt;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel;

/* compiled from: ScanQRCodeFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/familyaccess/addaddress/scanqrcode/ScanQRCodeViewModel$Event;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment$provideUiChanges$1$1", f = "ScanQRCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class ScanQRCodeFragment$provideUiChanges$1$1 extends SuspendLambda implements Function2<ScanQRCodeViewModel.Event, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScanQRCodeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScanQRCodeFragment$provideUiChanges$1$1(ScanQRCodeFragment scanQRCodeFragment, Continuation<? super ScanQRCodeFragment$provideUiChanges$1$1> continuation) {
        super(2, continuation);
        this.this$0 = scanQRCodeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScanQRCodeFragment$provideUiChanges$1$1 scanQRCodeFragment$provideUiChanges$1$1 = new ScanQRCodeFragment$provideUiChanges$1$1(this.this$0, continuation);
        scanQRCodeFragment$provideUiChanges$1$1.L$0 = obj;
        return scanQRCodeFragment$provideUiChanges$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScanQRCodeViewModel.Event event, Continuation<? super Unit> continuation) {
        return ((ScanQRCodeFragment$provideUiChanges$1$1) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ScanQRCodeViewModel.Event event = (ScanQRCodeViewModel.Event) this.L$0;
        if (Intrinsics.areEqual(event, ScanQRCodeViewModel.Event.NavigateToErrorPage.INSTANCE)) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this.this$0), NavGraphDestinations.Action.INSTANCE.getToRequestState(), BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "error")), null, 4, null);
        } else if (Intrinsics.areEqual(event, ScanQRCodeViewModel.Event.NavigateToSuccessPage.INSTANCE)) {
            NavExtKt.navigateSafe(FragmentKt.findNavController(this.this$0), NavGraphDestinations.Action.INSTANCE.getToRequestState(), BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "success"), TuplesKt.to("title", this.this$0.getString(R.string.address_added_title)), TuplesKt.to("message", this.this$0.getString(R.string.address_added_message))), NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), NavGraphDestinations.Dest.INSTANCE.getAddAddress(), true, false, 4, (Object) null).build());
        } else if (event instanceof ScanQRCodeViewModel.Event.ShowMessage) {
            Context requireContext = this.this$0.requireContext();
            String message = ((ScanQRCodeViewModel.Event.ShowMessage) event).getMessage();
            Context requireContext2 = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        }
        return Unit.INSTANCE;
    }
}
