package ru.tattelecom.intercom.feature.call_settings;

import android.app.Dialog;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.feature.call_settings.databinding.DialogCallSettingsBinding;

/* compiled from: CallSettingsDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\fH\u0016J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J-\u0010%\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0'2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0018H\u0016J\u001a\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0018H\u0002J\b\u00101\u001a\u00020\u0018H\u0002J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\rH\u0002J\b\u00104\u001a\u00020\u0018H\u0002J\u0012\u00105\u001a\u00020\u00182\b\u00106\u001a\u0004\u0018\u00010\rH\u0002J\u001e\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00180:H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006<"}, d2 = {"Lru/tattelecom/intercom/feature/call_settings/CallSettingsDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/call_settings/databinding/DialogCallSettingsBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/call_settings/databinding/DialogCallSettingsBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "defaultRingtonePaths", "", "Lkotlin/Pair;", "", "", "player", "Landroid/media/MediaPlayer;", "viewModel", "Lru/tattelecom/intercom/feature/call_settings/CallSettingsViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/call_settings/CallSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStop", "onViewCreated", "view", "openRingtoneSelection", "provideUiChanges", "selectSystemRingtone", "setUi", "startPlayer", "ringtone", "stopPlayer", "updateRingtoneList", "path", "withStoragePermission", "code", FirebaseAnalytics.Param.METHOD, "Lkotlin/Function0;", "Companion", "feature-call-settings_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallSettingsDialog extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CallSettingsDialog.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/call_settings/databinding/DialogCallSettingsBinding;", 0))};
    public static final int SELECT_OWN_RINGTONE_REQUEST_CODE = 2;
    public static final int SELECT_SYSTEM_RINGTONE_REQUEST_CODE = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private List<Pair<Integer, String>> defaultRingtonePaths;
    private MediaPlayer player;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public CallSettingsDialog() {
        final CallSettingsDialog callSettingsDialog = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(callSettingsDialog, DialogCallSettingsBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<CallSettingsViewModel>() { // from class: ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.call_settings.CallSettingsViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final CallSettingsViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CallSettingsViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final DialogCallSettingsBinding getBinding() {
        return (DialogCallSettingsBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final CallSettingsViewModel getViewModel() {
        return (CallSettingsViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.NoBackgroundBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_call_settings, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        stopPlayer();
    }

    private final void setUi() {
        Dialog dialog = getDialog();
        List<Pair<Integer, String>> list = null;
        if (dialog != null) {
            ExtensionsKt.setExpandedState$default(dialog, false, 1, null);
        }
        String str = "android.resource://" + requireContext().getPackageName() + "/raw";
        this.defaultRingtonePaths = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Integer.valueOf(R.string.intercom), str + "/ringtone_intercom"), TuplesKt.to(Integer.valueOf(R.string.doorbell), str + "/ringtone_doorbell"), TuplesKt.to(Integer.valueOf(R.string.doorbell_modern), str + "/ringtone_doorbell_modern"), TuplesKt.to(Integer.valueOf(R.string.doorbell_luxury), str + "/ringtone_doorbell_luxury"), TuplesKt.to(Integer.valueOf(R.string.doorbell_old), str + "/ringtone_doorbell_old"), TuplesKt.to(Integer.valueOf(R.string.default_ringtone), ""), TuplesKt.to(Integer.valueOf(R.string.from_device), "")});
        if (getViewModel().getSelectedRingtonePath().getValue() == null) {
            MutableStateFlow<String> selectedRingtonePath = getViewModel().getSelectedRingtonePath();
            List<Pair<Integer, String>> list2 = this.defaultRingtonePaths;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultRingtonePaths");
                list2 = null;
            }
            selectedRingtonePath.setValue(list2.get(0).getSecond());
        }
        DialogCallSettingsBinding binding = getBinding();
        ProgressBar progressDoNotDisturb = binding.progressDoNotDisturb;
        Intrinsics.checkNotNullExpressionValue(progressDoNotDisturb, "progressDoNotDisturb");
        progressDoNotDisturb.setVisibility(8);
        binding.llDoNotDisturb.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallSettingsDialog.setUi$lambda$5$lambda$0(CallSettingsDialog.this, view);
            }
        });
        binding.rgRingtone.removeAllViews();
        List<Pair<Integer, String>> list3 = this.defaultRingtonePaths;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultRingtonePaths");
        } else {
            list = list3;
        }
        final int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final Pair pair = (Pair) obj;
            RadioGroup radioGroup = binding.rgRingtone;
            final RadioButton radioButton = new RadioButton(requireContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, ExtensionsKt.getDp(8), 0, 0);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setText(((Number) pair.getFirst()).intValue());
            radioButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallSettingsDialog.setUi$lambda$5$lambda$4$lambda$3$lambda$2(i, this, pair, radioButton, view);
                }
            });
            radioGroup.addView(radioButton);
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$5$lambda$0(CallSettingsDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDoNotDisturbClick(this$0.getBinding().switchDoNotDisturb.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$5$lambda$4$lambda$3$lambda$2(int i, final CallSettingsDialog this$0, Pair ringtone, RadioButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ringtone, "$ringtone");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        List<Pair<Integer, String>> list = this$0.defaultRingtonePaths;
        List<Pair<Integer, String>> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultRingtonePaths");
            list = null;
        }
        if (i == list.size() - 1) {
            this$0.withStoragePermission(2, new CallSettingsDialog$setUi$1$2$1$2$1(this_apply, this$0));
            return;
        }
        List<Pair<Integer, String>> list3 = this$0.defaultRingtonePaths;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultRingtonePaths");
        } else {
            list2 = list3;
        }
        if (i == list2.size() - 2) {
            this$0.withStoragePermission(1, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$setUi$1$2$1$2$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CallSettingsDialog.this.selectSystemRingtone();
                }
            });
        } else {
            this$0.getViewModel().onRingtoneSelected((String) ringtone.getSecond());
            this$0.startPlayer((String) ringtone.getSecond());
        }
    }

    private final void provideUiChanges() {
        CallSettingsViewModel viewModel = getViewModel();
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.isDoNotDisturbEnabled(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new CallSettingsDialog$provideUiChanges$1$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        Flow onEach2 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getSelectedRingtonePath(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new CallSettingsDialog$provideUiChanges$1$2(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach2, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2));
        Flow onEach3 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.isLoading(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new CallSettingsDialog$provideUiChanges$1$3(this, null));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach3, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3));
        Flow onEach4 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEventShowMessage(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new CallSettingsDialog$provideUiChanges$1$4(this, null));
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach4, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4));
        Flow onEach5 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEventReturnOldRingtone(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new CallSettingsDialog$provideUiChanges$1$5(this, null));
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach5, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5));
    }

    private final void startPlayer(String ringtone) {
        try {
            if (this.player != null) {
                stopPlayer();
            }
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());
            mediaPlayer.setDataSource(requireContext(), Uri.parse(ringtone));
            mediaPlayer.prepare();
            mediaPlayer.start();
            this.player = mediaPlayer;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void stopPlayer() {
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            MediaPlayer mediaPlayer2 = this.player;
            if (mediaPlayer2 != null) {
                mediaPlayer2.stop();
            }
            MediaPlayer mediaPlayer3 = this.player;
            if (mediaPlayer3 != null) {
                mediaPlayer3.reset();
            }
            MediaPlayer mediaPlayer4 = this.player;
            if (mediaPlayer4 != null) {
                mediaPlayer4.release();
            }
            this.player = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRingtoneList(String path) {
        int i;
        RadioGroup radioGroup = getBinding().rgRingtone;
        String str = path;
        if (str == null || str.length() == 0) {
            radioGroup.clearCheck();
            return;
        }
        List<Pair<Integer, String>> list = this.defaultRingtonePaths;
        List<Pair<Integer, String>> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultRingtonePaths");
            list = null;
        }
        int size = list.size();
        int i2 = 0;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "external/audio", false, 2, (Object) null)) {
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "system/ringtone", false, 2, (Object) null)) {
                List<Pair<Integer, String>> list3 = this.defaultRingtonePaths;
                if (list3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defaultRingtonePaths");
                } else {
                    list2 = list3;
                }
                Iterator<Pair<Integer, String>> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else {
                        if (Intrinsics.areEqual(it.next().getSecond(), path)) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                i = size - 2;
            }
        } else {
            i = size - 1;
        }
        if (i != -1) {
            radioGroup.check(radioGroup.getChildAt(i).getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectSystemRingtone() {
        String uri = RingtoneManager.getDefaultUri(1).toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        getViewModel().onRingtoneSelected(uri);
        startPlayer(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openRingtoneSelection() {
        try {
            startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI), 2);
        } catch (Exception unused) {
            CallSettingsViewModel viewModel = getViewModel();
            String string = getString(R.string.no_audio_pick_app);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            viewModel.onError(string);
        }
    }

    private final void withStoragePermission(int code, Function0<Unit> method) {
        if (Build.VERSION.SDK_INT < 33) {
            if (ContextCompat.checkSelfPermission(requireContext(), PermissionUtil.READ_EXTERNAL_PERMISSION) == 0) {
                method.invoke();
                return;
            } else {
                requestPermissions(new String[]{PermissionUtil.READ_EXTERNAL_PERMISSION}, code);
                return;
            }
        }
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_MEDIA_AUDIO") == 0) {
            method.invoke();
        } else {
            requestPermissions(new String[]{"android.permission.READ_MEDIA_AUDIO"}, code);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if ((grantResults.length == 0) || grantResults[0] != 0) {
            getViewModel().onRingtoneSelectDenied();
        } else if (requestCode == 1) {
            selectSystemRingtone();
        } else {
            if (requestCode != 2) {
                return;
            }
            openRingtoneSelection();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataString;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode != -1) {
                getViewModel().onRingtoneSelectDenied();
            } else {
                if (data == null || (dataString = data.getDataString()) == null) {
                    return;
                }
                getViewModel().onRingtoneSelected(dataString);
                startPlayer(dataString);
            }
        }
    }
}
