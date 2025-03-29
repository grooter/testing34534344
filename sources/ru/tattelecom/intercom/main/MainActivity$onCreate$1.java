package ru.tattelecom.intercom.main;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "isActive", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.main.MainActivity$onCreate$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class MainActivity$onCreate$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$onCreate$1(MainActivity mainActivity, Continuation<? super MainActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainActivity$onCreate$1 mainActivity$onCreate$1 = new MainActivity$onCreate$1(this.this$0, continuation);
        mainActivity$onCreate$1.Z$0 = ((Boolean) obj).booleanValue();
        return mainActivity$onCreate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((MainActivity$onCreate$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NavController navController;
        NavController navController2;
        NavController navController3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.Z$0) {
            Integer[] numArr = {Boxing.boxInt(NavGraphDestinations.Dest.INSTANCE.getLogIn()), Boxing.boxInt(NavGraphDestinations.Dest.INSTANCE.getVerify()), Boxing.boxInt(NavGraphDestinations.Dest.INSTANCE.getRegistration())};
            navController = this.this$0.mainNavController;
            if (navController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainNavController");
                navController = null;
            }
            NavDestination currentDestination = navController.getCurrentDestination();
            if (!ArraysKt.contains(numArr, currentDestination != null ? Boxing.boxInt(currentDestination.getId()) : null)) {
                navController2 = this.this$0.mainNavController;
                if (navController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainNavController");
                    navController3 = null;
                } else {
                    navController3 = navController2;
                }
                NavExtKt.navigateSafe$default(navController3, NavGraphDestinations.Action.INSTANCE.getToLogIn(), null, null, 6, null);
            }
        }
        return Unit.INSTANCE;
    }
}
