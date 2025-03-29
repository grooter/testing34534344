package ru.tattelecom.intercom;

import android.widget.Toast;
import androidx.lifecycle.SavedStateHandle;
import androidx.room.Room;
import io.ktor.client.HttpClient;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.koin.android.ext.koin.ModuleExtKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;
import ru.tattelecom.feature.call_history.EventHistoryViewModel;
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.IntercomDatabase;
import ru.tattelecom.intercom.data.local.dao.AddressDao;
import ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao;
import ru.tattelecom.intercom.data.local.dao.DownloadDAO;
import ru.tattelecom.intercom.data.local.dao.EventDao;
import ru.tattelecom.intercom.data.local.dao.GateEventDao;
import ru.tattelecom.intercom.data.local.dao.IntercomDao;
import ru.tattelecom.intercom.data.local.dao.LockGateDao;
import ru.tattelecom.intercom.data.local.dao.RemoteLogsDao;
import ru.tattelecom.intercom.data.local.dao.ScheduleDao;
import ru.tattelecom.intercom.data.local.dao.StreamDao;
import ru.tattelecom.intercom.data.local.dao.SupportContactDao;
import ru.tattelecom.intercom.data.prefs.PushPrefsSource;
import ru.tattelecom.intercom.data.prefs.RemoteConfigPrefsSource;
import ru.tattelecom.intercom.data.prefs.SupportPrefsSource;
import ru.tattelecom.intercom.data.prefs.TutorialPrefsSource;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.ExternalKtorConfig;
import ru.tattelecom.intercom.data.remote.KtorConfig;
import ru.tattelecom.intercom.data.remote.contracts.AdvRemote;
import ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl;
import ru.tattelecom.intercom.data.remote.source.AuthRemote;
import ru.tattelecom.intercom.data.remote.source.ConfigRemote;
import ru.tattelecom.intercom.data.remote.source.EventHistoryRemote;
import ru.tattelecom.intercom.data.remote.source.GateRemote;
import ru.tattelecom.intercom.data.remote.source.GuestRemote;
import ru.tattelecom.intercom.data.remote.source.IntercomRemote;
import ru.tattelecom.intercom.data.remote.source.LeadRemote;
import ru.tattelecom.intercom.data.remote.source.LogRemote;
import ru.tattelecom.intercom.data.remote.source.OfficeMapRemote;
import ru.tattelecom.intercom.data.remote.source.PushRemote;
import ru.tattelecom.intercom.data.remote.source.ReaderRemote;
import ru.tattelecom.intercom.data.remote.source.StreamRemote;
import ru.tattelecom.intercom.data.remote.source.SupportRemote;
import ru.tattelecom.intercom.domain.contracts.AdvBottomSheetInteractor;
import ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor;
import ru.tattelecom.intercom.domain.interactors.AddressInteractor;
import ru.tattelecom.intercom.domain.interactors.AdvBottomSheetInteractorImpl;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.domain.interactors.EventHistoryInteractor;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.OfficeInteractor;
import ru.tattelecom.intercom.domain.interactors.PushInteractor;
import ru.tattelecom.intercom.domain.interactors.SignOutInteractor;
import ru.tattelecom.intercom.domain.interactors.StreamInteractor;
import ru.tattelecom.intercom.domain.interactors.SupportInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.feature.call_schedule.CallScheduleViewModel;
import ru.tattelecom.intercom.feature.call_settings.CallSettingsViewModel;
import ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationViewModel;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeViewModel;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel;
import ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel;
import ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel;
import ru.tattelecom.intercom.feature.home.HomeBottomSheetViewModel;
import ru.tattelecom.intercom.feature.home.HomeViewModel;
import ru.tattelecom.intercom.feature.home.error_screen.IntercomErrorViewModel;
import ru.tattelecom.intercom.feature.intercom_emergency_code.IntercomEmergencyCodeViewModel;
import ru.tattelecom.intercom.feature.leave_order.LeaveOrderViewModel;
import ru.tattelecom.intercom.feature.login.LoginViewModel;
import ru.tattelecom.intercom.feature.office_map.main.MapViewModel;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;
import ru.tattelecom.intercom.feature.profile.ProfileViewModel;
import ru.tattelecom.intercom.feature.profile_details.ProfileDetailsViewModel;
import ru.tattelecom.intercom.feature.trial.TrialViewModel;
import ru.tattelecom.intercom.feature.tutorial.TutorialViewModel;
import ru.tattelecom.intercom.feature.verify.VerifyViewModel;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemViewModel;
import ru.tattelecom.intercom.feature.welcome.WelcomeViewModel;
import ru.tattelecom.intercom.lib_chat.ChatViewModel;
import ru.tattelecom.intercom.main.MainViewModel;

/* compiled from: Modules.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003¨\u0006\u000e"}, d2 = {"dispatchersModule", "Lorg/koin/core/module/Module;", "getDispatchersModule", "()Lorg/koin/core/module/Module;", "interactorModule", "getInteractorModule", "localSourceModule", "getLocalSourceModule", "remoteLoggerModule", "getRemoteLoggerModule", "remoteSourceModule", "getRemoteSourceModule", "viewModelModule", "getViewModelModule", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModulesKt {
    private static final Module viewModelModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, EventHistoryViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final EventHistoryViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new EventHistoryViewModel((EventHistoryInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(EventHistoryInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null), (UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EventHistoryViewModel.class), null, anonymousClass1, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory);
            new KoinDefinition(module, factoryInstanceFactory);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, CallSettingsViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.2
                @Override // kotlin.jvm.functions.Function2
                public final CallSettingsViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new CallSettingsViewModel((IntercomInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(IntercomInteractor.class), null, null), (UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CallSettingsViewModel.class), null, anonymousClass2, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory2);
            new KoinDefinition(module, factoryInstanceFactory2);
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, CallScheduleViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.3
                @Override // kotlin.jvm.functions.Function2
                public final CallScheduleViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new CallScheduleViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (IntercomInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(IntercomInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(CallScheduleViewModel.class), null, anonymousClass3, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory3);
            new KoinDefinition(module, factoryInstanceFactory3);
            AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, GenerateQRCodeViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.4
                @Override // kotlin.jvm.functions.Function2
                public final GenerateQRCodeViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new GenerateQRCodeViewModel((FamilyAccessInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(FamilyAccessInteractor.class), null, null), (AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GenerateQRCodeViewModel.class), null, anonymousClass4, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory4);
            new KoinDefinition(module, factoryInstanceFactory4);
            AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, HomeViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.5
                @Override // kotlin.jvm.functions.Function2
                public final HomeViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new HomeViewModel((AddressInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, null), (IntercomInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(IntercomInteractor.class), null, null), (FamilyAccessInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(FamilyAccessInteractor.class), null, null), (TutorialPrefsSource) viewModel.get(Reflection.getOrCreateKotlinClass(TutorialPrefsSource.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null), (UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null), (ConfigInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(ConfigInteractor.class), null, null), (GateInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), null, null), (LockGateInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LockGateInteractor.class), null, null), (AdvBottomSheetInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AdvBottomSheetInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HomeViewModel.class), null, anonymousClass5, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory5);
            new KoinDefinition(module, factoryInstanceFactory5);
            AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, FaceDetectViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.6
                @Override // kotlin.jvm.functions.Function2
                public final FaceDetectViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new FaceDetectViewModel((UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FaceDetectViewModel.class), null, anonymousClass6, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory6);
            new KoinDefinition(module, factoryInstanceFactory6);
            AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, HomeBottomSheetViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.7
                @Override // kotlin.jvm.functions.Function2
                public final HomeBottomSheetViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new HomeBottomSheetViewModel((LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null), (AdvBottomSheetInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AdvBottomSheetInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HomeBottomSheetViewModel.class), null, anonymousClass7, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory7);
            new KoinDefinition(module, factoryInstanceFactory7);
            AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, IntercomEmergencyCodeViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.8
                @Override // kotlin.jvm.functions.Function2
                public final IntercomEmergencyCodeViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new IntercomEmergencyCodeViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(IntercomEmergencyCodeViewModel.class), null, anonymousClass8, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory8);
            new KoinDefinition(module, factoryInstanceFactory8);
            AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, IntercomErrorViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.9
                @Override // kotlin.jvm.functions.Function2
                public final IntercomErrorViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new IntercomErrorViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(IntercomErrorViewModel.class), null, anonymousClass9, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory9);
            new KoinDefinition(module, factoryInstanceFactory9);
            AnonymousClass10 anonymousClass10 = new Function2<Scope, ParametersHolder, InviteUserViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.10
                @Override // kotlin.jvm.functions.Function2
                public final InviteUserViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new InviteUserViewModel((FamilyAccessInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(FamilyAccessInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(InviteUserViewModel.class), null, anonymousClass10, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory10);
            new KoinDefinition(module, factoryInstanceFactory10);
            AnonymousClass11 anonymousClass11 = new Function2<Scope, ParametersHolder, LeaveOrderViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.11
                @Override // kotlin.jvm.functions.Function2
                public final LeaveOrderViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new LeaveOrderViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null), (AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeaveOrderViewModel.class), null, anonymousClass11, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory11);
            new KoinDefinition(module, factoryInstanceFactory11);
            AnonymousClass12 anonymousClass12 = new Function2<Scope, ParametersHolder, LoginViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.12
                @Override // kotlin.jvm.functions.Function2
                public final LoginViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new LoginViewModel((AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LoginViewModel.class), null, anonymousClass12, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory12);
            new KoinDefinition(module, factoryInstanceFactory12);
            AnonymousClass13 anonymousClass13 = new Function2<Scope, ParametersHolder, SupportViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.13
                @Override // kotlin.jvm.functions.Function2
                public final SupportViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SupportViewModel((SupportInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(SupportInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SupportViewModel.class), null, anonymousClass13, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory13);
            new KoinDefinition(module, factoryInstanceFactory13);
            AnonymousClass14 anonymousClass14 = new Function2<Scope, ParametersHolder, MainViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.14
                @Override // kotlin.jvm.functions.Function2
                public final MainViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new MainViewModel((UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null), (PushInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(PushInteractor.class), null, null), (ConfigInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(ConfigInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory14 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MainViewModel.class), null, anonymousClass14, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory14);
            new KoinDefinition(module, factoryInstanceFactory14);
            AnonymousClass15 anonymousClass15 = new Function2<Scope, ParametersHolder, MapViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.15
                @Override // kotlin.jvm.functions.Function2
                public final MapViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new MapViewModel((OfficeInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(OfficeInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory15 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MapViewModel.class), null, anonymousClass15, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory15);
            new KoinDefinition(module, factoryInstanceFactory15);
            AnonymousClass16 anonymousClass16 = new Function2<Scope, ParametersHolder, PlayerViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.16
                @Override // kotlin.jvm.functions.Function2
                public final PlayerViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new PlayerViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null), (StreamInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(StreamInteractor.class), null, null), (IntercomInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(IntercomInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null), (GateInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), null, null), (LockGateInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LockGateInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory16 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PlayerViewModel.class), null, anonymousClass16, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory16);
            new KoinDefinition(module, factoryInstanceFactory16);
            AnonymousClass17 anonymousClass17 = new Function2<Scope, ParametersHolder, ProfileViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.17
                @Override // kotlin.jvm.functions.Function2
                public final ProfileViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ProfileViewModel((UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null), (AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null), (PushInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(PushInteractor.class), null, null), (SignOutInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(SignOutInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null), (AddressInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory17 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProfileViewModel.class), null, anonymousClass17, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory17);
            new KoinDefinition(module, factoryInstanceFactory17);
            AnonymousClass18 anonymousClass18 = new Function2<Scope, ParametersHolder, ProfileDetailsViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.18
                @Override // kotlin.jvm.functions.Function2
                public final ProfileDetailsViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ProfileDetailsViewModel((AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory18 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ProfileDetailsViewModel.class), null, anonymousClass18, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory18);
            new KoinDefinition(module, factoryInstanceFactory18);
            AnonymousClass19 anonymousClass19 = new Function2<Scope, ParametersHolder, RegistrationViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.19
                @Override // kotlin.jvm.functions.Function2
                public final RegistrationViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new RegistrationViewModel((AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null), (AddressInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory19 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RegistrationViewModel.class), null, anonymousClass19, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory19);
            new KoinDefinition(module, factoryInstanceFactory19);
            AnonymousClass20 anonymousClass20 = new Function2<Scope, ParametersHolder, ScanQRCodeViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.20
                @Override // kotlin.jvm.functions.Function2
                public final ScanQRCodeViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ScanQRCodeViewModel((AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null), (AddressInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory20 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ScanQRCodeViewModel.class), null, anonymousClass20, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory20);
            new KoinDefinition(module, factoryInstanceFactory20);
            AnonymousClass21 anonymousClass21 = new Function2<Scope, ParametersHolder, SelectGateViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.21
                @Override // kotlin.jvm.functions.Function2
                public final SelectGateViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SelectGateViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (GateInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory21 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SelectGateViewModel.class), null, anonymousClass21, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory21);
            new KoinDefinition(module, factoryInstanceFactory21);
            AnonymousClass22 anonymousClass22 = new Function2<Scope, ParametersHolder, TemporaryCodeViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.22
                @Override // kotlin.jvm.functions.Function2
                public final TemporaryCodeViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new TemporaryCodeViewModel((AddressInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, null), (FamilyAccessInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(FamilyAccessInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory22 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TemporaryCodeViewModel.class), null, anonymousClass22, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory22);
            new KoinDefinition(module, factoryInstanceFactory22);
            AnonymousClass23 anonymousClass23 = new Function2<Scope, ParametersHolder, TrialViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.23
                @Override // kotlin.jvm.functions.Function2
                public final TrialViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new TrialViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (ConfigInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(ConfigInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory23 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TrialViewModel.class), null, anonymousClass23, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory23);
            new KoinDefinition(module, factoryInstanceFactory23);
            AnonymousClass24 anonymousClass24 = new Function2<Scope, ParametersHolder, TutorialViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.24
                @Override // kotlin.jvm.functions.Function2
                public final TutorialViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new TutorialViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null), (TutorialPrefsSource) viewModel.get(Reflection.getOrCreateKotlinClass(TutorialPrefsSource.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory24 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TutorialViewModel.class), null, anonymousClass24, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory24);
            new KoinDefinition(module, factoryInstanceFactory24);
            AnonymousClass25 anonymousClass25 = new Function2<Scope, ParametersHolder, VerifyViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.25
                @Override // kotlin.jvm.functions.Function2
                public final VerifyViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new VerifyViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (AuthInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, null), (PushInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(PushInteractor.class), null, null), (FamilyAccessInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(FamilyAccessInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory25 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(VerifyViewModel.class), null, anonymousClass25, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory25);
            new KoinDefinition(module, factoryInstanceFactory25);
            AnonymousClass26 anonymousClass26 = new Function2<Scope, ParametersHolder, VideoPlayerViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.26
                @Override // kotlin.jvm.functions.Function2
                public final VideoPlayerViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new VideoPlayerViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null), (GateInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), null, null), (StreamInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(StreamInteractor.class), null, null), (PlayerUserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(PlayerUserInteractor.class), null, null), (LockGateInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LockGateInteractor.class), null, null), (LogInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null), (ConfigInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(ConfigInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory26 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(VideoPlayerViewModel.class), null, anonymousClass26, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory26);
            new KoinDefinition(module, factoryInstanceFactory26);
            AnonymousClass27 anonymousClass27 = new Function2<Scope, ParametersHolder, DownloadViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.27
                @Override // kotlin.jvm.functions.Function2
                public final DownloadViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new DownloadViewModel((PlayerUserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(PlayerUserInteractor.class), null, null), (StreamInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(StreamInteractor.class), null, null), (SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory27 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DownloadViewModel.class), null, anonymousClass27, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory27);
            new KoinDefinition(module, factoryInstanceFactory27);
            AnonymousClass28 anonymousClass28 = new Function2<Scope, ParametersHolder, SelectItemViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.28
                @Override // kotlin.jvm.functions.Function2
                public final SelectItemViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SelectItemViewModel((SavedStateHandle) viewModel.get(Reflection.getOrCreateKotlinClass(SavedStateHandle.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory28 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SelectItemViewModel.class), null, anonymousClass28, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory28);
            new KoinDefinition(module, factoryInstanceFactory28);
            AnonymousClass29 anonymousClass29 = new Function2<Scope, ParametersHolder, WelcomeViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.29
                @Override // kotlin.jvm.functions.Function2
                public final WelcomeViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new WelcomeViewModel((UserInteractor) viewModel.get(Reflection.getOrCreateKotlinClass(UserInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory29 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(WelcomeViewModel.class), null, anonymousClass29, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory29);
            new KoinDefinition(module, factoryInstanceFactory29);
            AnonymousClass30 anonymousClass30 = new Function2<Scope, ParametersHolder, ChatViewModel>() { // from class: ru.tattelecom.intercom.ModulesKt$viewModelModule$1.30
                @Override // kotlin.jvm.functions.Function2
                public final ChatViewModel invoke(Scope viewModel, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ChatViewModel((UserPrefsSource) viewModel.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory30 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ChatViewModel.class), null, anonymousClass30, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory30);
            new KoinDefinition(module, factoryInstanceFactory30);
        }
    }, 1, null);
    private static final Module interactorModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, AddressInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final AddressInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new AddressInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (IntercomDatabase) factory.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null), (StreamRemote) factory.get(Reflection.getOrCreateKotlinClass(StreamRemote.class), null, null), (IntercomRemote) factory.get(Reflection.getOrCreateKotlinClass(IntercomRemote.class), null, null), (ReaderRemote) factory.get(Reflection.getOrCreateKotlinClass(ReaderRemote.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, anonymousClass1, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory);
            new KoinDefinition(module, factoryInstanceFactory);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, AuthInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.2
                @Override // kotlin.jvm.functions.Function2
                public final AuthInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new AuthInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (AuthRemote) factory.get(Reflection.getOrCreateKotlinClass(AuthRemote.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AuthInteractor.class), null, anonymousClass2, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory2);
            new KoinDefinition(module, factoryInstanceFactory2);
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, ConfigInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.3
                @Override // kotlin.jvm.functions.Function2
                public final ConfigInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ConfigInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (ConfigRemote) factory.get(Reflection.getOrCreateKotlinClass(ConfigRemote.class), null, null), (RemoteConfigPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(RemoteConfigPrefsSource.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ConfigInteractor.class), null, anonymousClass3, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory3);
            new KoinDefinition(module, factoryInstanceFactory3);
            AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, EventHistoryInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.4
                @Override // kotlin.jvm.functions.Function2
                public final EventHistoryInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new EventHistoryInteractor((EventHistoryRemote) factory.get(Reflection.getOrCreateKotlinClass(EventHistoryRemote.class), null, null), (EventDao) factory.get(Reflection.getOrCreateKotlinClass(EventDao.class), null, null), (ApartmentDao) factory.get(Reflection.getOrCreateKotlinClass(ApartmentDao.class), null, null), (ApartmentServicesDao) factory.get(Reflection.getOrCreateKotlinClass(ApartmentServicesDao.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EventHistoryInteractor.class), null, anonymousClass4, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory4);
            new KoinDefinition(module, factoryInstanceFactory4);
            AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, FamilyAccessInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.5
                @Override // kotlin.jvm.functions.Function2
                public final FamilyAccessInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new FamilyAccessInteractor((GuestRemote) factory.get(Reflection.getOrCreateKotlinClass(GuestRemote.class), null, null), (ApartmentDao) factory.get(Reflection.getOrCreateKotlinClass(ApartmentDao.class), null, null), (ApartmentGuestsDao) factory.get(Reflection.getOrCreateKotlinClass(ApartmentGuestsDao.class), null, null), (IntercomDatabase) factory.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FamilyAccessInteractor.class), null, anonymousClass5, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory5);
            new KoinDefinition(module, factoryInstanceFactory5);
            AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, GateInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.6
                @Override // kotlin.jvm.functions.Function2
                public final GateInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new GateInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (GateRemote) factory.get(Reflection.getOrCreateKotlinClass(GateRemote.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null), (IntercomDao) factory.get(Reflection.getOrCreateKotlinClass(IntercomDao.class), null, null), (GateEventDao) factory.get(Reflection.getOrCreateKotlinClass(GateEventDao.class), null, null), (LockGateInteractor) factory.get(Reflection.getOrCreateKotlinClass(LockGateInteractor.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GateInteractor.class), null, anonymousClass6, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory6);
            new KoinDefinition(module, factoryInstanceFactory6);
            AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, IntercomInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.7
                @Override // kotlin.jvm.functions.Function2
                public final IntercomInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new IntercomInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (IntercomRemote) factory.get(Reflection.getOrCreateKotlinClass(IntercomRemote.class), null, null), (IntercomDao) factory.get(Reflection.getOrCreateKotlinClass(IntercomDao.class), null, null), (ScheduleDao) factory.get(Reflection.getOrCreateKotlinClass(ScheduleDao.class), null, null), (AddressInteractor) factory.get(Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(IntercomInteractor.class), null, anonymousClass7, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory7);
            new KoinDefinition(module, factoryInstanceFactory7);
            AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, LogInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.8
                @Override // kotlin.jvm.functions.Function2
                public final LogInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new LogInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (RemoteLogsDao) factory.get(Reflection.getOrCreateKotlinClass(RemoteLogsDao.class), null, null), (LogRemote) factory.get(Reflection.getOrCreateKotlinClass(LogRemote.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LogInteractor.class), null, anonymousClass8, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory8);
            new KoinDefinition(module, factoryInstanceFactory8);
            AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, OfficeInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.9
                @Override // kotlin.jvm.functions.Function2
                public final OfficeInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new OfficeInteractor((OfficeMapRemote) factory.get(Reflection.getOrCreateKotlinClass(OfficeMapRemote.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OfficeInteractor.class), null, anonymousClass9, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory9);
            new KoinDefinition(module, factoryInstanceFactory9);
            AnonymousClass10 anonymousClass10 = new Function2<Scope, ParametersHolder, PushInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.10
                @Override // kotlin.jvm.functions.Function2
                public final PushInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new PushInteractor((PushPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(PushPrefsSource.class), null, null), (PushRemote) factory.get(Reflection.getOrCreateKotlinClass(PushRemote.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null), (UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PushInteractor.class), null, anonymousClass10, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory10);
            new KoinDefinition(module, factoryInstanceFactory10);
            AnonymousClass11 anonymousClass11 = new Function2<Scope, ParametersHolder, SignOutInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.11
                @Override // kotlin.jvm.functions.Function2
                public final SignOutInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SignOutInteractor((IntercomDatabase) factory.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null), (UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (RemoteConfigPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(RemoteConfigPrefsSource.class), null, null), (SupportPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(SupportPrefsSource.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SignOutInteractor.class), null, anonymousClass11, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory11);
            new KoinDefinition(module, factoryInstanceFactory11);
            AnonymousClass12 anonymousClass12 = new Function2<Scope, ParametersHolder, UserInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.12
                @Override // kotlin.jvm.functions.Function2
                public final UserInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new UserInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (LeadRemote) factory.get(Reflection.getOrCreateKotlinClass(LeadRemote.class), null, null), (IntercomDatabase) factory.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null), (DownloadDAO) factory.get(Reflection.getOrCreateKotlinClass(DownloadDAO.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null), (StreamRemote) factory.get(Reflection.getOrCreateKotlinClass(StreamRemote.class), null, null), (AuthRemote) factory.get(Reflection.getOrCreateKotlinClass(AuthRemote.class), null, null), (GateInteractor) factory.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), null, null), (ConfigRemote) factory.get(Reflection.getOrCreateKotlinClass(ConfigRemote.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UserInteractor.class), null, anonymousClass12, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory12);
            new KoinDefinition(module, factoryInstanceFactory12);
            AnonymousClass13 anonymousClass13 = new Function2<Scope, ParametersHolder, IntercomInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.13
                @Override // kotlin.jvm.functions.Function2
                public final IntercomInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new IntercomInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (IntercomRemote) factory.get(Reflection.getOrCreateKotlinClass(IntercomRemote.class), null, null), (IntercomDao) factory.get(Reflection.getOrCreateKotlinClass(IntercomDao.class), null, null), (ScheduleDao) factory.get(Reflection.getOrCreateKotlinClass(ScheduleDao.class), null, null), (AddressInteractor) factory.get(Reflection.getOrCreateKotlinClass(AddressInteractor.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(IntercomInteractor.class), null, anonymousClass13, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory13);
            new KoinDefinition(module, factoryInstanceFactory13);
            AnonymousClass14 anonymousClass14 = new Function2<Scope, ParametersHolder, StreamInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.14
                @Override // kotlin.jvm.functions.Function2
                public final StreamInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new StreamInteractor((StreamRemote) factory.get(Reflection.getOrCreateKotlinClass(StreamRemote.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory14 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StreamInteractor.class), null, anonymousClass14, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory14);
            new KoinDefinition(module, factoryInstanceFactory14);
            AnonymousClass15 anonymousClass15 = new Function2<Scope, ParametersHolder, LockGateInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.15
                @Override // kotlin.jvm.functions.Function2
                public final LockGateInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new LockGateInteractor((LockGateDao) factory.get(Reflection.getOrCreateKotlinClass(LockGateDao.class), null, null), (RemoteConfigPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(RemoteConfigPrefsSource.class), null, null), ModuleExtKt.androidContext(factory), (UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory15 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LockGateInteractor.class), null, anonymousClass15, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory15);
            new KoinDefinition(module, factoryInstanceFactory15);
            AnonymousClass16 anonymousClass16 = new Function2<Scope, ParametersHolder, SupportInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.16
                @Override // kotlin.jvm.functions.Function2
                public final SupportInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SupportInteractor((SupportContactDao) factory.get(Reflection.getOrCreateKotlinClass(SupportContactDao.class), null, null), (SupportRemote) factory.get(Reflection.getOrCreateKotlinClass(SupportRemote.class), null, null), (SupportPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(SupportPrefsSource.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory16 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SupportInteractor.class), null, anonymousClass16, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory16);
            new KoinDefinition(module, factoryInstanceFactory16);
            AnonymousClass17 anonymousClass17 = new Function2<Scope, ParametersHolder, AdvBottomSheetInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.17
                @Override // kotlin.jvm.functions.Function2
                public final AdvBottomSheetInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new AdvBottomSheetInteractorImpl((AdvRemote) factory.get(Reflection.getOrCreateKotlinClass(AdvRemote.class), null, null), (AdvBottomSheetDao) factory.get(Reflection.getOrCreateKotlinClass(AdvBottomSheetDao.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory17 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AdvBottomSheetInteractor.class), null, anonymousClass17, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory17);
            new KoinDefinition(module, factoryInstanceFactory17);
            AnonymousClass18 anonymousClass18 = new Function2<Scope, ParametersHolder, PlayerUserInteractor>() { // from class: ru.tattelecom.intercom.ModulesKt$interactorModule$1.18
                @Override // kotlin.jvm.functions.Function2
                public final PlayerUserInteractor invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new UserInteractor((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (LeadRemote) factory.get(Reflection.getOrCreateKotlinClass(LeadRemote.class), null, null), (IntercomDatabase) factory.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null), (DownloadDAO) factory.get(Reflection.getOrCreateKotlinClass(DownloadDAO.class), null, null), (AppCoroutineDispatchers) factory.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null), (StreamRemote) factory.get(Reflection.getOrCreateKotlinClass(StreamRemote.class), null, null), (AuthRemote) factory.get(Reflection.getOrCreateKotlinClass(AuthRemote.class), null, null), (GateInteractor) factory.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), null, null), (ConfigRemote) factory.get(Reflection.getOrCreateKotlinClass(ConfigRemote.class), null, null));
                }
            };
            FactoryInstanceFactory factoryInstanceFactory18 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PlayerUserInteractor.class), null, anonymousClass18, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory18);
            new KoinDefinition(module, factoryInstanceFactory18);
        }
    }, 1, null);
    private static final Module dispatchersModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: ru.tattelecom.intercom.ModulesKt$dispatchersModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, AppCoroutineDispatchers>() { // from class: ru.tattelecom.intercom.ModulesKt$dispatchersModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final AppCoroutineDispatchers invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new AppCoroutineDispatchers(Dispatchers.getIO(), Dispatchers.getDefault(), Dispatchers.getMain());
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
        }
    }, 1, null);
    private static final Module remoteLoggerModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteLoggerModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, TimberRemoteTree>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteLoggerModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final TimberRemoteTree invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new TimberRemoteTree((LogInteractor) single.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TimberRemoteTree.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
        }
    }, 1, null);
    private static final Module localSourceModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, IntercomDatabase>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final IntercomDatabase invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    Executor asExecutor = ExecutorsKt.asExecutor(((AppCoroutineDispatchers) single.get(Reflection.getOrCreateKotlinClass(AppCoroutineDispatchers.class), null, null)).getIo());
                    return (IntercomDatabase) Room.databaseBuilder(ModuleExtKt.androidApplication(single), IntercomDatabase.class, IntercomDatabase.DB_NAME).setQueryExecutor(asExecutor).setTransactionExecutor(asExecutor).fallbackToDestructiveMigration().build();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, AddressDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.2
                @Override // kotlin.jvm.functions.Function2
                public final AddressDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).addressDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AddressDao.class), null, anonymousClass2, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory4 = singleInstanceFactory3;
            module.indexPrimaryType(singleInstanceFactory4);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory3);
            }
            new KoinDefinition(module, singleInstanceFactory4);
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, ApartmentDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.3
                @Override // kotlin.jvm.functions.Function2
                public final ApartmentDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).apartmentDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApartmentDao.class), null, anonymousClass3, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory6 = singleInstanceFactory5;
            module.indexPrimaryType(singleInstanceFactory6);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory5);
            }
            new KoinDefinition(module, singleInstanceFactory6);
            AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, ApartmentGuestsDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.4
                @Override // kotlin.jvm.functions.Function2
                public final ApartmentGuestsDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).apartmentGuestsDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory7 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApartmentGuestsDao.class), null, anonymousClass4, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory8 = singleInstanceFactory7;
            module.indexPrimaryType(singleInstanceFactory8);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory7);
            }
            new KoinDefinition(module, singleInstanceFactory8);
            AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, ApartmentServicesDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.5
                @Override // kotlin.jvm.functions.Function2
                public final ApartmentServicesDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).apartmentServicesDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory9 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ApartmentServicesDao.class), null, anonymousClass5, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory10 = singleInstanceFactory9;
            module.indexPrimaryType(singleInstanceFactory10);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory9);
            }
            new KoinDefinition(module, singleInstanceFactory10);
            AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, EventDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.6
                @Override // kotlin.jvm.functions.Function2
                public final EventDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).callDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory11 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EventDao.class), null, anonymousClass6, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory12 = singleInstanceFactory11;
            module.indexPrimaryType(singleInstanceFactory12);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory11);
            }
            new KoinDefinition(module, singleInstanceFactory12);
            AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, IntercomDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.7
                @Override // kotlin.jvm.functions.Function2
                public final IntercomDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).intercomDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory13 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(IntercomDao.class), null, anonymousClass7, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory14 = singleInstanceFactory13;
            module.indexPrimaryType(singleInstanceFactory14);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory13);
            }
            new KoinDefinition(module, singleInstanceFactory14);
            AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, StreamDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.8
                @Override // kotlin.jvm.functions.Function2
                public final StreamDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).streamDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory15 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StreamDao.class), null, anonymousClass8, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory16 = singleInstanceFactory15;
            module.indexPrimaryType(singleInstanceFactory16);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory15);
            }
            new KoinDefinition(module, singleInstanceFactory16);
            AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, ScheduleDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.9
                @Override // kotlin.jvm.functions.Function2
                public final ScheduleDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).scheduleDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory17 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ScheduleDao.class), null, anonymousClass9, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory18 = singleInstanceFactory17;
            module.indexPrimaryType(singleInstanceFactory18);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory17);
            }
            new KoinDefinition(module, singleInstanceFactory18);
            AnonymousClass10 anonymousClass10 = new Function2<Scope, ParametersHolder, DownloadDAO>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.10
                @Override // kotlin.jvm.functions.Function2
                public final DownloadDAO invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).downloadDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory19 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(DownloadDAO.class), null, anonymousClass10, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory20 = singleInstanceFactory19;
            module.indexPrimaryType(singleInstanceFactory20);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory19);
            }
            new KoinDefinition(module, singleInstanceFactory20);
            AnonymousClass11 anonymousClass11 = new Function2<Scope, ParametersHolder, RemoteLogsDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.11
                @Override // kotlin.jvm.functions.Function2
                public final RemoteLogsDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).remoteLogsDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory21 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RemoteLogsDao.class), null, anonymousClass11, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory22 = singleInstanceFactory21;
            module.indexPrimaryType(singleInstanceFactory22);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory21);
            }
            new KoinDefinition(module, singleInstanceFactory22);
            AnonymousClass12 anonymousClass12 = new Function2<Scope, ParametersHolder, SupportContactDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.12
                @Override // kotlin.jvm.functions.Function2
                public final SupportContactDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).supportContactDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory23 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SupportContactDao.class), null, anonymousClass12, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory24 = singleInstanceFactory23;
            module.indexPrimaryType(singleInstanceFactory24);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory23);
            }
            new KoinDefinition(module, singleInstanceFactory24);
            AnonymousClass13 anonymousClass13 = new Function2<Scope, ParametersHolder, LockGateDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.13
                @Override // kotlin.jvm.functions.Function2
                public final LockGateDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).lockGateDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory25 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LockGateDao.class), null, anonymousClass13, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory26 = singleInstanceFactory25;
            module.indexPrimaryType(singleInstanceFactory26);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory25);
            }
            new KoinDefinition(module, singleInstanceFactory26);
            AnonymousClass14 anonymousClass14 = new Function2<Scope, ParametersHolder, AdvBottomSheetDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.14
                @Override // kotlin.jvm.functions.Function2
                public final AdvBottomSheetDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).advBottomSheetDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory27 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AdvBottomSheetDao.class), null, anonymousClass14, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory28 = singleInstanceFactory27;
            module.indexPrimaryType(singleInstanceFactory28);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory27);
            }
            new KoinDefinition(module, singleInstanceFactory28);
            AnonymousClass15 anonymousClass15 = new Function2<Scope, ParametersHolder, GateEventDao>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.15
                @Override // kotlin.jvm.functions.Function2
                public final GateEventDao invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((IntercomDatabase) single.get(Reflection.getOrCreateKotlinClass(IntercomDatabase.class), null, null)).gateEventDao();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory29 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GateEventDao.class), null, anonymousClass15, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory30 = singleInstanceFactory29;
            module.indexPrimaryType(singleInstanceFactory30);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory29);
            }
            new KoinDefinition(module, singleInstanceFactory30);
            AnonymousClass16 anonymousClass16 = new Function2<Scope, ParametersHolder, TutorialPrefsSource>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.16
                @Override // kotlin.jvm.functions.Function2
                public final TutorialPrefsSource invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new TutorialPrefsSource(ModuleExtKt.androidContext(single));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory31 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TutorialPrefsSource.class), null, anonymousClass16, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory32 = singleInstanceFactory31;
            module.indexPrimaryType(singleInstanceFactory32);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory31);
            }
            new KoinDefinition(module, singleInstanceFactory32);
            AnonymousClass17 anonymousClass17 = new Function2<Scope, ParametersHolder, UserPrefsSource>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.17
                @Override // kotlin.jvm.functions.Function2
                public final UserPrefsSource invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new UserPrefsSource(ModuleExtKt.androidContext(single));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory33 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, anonymousClass17, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory34 = singleInstanceFactory33;
            module.indexPrimaryType(singleInstanceFactory34);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory33);
            }
            new KoinDefinition(module, singleInstanceFactory34);
            AnonymousClass18 anonymousClass18 = new Function2<Scope, ParametersHolder, PushPrefsSource>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.18
                @Override // kotlin.jvm.functions.Function2
                public final PushPrefsSource invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new PushPrefsSource(ModuleExtKt.androidContext(single));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory35 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PushPrefsSource.class), null, anonymousClass18, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory36 = singleInstanceFactory35;
            module.indexPrimaryType(singleInstanceFactory36);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory35);
            }
            new KoinDefinition(module, singleInstanceFactory36);
            AnonymousClass19 anonymousClass19 = new Function2<Scope, ParametersHolder, RemoteConfigPrefsSource>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.19
                @Override // kotlin.jvm.functions.Function2
                public final RemoteConfigPrefsSource invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new RemoteConfigPrefsSource(ModuleExtKt.androidContext(single));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory37 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(RemoteConfigPrefsSource.class), null, anonymousClass19, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory38 = singleInstanceFactory37;
            module.indexPrimaryType(singleInstanceFactory38);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory37);
            }
            new KoinDefinition(module, singleInstanceFactory38);
            AnonymousClass20 anonymousClass20 = new Function2<Scope, ParametersHolder, SupportPrefsSource>() { // from class: ru.tattelecom.intercom.ModulesKt$localSourceModule$1.20
                @Override // kotlin.jvm.functions.Function2
                public final SupportPrefsSource invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SupportPrefsSource(ModuleExtKt.androidContext(single));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory39 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SupportPrefsSource.class), null, anonymousClass20, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory40 = singleInstanceFactory39;
            module.indexPrimaryType(singleInstanceFactory40);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory39);
            }
            new KoinDefinition(module, singleInstanceFactory40);
        }
    }, 1, null);
    private static final Module remoteSourceModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            final Mutex Mutex$default = MutexKt.Mutex$default(false, 1, null);
            Function2<Scope, ParametersHolder, HttpClient> function2 = new Function2<Scope, ParametersHolder, HttpClient>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.1
                {
                    super(2);
                }

                /* compiled from: Modules.kt */
                @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1$1$1", f = "Modules.kt", i = {0, 0, 1, 1}, l = {284, 247, 251}, m = "invokeSuspend", n = {"isSignedIn", "$this$withLock_u24default$iv", "isSignedIn", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
                /* renamed from: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1$1$1, reason: invalid class name and collision with other inner class name */
                static final class C01021 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                    final /* synthetic */ Mutex $signOutMutex;
                    final /* synthetic */ Scope $this_factory;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01021(Mutex mutex, Scope scope, Continuation<? super C01021> continuation) {
                        super(1, continuation);
                        this.$signOutMutex = mutex;
                        this.$this_factory = scope;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new C01021(this.$signOutMutex, this.$this_factory, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super Unit> continuation) {
                        return ((C01021) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                        /*
                            r9 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r9.label
                            r2 = 3
                            r3 = 2
                            r4 = 1
                            r5 = 0
                            if (r1 == 0) goto L40
                            if (r1 == r4) goto L2f
                            if (r1 == r3) goto L1f
                            if (r1 != r2) goto L17
                            kotlin.ResultKt.throwOnFailure(r10)
                            goto Lc4
                        L17:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r0)
                            throw r10
                        L1f:
                            java.lang.Object r1 = r9.L$1
                            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
                            java.lang.Object r3 = r9.L$0
                            kotlin.jvm.internal.Ref$BooleanRef r3 = (kotlin.jvm.internal.Ref.BooleanRef) r3
                            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L2c
                            goto L9c
                        L2c:
                            r10 = move-exception
                            goto Lc9
                        L2f:
                            java.lang.Object r1 = r9.L$2
                            org.koin.core.scope.Scope r1 = (org.koin.core.scope.Scope) r1
                            java.lang.Object r6 = r9.L$1
                            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
                            java.lang.Object r7 = r9.L$0
                            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
                            kotlin.ResultKt.throwOnFailure(r10)
                            r10 = r7
                            goto L61
                        L40:
                            kotlin.ResultKt.throwOnFailure(r10)
                            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef
                            r10.<init>()
                            kotlinx.coroutines.sync.Mutex r1 = r9.$signOutMutex
                            org.koin.core.scope.Scope r6 = r9.$this_factory
                            r7 = r9
                            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                            r9.L$0 = r10
                            r9.L$1 = r1
                            r9.L$2 = r6
                            r9.label = r4
                            java.lang.Object r7 = r1.lock(r5, r7)
                            if (r7 != r0) goto L5e
                            return r0
                        L5e:
                            r8 = r6
                            r6 = r1
                            r1 = r8
                        L61:
                            java.lang.Class<ru.tattelecom.intercom.domain.interactors.UserInteractor> r7 = ru.tattelecom.intercom.domain.interactors.UserInteractor.class
                            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)     // Catch: java.lang.Throwable -> Lc7
                            java.lang.Object r7 = r1.get(r7, r5, r5)     // Catch: java.lang.Throwable -> Lc7
                            ru.tattelecom.intercom.domain.interactors.UserInteractor r7 = (ru.tattelecom.intercom.domain.interactors.UserInteractor) r7     // Catch: java.lang.Throwable -> Lc7
                            java.lang.String r7 = r7.getToken()     // Catch: java.lang.Throwable -> Lc7
                            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch: java.lang.Throwable -> Lc7
                            if (r7 == 0) goto L7d
                            int r7 = r7.length()     // Catch: java.lang.Throwable -> Lc7
                            if (r7 != 0) goto L7c
                            goto L7d
                        L7c:
                            r4 = 0
                        L7d:
                            r10.element = r4     // Catch: java.lang.Throwable -> Lc7
                            java.lang.Class<ru.tattelecom.intercom.domain.interactors.SignOutInteractor> r4 = ru.tattelecom.intercom.domain.interactors.SignOutInteractor.class
                            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)     // Catch: java.lang.Throwable -> Lc7
                            java.lang.Object r1 = r1.get(r4, r5, r5)     // Catch: java.lang.Throwable -> Lc7
                            ru.tattelecom.intercom.domain.interactors.SignOutInteractor r1 = (ru.tattelecom.intercom.domain.interactors.SignOutInteractor) r1     // Catch: java.lang.Throwable -> Lc7
                            r9.L$0 = r10     // Catch: java.lang.Throwable -> Lc7
                            r9.L$1 = r6     // Catch: java.lang.Throwable -> Lc7
                            r9.L$2 = r5     // Catch: java.lang.Throwable -> Lc7
                            r9.label = r3     // Catch: java.lang.Throwable -> Lc7
                            java.lang.Object r1 = r1.signOut(r9)     // Catch: java.lang.Throwable -> Lc7
                            if (r1 != r0) goto L9a
                            return r0
                        L9a:
                            r3 = r10
                            r1 = r6
                        L9c:
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2c
                            r1.unlock(r5)
                            boolean r10 = r3.element
                            if (r10 != 0) goto Lc4
                            kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()
                            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
                            ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1$1$1$2 r1 = new ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1$1$1$2
                            org.koin.core.scope.Scope r3 = r9.$this_factory
                            r1.<init>(r3, r5)
                            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                            r3 = r9
                            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                            r9.L$0 = r5
                            r9.L$1 = r5
                            r9.label = r2
                            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r3)
                            if (r10 != r0) goto Lc4
                            return r0
                        Lc4:
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                            return r10
                        Lc7:
                            r10 = move-exception
                            r1 = r6
                        Lc9:
                            r1.unlock(r5)
                            throw r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.AnonymousClass1.C01021.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    /* compiled from: Modules.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1$1$1$2", f = "Modules.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1$1$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Scope $this_factory;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(Scope scope, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$this_factory = scope;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$this_factory, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            Toast.makeText(ModuleExtKt.androidApplication(this.$this_factory), ModuleExtKt.androidApplication(this.$this_factory).getString(R.string.unauthorized_message), 1).show();
                            return Unit.INSTANCE;
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public final HttpClient invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new KtorConfig((UserPrefsSource) factory.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), new C01021(Mutex.this, factory, null)).getClient();
                }
            };
            FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(HttpClient.class), null, function2, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory);
            new KoinDefinition(module, factoryInstanceFactory);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, ExternalKtorConfig>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.2
                @Override // kotlin.jvm.functions.Function2
                public final ExternalKtorConfig invoke(Scope factory, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(factory, "$this$factory");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ExternalKtorConfig();
                }
            };
            FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ExternalKtorConfig.class), null, anonymousClass2, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory2);
            new KoinDefinition(module, factoryInstanceFactory2);
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, AuthRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.3
                @Override // kotlin.jvm.functions.Function2
                public final AuthRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new AuthRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AuthRemote.class), null, anonymousClass3, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
            AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, ConfigRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.4
                @Override // kotlin.jvm.functions.Function2
                public final ConfigRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ConfigRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ConfigRemote.class), null, anonymousClass4, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory4 = singleInstanceFactory3;
            module.indexPrimaryType(singleInstanceFactory4);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory3);
            }
            new KoinDefinition(module, singleInstanceFactory4);
            AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, SupportRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.5
                @Override // kotlin.jvm.functions.Function2
                public final SupportRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SupportRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SupportRemote.class), null, anonymousClass5, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory6 = singleInstanceFactory5;
            module.indexPrimaryType(singleInstanceFactory6);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory5);
            }
            new KoinDefinition(module, singleInstanceFactory6);
            AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, AdvRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.6
                @Override // kotlin.jvm.functions.Function2
                public final AdvRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new AdvRemoteImpl((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory7 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AdvRemote.class), null, anonymousClass6, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory8 = singleInstanceFactory7;
            module.indexPrimaryType(singleInstanceFactory8);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory7);
            }
            new KoinDefinition(module, singleInstanceFactory8);
            AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, EventHistoryRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.7
                @Override // kotlin.jvm.functions.Function2
                public final EventHistoryRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new EventHistoryRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null), (UserPrefsSource) single.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory9 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EventHistoryRemote.class), null, anonymousClass7, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory10 = singleInstanceFactory9;
            module.indexPrimaryType(singleInstanceFactory10);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory9);
            }
            new KoinDefinition(module, singleInstanceFactory10);
            AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, GateRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.8
                @Override // kotlin.jvm.functions.Function2
                public final GateRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new GateRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory11 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GateRemote.class), null, anonymousClass8, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory12 = singleInstanceFactory11;
            module.indexPrimaryType(singleInstanceFactory12);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory11);
            }
            new KoinDefinition(module, singleInstanceFactory12);
            AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, GuestRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.9
                @Override // kotlin.jvm.functions.Function2
                public final GuestRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new GuestRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null), (UserPrefsSource) single.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory13 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GuestRemote.class), null, anonymousClass9, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory14 = singleInstanceFactory13;
            module.indexPrimaryType(singleInstanceFactory14);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory13);
            }
            new KoinDefinition(module, singleInstanceFactory14);
            AnonymousClass10 anonymousClass10 = new Function2<Scope, ParametersHolder, IntercomRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.10
                @Override // kotlin.jvm.functions.Function2
                public final IntercomRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new IntercomRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null), (UserPrefsSource) single.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory15 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(IntercomRemote.class), null, anonymousClass10, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory16 = singleInstanceFactory15;
            module.indexPrimaryType(singleInstanceFactory16);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory15);
            }
            new KoinDefinition(module, singleInstanceFactory16);
            AnonymousClass11 anonymousClass11 = new Function2<Scope, ParametersHolder, LeadRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.11
                @Override // kotlin.jvm.functions.Function2
                public final LeadRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new LeadRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory17 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LeadRemote.class), null, anonymousClass11, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory18 = singleInstanceFactory17;
            module.indexPrimaryType(singleInstanceFactory18);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory17);
            }
            new KoinDefinition(module, singleInstanceFactory18);
            AnonymousClass12 anonymousClass12 = new Function2<Scope, ParametersHolder, OfficeMapRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.12
                @Override // kotlin.jvm.functions.Function2
                public final OfficeMapRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new OfficeMapRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory19 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OfficeMapRemote.class), null, anonymousClass12, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory20 = singleInstanceFactory19;
            module.indexPrimaryType(singleInstanceFactory20);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory19);
            }
            new KoinDefinition(module, singleInstanceFactory20);
            AnonymousClass13 anonymousClass13 = new Function2<Scope, ParametersHolder, PushRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.13
                @Override // kotlin.jvm.functions.Function2
                public final PushRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new PushRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory21 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PushRemote.class), null, anonymousClass13, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory22 = singleInstanceFactory21;
            module.indexPrimaryType(singleInstanceFactory22);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory21);
            }
            new KoinDefinition(module, singleInstanceFactory22);
            AnonymousClass14 anonymousClass14 = new Function2<Scope, ParametersHolder, LogRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.14
                @Override // kotlin.jvm.functions.Function2
                public final LogRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new LogRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory23 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(LogRemote.class), null, anonymousClass14, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory24 = singleInstanceFactory23;
            module.indexPrimaryType(singleInstanceFactory24);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory23);
            }
            new KoinDefinition(module, singleInstanceFactory24);
            AnonymousClass15 anonymousClass15 = new Function2<Scope, ParametersHolder, StreamRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.15
                @Override // kotlin.jvm.functions.Function2
                public final StreamRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new StreamRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null), (UserPrefsSource) single.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), null, null), (ExternalKtorConfig) single.get(Reflection.getOrCreateKotlinClass(ExternalKtorConfig.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory25 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(StreamRemote.class), null, anonymousClass15, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory26 = singleInstanceFactory25;
            module.indexPrimaryType(singleInstanceFactory26);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory25);
            }
            new KoinDefinition(module, singleInstanceFactory26);
            AnonymousClass16 anonymousClass16 = new Function2<Scope, ParametersHolder, ReaderRemote>() { // from class: ru.tattelecom.intercom.ModulesKt$remoteSourceModule$1.16
                @Override // kotlin.jvm.functions.Function2
                public final ReaderRemote invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new ReaderRemote((HttpClient) single.get(Reflection.getOrCreateKotlinClass(HttpClient.class), null, null));
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory27 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ReaderRemote.class), null, anonymousClass16, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory28 = singleInstanceFactory27;
            module.indexPrimaryType(singleInstanceFactory28);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory27);
            }
            new KoinDefinition(module, singleInstanceFactory28);
        }
    }, 1, null);

    public static final Module getViewModelModule() {
        return viewModelModule;
    }

    public static final Module getInteractorModule() {
        return interactorModule;
    }

    public static final Module getDispatchersModule() {
        return dispatchersModule;
    }

    public static final Module getRemoteLoggerModule() {
        return remoteLoggerModule;
    }

    public static final Module getLocalSourceModule() {
        return localSourceModule;
    }

    public static final Module getRemoteSourceModule() {
        return remoteSourceModule;
    }
}
