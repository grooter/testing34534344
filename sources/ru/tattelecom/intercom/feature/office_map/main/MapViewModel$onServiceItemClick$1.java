package ru.tattelecom.intercom.feature.office_map.main;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* compiled from: MapViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.office_map.main.MapViewModel$onServiceItemClick$1", f = "MapViewModel.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MapViewModel$onServiceItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfficeService $officeService;
    int label;
    final /* synthetic */ MapViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MapViewModel$onServiceItemClick$1(OfficeService officeService, MapViewModel mapViewModel, Continuation<? super MapViewModel$onServiceItemClick$1> continuation) {
        super(2, continuation);
        this.$officeService = officeService;
        this.this$0 = mapViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapViewModel$onServiceItemClick$1(this.$officeService, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapViewModel$onServiceItemClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$officeService.getId() == -2) {
                channel = this.this$0._eventOpenFilterPage;
                this.label = 1;
                if (channel.send(Boxing.boxBoolean(true), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.this$0.updateServicesList(this.$officeService.getName());
                this.this$0.updateOfficesList();
                MapViewModel mapViewModel = this.this$0;
                mapViewModel.updateFirstItem(mapViewModel.getFilters().size());
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
