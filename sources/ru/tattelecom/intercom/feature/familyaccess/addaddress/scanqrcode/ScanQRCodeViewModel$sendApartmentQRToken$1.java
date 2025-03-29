package ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import ru.tattelecom.intercom.domain.interactors.AddressInteractor;

/* compiled from: ScanQRCodeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1", f = "ScanQRCodeViewModel.kt", i = {0}, l = {30, 36, 38}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class ScanQRCodeViewModel$sendApartmentQRToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apartmentToken;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScanQRCodeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScanQRCodeViewModel$sendApartmentQRToken$1(String str, ScanQRCodeViewModel scanQRCodeViewModel, Continuation<? super ScanQRCodeViewModel$sendApartmentQRToken$1> continuation) {
        super(2, continuation);
        this.$apartmentToken = str;
        this.this$0 = scanQRCodeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScanQRCodeViewModel$sendApartmentQRToken$1 scanQRCodeViewModel$sendApartmentQRToken$1 = new ScanQRCodeViewModel$sendApartmentQRToken$1(this.$apartmentToken, this.this$0, continuation);
        scanQRCodeViewModel$sendApartmentQRToken$1.L$0 = obj;
        return scanQRCodeViewModel$sendApartmentQRToken$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScanQRCodeViewModel$sendApartmentQRToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2a
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.throwOnFailure(r13)
            goto L87
        L16:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1e:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L71
            goto L87
        L22:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L71
            goto L47
        L2a:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.String r13 = r12.$apartmentToken     // Catch: java.lang.Exception -> L71
            if (r13 == 0) goto L49
            ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel r6 = r12.this$0     // Catch: java.lang.Exception -> L71
            ru.tattelecom.intercom.domain.interactors.AuthInteractor r6 = ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel.access$getAuthInteractor$p(r6)     // Catch: java.lang.Exception -> L71
            r12.L$0 = r1     // Catch: java.lang.Exception -> L71
            r12.label = r4     // Catch: java.lang.Exception -> L71
            java.lang.Object r13 = r6.addApartmentByQRToken(r13, r12)     // Catch: java.lang.Exception -> L71
            if (r13 != r0) goto L47
            return r0
        L47:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r13 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r13     // Catch: java.lang.Exception -> L71
        L49:
            r6 = r1
            ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1$2 r13 = new ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1$2     // Catch: java.lang.Exception -> L71
            ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel r1 = r12.this$0     // Catch: java.lang.Exception -> L71
            r13.<init>(r1, r5)     // Catch: java.lang.Exception -> L71
            r9 = r13
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9     // Catch: java.lang.Exception -> L71
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L71
            ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel r13 = r12.this$0     // Catch: java.lang.Exception -> L71
            kotlinx.coroutines.channels.Channel r13 = ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel.access$get_events$p(r13)     // Catch: java.lang.Exception -> L71
            ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$Event$NavigateToSuccessPage r1 = ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel.Event.NavigateToSuccessPage.INSTANCE     // Catch: java.lang.Exception -> L71
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Exception -> L71
            r12.L$0 = r5     // Catch: java.lang.Exception -> L71
            r12.label = r3     // Catch: java.lang.Exception -> L71
            java.lang.Object r13 = r13.send(r1, r4)     // Catch: java.lang.Exception -> L71
            if (r13 != r0) goto L87
            return r0
        L71:
            ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel r13 = r12.this$0
            kotlinx.coroutines.channels.Channel r13 = ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel.access$get_events$p(r13)
            ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$Event$NavigateToErrorPage r1 = ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel.Event.NavigateToErrorPage.INSTANCE
            r3 = r12
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r12.L$0 = r5
            r12.label = r2
            java.lang.Object r13 = r13.send(r1, r3)
            if (r13 != r0) goto L87
            return r0
        L87:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: ScanQRCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1$2", f = "ScanQRCodeViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScanQRCodeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ScanQRCodeViewModel scanQRCodeViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = scanQRCodeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ScanQRCodeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1$2$1", f = "ScanQRCodeViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel$sendApartmentQRToken$1$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ScanQRCodeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ScanQRCodeViewModel scanQRCodeViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = scanQRCodeViewModel;
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
                AddressInteractor addressInteractor;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    addressInteractor = this.this$0.addressInteractor;
                    this.label = 1;
                    if (addressInteractor.refreshAll(this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
}
