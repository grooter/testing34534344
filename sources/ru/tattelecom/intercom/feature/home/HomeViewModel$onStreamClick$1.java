package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import ru.tattelecom.intercom.feature.home.model.OpenStreamEvent;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$onStreamClick$1", f = "HomeViewModel.kt", i = {}, l = {351, 348}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$onStreamClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isIntercom;
    final /* synthetic */ HomeStream $stream;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$onStreamClick$1(HomeViewModel homeViewModel, HomeStream homeStream, boolean z, Continuation<? super HomeViewModel$onStreamClick$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$stream = homeStream;
        this.$isIntercom = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$onStreamClick$1(this.this$0, this.$stream, this.$isIntercom, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$onStreamClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        Object buildingServices;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableSharedFlow = this.this$0._eventOpenStream;
            int id = this.$stream.getId();
            this.L$0 = mutableSharedFlow;
            this.I$0 = id;
            this.label = 1;
            buildingServices = this.this$0.getBuildingServices(this.$stream.getBuildingId(), this);
            if (buildingServices == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = id;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            int i3 = this.I$0;
            MutableSharedFlow mutableSharedFlow2 = (MutableSharedFlow) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            mutableSharedFlow = mutableSharedFlow2;
            buildingServices = obj;
        }
        Pair pair = (Pair) buildingServices;
        String gateName = this.$stream.getGateName();
        boolean isFavorite = this.$stream.isFavorite();
        String url = this.$stream.getUrl();
        if (url == null) {
            url = "Undefined";
        }
        String str = url;
        String url2 = this.$isIntercom ? this.$stream.getUrl() : null;
        Integer gateId = this.$isIntercom ? this.$stream.getGateId() : null;
        Boolean boxBoolean = !this.$isIntercom ? Boxing.boxBoolean(this.$stream.isFlussonic()) : null;
        String url3 = !this.$isIntercom ? this.$stream.getUrl() : null;
        String archive = !this.$isIntercom ? this.$stream.getArchive() : null;
        String archiveExport = !this.$isIntercom ? this.$stream.getArchiveExport() : null;
        this.L$0 = null;
        this.label = 2;
        if (mutableSharedFlow.emit(new OpenStreamEvent(i, pair, gateName, isFavorite, str, url2, gateId, boxBoolean, url3, archive, archiveExport), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
