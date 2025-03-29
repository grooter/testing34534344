package ru.tattelecom.intercom.feature.office_map.main;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.Marker;
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
import ru.tattelecom.intercom.feature.office_map.R;
import ru.tattelecom.intercom.feature.office_map.databinding.FragmentMapBinding;
import ru.tattelecom.intercom.feature.office_map.filter.FilterFragment;

/* compiled from: MapFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.office_map.main.MapFragment$provideUiChanges$1$3", f = "MapFragment.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MapFragment$provideUiChanges$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MapFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MapFragment$provideUiChanges$1$3(MapFragment mapFragment, Continuation<? super MapFragment$provideUiChanges$1$3> continuation) {
        super(2, continuation);
        this.this$0 = mapFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapFragment$provideUiChanges$1$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapFragment$provideUiChanges$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final MapFragment mapFragment = this.this$0;
            this.label = 1;
            if (eventOpenFilterPage.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.office_map.main.MapFragment$provideUiChanges$1$3.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    FragmentMapBinding binding;
                    MapViewModel viewModel2;
                    MapViewModel viewModel3;
                    T t;
                    MapViewModel viewModel4;
                    BitmapDescriptor bitmapDescriptorFromVector;
                    MapViewModel viewModel5;
                    FragmentMapBinding binding2;
                    if (z) {
                        binding = MapFragment.this.getBinding();
                        ConstraintLayout bottomSheet = binding.bottomSheet;
                        Intrinsics.checkNotNullExpressionValue(bottomSheet, "bottomSheet");
                        if (bottomSheet.getVisibility() == 0) {
                            binding2 = MapFragment.this.getBinding();
                            ConstraintLayout bottomSheet2 = binding2.bottomSheet;
                            Intrinsics.checkNotNullExpressionValue(bottomSheet2, "bottomSheet");
                            bottomSheet2.setVisibility(8);
                        }
                        viewModel2 = MapFragment.this.getViewModel();
                        if (viewModel2.getCurrentSelectedMarker() != null) {
                            viewModel3 = MapFragment.this.getViewModel();
                            List<Marker> googleMarkers = viewModel3.getGoogleMarkers();
                            MapFragment mapFragment2 = MapFragment.this;
                            Iterator<T> it = googleMarkers.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    t = (T) null;
                                    break;
                                }
                                t = it.next();
                                Marker marker = (Marker) t;
                                Object tag = marker != null ? marker.getTag() : null;
                                viewModel5 = mapFragment2.getViewModel();
                                if (Intrinsics.areEqual(tag, viewModel5.getCurrentSelectedMarker())) {
                                    break;
                                }
                            }
                            Marker marker2 = t;
                            if (marker2 != null) {
                                MapFragment mapFragment3 = MapFragment.this;
                                Context requireContext = mapFragment3.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                                bitmapDescriptorFromVector = mapFragment3.bitmapDescriptorFromVector(requireContext, R.drawable.ic_point_default);
                                marker2.setIcon(bitmapDescriptorFromVector);
                            }
                            viewModel4 = MapFragment.this.getViewModel();
                            viewModel4.setCurrentSelectedMarker(null);
                        }
                        new FilterFragment().show(MapFragment.this.getChildFragmentManager(), (String) null);
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
