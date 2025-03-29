package ru.tattelecom.intercom.feature.leave_order;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.navigation.NavOptions;
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
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.leave_order.Event;

/* compiled from: LeaveOrderFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/leave_order/Event;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$provideUiChanges$1$5", f = "LeaveOrderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LeaveOrderFragment$provideUiChanges$1$5 extends SuspendLambda implements Function2<Event, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LeaveOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LeaveOrderFragment$provideUiChanges$1$5(LeaveOrderFragment leaveOrderFragment, Continuation<? super LeaveOrderFragment$provideUiChanges$1$5> continuation) {
        super(2, continuation);
        this.this$0 = leaveOrderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LeaveOrderFragment$provideUiChanges$1$5 leaveOrderFragment$provideUiChanges$1$5 = new LeaveOrderFragment$provideUiChanges$1$5(this.this$0, continuation);
        leaveOrderFragment$provideUiChanges$1$5.L$0 = obj;
        return leaveOrderFragment$provideUiChanges$1$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Event event, Continuation<? super Unit> continuation) {
        return ((LeaveOrderFragment$provideUiChanges$1$5) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LeaveOrderViewModel viewModel;
        LeaveOrderViewModel viewModel2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Event event = (Event) this.L$0;
        if (Intrinsics.areEqual(event, Event.NavigateToErrorPage.INSTANCE)) {
            LeaveOrderFragment leaveOrderFragment = this.this$0;
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "error"));
            viewModel2 = this.this$0.getViewModel();
            Integer previousPage = viewModel2.getPreviousPage();
            LeaveOrderFragment.navigateToRequestState$default(leaveOrderFragment, bundleOf, previousPage == null || previousPage.intValue() != NavGraphDestinations.Dest.INSTANCE.getPlayer(), null, 4, null);
        } else if (Intrinsics.areEqual(event, Event.NavigateToSuccessPage.INSTANCE)) {
            LeaveOrderFragment leaveOrderFragment2 = this.this$0;
            Bundle bundleOf2 = BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "success"), TuplesKt.to("title", this.this$0.getString(R.string.leave_order_title)), TuplesKt.to("message", this.this$0.getString(R.string.leave_order_message)));
            viewModel = this.this$0.getViewModel();
            Integer previousPage2 = viewModel.getPreviousPage();
            leaveOrderFragment2.navigateToRequestState(bundleOf2, previousPage2 == null || previousPage2.intValue() != NavGraphDestinations.Dest.INSTANCE.getPlayer(), NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), NavGraphDestinations.Dest.INSTANCE.getConnectServices(), true, false, 4, (Object) null).build());
        } else if (event instanceof Event.ShowMessage) {
            Context requireContext = this.this$0.requireContext();
            String message = ((Event.ShowMessage) event).getMessage();
            Context requireContext2 = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        }
        return Unit.INSTANCE;
    }
}
