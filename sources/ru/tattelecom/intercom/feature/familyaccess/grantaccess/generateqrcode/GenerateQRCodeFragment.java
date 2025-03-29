package ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragmentKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentGenerateQrCodeBinding;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeViewModel;

/* compiled from: GenerateQRCodeFragment.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentGenerateQrCodeBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentGenerateQrCodeBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "viewModel", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideEvent", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event;", "provideUiChanges", "setUi", "setupApartmentsDropDown", EntitiesKt.APARTMENTS_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/ApartmentGuestsEntity;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GenerateQRCodeFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GenerateQRCodeFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentGenerateQrCodeBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public GenerateQRCodeFragment() {
        super(R.layout.fragment_generate_qr_code);
        final GenerateQRCodeFragment generateQRCodeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GenerateQRCodeViewModel>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final GenerateQRCodeViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ?? resolveViewModel;
                Fragment fragment = Fragment.this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GenerateQRCodeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(generateQRCodeFragment, FragmentGenerateQrCodeBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GenerateQRCodeViewModel getViewModel() {
        return (GenerateQRCodeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentGenerateQrCodeBinding getBinding() {
        return (FragmentGenerateQrCodeBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        getBinding().btnGenerateQrCode.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenerateQRCodeFragment.setUi$lambda$0(GenerateQRCodeFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$0(GenerateQRCodeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().generateQrCode();
    }

    private final void provideUiChanges() {
        GenerateQRCodeViewModel viewModel = getViewModel();
        viewModel.getApartments().observe(getViewLifecycleOwner(), new GenerateQRCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends ApartmentGuestsEntity>, Unit>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$provideUiChanges$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApartmentGuestsEntity> list) {
                invoke2((List<ApartmentGuestsEntity>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApartmentGuestsEntity> list) {
                if (list != null) {
                    GenerateQRCodeFragment.this.setupApartmentsDropDown(list);
                }
            }
        }));
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.isContinueButtonAllowed(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new GenerateQRCodeFragment$provideUiChanges$1$2(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        Flow onEach2 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new GenerateQRCodeFragment$provideUiChanges$1$3(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach2, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupApartmentsDropDown(final List<ApartmentGuestsEntity> apartments) {
        Object obj;
        List<ApartmentGuestsEntity> list = apartments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ApartmentGuestsEntity) it.next()).getAddress());
        }
        ArrayList arrayList2 = arrayList;
        final ArrayAdapter arrayAdapter = new ArrayAdapter(requireActivity(), R.layout.item_dropdown_apartment, R.id.tv_apartment, arrayList2);
        final FragmentGenerateQrCodeBinding binding = getBinding();
        binding.etApartment.setAdapter(arrayAdapter);
        Editable text = binding.etApartment.getText();
        if (text != null && text.length() != 0) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (Intrinsics.areEqual(((ApartmentGuestsEntity) obj).getAddress(), binding.etApartment.getText().toString())) {
                        break;
                    }
                }
            }
            ApartmentGuestsEntity apartmentGuestsEntity = (ApartmentGuestsEntity) obj;
            if (apartmentGuestsEntity != null) {
                TextView textView = binding.tvApartment;
                String string = requireContext().getString(R.string.invited_user_count);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(apartmentGuestsEntity.getGuestPhones().size()), Integer.valueOf(apartmentGuestsEntity.getRemainingInvites())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
        }
        binding.etApartment.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenerateQRCodeFragment.setupApartmentsDropDown$lambda$7$lambda$4(GenerateQRCodeFragment.this, view);
            }
        });
        AppCompatAutoCompleteTextView etApartment = binding.etApartment;
        Intrinsics.checkNotNullExpressionValue(etApartment, "etApartment");
        etApartment.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$setupApartmentsDropDown$lambda$7$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text2, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text2, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                GenerateQRCodeViewModel viewModel;
                GenerateQRCodeViewModel viewModel2;
                int position = arrayAdapter.getPosition(s != null ? s.toString() : null);
                if (position == -1) {
                    binding.tvApartment.setText(this.getString(R.string.address_for_sharing));
                    return;
                }
                ApartmentGuestsEntity apartmentGuestsEntity2 = (ApartmentGuestsEntity) apartments.get(position);
                TextView textView2 = binding.tvApartment;
                String string2 = this.requireContext().getString(R.string.invited_user_count);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(apartmentGuestsEntity2.getGuestPhones().size()), Integer.valueOf(apartmentGuestsEntity2.getRemainingInvites())}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView2.setText(format2);
                int remainingInvites = apartmentGuestsEntity2.getRemainingInvites();
                viewModel = this.getViewModel();
                viewModel.setRemainingInvites(remainingInvites);
                viewModel2 = this.getViewModel();
                viewModel2.isSelectedApartment(apartmentGuestsEntity2.getId());
            }
        });
        if (arrayList2.size() == 1) {
            binding.etApartment.setText((CharSequence) arrayAdapter.getItem(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupApartmentsDropDown$lambda$7$lambda$4(GenerateQRCodeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().etApartment.showDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(GenerateQRCodeViewModel.Event event) {
        if (Intrinsics.areEqual(event, GenerateQRCodeViewModel.Event.NavigateToErrorPage.INSTANCE)) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToRequestState(), BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "error")), null, 4, null);
            return;
        }
        if (event instanceof GenerateQRCodeViewModel.Event.Navigate) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Dest.INSTANCE.getQrCode(), BundleKt.bundleOf(TuplesKt.to(NavArg.QR_CODE_DATA, ((GenerateQRCodeViewModel.Event.Navigate) event).getQrCodeData())), null, 4, null);
            return;
        }
        if (event instanceof GenerateQRCodeViewModel.Event.ShowMessage) {
            Context requireContext = requireContext();
            String message = ((GenerateQRCodeViewModel.Event.ShowMessage) event).getMessage();
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        }
    }
}
