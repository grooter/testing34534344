package ru.tattelecom.intercom.feature.profile;

import com.huawei.hms.feature.dynamic.e.e;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProfileViewModel.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.profile.ProfileViewModel", f = "ProfileViewModel.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3}, l = {104, 106, 107, 110}, m = "getUserConfig", n = {"this", "phone", "formattedPhone", "this", "phone", "formattedPhone", "this", "phone", "formattedPhone", e.f202a}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes7.dex */
final class ProfileViewModel$getUserConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$getUserConfig$1(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$getUserConfig$1> continuation) {
        super(continuation);
        this.this$0 = profileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUserConfig(null, null, null, this);
    }
}
