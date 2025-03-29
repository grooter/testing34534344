package ru.tattelecom.intercom.feature.gate_widget.select_gate;

import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import by.kirich1409.viewbindingdelegate.ReflectionActivityViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.feature.gate_widget.R;
import ru.tattelecom.intercom.feature.gate_widget.databinding.ActivitySelectGateBinding;

/* compiled from: SelectGateActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/tattelecom/intercom/feature/gate_widget/select_gate/SelectGateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lru/tattelecom/intercom/feature/gate_widget/databinding/ActivitySelectGateBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/gate_widget/databinding/ActivitySelectGateBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "viewModel", "Lru/tattelecom/intercom/feature/gate_widget/select_gate/SelectGateViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/gate_widget/select_gate/SelectGateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "finishWithMessage", "", "stringResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "feature-gate-widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectGateActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SelectGateActivity.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/gate_widget/databinding/ActivitySelectGateBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public SelectGateActivity() {
        super(R.layout.activity_select_gate);
        final SelectGateActivity selectGateActivity = this;
        this.binding = ReflectionActivityViewBindings.viewBindingActivity(selectGateActivity, ActivitySelectGateBinding.class, R.id.llRoot, UtilsKt.emptyVbCallback());
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        final byte b2 = 0 == true ? 1 : 0;
        this.viewModel = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SelectGateViewModel>() { // from class: ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final SelectGateViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ?? resolveViewModel;
                ComponentActivity componentActivity = ComponentActivity.this;
                Qualifier qualifier2 = qualifier;
                Function0 function0 = b;
                Function0 function02 = b2;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function0 == null || (defaultViewModelCreationExtras = (CreationExtras) function0.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SelectGateViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function02);
                return resolveViewModel;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ActivitySelectGateBinding getBinding() {
        return (ActivitySelectGateBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectGateViewModel getViewModel() {
        return (SelectGateViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GatesAdapter gatesAdapter = new GatesAdapter(new SelectGateActivity$onCreate$adapter$1(getViewModel()));
        getBinding().rvGates.setAdapter(gatesAdapter);
        SelectGateActivity selectGateActivity = this;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(selectGateActivity), null, null, new SelectGateActivity$onCreate$1(this, gatesAdapter, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(selectGateActivity), null, null, new SelectGateActivity$onCreate$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(selectGateActivity), null, null, new SelectGateActivity$onCreate$3(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithMessage(int stringResourceId) {
        Toast.makeText(this, stringResourceId, 0).show();
        finish();
    }
}
