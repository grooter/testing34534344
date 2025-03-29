package ru.tattelecom.intercom.android.resources.blur;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RSBlur.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lru/tattelecom/intercom/android/resources/blur/RSBlur;", "", "()V", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RSBlur {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: RSBlur.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lru/tattelecom/intercom/android/resources/blur/RSBlur$Companion;", "", "()V", "blur", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "bitmap", "radius", "", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.graphics.Bitmap blur(android.content.Context r6, android.graphics.Bitmap r7, int r8) {
            /*
                r5 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "bitmap"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r0 = 0
                android.renderscript.RenderScript r6 = android.renderscript.RenderScript.create(r6)     // Catch: java.lang.Throwable -> L5e
                android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch: java.lang.Throwable -> L58
                r1.<init>()     // Catch: java.lang.Throwable -> L58
                r6.setMessageHandler(r1)     // Catch: java.lang.Throwable -> L58
                android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch: java.lang.Throwable -> L58
                r2 = 1
                android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r6, r7, r1, r2)     // Catch: java.lang.Throwable -> L58
                android.renderscript.Type r2 = r1.getType()     // Catch: java.lang.Throwable -> L55
                android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r6, r2)     // Catch: java.lang.Throwable -> L55
                android.renderscript.Element r3 = android.renderscript.Element.U8_4(r6)     // Catch: java.lang.Throwable -> L50
                android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r6, r3)     // Catch: java.lang.Throwable -> L50
                r0.setInput(r1)     // Catch: java.lang.Throwable -> L50
                float r8 = (float) r8     // Catch: java.lang.Throwable -> L50
                r0.setRadius(r8)     // Catch: java.lang.Throwable -> L50
                r0.forEach(r2)     // Catch: java.lang.Throwable -> L50
                r2.copyTo(r7)     // Catch: java.lang.Throwable -> L50
                if (r6 == 0) goto L40
                android.renderscript.RenderScript.releaseAllContexts()
            L40:
                if (r1 == 0) goto L45
                r1.destroy()
            L45:
                if (r2 == 0) goto L4a
                r2.destroy()
            L4a:
                if (r0 == 0) goto L4f
                r0.destroy()
            L4f:
                return r7
            L50:
                r7 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L62
            L55:
                r7 = move-exception
                r2 = r0
                goto L5b
            L58:
                r7 = move-exception
                r1 = r0
                r2 = r1
            L5b:
                r0 = r6
                r6 = r2
                goto L62
            L5e:
                r7 = move-exception
                r6 = r0
                r1 = r6
                r2 = r1
            L62:
                if (r0 == 0) goto L67
                android.renderscript.RenderScript.releaseAllContexts()
            L67:
                if (r1 == 0) goto L6c
                r1.destroy()
            L6c:
                if (r2 == 0) goto L71
                r2.destroy()
            L71:
                if (r6 == 0) goto L76
                r6.destroy()
            L76:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.android.resources.blur.RSBlur.Companion.blur(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
        }
    }
}
