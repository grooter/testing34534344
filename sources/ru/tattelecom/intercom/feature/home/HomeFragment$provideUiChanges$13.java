package ru.tattelecom.intercom.feature.home;

import androidx.core.os.BundleKt;
import androidx.navigation.fragment.FragmentKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.home.model.OpenStreamEvent;

/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$13", f = "HomeFragment.kt", i = {}, l = {580}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeFragment$provideUiChanges$13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$provideUiChanges$13(HomeFragment homeFragment, Continuation<? super HomeFragment$provideUiChanges$13> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$provideUiChanges$13(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$provideUiChanges$13) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HomeViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            SharedFlow<OpenStreamEvent> eventOpenStream = viewModel.getEventOpenStream();
            final HomeFragment homeFragment = this.this$0;
            this.label = 1;
            if (eventOpenStream.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$13.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((OpenStreamEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(OpenStreamEvent openStreamEvent, Continuation<? super Unit> continuation) {
                    NavExtKt.navigateSafe$default(FragmentKt.findNavController(HomeFragment.this), NavGraphDestinations.Action.INSTANCE.getToVideoPlayer(), BundleKt.bundleOf(TuplesKt.to("streamId", Boxing.boxInt(openStreamEvent.getStreamId())), TuplesKt.to("buildingServices", openStreamEvent.getBuildingServices()), TuplesKt.to("streamDescription", openStreamEvent.getStreamDescription()), TuplesKt.to("isFavorite", Boxing.boxBoolean(openStreamEvent.isFavorite())), TuplesKt.to("leaveOrderDestination", Boxing.boxInt(NavGraphDestinations.Action.INSTANCE.getToConnectServices())), TuplesKt.to("videoPlayerDestination", Boxing.boxInt(NavGraphDestinations.Dest.INSTANCE.getVideoPlayer())), TuplesKt.to("cameraUrl", openStreamEvent.getCameraUrl()), TuplesKt.to("videoUrl", openStreamEvent.getIntercomVideoUrl()), TuplesKt.to("gateId", openStreamEvent.getGateId()), TuplesKt.to("isFlussonic", openStreamEvent.isFlussonic()), TuplesKt.to("cameraLiveSource", openStreamEvent.getCameraLiveSource()), TuplesKt.to("cameraArchiveSource", openStreamEvent.getCameraArchiveSource()), TuplesKt.to("cameraExportSource", openStreamEvent.getCameraExportSource())), null, 4, null);
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
