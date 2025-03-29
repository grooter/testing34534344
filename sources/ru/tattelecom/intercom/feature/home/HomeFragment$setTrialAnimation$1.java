package ru.tattelecom.intercom.feature.home;

import android.widget.TextView;
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

/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$setTrialAnimation$1", f = "HomeFragment.kt", i = {}, l = {693}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeFragment$setTrialAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextView $this_setTrialAnimation;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$setTrialAnimation$1(HomeFragment homeFragment, TextView textView, Continuation<? super HomeFragment$setTrialAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
        this.$this_setTrialAnimation = textView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$setTrialAnimation$1(this.this$0, this.$this_setTrialAnimation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$setTrialAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$setTrialAnimation$1$1", f = "HomeFragment.kt", i = {}, l = {695, 700, 705}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.home.HomeFragment$setTrialAnimation$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $this_setTrialAnimation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextView textView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_setTrialAnimation = textView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_setTrialAnimation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0081 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x007f -> B:12:0x0027). Please report as a decompilation issue!!! */
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
                r5 = 450(0x1c2, double:2.223E-321)
                if (r1 == 0) goto L24
                if (r1 == r4) goto L20
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                goto L24
            L14:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1c:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L5d
            L20:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L35
            L24:
                kotlin.ResultKt.throwOnFailure(r10)
            L27:
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r9.label = r4
                r7 = 2320(0x910, double:1.146E-320)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r7, r10)
                if (r10 != r0) goto L35
                return r0
            L35:
                android.widget.TextView r10 = r9.$this_setTrialAnimation
                android.view.ViewPropertyAnimator r10 = r10.animate()
                r1 = 1065353216(0x3f800000, float:1.0)
                android.view.ViewPropertyAnimator r10 = r10.alpha(r1)
                android.view.animation.LinearInterpolator r1 = new android.view.animation.LinearInterpolator
                r1.<init>()
                android.animation.TimeInterpolator r1 = (android.animation.TimeInterpolator) r1
                android.view.ViewPropertyAnimator r10 = r10.setInterpolator(r1)
                r10.setDuration(r5)
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r9.label = r3
                r7 = 4450(0x1162, double:2.1986E-320)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r7, r10)
                if (r10 != r0) goto L5d
                return r0
            L5d:
                android.widget.TextView r10 = r9.$this_setTrialAnimation
                android.view.ViewPropertyAnimator r10 = r10.animate()
                r1 = 0
                android.view.ViewPropertyAnimator r10 = r10.alpha(r1)
                android.view.animation.LinearInterpolator r1 = new android.view.animation.LinearInterpolator
                r1.<init>()
                android.animation.TimeInterpolator r1 = (android.animation.TimeInterpolator) r1
                android.view.ViewPropertyAnimator r10 = r10.setInterpolator(r1)
                r10.setDuration(r5)
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r9.label = r2
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r10)
                if (r10 != r0) goto L27
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeFragment$setTrialAnimation$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.$this_setTrialAnimation, null), this) == coroutine_suspended) {
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
