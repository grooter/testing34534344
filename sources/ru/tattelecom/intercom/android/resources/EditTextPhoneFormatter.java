package ru.tattelecom.intercom.android.resources;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditTextPhoneFormatter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J$\u0010\u0011\u001a\u00020\b2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u0015\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J(\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0014\u0010\u001b\u001a\u00020\b2\n\u0010\u0018\u001a\u00060\u0013j\u0002`\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/tattelecom/intercom/android/resources/EditTextPhoneFormatter;", "Landroid/text/TextWatcher;", "mEditText", "Landroid/widget/EditText;", "mPattern", "", "(Landroid/widget/EditText;Ljava/lang/String;)V", "afterTextChanged", "", CmcdData.Factory.STREAMING_FORMAT_SS, "Landroid/text/Editable;", "beforeTextChanged", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "fixNumberCount", "str", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getNumbersCount", "isValid", "", "phone", "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "reformatNumber", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EditTextPhoneFormatter implements TextWatcher {
    private final EditText mEditText;
    private final String mPattern;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    public EditTextPhoneFormatter(EditText mEditText, String mPattern) {
        Intrinsics.checkNotNullParameter(mEditText, "mEditText");
        Intrinsics.checkNotNullParameter(mPattern, "mPattern");
        this.mEditText = mEditText;
        this.mPattern = mPattern;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (isValid(r3) != false) goto L14;
     */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onTextChanged(java.lang.CharSequence r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            java.lang.String r4 = "s"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            int r2 = r4.length()
            r0 = 13
            if (r2 <= r0) goto L2d
            r2 = 1
            if (r5 != r2) goto L2d
            r4.deleteCharAt(r3)
            android.widget.EditText r2 = r1.mEditText
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            android.widget.EditText r2 = r1.mEditText
            android.text.Editable r3 = r2.getText()
            int r3 = r3.length()
            r2.setSelection(r3)
            return
        L2d:
            int r2 = r1.getNumbersCount(r4)
            r0 = 9
            if (r2 <= r0) goto L38
            r1.fixNumberCount(r4, r2, r3)
        L38:
            if (r5 <= 0) goto L49
            java.lang.String r3 = r4.toString()
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            boolean r3 = r1.isValid(r3)
            if (r3 == 0) goto L4b
        L49:
            if (r2 <= r0) goto L62
        L4b:
            r1.reformatNumber(r4)
            android.widget.EditText r2 = r1.mEditText
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            android.widget.EditText r2 = r1.mEditText
            android.text.Editable r3 = r2.getText()
            int r3 = r3.length()
            r2.setSelection(r3)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.android.resources.EditTextPhoneFormatter.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    private final void reformatNumber(StringBuilder phone) {
        char charAt;
        int length = phone.length();
        int i = 0;
        while (i < length) {
            if (i >= this.mPattern.length()) {
                phone.deleteCharAt(i);
            } else {
                char charAt2 = this.mPattern.charAt(i);
                if (charAt2 == '#' && ('0' > (charAt = phone.charAt(i)) || charAt >= ':')) {
                    phone.deleteCharAt(i);
                } else {
                    if (charAt2 != '#' && charAt2 != phone.charAt(i)) {
                        phone.insert(i, charAt2);
                        length++;
                    }
                    i++;
                }
            }
            length--;
        }
    }

    private final int getNumbersCount(StringBuilder str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ('0' <= charAt && charAt < ':') {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        if (r9.charAt(r0) != '9') goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void fixNumberCount(java.lang.StringBuilder r9, int r10, int r11) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = -1
            int r0 = r0 + r1
            r2 = 11
            r3 = 58
            r4 = 48
            if (r0 < 0) goto L25
        Le:
            int r5 = r0 + (-1)
            if (r10 > r2) goto L13
            goto L25
        L13:
            char r6 = r9.charAt(r0)
            if (r4 > r6) goto L20
            if (r6 >= r3) goto L20
            r9.deleteCharAt(r0)
            int r10 = r10 + (-1)
        L20:
            if (r5 >= 0) goto L23
            goto L25
        L23:
            r0 = r5
            goto Le
        L25:
            r0 = 0
            r5 = 57
            if (r10 != r2) goto L64
            int r11 = r9.length()
            r2 = r1
        L2f:
            if (r0 >= r11) goto L56
            char r6 = r9.charAt(r0)
            if (r4 > r6) goto L53
            if (r6 >= r3) goto L53
            if (r2 != r1) goto L47
            char r6 = r9.charAt(r0)
            r7 = 55
            if (r7 > r6) goto L47
            if (r6 >= r5) goto L47
            r2 = r0
            goto L53
        L47:
            if (r2 == r1) goto L50
            char r11 = r9.charAt(r0)
            if (r11 != r5) goto L50
            goto L57
        L50:
            r0 = r1
            r2 = r0
            goto L57
        L53:
            int r0 = r0 + 1
            goto L2f
        L56:
            r0 = r1
        L57:
            if (r2 == r1) goto L88
            if (r0 == r1) goto L88
            r9.deleteCharAt(r0)
            r9.deleteCharAt(r2)
            int r10 = r10 + (-2)
            goto L88
        L64:
            r2 = 10
            if (r10 != r2) goto L88
            if (r11 != 0) goto L88
            int r11 = r9.length()
        L6e:
            if (r0 >= r11) goto L88
            char r2 = r9.charAt(r0)
            if (r2 != r5) goto L7c
            r9.deleteCharAt(r0)
            int r10 = r10 + (-1)
            goto L88
        L7c:
            char r2 = r9.charAt(r0)
            if (r4 > r2) goto L85
            if (r2 >= r3) goto L85
            goto L88
        L85:
            int r0 = r0 + 1
            goto L6e
        L88:
            r11 = 9
            if (r10 <= r11) goto La9
            int r0 = r9.length()
            int r0 = r0 + r1
            if (r0 < 0) goto La9
        L93:
            int r1 = r0 + (-1)
            char r2 = r9.charAt(r0)
            if (r4 > r2) goto La4
            if (r2 >= r3) goto La4
            r9.deleteCharAt(r0)
            int r10 = r10 + (-1)
            if (r10 == r11) goto La9
        La4:
            if (r1 >= 0) goto La7
            goto La9
        La7:
            r0 = r1
            goto L93
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.android.resources.EditTextPhoneFormatter.fixNumberCount(java.lang.StringBuilder, int, int):void");
    }

    private final boolean isValid(String phone) {
        char charAt;
        int length = phone.length();
        for (int i = 0; i < length; i++) {
            if (i >= this.mPattern.length()) {
                return false;
            }
            char charAt2 = this.mPattern.charAt(i);
            if (charAt2 == '#' && ('0' > (charAt = phone.charAt(i)) || charAt >= ':')) {
                return false;
            }
            if (charAt2 != '#' && charAt2 != phone.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
