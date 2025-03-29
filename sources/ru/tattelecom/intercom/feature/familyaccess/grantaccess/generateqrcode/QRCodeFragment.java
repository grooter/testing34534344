package ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentQrCodeBinding;

/* compiled from: QRCodeFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/QRCodeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentQrCodeBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentQrCodeBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "getQrCodeBitmap", "Landroid/graphics/Bitmap;", NavArg.QR_CODE_DATA, "", ContentDisposition.Parameters.Size, "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideUiChanges", "setUi", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QRCodeFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(QRCodeFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentQrCodeBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    private final void provideUiChanges() {
    }

    public QRCodeFragment() {
        super(R.layout.fragment_qr_code);
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(this, FragmentQrCodeBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentQrCodeBinding getBinding() {
        return (FragmentQrCodeBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        Bitmap bitmap = null;
        try {
            bitmap = getQrCodeBitmap$default(this, getArguments() != null ? requireArguments().getString(NavArg.QR_CODE_DATA) : null, 0, 2, null);
        } catch (Exception e) {
            e.getStackTrace();
        }
        getBinding().ivQRCode.setImageBitmap(bitmap);
        getBinding().btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.QRCodeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRCodeFragment.setUi$lambda$1(QRCodeFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$1(QRCodeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    static /* synthetic */ Bitmap getQrCodeBitmap$default(QRCodeFragment qRCodeFragment, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return qRCodeFragment.getQrCodeBitmap(str, i);
    }

    private final Bitmap getQrCodeBitmap(String qrCodeData, int size) {
        BitMatrix encode = new MultiFormatWriter().encode(qrCodeData, BarcodeFormat.QR_CODE, size, size, MapsKt.mapOf(TuplesKt.to(EncodeHintType.MARGIN, 0)));
        Bitmap createBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                createBitmap.setPixel(i, i2, encode.get(i, i2) ? ViewCompat.MEASURED_STATE_MASK : -1);
            }
        }
        return createBitmap;
    }
}
