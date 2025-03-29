package ru.tattelecom.intercom.feature.leave_order;

import androidx.media3.extractor.ts.TsExtractor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.feature.leave_order.Event;

/* compiled from: LeaveOrderViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.leave_order.LeaveOrderViewModel$onLeaveOrder$1", f = "LeaveOrderViewModel.kt", i = {}, l = {116, 124, 126, TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LeaveOrderViewModel$onLeaveOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $phone;
    final /* synthetic */ List<Integer> $services;
    Object L$0;
    int label;
    final /* synthetic */ LeaveOrderViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LeaveOrderViewModel$onLeaveOrder$1(LeaveOrderViewModel leaveOrderViewModel, String str, String str2, List<Integer> list, Continuation<? super LeaveOrderViewModel$onLeaveOrder$1> continuation) {
        super(2, continuation);
        this.this$0 = leaveOrderViewModel;
        this.$name = str;
        this.$phone = str2;
        this.$services = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LeaveOrderViewModel$onLeaveOrder$1(this.this$0, this.$name, this.$phone, this.$services, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LeaveOrderViewModel$onLeaveOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (Exception unused) {
                this.L$0 = null;
                this.label = 4;
                if (this.this$0._events.send(Event.NavigateToErrorPage.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow3 = this.this$0._isLoading;
                mutableStateFlow3.setValue(Boxing.boxBoolean(true));
                UserInteractor userInteractor = this.this$0.userInteractor;
                LeaveOrderViewModel leaveOrderViewModel = this.this$0;
                String entityScreenString = leaveOrderViewModel.getEntityScreenString(leaveOrderViewModel.getPreviousPage());
                Long entityId = this.this$0.getEntityId();
                this.label = 1;
                obj = userInteractor.leaveOrder(this.$name, this.$phone, this.$services, entityScreenString, entityId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                    } else {
                        if (i != 3) {
                            if (i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            mutableStateFlow2 = this.this$0._isLoading;
                            mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                            return Unit.INSTANCE;
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow2 = this.this$0._isLoading;
                    mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            StatusResponse statusResponse = (StatusResponse) obj;
            if (statusResponse != null) {
                LeaveOrderViewModel leaveOrderViewModel2 = this.this$0;
                if (Intrinsics.areEqual(statusResponse.isSuccess(), Boxing.boxBoolean(true))) {
                    Channel channel = leaveOrderViewModel2._events;
                    Event.NavigateToSuccessPage navigateToSuccessPage = Event.NavigateToSuccessPage.INSTANCE;
                    this.L$0 = statusResponse;
                    this.label = 2;
                    if (channel.send(navigateToSuccessPage, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Channel channel2 = leaveOrderViewModel2._events;
                    Event.NavigateToErrorPage navigateToErrorPage = Event.NavigateToErrorPage.INSTANCE;
                    this.L$0 = statusResponse;
                    this.label = 3;
                    if (channel2.send(navigateToErrorPage, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            mutableStateFlow2 = this.this$0._isLoading;
            mutableStateFlow2.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableStateFlow = this.this$0._isLoading;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
            throw th;
        }
    }
}
