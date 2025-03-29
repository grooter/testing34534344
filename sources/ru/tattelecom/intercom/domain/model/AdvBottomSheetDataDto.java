package ru.tattelecom.intercom.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: AdvBottomSheetDtos.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/domain/model/AdvBottomSheetDataDto;", "", "url", "", "screen", NavArg.SELECTED_SERVICES, "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getScreen", "()Ljava/lang/String;", "getSelectedServices", "()Ljava/util/List;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetDataDto {
    private final String screen;
    private final List<Integer> selectedServices;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdvBottomSheetDataDto copy$default(AdvBottomSheetDataDto advBottomSheetDataDto, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advBottomSheetDataDto.url;
        }
        if ((i & 2) != 0) {
            str2 = advBottomSheetDataDto.screen;
        }
        if ((i & 4) != 0) {
            list = advBottomSheetDataDto.selectedServices;
        }
        return advBottomSheetDataDto.copy(str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getScreen() {
        return this.screen;
    }

    public final List<Integer> component3() {
        return this.selectedServices;
    }

    public final AdvBottomSheetDataDto copy(String url, String screen, List<Integer> selectedServices) {
        return new AdvBottomSheetDataDto(url, screen, selectedServices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetDataDto)) {
            return false;
        }
        AdvBottomSheetDataDto advBottomSheetDataDto = (AdvBottomSheetDataDto) other;
        return Intrinsics.areEqual(this.url, advBottomSheetDataDto.url) && Intrinsics.areEqual(this.screen, advBottomSheetDataDto.screen) && Intrinsics.areEqual(this.selectedServices, advBottomSheetDataDto.selectedServices);
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.screen;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Integer> list = this.selectedServices;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AdvBottomSheetDataDto(url=" + this.url + ", screen=" + this.screen + ", selectedServices=" + this.selectedServices + ")";
    }

    public AdvBottomSheetDataDto(String str, String str2, List<Integer> list) {
        this.url = str;
        this.screen = str2;
        this.selectedServices = list;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getScreen() {
        return this.screen;
    }

    public final List<Integer> getSelectedServices() {
        return this.selectedServices;
    }
}
