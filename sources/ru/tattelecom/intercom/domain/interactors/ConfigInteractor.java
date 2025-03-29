package ru.tattelecom.intercom.domain.interactors;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONObject;
import ru.tattelecom.intercom.data.prefs.RemoteConfigPrefsSource;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.source.ConfigRemote;
import ru.tattelecom.intercom.domain.model.TrialDto;

/* compiled from: ConfigInteractor.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;", "", "prefsSource", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "configRemote", "Lru/tattelecom/intercom/data/remote/source/ConfigRemote;", "configPrefsSource", "Lru/tattelecom/intercom/data/prefs/RemoteConfigPrefsSource;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/remote/source/ConfigRemote;Lru/tattelecom/intercom/data/prefs/RemoteConfigPrefsSource;)V", "value", "", "isShowTrialForToolTips", "()Z", "setShowTrialForToolTips", "(Z)V", "isTrialActivated", "setTrialActivated", "Lorg/json/JSONObject;", "toolTips", "getToolTips", "()Lorg/json/JSONObject;", "setToolTips", "(Lorg/json/JSONObject;)V", "trialFlow", "Lkotlinx/coroutines/flow/Flow;", "Lru/tattelecom/intercom/domain/model/TrialDto;", "getTrialFlow", "()Lkotlinx/coroutines/flow/Flow;", "activateTrial", "", TtmlNode.ATTR_ID, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfig", "Lru/tattelecom/intercom/domain/model/ConfigDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isToolTipRequires", "toolTip", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor$ToolTips;", "setToolTipSeen", "ToolTips", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfigInteractor {
    private final RemoteConfigPrefsSource configPrefsSource;
    private final ConfigRemote configRemote;
    private final UserPrefsSource prefsSource;
    private final Flow<TrialDto> trialFlow;

    public ConfigInteractor(UserPrefsSource prefsSource, ConfigRemote configRemote, RemoteConfigPrefsSource configPrefsSource) {
        Intrinsics.checkNotNullParameter(prefsSource, "prefsSource");
        Intrinsics.checkNotNullParameter(configRemote, "configRemote");
        Intrinsics.checkNotNullParameter(configPrefsSource, "configPrefsSource");
        this.prefsSource = prefsSource;
        this.configRemote = configRemote;
        this.configPrefsSource = configPrefsSource;
        this.trialFlow = FlowKt.combine(configPrefsSource.getTrialIdFlow(), configPrefsSource.isTrialActivatedFlow(), configPrefsSource.getTrialRemainDaysFlow(), new ConfigInteractor$trialFlow$1(null));
    }

    public final Flow<TrialDto> getTrialFlow() {
        return this.trialFlow;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ConfigInteractor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/ConfigInteractor$ToolTips;", "", "(Ljava/lang/String;I)V", "BTN_GENERATE_CODE", "BTN_JOURNAL", "ARCHIVE", "TIMELINE", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToolTips {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ToolTips[] $VALUES;
        public static final ToolTips BTN_GENERATE_CODE = new ToolTips("BTN_GENERATE_CODE", 0);
        public static final ToolTips BTN_JOURNAL = new ToolTips("BTN_JOURNAL", 1);
        public static final ToolTips ARCHIVE = new ToolTips("ARCHIVE", 2);
        public static final ToolTips TIMELINE = new ToolTips("TIMELINE", 3);

        private static final /* synthetic */ ToolTips[] $values() {
            return new ToolTips[]{BTN_GENERATE_CODE, BTN_JOURNAL, ARCHIVE, TIMELINE};
        }

        public static EnumEntries<ToolTips> getEntries() {
            return $ENTRIES;
        }

        public static ToolTips valueOf(String str) {
            return (ToolTips) Enum.valueOf(ToolTips.class, str);
        }

        public static ToolTips[] values() {
            return (ToolTips[]) $VALUES.clone();
        }

        private ToolTips(String str, int i) {
        }

        static {
            ToolTips[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    private final JSONObject getToolTips() {
        try {
            return new JSONObject(this.configPrefsSource.getToolTips());
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    private final void setToolTips(JSONObject jSONObject) {
        RemoteConfigPrefsSource remoteConfigPrefsSource = this.configPrefsSource;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        remoteConfigPrefsSource.setToolTips(jSONObject2);
    }

    public final void setToolTipSeen(ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        JSONObject toolTips = getToolTips();
        toolTips.put(toolTip.name(), true);
        setToolTips(toolTips);
    }

    public final boolean isToolTipRequires(ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        return !(getToolTips().has(toolTip.name()) && getToolTips().getBoolean(toolTip.name())) && isShowTrialForToolTips();
    }

    private final boolean isShowTrialForToolTips() {
        return this.configPrefsSource.isShowTrialForToolTips();
    }

    private final void setShowTrialForToolTips(boolean z) {
        this.configPrefsSource.setShowTrialForToolTips(z);
    }

    public final boolean isTrialActivated() {
        return this.configPrefsSource.isTrialActivated();
    }

    public final void setTrialActivated(boolean z) {
        this.configPrefsSource.setTrialActivated(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getConfig(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.domain.model.ConfigDto> r12) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.ConfigInteractor.getConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object activateTrial(int i, Continuation<? super Unit> continuation) {
        Object startTrial = this.configRemote.startTrial(i, continuation);
        return startTrial == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? startTrial : Unit.INSTANCE;
    }
}
