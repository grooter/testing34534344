package ru.tattelecom.intercom.feature.profile;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.feature.profile.databinding.FragmentProfileBinding;

/* compiled from: ProfileFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.profile.ProfileFragment$setUi$1$11", f = "ProfileFragment.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class ProfileFragment$setUi$1$11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentProfileBinding $this_apply;
    int label;
    final /* synthetic */ ProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileFragment$setUi$1$11(ProfileFragment profileFragment, FragmentProfileBinding fragmentProfileBinding, Continuation<? super ProfileFragment$setUi$1$11> continuation) {
        super(2, continuation);
        this.this$0 = profileFragment;
        this.$this_apply = fragmentProfileBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileFragment$setUi$1$11(this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileFragment$setUi$1$11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: ProfileFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.profile.ProfileFragment$setUi$1$11$1", f = "ProfileFragment.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.profile.ProfileFragment$setUi$1$11$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentProfileBinding $this_apply;
        int label;
        final /* synthetic */ ProfileFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProfileFragment profileFragment, FragmentProfileBinding fragmentProfileBinding, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = profileFragment;
            this.$this_apply = fragmentProfileBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$this_apply, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:5:0x0028). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r6)
                goto L28
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                kotlin.ResultKt.throwOnFailure(r6)
            L1a:
                r6 = r5
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r5.label = r2
                r3 = 50
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
                if (r6 != r0) goto L28
                return r0
            L28:
                ru.tattelecom.intercom.feature.profile.ProfileFragment r6 = r5.this$0
                ru.tattelecom.intercom.android.resources.SupportViewModel r6 = ru.tattelecom.intercom.feature.profile.ProfileFragment.access$getSupportViewModel(r6)
                boolean r6 = r6.getIsChatClicked()
                if (r6 != 0) goto L95
                ru.tattelecom.intercom.feature.profile.ProfileFragment r6 = r5.this$0
                ru.tattelecom.intercom.android.resources.SupportViewModel r6 = ru.tattelecom.intercom.feature.profile.ProfileFragment.access$getSupportViewModel(r6)
                kotlinx.coroutines.flow.StateFlow r6 = r6.isLoading()
                java.lang.Object r6 = r6.getValue()
                r1 = 0
                java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r3)
                if (r6 == 0) goto L1a
                ru.tattelecom.intercom.feature.profile.ProfileFragment r6 = r5.this$0
                ru.tattelecom.intercom.android.resources.SupportViewModel r6 = ru.tattelecom.intercom.feature.profile.ProfileFragment.access$getSupportViewModel(r6)
                boolean r6 = r6.getIsChatClicked()
                if (r6 != 0) goto L1a
                ru.tattelecom.intercom.feature.profile.ProfileFragment r6 = r5.this$0
                ru.tattelecom.intercom.android.resources.SupportViewModel r6 = ru.tattelecom.intercom.feature.profile.ProfileFragment.access$getSupportViewModel(r6)
                r6.setChatClicked(r2)
                ru.tattelecom.intercom.feature.profile.ProfileFragment r6 = r5.this$0
                ru.tattelecom.intercom.android.resources.SupportViewModel r6 = ru.tattelecom.intercom.feature.profile.ProfileFragment.access$getSupportViewModel(r6)
                kotlinx.coroutines.flow.StateFlow r6 = r6.getSupportContacts()
                java.lang.Object r6 = r6.getValue()
                ru.tattelecom.intercom.domain.model.SupportContactDto r6 = (ru.tattelecom.intercom.domain.model.SupportContactDto) r6
                if (r6 == 0) goto L8c
                java.util.List r6 = r6.getContacts()
                if (r6 == 0) goto L8c
                ru.tattelecom.intercom.domain.model.SupportContactDto$Type r0 = ru.tattelecom.intercom.domain.model.SupportContactDto.Type.CHAT
                ru.tattelecom.intercom.domain.model.SupportContactDto$Item r6 = ru.tattelecom.intercom.domain.model.SupportDtosKt.getContact(r6, r0)
                if (r6 == 0) goto L8c
                java.lang.Boolean r6 = r6.isEnabled()
                if (r6 == 0) goto L8c
                boolean r1 = r6.booleanValue()
            L8c:
                if (r1 == 0) goto L95
                ru.tattelecom.intercom.feature.profile.databinding.FragmentProfileBinding r6 = r5.$this_apply
                ru.tattelecom.intercom.android.resources.customview.SupportContactView r6 = r6.cvSupport
                r6.performChatClick()
            L95:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.profile.ProfileFragment$setUi$1$11.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0, Lifecycle.State.CREATED, new AnonymousClass1(this.this$0, this.$this_apply, null), this) == coroutine_suspended) {
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
