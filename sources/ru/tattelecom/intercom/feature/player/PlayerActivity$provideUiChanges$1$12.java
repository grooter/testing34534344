package ru.tattelecom.intercom.feature.player;

import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.core.view.ViewGroupKt;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Ljava/util/Date;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
final class PlayerActivity$provideUiChanges$1$12 extends Lambda implements Function1<List<? extends Date>, Unit> {
    final /* synthetic */ PlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerActivity$provideUiChanges$1$12(PlayerActivity playerActivity) {
        super(1);
        this.this$0 = playerActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Date> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Date> list) {
        ActivityPlayerBinding binding;
        SimpleDateFormat simpleDateFormat;
        binding = this.this$0.getBinding();
        PlayerActivity playerActivity = this.this$0;
        ChipGroup cgDays = binding.cgDays;
        Intrinsics.checkNotNullExpressionValue(cgDays, "cgDays");
        int i = 0;
        for (View view : ViewGroupKt.getChildren(cgDays)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            if (i != 7) {
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                simpleDateFormat = playerActivity.dateFormatter;
                ((Chip) view2).setText(simpleDateFormat.format(list.get((binding.cgDays.getChildCount() - 2) - i)));
            }
            i = i2;
        }
        final HorizontalScrollView horizontalScrollView = binding.hsDays;
        horizontalScrollView.post(new Runnable() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$12$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PlayerActivity$provideUiChanges$1$12.invoke$lambda$3$lambda$2$lambda$1(horizontalScrollView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2$lambda$1(HorizontalScrollView this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.fullScroll(66);
    }
}
