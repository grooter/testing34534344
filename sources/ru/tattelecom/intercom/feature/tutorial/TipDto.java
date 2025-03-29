package ru.tattelecom.intercom.feature.tutorial;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TutorialViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lru/tattelecom/intercom/feature/tutorial/TipDto;", "", "name", "", "imageResId", "", "buttonText", "buttonCallback", "Lkotlin/Function0;", "", "(Ljava/lang/String;IILkotlin/jvm/functions/Function0;)V", "getButtonCallback", "()Lkotlin/jvm/functions/Function0;", "getButtonText", "()I", "getImageResId", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "feature-tutorial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class TipDto {
    private final Function0<Unit> buttonCallback;
    private final int buttonText;
    private final int imageResId;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TipDto copy$default(TipDto tipDto, String str, int i, int i2, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = tipDto.name;
        }
        if ((i3 & 2) != 0) {
            i = tipDto.imageResId;
        }
        if ((i3 & 4) != 0) {
            i2 = tipDto.buttonText;
        }
        if ((i3 & 8) != 0) {
            function0 = tipDto.buttonCallback;
        }
        return tipDto.copy(str, i, i2, function0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getImageResId() {
        return this.imageResId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getButtonText() {
        return this.buttonText;
    }

    public final Function0<Unit> component4() {
        return this.buttonCallback;
    }

    public final TipDto copy(String name, int imageResId, int buttonText, Function0<Unit> buttonCallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(buttonCallback, "buttonCallback");
        return new TipDto(name, imageResId, buttonText, buttonCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TipDto)) {
            return false;
        }
        TipDto tipDto = (TipDto) other;
        return Intrinsics.areEqual(this.name, tipDto.name) && this.imageResId == tipDto.imageResId && this.buttonText == tipDto.buttonText && Intrinsics.areEqual(this.buttonCallback, tipDto.buttonCallback);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.imageResId) * 31) + this.buttonText) * 31) + this.buttonCallback.hashCode();
    }

    public String toString() {
        return "TipDto(name=" + this.name + ", imageResId=" + this.imageResId + ", buttonText=" + this.buttonText + ", buttonCallback=" + this.buttonCallback + ")";
    }

    public TipDto(String name, int i, int i2, Function0<Unit> buttonCallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(buttonCallback, "buttonCallback");
        this.name = name;
        this.imageResId = i;
        this.buttonText = i2;
        this.buttonCallback = buttonCallback;
    }

    public final String getName() {
        return this.name;
    }

    public final int getImageResId() {
        return this.imageResId;
    }

    public final int getButtonText() {
        return this.buttonText;
    }

    public final Function0<Unit> getButtonCallback() {
        return this.buttonCallback;
    }
}
