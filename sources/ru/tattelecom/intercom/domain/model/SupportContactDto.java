package ru.tattelecom.intercom.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: SupportDtos.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/tattelecom/intercom/domain/model/SupportContactDto;", "", "title", "", "contacts", "", "Lru/tattelecom/intercom/domain/model/SupportContactDto$Item;", "isError", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getContacts", "()Ljava/util/List;", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Item", "Type", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SupportContactDto {
    private final List<Item> contacts;
    private final boolean isError;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SupportContactDto copy$default(SupportContactDto supportContactDto, String str, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supportContactDto.title;
        }
        if ((i & 2) != 0) {
            list = supportContactDto.contacts;
        }
        if ((i & 4) != 0) {
            z = supportContactDto.isError;
        }
        return supportContactDto.copy(str, list, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<Item> component2() {
        return this.contacts;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public final SupportContactDto copy(String title, List<Item> contacts, boolean isError) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        return new SupportContactDto(title, contacts, isError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupportContactDto)) {
            return false;
        }
        SupportContactDto supportContactDto = (SupportContactDto) other;
        return Intrinsics.areEqual(this.title, supportContactDto.title) && Intrinsics.areEqual(this.contacts, supportContactDto.contacts) && this.isError == supportContactDto.isError;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.contacts.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isError);
    }

    public String toString() {
        return "SupportContactDto(title=" + this.title + ", contacts=" + this.contacts + ", isError=" + this.isError + ")";
    }

    public SupportContactDto(String title, List<Item> contacts, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        this.title = title;
        this.contacts = contacts;
        this.isError = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<Item> getContacts() {
        return this.contacts;
    }

    public final boolean isError() {
        return this.isError;
    }

    /* compiled from: SupportDtos.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0007\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/tattelecom/intercom/domain/model/SupportContactDto$Item;", "", "type", "Lru/tattelecom/intercom/domain/model/SupportContactDto$Type;", "description", "", "value", "isEnabled", "", "(Lru/tattelecom/intercom/domain/model/SupportContactDto$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getDescription", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()Lru/tattelecom/intercom/domain/model/SupportContactDto$Type;", "getValue", "component1", "component2", "component3", "component4", "copy", "(Lru/tattelecom/intercom/domain/model/SupportContactDto$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/tattelecom/intercom/domain/model/SupportContactDto$Item;", "equals", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Item {
        private final String description;
        private final Boolean isEnabled;
        private final Type type;
        private final String value;

        public static /* synthetic */ Item copy$default(Item item, Type type, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                type = item.type;
            }
            if ((i & 2) != 0) {
                str = item.description;
            }
            if ((i & 4) != 0) {
                str2 = item.value;
            }
            if ((i & 8) != 0) {
                bool = item.isEnabled;
            }
            return item.copy(type, str, str2, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        /* renamed from: component4, reason: from getter */
        public final Boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final Item copy(Type type, String description, String value, Boolean isEnabled) {
            return new Item(type, description, value, isEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return this.type == item.type && Intrinsics.areEqual(this.description, item.description) && Intrinsics.areEqual(this.value, item.value) && Intrinsics.areEqual(this.isEnabled, item.isEnabled);
        }

        public int hashCode() {
            Type type = this.type;
            int hashCode = (type == null ? 0 : type.hashCode()) * 31;
            String str = this.description;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.value;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.isEnabled;
            return hashCode3 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Item(type=" + this.type + ", description=" + this.description + ", value=" + this.value + ", isEnabled=" + this.isEnabled + ")";
        }

        public Item(Type type, String str, String str2, Boolean bool) {
            this.type = type;
            this.description = str;
            this.value = str2;
            this.isEnabled = bool;
        }

        public final Type getType() {
            return this.type;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getValue() {
            return this.value;
        }

        public final Boolean isEnabled() {
            return this.isEnabled;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SupportDtos.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/domain/model/SupportContactDto$Type;", "", "(Ljava/lang/String;I)V", "TELEGRAM", "CALL_PHONE", "CHAT", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type TELEGRAM = new Type("TELEGRAM", 0);
        public static final Type CALL_PHONE = new Type("CALL_PHONE", 1);
        public static final Type CHAT = new Type("CHAT", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{TELEGRAM, CALL_PHONE, CHAT};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i) {
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
