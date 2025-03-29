package ru.tattelecom.intercom.feature.profile;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProfileViewModel.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.profile.ProfileViewModel", f = "ProfileViewModel.kt", i = {0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, l = {60, 65, 68, 71, 74, 76, 65, 68, 71, 74, 76, 65, 68, 71, 74, 76}, m = "checkAddresses", n = {"this", "this", "addressesListState", "this", "this", "this", "this", "this", "this", "this", "this", "this", "this", "this", "this", "this", "this"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes7.dex */
final class ProfileViewModel$checkAddresses$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$checkAddresses$1(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$checkAddresses$1> continuation) {
        super(continuation);
        this.this$0 = profileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object checkAddresses;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkAddresses = this.this$0.checkAddresses(this);
        return checkAddresses;
    }
}
