package ru.tattelecom.intercom.feature.office_map.main;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.fragment.FragmentKt;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.Marker;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.office_map.R;
import ru.tattelecom.intercom.feature.office_map.databinding.FragmentHuaweiMapBinding;

/* compiled from: HuaweiMapFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$provideUiChanges$1$3", f = "HuaweiMapFragment.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class HuaweiMapFragment$provideUiChanges$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HuaweiMapFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HuaweiMapFragment$provideUiChanges$1$3(HuaweiMapFragment huaweiMapFragment, Continuation<? super HuaweiMapFragment$provideUiChanges$1$3> continuation) {
        super(2, continuation);
        this.this$0 = huaweiMapFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HuaweiMapFragment$provideUiChanges$1$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HuaweiMapFragment$provideUiChanges$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MapViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            Flow<Boolean> eventOpenFilterPage = viewModel.getEventOpenFilterPage();
            final HuaweiMapFragment huaweiMapFragment = this.this$0;
            this.label = 1;
            if (eventOpenFilterPage.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$provideUiChanges$1$3.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    FragmentHuaweiMapBinding binding;
                    MapViewModel viewModel2;
                    MapViewModel viewModel3;
                    T t;
                    MapViewModel viewModel4;
                    BitmapDescriptor bitmapDescriptorFromVector;
                    MapViewModel viewModel5;
                    FragmentHuaweiMapBinding binding2;
                    if (z) {
                        binding = HuaweiMapFragment.this.getBinding();
                        ConstraintLayout bottomSheet = binding.bottomSheet;
                        Intrinsics.checkNotNullExpressionValue(bottomSheet, "bottomSheet");
                        if (bottomSheet.getVisibility() == 0) {
                            binding2 = HuaweiMapFragment.this.getBinding();
                            ConstraintLayout bottomSheet2 = binding2.bottomSheet;
                            Intrinsics.checkNotNullExpressionValue(bottomSheet2, "bottomSheet");
                            bottomSheet2.setVisibility(8);
                        }
                        viewModel2 = HuaweiMapFragment.this.getViewModel();
                        if (viewModel2.getCurrentSelectedMarker() != null) {
                            viewModel3 = HuaweiMapFragment.this.getViewModel();
                            List<Marker> huaweiMarkers = viewModel3.getHuaweiMarkers();
                            HuaweiMapFragment huaweiMapFragment2 = HuaweiMapFragment.this;
                            Iterator<T> it = huaweiMarkers.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    t = (T) null;
                                    break;
                                }
                                t = it.next();
                                Marker marker = (Marker) t;
                                Object tag = marker != null ? marker.getTag() : null;
                                viewModel5 = huaweiMapFragment2.getViewModel();
                                if (Intrinsics.areEqual(tag, viewModel5.getCurrentSelectedMarker())) {
                                    break;
                                }
                            }
                            Marker marker2 = t;
                            if (marker2 != null) {
                                HuaweiMapFragment huaweiMapFragment3 = HuaweiMapFragment.this;
                                Context requireContext = huaweiMapFragment3.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                                bitmapDescriptorFromVector = huaweiMapFragment3.bitmapDescriptorFromVector(requireContext, R.drawable.ic_point_default);
                                marker2.setIcon(bitmapDescriptorFromVector);
                            }
                            viewModel4 = HuaweiMapFragment.this.getViewModel();
                            viewModel4.setCurrentSelectedMarker(null);
                        }
                        NavExtKt.navigateSafe$default(FragmentKt.findNavController(HuaweiMapFragment.this), NavGraphDestinations.Action.INSTANCE.getToOfficeMapFilter(), null, null, 6, null);
                    }
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
        return Unit.INSTANCE;
    }
}
