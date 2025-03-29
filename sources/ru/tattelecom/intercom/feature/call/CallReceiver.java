package ru.tattelecom.intercom.feature.call;

import kotlin.Metadata;

/* compiled from: Receivers.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallReceiver;", "", "()V", "Arg", "Name", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallReceiver {
    public static final CallReceiver INSTANCE = new CallReceiver();

    private CallReceiver() {
    }

    /* compiled from: Receivers.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallReceiver$Name;", "", "()V", "CALL", "", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Name {
        public static final String CALL = "callAction";
        public static final Name INSTANCE = new Name();

        private Name() {
        }
    }

    /* compiled from: Receivers.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallReceiver$Arg;", "", "()V", "END_CALL", "", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Arg {
        public static final String END_CALL = "endCall";
        public static final Arg INSTANCE = new Arg();

        private Arg() {
        }
    }
}
