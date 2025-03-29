package ru.tattelecom.intercom.android.resources.blur;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: FastBlur.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lru/tattelecom/intercom/android/resources/blur/FastBlur;", "", "()V", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FastBlur {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: FastBlur.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lru/tattelecom/intercom/android/resources/blur/FastBlur$Companion;", "", "()V", "blur", "Landroid/graphics/Bitmap;", "sentBitmap", "radius", "", "canReuseInBitmap", "", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Bitmap blur(Bitmap sentBitmap, int radius, boolean canReuseInBitmap) {
            int[] iArr;
            Bitmap sentBitmap2 = sentBitmap;
            int i = radius;
            Intrinsics.checkNotNullParameter(sentBitmap2, "sentBitmap");
            if (!canReuseInBitmap) {
                sentBitmap2 = sentBitmap2.copy(sentBitmap.getConfig(), true);
                Intrinsics.checkNotNull(sentBitmap2);
            }
            if (i < 1) {
                return null;
            }
            int width = sentBitmap2.getWidth();
            int height = sentBitmap2.getHeight();
            int i2 = width * height;
            int[] iArr2 = new int[i2];
            sentBitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i3 = width - 1;
            int i4 = height - 1;
            int i5 = i + i;
            int i6 = i5 + 1;
            int[] iArr3 = new int[i2];
            int[] iArr4 = new int[i2];
            int[] iArr5 = new int[i2];
            int[] iArr6 = new int[RangesKt.coerceAtLeast(width, height)];
            int i7 = (i5 + 2) >> 1;
            int i8 = i7 * i7;
            int i9 = i8 * 256;
            int[] iArr7 = new int[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                iArr7[i10] = i10 / i8;
            }
            int[][] iArr8 = new int[i6][];
            for (int i11 = 0; i11 < i6; i11++) {
                iArr8[i11] = new int[3];
            }
            int i12 = i + 1;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i13 < height) {
                Bitmap bitmap = sentBitmap2;
                int i16 = height;
                int i17 = 9;
                int i18 = 9;
                int i19 = 9;
                int i20 = 9;
                int i21 = 9;
                int i22 = 9;
                int i23 = 9;
                int i24 = 0;
                int i25 = -i;
                int i26 = 0;
                while (i25 <= i) {
                    int i27 = i4;
                    int[] iArr9 = iArr6;
                    int i28 = iArr2[i14 + RangesKt.coerceAtMost(i3, RangesKt.coerceAtLeast(i25, 0))];
                    int[] iArr10 = iArr8[i25 + i];
                    iArr10[0] = (i28 & 16711680) >> 16;
                    iArr10[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr10[2] = i28 & 255;
                    int abs = i12 - Math.abs(i25);
                    int i29 = iArr10[0];
                    i17 += i29 * abs;
                    int i30 = iArr10[1];
                    i26 += i30 * abs;
                    int i31 = iArr10[2];
                    i24 += abs * i31;
                    if (i25 > 0) {
                        i21 += i29;
                        i22 += i30;
                        i23 += i31;
                    } else {
                        i18 += i29;
                        i19 += i30;
                        i20 += i31;
                    }
                    i25++;
                    i4 = i27;
                    iArr6 = iArr9;
                }
                int i32 = i4;
                int[] iArr11 = iArr6;
                int i33 = i26;
                int i34 = i;
                int i35 = 0;
                while (i35 < width) {
                    iArr3[i14] = iArr7[i17];
                    iArr4[i14] = iArr7[i33];
                    iArr5[i14] = iArr7[i24];
                    int i36 = i17 - i18;
                    int i37 = i33 - i19;
                    int i38 = i24 - i20;
                    int[] iArr12 = iArr8[((i34 - i) + i6) % i6];
                    int i39 = i18 - iArr12[0];
                    int i40 = i19 - iArr12[1];
                    int i41 = i20 - iArr12[2];
                    if (i13 == 0) {
                        iArr = iArr7;
                        iArr11[i35] = RangesKt.coerceAtMost(i35 + i + 1, i3);
                    } else {
                        iArr = iArr7;
                    }
                    int i42 = iArr2[i15 + iArr11[i35]];
                    int i43 = (i42 & 16711680) >> 16;
                    iArr12[0] = i43;
                    int i44 = (i42 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr12[1] = i44;
                    int i45 = i42 & 255;
                    iArr12[2] = i45;
                    int i46 = i21 + i43;
                    int i47 = i22 + i44;
                    int i48 = i23 + i45;
                    i17 = i36 + i46;
                    i33 = i37 + i47;
                    i24 = i38 + i48;
                    i34 = (i34 + 1) % i6;
                    int[] iArr13 = iArr8[i34 % i6];
                    int i49 = iArr13[0];
                    i18 = i39 + i49;
                    int i50 = iArr13[1];
                    i19 = i40 + i50;
                    int i51 = iArr13[2];
                    i20 = i41 + i51;
                    i21 = i46 - i49;
                    i22 = i47 - i50;
                    i23 = i48 - i51;
                    i14++;
                    i35++;
                    iArr7 = iArr;
                }
                i15 += width;
                i13++;
                sentBitmap2 = bitmap;
                height = i16;
                i4 = i32;
                iArr6 = iArr11;
            }
            Bitmap bitmap2 = sentBitmap2;
            int i52 = i4;
            int[] iArr14 = iArr6;
            int i53 = height;
            int[] iArr15 = iArr7;
            int i54 = 0;
            while (i54 < width) {
                int i55 = -i;
                int i56 = i6;
                int[] iArr16 = iArr2;
                int i57 = 0;
                int i58 = 0;
                int i59 = 0;
                int i60 = 0;
                int i61 = 0;
                int i62 = 0;
                int i63 = 0;
                int i64 = i55;
                int i65 = i55 * width;
                int i66 = 0;
                int i67 = 0;
                while (i64 <= i) {
                    int i68 = width;
                    int coerceAtLeast = RangesKt.coerceAtLeast(0, i65) + i54;
                    int[] iArr17 = iArr8[i64 + i];
                    iArr17[0] = iArr3[coerceAtLeast];
                    iArr17[1] = iArr4[coerceAtLeast];
                    iArr17[2] = iArr5[coerceAtLeast];
                    int abs2 = i12 - Math.abs(i64);
                    i66 += iArr3[coerceAtLeast] * abs2;
                    i67 += iArr4[coerceAtLeast] * abs2;
                    i57 += iArr5[coerceAtLeast] * abs2;
                    if (i64 > 0) {
                        i61 += iArr17[0];
                        i62 += iArr17[1];
                        i63 += iArr17[2];
                    } else {
                        i58 += iArr17[0];
                        i59 += iArr17[1];
                        i60 += iArr17[2];
                    }
                    int i69 = i52;
                    if (i64 < i69) {
                        i65 += i68;
                    }
                    i64++;
                    i52 = i69;
                    width = i68;
                }
                int i70 = width;
                int i71 = i52;
                int i72 = i;
                int i73 = i53;
                int i74 = 0;
                int i75 = i54;
                while (i74 < i73) {
                    iArr16[i75] = (iArr16[i75] & ViewCompat.MEASURED_STATE_MASK) | (iArr15[i66] << 16) | (iArr15[i67] << 8) | iArr15[i57];
                    int i76 = i66 - i58;
                    int i77 = i67 - i59;
                    int i78 = i57 - i60;
                    int[] iArr18 = iArr8[((i72 - i) + i56) % i56];
                    int i79 = i58 - iArr18[0];
                    int i80 = i59 - iArr18[1];
                    int i81 = i60 - iArr18[2];
                    if (i54 == 0) {
                        iArr14[i74] = RangesKt.coerceAtMost(i74 + i12, i71) * i70;
                    }
                    int i82 = iArr14[i74] + i54;
                    int i83 = iArr3[i82];
                    iArr18[0] = i83;
                    int i84 = iArr4[i82];
                    iArr18[1] = i84;
                    int i85 = iArr5[i82];
                    iArr18[2] = i85;
                    int i86 = i61 + i83;
                    int i87 = i62 + i84;
                    int i88 = i63 + i85;
                    i66 = i76 + i86;
                    i67 = i77 + i87;
                    i57 = i78 + i88;
                    i72 = (i72 + 1) % i56;
                    int[] iArr19 = iArr8[i72];
                    int i89 = iArr19[0];
                    i58 = i79 + i89;
                    int i90 = iArr19[1];
                    i59 = i80 + i90;
                    int i91 = iArr19[2];
                    i60 = i81 + i91;
                    i61 = i86 - i89;
                    i62 = i87 - i90;
                    i63 = i88 - i91;
                    i75 += i70;
                    i74++;
                    i = radius;
                }
                i54++;
                i = radius;
                i52 = i71;
                i53 = i73;
                i6 = i56;
                iArr2 = iArr16;
                width = i70;
            }
            int i92 = width;
            bitmap2.setPixels(iArr2, 0, i92, 0, 0, i92, i53);
            return bitmap2;
        }
    }
}
