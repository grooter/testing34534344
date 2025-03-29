package ru.tattelecom.intercom.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: AppCoroutineDispatchers.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "", "io", "Lkotlinx/coroutines/CoroutineDispatcher;", "computation", "main", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getComputation", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getIo", "getMain", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AppCoroutineDispatchers {
    private final CoroutineDispatcher computation;
    private final CoroutineDispatcher io;
    private final CoroutineDispatcher main;

    public static /* synthetic */ AppCoroutineDispatchers copy$default(AppCoroutineDispatchers appCoroutineDispatchers, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = appCoroutineDispatchers.io;
        }
        if ((i & 2) != 0) {
            coroutineDispatcher2 = appCoroutineDispatchers.computation;
        }
        if ((i & 4) != 0) {
            coroutineDispatcher3 = appCoroutineDispatchers.main;
        }
        return appCoroutineDispatchers.copy(coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3);
    }

    /* renamed from: component1, reason: from getter */
    public final CoroutineDispatcher getIo() {
        return this.io;
    }

    /* renamed from: component2, reason: from getter */
    public final CoroutineDispatcher getComputation() {
        return this.computation;
    }

    /* renamed from: component3, reason: from getter */
    public final CoroutineDispatcher getMain() {
        return this.main;
    }

    public final AppCoroutineDispatchers copy(CoroutineDispatcher io2, CoroutineDispatcher computation, CoroutineDispatcher main) {
        Intrinsics.checkNotNullParameter(io2, "io");
        Intrinsics.checkNotNullParameter(computation, "computation");
        Intrinsics.checkNotNullParameter(main, "main");
        return new AppCoroutineDispatchers(io2, computation, main);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppCoroutineDispatchers)) {
            return false;
        }
        AppCoroutineDispatchers appCoroutineDispatchers = (AppCoroutineDispatchers) other;
        return Intrinsics.areEqual(this.io, appCoroutineDispatchers.io) && Intrinsics.areEqual(this.computation, appCoroutineDispatchers.computation) && Intrinsics.areEqual(this.main, appCoroutineDispatchers.main);
    }

    public int hashCode() {
        return (((this.io.hashCode() * 31) + this.computation.hashCode()) * 31) + this.main.hashCode();
    }

    public String toString() {
        return "AppCoroutineDispatchers(io=" + this.io + ", computation=" + this.computation + ", main=" + this.main + ")";
    }

    public AppCoroutineDispatchers(CoroutineDispatcher io2, CoroutineDispatcher computation, CoroutineDispatcher main) {
        Intrinsics.checkNotNullParameter(io2, "io");
        Intrinsics.checkNotNullParameter(computation, "computation");
        Intrinsics.checkNotNullParameter(main, "main");
        this.io = io2;
        this.computation = computation;
        this.main = main;
    }

    public final CoroutineDispatcher getIo() {
        return this.io;
    }

    public final CoroutineDispatcher getComputation() {
        return this.computation;
    }

    public final CoroutineDispatcher getMain() {
        return this.main;
    }
}
