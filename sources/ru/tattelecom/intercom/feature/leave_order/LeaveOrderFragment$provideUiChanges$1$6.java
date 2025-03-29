package ru.tattelecom.intercom.feature.leave_order;

import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import com.google.android.material.chip.Chip;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.leave_order.databinding.FragmentLeaveOrderBinding;

/* compiled from: LeaveOrderFragment.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "", "Lru/tattelecom/intercom/feature/leave_order/Service;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$provideUiChanges$1$6", f = "LeaveOrderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LeaveOrderFragment$provideUiChanges$1$6 extends SuspendLambda implements Function2<List<? extends Service>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LeaveOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LeaveOrderFragment$provideUiChanges$1$6(LeaveOrderFragment leaveOrderFragment, Continuation<? super LeaveOrderFragment$provideUiChanges$1$6> continuation) {
        super(2, continuation);
        this.this$0 = leaveOrderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LeaveOrderFragment$provideUiChanges$1$6 leaveOrderFragment$provideUiChanges$1$6 = new LeaveOrderFragment$provideUiChanges$1$6(this.this$0, continuation);
        leaveOrderFragment$provideUiChanges$1$6.L$0 = obj;
        return leaveOrderFragment$provideUiChanges$1$6;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends Service> list, Continuation<? super Unit> continuation) {
        return invoke2((List<Service>) list, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<Service> list, Continuation<? super Unit> continuation) {
        return ((LeaveOrderFragment$provideUiChanges$1$6) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentLeaveOrderBinding binding;
        LeaveOrderViewModel viewModel;
        FragmentLeaveOrderBinding binding2;
        LeaveOrderViewModel viewModel2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<Service> list = (List) this.L$0;
            binding = this.this$0.getBinding();
            binding.cgServices.removeAllViews();
            if (list != null) {
                final LeaveOrderFragment leaveOrderFragment = this.this$0;
                for (final Service service : list) {
                    Chip chip = new Chip(leaveOrderFragment.requireContext());
                    chip.setText(service.getName());
                    chip.setTextAppearance(R.style.ChipTextAppearance);
                    chip.setChipBackgroundColor(ContextCompat.getColorStateList(leaveOrderFragment.requireContext(), R.color.chip_bg));
                    chip.setCheckable(true);
                    chip.setCheckedIconVisible(false);
                    chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$provideUiChanges$1$6$$ExternalSyntheticLambda0
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            LeaveOrderFragment$provideUiChanges$1$6.invokeSuspend$lambda$3$lambda$1$lambda$0(LeaveOrderFragment.this, service, compoundButton, z);
                        }
                    });
                    viewModel = leaveOrderFragment.getViewModel();
                    if (!viewModel.getSelectedServices().isEmpty()) {
                        viewModel2 = leaveOrderFragment.getViewModel();
                        Set<Service> selectedServices = viewModel2.getSelectedServices();
                        if (!(selectedServices instanceof Collection) || !selectedServices.isEmpty()) {
                            Iterator<T> it = selectedServices.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                if (Intrinsics.areEqual(((Service) it.next()).getName(), service.getName())) {
                                    chip.setChecked(true);
                                    break;
                                }
                            }
                        }
                    }
                    binding2 = leaveOrderFragment.getBinding();
                    binding2.cgServices.addView(chip);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3$lambda$1$lambda$0(LeaveOrderFragment leaveOrderFragment, Service service, CompoundButton compoundButton, boolean z) {
        LeaveOrderViewModel viewModel;
        viewModel = leaveOrderFragment.getViewModel();
        viewModel.onChipClicked(service, z);
    }
}
