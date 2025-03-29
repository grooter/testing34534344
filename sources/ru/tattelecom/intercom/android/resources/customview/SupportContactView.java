package ru.tattelecom.intercom.android.resources.customview;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import ru.tattelecom.intercom.android.resources.R;

/* compiled from: SupportContactView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\bJ3\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\b2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0&\"\u00020\bH\u0002¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020 J\u0014\u0010)\u001a\u00020 2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0+J,\u0010,\u001a\u00020 2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010-\u001a\u00020 H\u0002R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR(\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/SupportContactView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "callPhoneContact", "getCallPhoneContact", "()Ljava/lang/String;", "setCallPhoneContact", "(Ljava/lang/String;)V", "", "isChatEnabled", "()Z", "setChatEnabled", "(Z)V", "ivCallPhone", "Landroid/widget/ImageView;", "ivChat", "ivTelegram", "telegramContact", "getTelegramContact", "setTelegramContact", "textHeader", "getTextHeader", "setTextHeader", "tvHeader", "Landroid/widget/TextView;", "onContactClick", "", "callPhone", "openAppSupport", "appName", "uri", "packageNames", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "performChatClick", "setOnChatClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "setParams", "setUi", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SupportContactView extends FrameLayout {
    private String callPhoneContact;
    private boolean isChatEnabled;
    private ImageView ivCallPhone;
    private ImageView ivChat;
    private ImageView ivTelegram;
    private String telegramContact;
    private String textHeader;
    private TextView tvHeader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.support_contact_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.tvSupport);
        TextView textView = (TextView) findViewById;
        textView.setText(R.string.empty_string);
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        this.tvHeader = textView;
        View findViewById2 = findViewById(R.id.ivChatContact);
        ImageView imageView = (ImageView) findViewById2;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "apply(...)");
        this.ivChat = imageView;
        View findViewById3 = findViewById(R.id.ivTelegramContact);
        ImageView imageView2 = (ImageView) findViewById3;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setVisibility(8);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.android.resources.customview.SupportContactView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportContactView.lambda$3$lambda$2(SupportContactView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "apply(...)");
        this.ivTelegram = imageView2;
        View findViewById4 = findViewById(R.id.ivCallContact);
        ImageView imageView3 = (ImageView) findViewById4;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setVisibility(8);
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.android.resources.customview.SupportContactView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportContactView.lambda$5$lambda$4(SupportContactView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById4, "apply(...)");
        this.ivCallPhone = imageView3;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SupportContact, 0, 0);
        setTelegramContact(obtainStyledAttributes.getString(R.styleable.SupportContact_telegram_contact));
        setChatEnabled(obtainStyledAttributes.getBoolean(R.styleable.SupportContact_is_chat_enabled, false));
        setCallPhoneContact(obtainStyledAttributes.getString(R.styleable.SupportContact_call_phone_contact));
        setTextHeader(obtainStyledAttributes.getString(R.styleable.SupportContact_header_contact));
        obtainStyledAttributes.recycle();
        if (isInEditMode()) {
            Object systemService = ContextCompat.getSystemService(context, LayoutInflater.class);
            Intrinsics.checkNotNull(systemService);
            addView(((LayoutInflater) systemService).inflate(R.layout.support_contact_layout, (ViewGroup) null));
        }
    }

    public final String getTextHeader() {
        return this.textHeader;
    }

    public final void setTextHeader(String str) {
        if (Intrinsics.areEqual(this.textHeader, str)) {
            return;
        }
        this.textHeader = str;
    }

    /* renamed from: isChatEnabled, reason: from getter */
    public final boolean getIsChatEnabled() {
        return this.isChatEnabled;
    }

    public final void setChatEnabled(boolean z) {
        if (this.isChatEnabled != z) {
            this.isChatEnabled = z;
        }
    }

    public final String getTelegramContact() {
        return this.telegramContact;
    }

    public final void setTelegramContact(String str) {
        if (Intrinsics.areEqual(this.telegramContact, str)) {
            return;
        }
        this.telegramContact = str;
    }

    public final String getCallPhoneContact() {
        return this.callPhoneContact;
    }

    public final void setCallPhoneContact(String str) {
        if (Intrinsics.areEqual(this.callPhoneContact, str)) {
            return;
        }
        this.callPhoneContact = str;
    }

    static final void lambda$3$lambda$2(SupportContactView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openAppSupport("Telegram", "tg://resolve?domain=" + this$0.telegramContact, "org.telegram.messenger", "org.telegram.messenger.web");
    }

    static final void lambda$5$lambda$4(SupportContactView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onContactClick$default(this$0, null, 1, null);
    }

    public final void setParams(String textHeader, boolean isChatEnabled, String telegramContact, String callPhoneContact) {
        setTextHeader(textHeader);
        setChatEnabled(isChatEnabled);
        setTelegramContact(telegramContact);
        setCallPhoneContact(callPhoneContact);
        setUi();
        invalidate();
        requestLayout();
    }

    public final void setOnChatClickListener(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.ivChat.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.android.resources.customview.SupportContactView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportContactView.setOnChatClickListener$lambda$7(Function0.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnChatClickListener$lambda$7(Function0 listener, View view) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.invoke();
    }

    public static /* synthetic */ void onContactClick$default(SupportContactView supportContactView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supportContactView.callPhoneContact;
        }
        supportContactView.onContactClick(str);
    }

    public final void onContactClick(String callPhone) {
        getContext().startActivity(new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + callPhone)));
    }

    private final void setUi() {
        this.ivChat.setVisibility(this.isChatEnabled ? 0 : 8);
        ImageView imageView = this.ivTelegram;
        String str = this.telegramContact;
        boolean z = true;
        imageView.setVisibility(!(str == null || StringsKt.isBlank(str)) ? 0 : 8);
        ImageView imageView2 = this.ivCallPhone;
        String str2 = this.callPhoneContact;
        imageView2.setVisibility(!(str2 == null || StringsKt.isBlank(str2)) ? 0 : 8);
        String str3 = this.textHeader;
        this.tvHeader.setText(str3);
        TextView textView = this.tvHeader;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            z = false;
        }
        textView.setVisibility(z ? 8 : 0);
    }

    public final void performChatClick() {
        this.ivChat.performClick();
    }

    private final void openAppSupport(String appName, String uri, String... packageNames) {
        PackageManager.PackageInfoFlags of;
        if (uri == null) {
            return;
        }
        int length = packageNames.length;
        int i = 0;
        while (true) {
            try {
                if (i < length) {
                    String str = packageNames[i];
                    try {
                        if (Build.VERSION.SDK_INT >= 33) {
                            PackageManager packageManager = getContext().getPackageManager();
                            of = PackageManager.PackageInfoFlags.of(1L);
                            packageManager.getPackageInfo(str, of);
                        } else {
                            getContext().getPackageManager().getPackageInfo(str, 1);
                        }
                        getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(uri)));
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                        i++;
                    }
                } else {
                    Context context = getContext();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getContext().getString(R.string.app_not_installed);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{appName}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    Toast.makeText(context, format, 0).show();
                    break;
                }
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
                return;
            }
        }
    }
}
