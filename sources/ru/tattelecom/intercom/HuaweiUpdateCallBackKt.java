package ru.tattelecom.intercom;

import android.content.Intent;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HuaweiUpdateCallBack.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"serializable", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Landroid/content/Intent;", "key", "", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/io/Serializable;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HuaweiUpdateCallBackKt {
    private static final /* synthetic */ <T extends Serializable> T serializable(Intent intent, String str) {
        Serializable serializableExtra;
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            serializableExtra = intent.getSerializableExtra(str, Serializable.class);
            return (T) serializableExtra;
        }
        T t = (T) intent.getSerializableExtra(str);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }
}
