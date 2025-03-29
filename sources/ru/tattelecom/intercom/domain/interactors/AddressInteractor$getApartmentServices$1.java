package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AddressInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.AddressInteractor", f = "AddressInteractor.kt", i = {}, l = {40}, m = "getApartmentServices", n = {}, s = {})
/* loaded from: classes5.dex */
final class AddressInteractor$getApartmentServices$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddressInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddressInteractor$getApartmentServices$1(AddressInteractor addressInteractor, Continuation<? super AddressInteractor$getApartmentServices$1> continuation) {
        super(continuation);
        this.this$0 = addressInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getApartmentServices(null, this);
    }
}
