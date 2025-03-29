package ru.tattelecom.intercom.feature.home;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.domain.model.AdvBottomSheetDataDto;
import ru.tattelecom.intercom.domain.model.AdvBottomSheetDto;
import ru.tattelecom.intercom.domain.model.DefaultThemeDto;
import ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog$setUi$1;
import ru.tattelecom.intercom.feature.home.databinding.DialogHomeBottomSheetBinding;

/* compiled from: HomeBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog$setUi$1", f = "HomeBottomSheetDialog.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeBottomSheetDialog$setUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeBottomSheetDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeBottomSheetDialog$setUi$1(HomeBottomSheetDialog homeBottomSheetDialog, Continuation<? super HomeBottomSheetDialog$setUi$1> continuation) {
        super(2, continuation);
        this.this$0 = homeBottomSheetDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeBottomSheetDialog$setUi$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeBottomSheetDialog$setUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: HomeBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog$setUi$1$1", f = "HomeBottomSheetDialog.kt", i = {}, l = {57, 66}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog$setUi$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HomeBottomSheetDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HomeBottomSheetDialog homeBottomSheetDialog, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = homeBottomSheetDialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AdvBottomSheetDesignTheme advBottomSheetDesignTheme;
            HomeBottomSheetViewModel viewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if ((this.this$0.getResources().getConfiguration().uiMode & 48) == 32) {
                    advBottomSheetDesignTheme = AdvBottomSheetDesignTheme.DARK;
                } else {
                    advBottomSheetDesignTheme = AdvBottomSheetDesignTheme.LIGHT;
                }
                Resources.Theme theme = this.this$0.requireActivity().getTheme();
                viewModel = this.this$0.getViewModel();
                this.label = 1;
                obj = viewModel.getAdv(advBottomSheetDesignTheme, new DefaultThemeDto(this.this$0.getResources().getColor(R.color.octavus, theme), this.this$0.getResources().getColor(R.color.octavus, theme), this.this$0.getResources().getColor(R.color.bottom_sheet_text_color, theme), this.this$0.getResources().getColor(R.color.bottom_sheet_text_color, theme), this.this$0.getResources().getColor(R.color.bottom_sheet_bottom_color, theme)), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (((Flow) obj).collect(new C01071(this.this$0), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* compiled from: HomeBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "advDto", "Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;", "emit", "(Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog$setUi$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01071<T> implements FlowCollector {
            final /* synthetic */ HomeBottomSheetDialog this$0;

            C01071(HomeBottomSheetDialog homeBottomSheetDialog) {
                this.this$0 = homeBottomSheetDialog;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((AdvBottomSheetDto) obj, (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final AdvBottomSheetDto advBottomSheetDto, Continuation<? super Unit> continuation) {
                DialogHomeBottomSheetBinding binding;
                Integer num;
                int gravity;
                int gravity2;
                HomeBottomSheetViewModel viewModel;
                if (advBottomSheetDto != null) {
                    final HomeBottomSheetDialog homeBottomSheetDialog = this.this$0;
                    if (!advBottomSheetDto.isRead()) {
                        viewModel = homeBottomSheetDialog.getViewModel();
                        viewModel.setAdvRead(advBottomSheetDto.getId());
                    }
                    binding = homeBottomSheetDialog.getBinding();
                    TextView textView = binding.tvTitle;
                    textView.setText(advBottomSheetDto.getTitle());
                    textView.setTextColor(advBottomSheetDto.getTitleColor());
                    String titleAlign = advBottomSheetDto.getTitleAlign();
                    Integer num2 = null;
                    if (titleAlign != null) {
                        gravity2 = homeBottomSheetDialog.toGravity(titleAlign);
                        num = Boxing.boxInt(gravity2);
                    } else {
                        num = null;
                    }
                    int i = GravityCompat.START;
                    textView.setGravity(num != null ? num.intValue() : 8388611);
                    TextView textView2 = binding.tvDescription;
                    Intrinsics.checkNotNull(textView2);
                    TextView textView3 = textView2;
                    textView3.setVisibility(8);
                    textView2.setText(advBottomSheetDto.getDescription());
                    textView2.setTextColor(advBottomSheetDto.getDescriptionColor());
                    textView3.setVisibility(0);
                    String descriptionAlign = advBottomSheetDto.getDescriptionAlign();
                    if (descriptionAlign != null) {
                        gravity = homeBottomSheetDialog.toGravity(descriptionAlign);
                        num2 = Boxing.boxInt(gravity);
                    }
                    if (num2 != null) {
                        i = num2.intValue();
                    }
                    textView2.setGravity(i);
                    MaterialButton materialButton = binding.button;
                    materialButton.setTextColor(advBottomSheetDto.getButtonTextColor());
                    materialButton.setText(advBottomSheetDto.getButtonText());
                    materialButton.setBackgroundColor(advBottomSheetDto.getButtonBackgroundColor());
                    Intrinsics.checkNotNull(materialButton);
                    materialButton.setVisibility(0);
                    ImageView imageView = binding.ivAdvImage;
                    imageView.setClipToOutline(true);
                    Glide.with(binding.getRoot().getContext()).load(Base64.decode(advBottomSheetDto.getImage(), 0)).into(imageView);
                    binding.vContentBg.getBackground().setTint(advBottomSheetDto.getBackgroundColor());
                    binding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog$setUi$1$1$1$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeBottomSheetDialog$setUi$1.AnonymousClass1.C01071.emit$lambda$9$lambda$8$lambda$6(HomeBottomSheetDialog.this, view);
                        }
                    });
                    binding.button.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog$setUi$1$1$1$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeBottomSheetDialog$setUi$1.AnonymousClass1.C01071.emit$lambda$9$lambda$8$lambda$7(AdvBottomSheetDto.this, homeBottomSheetDialog, advBottomSheetDto, view);
                        }
                    });
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$9$lambda$8$lambda$6(HomeBottomSheetDialog this$0, View view) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                FragmentKt.findNavController(this$0).navigateUp();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$9$lambda$8$lambda$7(AdvBottomSheetDto theme, HomeBottomSheetDialog this$0, AdvBottomSheetDto advBottomSheetDto, View view) {
                HomeBottomSheetViewModel viewModel;
                Intrinsics.checkNotNullParameter(theme, "$theme");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                String type = theme.getType();
                if (Intrinsics.areEqual(type, "url")) {
                    try {
                        AdvBottomSheetDataDto typeData = theme.getTypeData();
                        this$0.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(typeData != null ? typeData.getUrl() : null)));
                        return;
                    } catch (Throwable unused) {
                        FragmentKt.findNavController(this$0).navigateUp();
                        return;
                    }
                }
                if (Intrinsics.areEqual(type, "screen")) {
                    viewModel = this$0.getViewModel();
                    viewModel.reportEventAdv(103, advBottomSheetDto.getId());
                    NavController findNavController = FragmentKt.findNavController(this$0);
                    AdvBottomSheetDataDto typeData2 = theme.getTypeData();
                    int toConnectServices = Intrinsics.areEqual(typeData2 != null ? typeData2.getScreen() : null, "leave_order") ? NavGraphDestinations.Action.INSTANCE.getToConnectServices() : NavGraphDestinations.Action.INSTANCE.getToConnectServices();
                    Pair[] pairArr = new Pair[3];
                    pairArr[0] = TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getHomeBottomSheet()));
                    pairArr[1] = TuplesKt.to(NavArg.ENTITY_ID, Long.valueOf(advBottomSheetDto.getId()));
                    AdvBottomSheetDataDto typeData3 = theme.getTypeData();
                    pairArr[2] = TuplesKt.to(NavArg.SELECTED_SERVICES, typeData3 != null ? typeData3.getSelectedServices() : null);
                    NavExtKt.navigateSafe$default(findNavController, toConnectServices, BundleKt.bundleOf(pairArr), null, 4, null);
                    return;
                }
                FragmentKt.findNavController(this$0).navigateUp();
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
