package ru.tattelecom.intercom.android.resources.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: GlideBlurTransformation.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/android/resources/blur/GlideBlurTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "context", "Landroid/content/Context;", "radius", "", "sampling", "(Landroid/content/Context;II)V", "getContext", "()Landroid/content/Context;", "getRadius", "()I", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlideBlurTransformation extends BitmapTransformation {
    private final Context context;
    private final int radius;
    private final int sampling;

    public /* synthetic */ GlideBlurTransformation(Context context, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 25 : i, (i3 & 4) != 0 ? 1 : i2);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getRadius() {
        return this.radius;
    }

    public GlideBlurTransformation(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.radius = i;
        this.sampling = i2;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        byte[] bytes = "blur transformation".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(toTransform, "toTransform");
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        int i = this.sampling;
        Bitmap bitmap = pool.get(width / i, height / i, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        bitmap.setDensity(toTransform.getDensity());
        Canvas canvas = new Canvas(bitmap);
        int i2 = this.sampling;
        canvas.scale(1.0f / i2, 1.0f / i2);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        try {
            return RSBlur.INSTANCE.blur(this.context, bitmap, this.radius);
        } catch (RSRuntimeException unused) {
            Bitmap blur = FastBlur.INSTANCE.blur(bitmap, this.radius, true);
            Intrinsics.checkNotNull(blur);
            return blur;
        }
    }
}
