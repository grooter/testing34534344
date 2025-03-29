package ru.tattelecom.intercom.feature.face_detect;

import android.os.Environment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: FaceDetectViewModel.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001dR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/tattelecom/intercom/feature/face_detect/FaceDetectViewModel;", "Landroidx/lifecycle/ViewModel;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "(Lru/tattelecom/intercom/domain/interactors/UserInteractor;)V", "_eventCloseScreen", "Lkotlinx/coroutines/channels/Channel;", "", "_eventShowMessage", "", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_photosList", "", "Lru/tattelecom/intercom/feature/face_detect/Photo;", "currentPhotoPath", "eventCloseScreen", "Lkotlinx/coroutines/flow/Flow;", "getEventCloseScreen", "()Lkotlinx/coroutines/flow/Flow;", "eventShowMessage", "getEventShowMessage", "photosList", "Lkotlinx/coroutines/flow/StateFlow;", "getPhotosList", "()Lkotlinx/coroutines/flow/StateFlow;", "createImageFile", "Ljava/io/File;", "fetchPhotoList", "", "onItemClick", TtmlNode.ATTR_ID, "", "onTakePhoto", "feature-face-detect_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FaceDetectViewModel extends ViewModel {
    private final Channel<Boolean> _eventCloseScreen;
    private final Channel<String> _eventShowMessage;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<List<Photo>> _photosList;
    private String currentPhotoPath;
    private final Flow<Boolean> eventCloseScreen;
    private final Flow<String> eventShowMessage;
    private final StateFlow<List<Photo>> photosList;
    private final UserInteractor userInteractor;

    public FaceDetectViewModel(UserInteractor userInteractor) {
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        this.userInteractor = userInteractor;
        this.currentPhotoPath = "";
        MutableStateFlow<List<Photo>> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._photosList = MutableStateFlow;
        this.photosList = MutableStateFlow;
        this._isLoading = StateFlowKt.MutableStateFlow(false);
        Channel<String> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowMessage = Channel$default;
        this.eventShowMessage = FlowKt.receiveAsFlow(Channel$default);
        Channel<Boolean> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventCloseScreen = Channel$default2;
        this.eventCloseScreen = FlowKt.receiveAsFlow(Channel$default2);
    }

    public final StateFlow<List<Photo>> getPhotosList() {
        return this.photosList;
    }

    public final Flow<String> getEventShowMessage() {
        return this.eventShowMessage;
    }

    public final Flow<Boolean> getEventCloseScreen() {
        return this.eventCloseScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchPhotoList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FaceDetectViewModel$fetchPhotoList$1(this, null), 3, null);
    }

    public final void onItemClick(int id) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FaceDetectViewModel$onItemClick$1(this, id, null), 3, null);
    }

    public final void onTakePhoto() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FaceDetectViewModel$onTakePhoto$1(this, null), 3, null);
    }

    public final File createImageFile() {
        try {
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss", new Locale("ru", "RU")).format(new Date());
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            Intrinsics.checkNotNullExpressionValue(externalStoragePublicDirectory, "getExternalStoragePublicDirectory(...)");
            File createTempFile = File.createTempFile("МойДом_" + format + "_", ".jpg", externalStoragePublicDirectory);
            String absolutePath = createTempFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            this.currentPhotoPath = absolutePath;
            return createTempFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
