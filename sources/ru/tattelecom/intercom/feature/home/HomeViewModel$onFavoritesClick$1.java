package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.apache.commons.compress.archivers.zip.UnixStat;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$onFavoritesClick$1", f = "HomeViewModel.kt", i = {}, l = {418, UnixStat.DEFAULT_FILE_PERM, 425, 427, 432}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$onFavoritesClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeStream $stream;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$onFavoritesClick$1(HomeStream homeStream, HomeViewModel homeViewModel, Continuation<? super HomeViewModel$onFavoritesClick$1> continuation) {
        super(2, continuation);
        this.$stream = homeStream;
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$onFavoritesClick$1(this.$stream, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$onFavoritesClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c6 -> B:16:0x00c9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        GateInteractor gateInteractor;
        GateInteractor gateInteractor2;
        UserInteractor userInteractor;
        UserInteractor userInteractor2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 5;
        i2 = 5;
        i2 = 5;
        i2 = 5;
        i2 = 5;
        i2 = 5;
        i2 = 5;
        try {
        } catch (Exception unused) {
            channel = this.this$0._eventShowMessage;
            this.label = i2;
            i2 = "something_went_wrong";
            if (channel.send("something_went_wrong", this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$stream.getType() == 2 && !this.$stream.isIntercom()) {
                if (this.$stream.isFavorite()) {
                    userInteractor2 = this.this$0.userInteractor;
                    this.label = 1;
                    if (userInteractor2.removeStreamFromFavorites(this.$stream.getUrl(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    userInteractor = this.this$0.userInteractor;
                    this.label = 2;
                    if (userInteractor.addStreamToFavorites(this.$stream.getUrl(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                Integer gateId = this.$stream.getGateId();
                if (gateId != null) {
                    HomeStream homeStream = this.$stream;
                    HomeViewModel homeViewModel = this.this$0;
                    gateId.intValue();
                    if (homeStream.isFavorite()) {
                        gateInteractor2 = homeViewModel.gateInteractor;
                        int intValue = homeStream.getGateId().intValue();
                        this.label = 3;
                        if (gateInteractor2.removeFromFavorites(intValue, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        gateInteractor = homeViewModel.gateInteractor;
                        int intValue2 = homeStream.getGateId().intValue();
                        this.label = 4;
                        if (gateInteractor.addToFavorites(intValue2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
        } else {
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
