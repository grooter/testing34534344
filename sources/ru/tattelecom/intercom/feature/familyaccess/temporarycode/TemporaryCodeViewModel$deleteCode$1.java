package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TemporaryCodeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$deleteCode$1", f = "TemporaryCodeViewModel.kt", i = {}, l = {65, 66, 81}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class TemporaryCodeViewModel$deleteCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TemporaryCodeItem $apartment;
    int label;
    final /* synthetic */ TemporaryCodeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TemporaryCodeViewModel$deleteCode$1(TemporaryCodeViewModel temporaryCodeViewModel, TemporaryCodeItem temporaryCodeItem, Continuation<? super TemporaryCodeViewModel$deleteCode$1> continuation) {
        super(2, continuation);
        this.this$0 = temporaryCodeViewModel;
        this.$apartment = temporaryCodeItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemporaryCodeViewModel$deleteCode$1(this.this$0, this.$apartment, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TemporaryCodeViewModel$deleteCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008d A[Catch: Exception -> 0x00a3, TryCatch #0 {Exception -> 0x00a3, blocks: (B:13:0x001f, B:14:0x0079, B:16:0x008d, B:17:0x009f, B:19:0x0023, B:20:0x0042, B:22:0x0046, B:24:0x0056, B:29:0x002a), top: B:2:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L27
            if (r1 == r5) goto L23
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lbe
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> La3
            goto L79
        L23:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> La3
            goto L42
        L27:
            kotlin.ResultKt.throwOnFailure(r12)
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel r12 = r11.this$0     // Catch: java.lang.Exception -> La3
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor r12 = ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel.access$getFamilyAccessInteractor$p(r12)     // Catch: java.lang.Exception -> La3
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeItem r1 = r11.$apartment     // Catch: java.lang.Exception -> La3
            int r1 = r1.getApartmentId()     // Catch: java.lang.Exception -> La3
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> La3
            r11.label = r5     // Catch: java.lang.Exception -> La3
            java.lang.Object r12 = r12.deleteTemporaryCode(r1, r6)     // Catch: java.lang.Exception -> La3
            if (r12 != r0) goto L42
            return r0
        L42:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r12 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r12     // Catch: java.lang.Exception -> La3
            if (r12 == 0) goto L53
            java.lang.Boolean r12 = r12.isSuccess()     // Catch: java.lang.Exception -> La3
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Exception -> La3
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r1)     // Catch: java.lang.Exception -> La3
            goto L54
        L53:
            r12 = 0
        L54:
            if (r12 == 0) goto Lbe
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel r12 = r11.this$0     // Catch: java.lang.Exception -> La3
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor r12 = ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel.access$getFamilyAccessInteractor$p(r12)     // Catch: java.lang.Exception -> La3
            ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity r1 = new ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity     // Catch: java.lang.Exception -> La3
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeItem r5 = r11.$apartment     // Catch: java.lang.Exception -> La3
            int r5 = r5.getApartmentId()     // Catch: java.lang.Exception -> La3
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeItem r6 = r11.$apartment     // Catch: java.lang.Exception -> La3
            java.lang.String r6 = r6.getAddress()     // Catch: java.lang.Exception -> La3
            r1.<init>(r5, r6, r2)     // Catch: java.lang.Exception -> La3
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> La3
            r11.label = r4     // Catch: java.lang.Exception -> La3
            java.lang.Object r12 = r12.addTemporaryCode(r1, r5)     // Catch: java.lang.Exception -> La3
            if (r12 != r0) goto L79
            return r0
        L79:
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel r12 = r11.this$0     // Catch: java.lang.Exception -> La3
            kotlinx.coroutines.flow.MutableStateFlow r12 = ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel.access$get_apartmentsTemporaryCode$p(r12)     // Catch: java.lang.Exception -> La3
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel r1 = r11.this$0     // Catch: java.lang.Exception -> La3
            kotlinx.coroutines.flow.MutableStateFlow r1 = ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel.access$get_apartmentsTemporaryCode$p(r1)     // Catch: java.lang.Exception -> La3
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Exception -> La3
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Exception -> La3
            if (r1 == 0) goto L9f
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeItem r2 = r11.$apartment     // Catch: java.lang.Exception -> La3
            r9 = 11
            r10 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r2
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeItem r4 = ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeItem.copy$default(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> La3
            java.util.List r2 = ru.tattelecom.intercom.android.resources.ExtensionsKt.mapButReplace(r1, r2, r4)     // Catch: java.lang.Exception -> La3
        L9f:
            r12.setValue(r2)     // Catch: java.lang.Exception -> La3
            goto Lbe
        La3:
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel r12 = r11.this$0
            r1 = 84
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel.access$reportEvent(r12, r1)
            ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel r12 = r11.this$0
            kotlinx.coroutines.channels.Channel r12 = ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel.access$get_eventShowErrorDialog$p(r12)
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.label = r3
            java.lang.String r2 = "deleteError"
            java.lang.Object r12 = r12.send(r2, r1)
            if (r12 != r0) goto Lbe
            return r0
        Lbe:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$deleteCode$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
