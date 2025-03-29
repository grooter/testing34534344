package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.AddressInteractor;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$onRefreshAddresses$1", f = "HomeViewModel.kt", i = {0, 1, 2, 3}, l = {294, 298, 298, 298}, m = "invokeSuspend", n = {"addressesListState", "addressesListState", "addressesListState", "addressesListState"}, s = {"L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes6.dex */
final class HomeViewModel$onRefreshAddresses$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableStateFlow<Boolean> $loading;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$onRefreshAddresses$1(MutableStateFlow<Boolean> mutableStateFlow, HomeViewModel homeViewModel, Continuation<? super HomeViewModel$onRefreshAddresses$1> continuation) {
        super(2, continuation);
        this.$loading = mutableStateFlow;
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$onRefreshAddresses$1(this.$loading, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$onRefreshAddresses$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object, kotlin.jvm.internal.Ref$BooleanRef] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LockGateInteractor lockGateInteractor;
        Throwable th;
        LockGateInteractor lockGateInteractor2;
        Ref.BooleanRef booleanRef;
        MutableStateFlow mutableStateFlow;
        Object value;
        Ref.BooleanRef booleanRef2;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        UserInteractor userInteractor;
        AddressInteractor addressInteractor;
        LockGateInteractor lockGateInteractor3;
        Ref.BooleanRef booleanRef3;
        MutableStateFlow mutableStateFlow3;
        Object value3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
        } catch (Exception unused) {
            lockGateInteractor2 = this.this$0.lockGateInteractor;
            this.L$0 = r1;
            this.label = 3;
            if (lockGateInteractor2.deleteOld(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = r1;
        } catch (Throwable th2) {
            lockGateInteractor = this.this$0.lockGateInteractor;
            this.L$0 = r1;
            this.L$1 = th2;
            this.label = 4;
            if (lockGateInteractor.deleteOld(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            th = th2;
            booleanRef2 = r1;
        }
        if (r1 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
            this.$loading.setValue(Boxing.boxBoolean(true));
            userInteractor = this.this$0.userInteractor;
            String token = userInteractor.getToken();
            r1 = booleanRef4;
            if (token != null) {
                if (token.length() == 0) {
                    r1 = booleanRef4;
                } else {
                    addressInteractor = this.this$0.addressInteractor;
                    this.L$0 = booleanRef4;
                    this.label = 1;
                    r1 = booleanRef4;
                    if (addressInteractor.refreshAll(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (r1 != 1) {
                if (r1 == 2) {
                    Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    booleanRef3 = booleanRef5;
                    mutableStateFlow3 = this.this$0._isError;
                    do {
                        value3 = mutableStateFlow3.getValue();
                        ((Boolean) value3).booleanValue();
                    } while (!mutableStateFlow3.compareAndSet(value3, Boxing.boxBoolean(!booleanRef3.element)));
                    this.$loading.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                if (r1 == 3) {
                    booleanRef = (Ref.BooleanRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = this.this$0._isError;
                    do {
                        value = mutableStateFlow.getValue();
                        ((Boolean) value).booleanValue();
                    } while (!mutableStateFlow.compareAndSet(value, Boxing.boxBoolean(!booleanRef.element)));
                    this.$loading.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                if (r1 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.L$1;
                Ref.BooleanRef booleanRef6 = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                booleanRef2 = booleanRef6;
                mutableStateFlow2 = this.this$0._isError;
                do {
                    value2 = mutableStateFlow2.getValue();
                    ((Boolean) value2).booleanValue();
                } while (!mutableStateFlow2.compareAndSet(value2, Boxing.boxBoolean(!booleanRef2.element)));
                this.$loading.setValue(Boxing.boxBoolean(false));
                throw th;
            }
            Ref.BooleanRef booleanRef7 = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            r1 = booleanRef7;
        }
        r1.element = true;
        lockGateInteractor3 = this.this$0.lockGateInteractor;
        this.L$0 = r1;
        this.label = 2;
        if (lockGateInteractor3.deleteOld(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        booleanRef3 = r1;
        mutableStateFlow3 = this.this$0._isError;
        do {
            value3 = mutableStateFlow3.getValue();
            ((Boolean) value3).booleanValue();
        } while (!mutableStateFlow3.compareAndSet(value3, Boxing.boxBoolean(!booleanRef3.element)));
        this.$loading.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
