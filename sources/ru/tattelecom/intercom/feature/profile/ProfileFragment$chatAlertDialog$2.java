package ru.tattelecom.intercom.feature.profile;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.tattelecom.intercom.android.resources.SupportViewModel;

/* compiled from: ProfileFragment.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/appcompat/app/AlertDialog;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
final class ProfileFragment$chatAlertDialog$2 extends Lambda implements Function0<AlertDialog> {
    final /* synthetic */ ProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileFragment$chatAlertDialog$2(ProfileFragment profileFragment) {
        super(0);
        this.this$0 = profileFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AlertDialog invoke() {
        MaterialAlertDialogBuilder message = new MaterialAlertDialogBuilder(this.this$0.requireContext()).setTitle((CharSequence) this.this$0.getString(R.string.chat_unavailable_title)).setMessage((CharSequence) this.this$0.getString(R.string.chat_unavailable_message_no_link, SupportViewModel.Companion.formatPhoneNumber$default(SupportViewModel.INSTANCE, null, 1, null)));
        String string = this.this$0.getString(R.string.call_support);
        final ProfileFragment profileFragment = this.this$0;
        return message.setPositiveButton((CharSequence) string, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$chatAlertDialog$2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProfileFragment$chatAlertDialog$2.invoke$lambda$0(ProfileFragment.this, dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) this.this$0.getString(R.string.good), new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$chatAlertDialog$2$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(ProfileFragment this$0, final DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPhoneActivity(SupportViewModel.DEFAULT_PHONE_NUMBER, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$chatAlertDialog$2$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                dialogInterface.dismiss();
            }
        });
    }
}
