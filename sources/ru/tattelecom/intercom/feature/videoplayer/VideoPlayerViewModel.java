package ru.tattelecom.intercom.feature.videoplayer;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.common.MimeTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.StreamInteractor;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.domain.model.LockGateStatusDto;
import ru.tattelecom.intercom.feature.videoplayer.PlayerState;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog;
import ru.tattelecom.intercom.feature.videoplayer.model.DownloadItem;
import ru.tattelecom.intercom.feature.videoplayer.model.EventItem;
import ru.tattelecom.intercom.feature.videoplayer.model.PlayerEvent;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 ï\u00012\u00020\u0001:\u0002ï\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0019\u0010\u008b\u0001\u001a\u00020!2\u0007\u0010\u008c\u0001\u001a\u00020#2\u0007\u0010\u008d\u0001\u001a\u00020&J\u0007\u0010\u008e\u0001\u001a\u00020!J\u0010\u0010\u008f\u0001\u001a\u00020!2\u0007\u0010\u0090\u0001\u001a\u00020\u0018J\u0015\u0010\u0091\u0001\u001a\u00020\u00182\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0002J\u001a\u0010\u0094\u0001\u001a\u00020\u00182\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0003\u0010\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020!2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001J\u0010\u0010\u0098\u0001\u001a\u00020(2\u0007\u0010\u0099\u0001\u001a\u00020#J\t\u0010\u009a\u0001\u001a\u00020(H\u0002J+\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\t\b\u0002\u0010\u008c\u0001\u001a\u00020#2\u000b\b\u0002\u0010\u009d\u0001\u001a\u0004\u0018\u00010(H\u0086@¢\u0006\u0003\u0010\u009e\u0001J\u0007\u0010\u009f\u0001\u001a\u00020(J\u0011\u0010 \u0001\u001a\u00020\u00182\b\u0010¡\u0001\u001a\u00030¢\u0001J\u0007\u0010£\u0001\u001a\u00020!J\u001b\u0010¤\u0001\u001a\u00020!2\u0007\u0010¥\u0001\u001a\u00020#2\t\b\u0002\u0010¦\u0001\u001a\u00020\u0018J\t\u0010§\u0001\u001a\u00020!H\u0014J\u0011\u0010¨\u0001\u001a\u00020!2\b\u0010¡\u0001\u001a\u00030¢\u0001J\u0010\u0010©\u0001\u001a\u00020!2\u0007\u0010ª\u0001\u001a\u00020&J\u0019\u0010«\u0001\u001a\u00020!2\u0007\u0010¬\u0001\u001a\u00020#2\u0007\u0010\u00ad\u0001\u001a\u00020\u0018J\u0010\u0010®\u0001\u001a\u00020!2\u0007\u0010¯\u0001\u001a\u00020\\J\u0010\u0010°\u0001\u001a\u00020!2\u0007\u0010±\u0001\u001a\u00020\u0018J\u0018\u0010²\u0001\u001a\u00020!2\t\u0010³\u0001\u001a\u0004\u0018\u00010#¢\u0006\u0003\u0010´\u0001J\u0007\u0010µ\u0001\u001a\u00020!J\u0007\u0010¶\u0001\u001a\u00020!J\u0007\u0010·\u0001\u001a\u00020!J2\u0010¸\u0001\u001a\u00020!2\t\b\u0002\u0010¹\u0001\u001a\u00020#2\u000b\b\u0002\u0010º\u0001\u001a\u0004\u0018\u00010#2\t\b\u0002\u0010»\u0001\u001a\u00020\u0018H\u0002¢\u0006\u0003\u0010¼\u0001J%\u0010½\u0001\u001a\u00020!2\u0007\u0010¹\u0001\u001a\u00020#2\u000b\b\u0002\u0010º\u0001\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0003\u0010¾\u0001J\u001a\u0010¿\u0001\u001a\u00020!2\u0006\u0010C\u001a\u00020&2\u0007\u0010À\u0001\u001a\u00020#H\u0002J-\u0010Á\u0001\u001a\u00020!2\u0007\u0010Â\u0001\u001a\u00020&2\u001b\b\u0002\u0010Ã\u0001\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0007\u0012\u0005\u0018\u00010Å\u0001\u0018\u00010Ä\u0001J\u0010\u0010Æ\u0001\u001a\u00020!2\u0007\u0010¥\u0001\u001a\u00020#J\t\u0010Ç\u0001\u001a\u00020!H\u0002J\u0011\u0010È\u0001\u001a\u00020!2\b\u0010É\u0001\u001a\u00030\u009c\u0001J\u001d\u0010Ê\u0001\u001a\u00020!2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\b\u0010Ë\u0001\u001a\u00030Ì\u0001J\u0013\u0010Í\u0001\u001a\u00020V2\b\u0010Ë\u0001\u001a\u00030Ì\u0001H\u0002J\u001f\u0010Î\u0001\u001a\u00020!2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\b\u0010Ë\u0001\u001a\u00030Ì\u0001H\u0003J\u0012\u0010Ï\u0001\u001a\u00020!2\u0007\u0010¥\u0001\u001a\u00020#H\u0002J\u0014\u0010Ð\u0001\u001a\u00020#2\t\b\u0002\u0010Ñ\u0001\u001a\u00020&H\u0002J\u001c\u0010Ò\u0001\u001a\u0004\u0018\u00010#2\t\b\u0002\u0010Ñ\u0001\u001a\u00020&H\u0002¢\u0006\u0003\u0010Ó\u0001J\u0010\u0010Ô\u0001\u001a\u00020!2\u0007\u0010Õ\u0001\u001a\u00020\u0015J\u0018\u0010Ö\u0001\u001a\u00020!2\r\u0010×\u0001\u001a\b\u0012\u0004\u0012\u00020:03H\u0002J\u0012\u0010Ø\u0001\u001a\u00020!2\u0007\u0010Ù\u0001\u001a\u00020#H\u0002J\u0007\u0010Ú\u0001\u001a\u00020!J\u0010\u0010Û\u0001\u001a\u00020!2\u0007\u0010\u008c\u0001\u001a\u00020#J\u0010\u0010Ü\u0001\u001a\u00020!2\u0007\u0010\u008c\u0001\u001a\u00020#J\u0011\u0010Ý\u0001\u001a\u00020!2\u0006\u0010I\u001a\u00020\u0018H\u0002J\u000f\u0010Þ\u0001\u001a\u00020!2\u0006\u0010L\u001a\u00020\u0018J\u0011\u0010ß\u0001\u001a\u00020!2\u0006\u0010M\u001a\u00020\u0018H\u0002J\u0011\u0010à\u0001\u001a\u00020!2\u0006\u0010O\u001a\u00020\u0018H\u0002J\u0011\u0010á\u0001\u001a\u00020!2\u0006\u0010[\u001a\u00020\\H\u0002J\u0011\u0010â\u0001\u001a\u00020!2\u0006\u0010`\u001a\u00020#H\u0002J\u0011\u0010ã\u0001\u001a\u00020!2\u0006\u0010m\u001a\u00020&H\u0002J\u0012\u0010ä\u0001\u001a\u00020!2\u0007\u0010Ù\u0001\u001a\u00020#H\u0002J\u0011\u0010å\u0001\u001a\u00020!2\u0006\u0010~\u001a\u00020#H\u0002J\u0014\u0010æ\u0001\u001a\u00020!2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010(H\u0002J\u001a\u0010ç\u0001\u001a\u00020!2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0003\u0010´\u0001J\u0010\u0010è\u0001\u001a\u00020!2\u0007\u0010Ù\u0001\u001a\u00020\u001dJ\"\u0010é\u0001\u001a\u00020!2\u0007\u0010ê\u0001\u001a\u00020#2\u0007\u0010ë\u0001\u001a\u00020#2\u0007\u0010Â\u0001\u001a\u00020(J\u0018\u0010ì\u0001\u001a\u00020!2\r\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020=03H\u0002J\t\u0010î\u0001\u001a\u00020!H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010+\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0010\u00100\u001a\u0004\u0018\u00010(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020403\u0018\u000102X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0019\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#02¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0302¢\u0006\b\n\u0000\u001a\u0004\b;\u00106R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0302¢\u0006\b\n\u0000\u001a\u0004\b>\u00106R\u0019\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0012\u0010C\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010E\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010\u00180\u00180F¢\u0006\b\n\u0000\u001a\u0004\bE\u0010HR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001802¢\u0006\b\n\u0000\u001a\u0004\bI\u00106R\u0011\u0010J\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001802¢\u0006\b\n\u0000\u001a\u0004\bL\u00106R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001802¢\u0006\b\n\u0000\u001a\u0004\bM\u00106R\u0019\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\bN\u00106R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001802¢\u0006\b\n\u0000\u001a\u0004\bO\u00106R\u001a\u0010P\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010RR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001802¢\u0006\b\n\u0000\u001a\u0004\bS\u00106R\u0019\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001802¢\u0006\b\n\u0000\u001a\u0004\bT\u00106R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010X\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010D\u001a\u0004\bY\u0010ZR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\\02¢\u0006\b\n\u0000\u001a\u0004\b]\u00106R\u0019\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0@¢\u0006\b\n\u0000\u001a\u0004\b_\u0010BR\u0015\u0010`\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010c\u001a\u0004\ba\u0010bR\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001d02¢\u0006\b\n\u0000\u001a\u0004\be\u00106R\u0010\u0010f\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001d02¢\u0006\b\n\u0000\u001a\u0004\bh\u00106R\u0019\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f02¢\u0006\b\n\u0000\u001a\u0004\bj\u00106R\u0019\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0F¢\u0006\b\n\u0000\u001a\u0004\bl\u0010HR\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020&02¢\u0006\b\n\u0000\u001a\u0004\bn\u00106R\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020\\03¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0013\u0010w\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bx\u0010-R\u001a\u0010y\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010K\"\u0004\b{\u0010RR\u0012\u0010|\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010}\u001a\b\u0012\u0004\u0012\u00020#02X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010~\u001a\b\u0012\u0004\u0012\u00020#02¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u00106R\u001b\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0F¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010HR\u0019\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020!0@¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010BR\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0085\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#02¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u00106R\u0017\u0010\u0087\u0001\u001a\u0004\u0018\u00010&¢\u0006\u000b\n\u0002\u0010D\u001a\u0005\b\u0088\u0001\u0010ZR\u0015\u0010\u0089\u0001\u001a\u0004\u0018\u00010(¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010-¨\u0006ð\u0001"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "gateInteractor", "Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "streamInteractor", "Lru/tattelecom/intercom/domain/interactors/StreamInteractor;", "userInteractor", "Lru/tattelecom/intercom/domain/contracts/PlayerUserInteractor;", "lockGateInteractor", "Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "configInteractor", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/GateInteractor;Lru/tattelecom/intercom/domain/interactors/StreamInteractor;Lru/tattelecom/intercom/domain/contracts/PlayerUserInteractor;Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;)V", "_downloadListMutex", "Lkotlinx/coroutines/sync/Mutex;", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "_isStreamLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isVideoError", "_playbackSpeedDialogEvent", "Lru/tattelecom/intercom/feature/videoplayer/PlaybackSpeedDialogEvent;", "_scale", "", "_screenState", "Lru/tattelecom/intercom/feature/videoplayer/PlayerState;", "_timelineUpdateEvent", "", VideoPlayerViewModel.AXXON_DIFF_TIME, "", "buildingServices", "Lkotlin/Pair;", "", "cameraArchiveSource", "", "cameraArchiveTimeFormatter", "Ljava/text/SimpleDateFormat;", "cameraExportSource", "getCameraExportSource", "()Ljava/lang/String;", "cameraLiveSource", "getCameraLiveSource", "cameraUrl", "currentDayGateEvents", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem;", "getCurrentDayGateEvents$videoplayer_release", "()Lkotlinx/coroutines/flow/StateFlow;", VideoPlayerViewModel.DAY_START_TIME, "getDayStartTime", "days", "Ljava/util/Date;", "getDays", "downloadListFlow", "Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem;", "getDownloadListFlow", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "gateId", "Ljava/lang/Integer;", "isBadConnBannerClosed", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "()Landroidx/lifecycle/MutableLiveData;", "isFavorite", "isFlussonic", "()Z", VideoPlayerViewModel.IS_LIVE, VideoPlayerViewModel.IS_MENU_SHOWN, "isOpenDoorEnabled", VideoPlayerViewModel.IS_OPEN_DOOR_LOADING, "isPlayerTimeSeeked", "setPlayerTimeSeeked", "(Z)V", "isStreamLoading", "isVideoError", "keepAliveAxxonJob", "Lkotlinx/coroutines/Job;", VideoPlayerViewModel.LAST_AXXON_PLAYER_TIME, "leaveOrderDestination", "getLeaveOrderDestination", "()Ljava/lang/Integer;", VideoPlayerViewModel.PLAYBACK_SPEED, "Lru/tattelecom/intercom/feature/videoplayer/SpeedPlayback;", "getPlaybackSpeed", "playbackSpeedDialogEvent", "getPlaybackSpeedDialogEvent", VideoPlayerViewModel.PLAYER_TIME, "getPlayerTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "playerVolume", "getPlayerVolume", "refreshPlayerTimeJob", "scale", "getScale", "screenState", "getScreenState", "scrollEventId", "getScrollEventId", VideoPlayerViewModel.SELECTED_DAY_ID, "getSelectedDayId", "speedPlaybackValues", "getSpeedPlaybackValues", "()Ljava/util/List;", "streamArchiveService", "getStreamArchiveService", "()I", "setStreamArchiveService", "(I)V", "streamDescription", "getStreamDescription", "streamDownloadService", "getStreamDownloadService", "setStreamDownloadService", "streamId", VideoPlayerViewModel.STREAM_START_TIME, VideoPlayerViewModel.STREAM_TIME, "getStreamTime", VideoPlayerViewModel.STREAM_URL, "getStreamUrl", "timelineUpdateEvent", "getTimelineUpdateEvent", "updateEventsJob", "videoLoadStartTime", "getVideoLoadStartTime", "videoPlayerDestination", "getVideoPlayerDestination", "videoUrl", "getVideoUrl", "changeDownloadState", "downloadId", "percentage", "changeFavoriteStatus", "changeMenuState", "isShown", "checkConnection", "context", "Landroid/content/Context;", "checkSubType", "netSubType", "(Ljava/lang/Integer;)Z", "checkVpnConnection", "convertTimeToPattern", "cursorValue", "generateScreenshotFilename", "getDownload", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "downloadDescription", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserToken", "isToolTipRequires", "toolTip", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor$ToolTips;", "maybeShowDoubleTapBanner", "onArchiveTimeSelected", "timeInMs", "isNeedToScrollEventList", "onCleared", "onCloseToolTip", "onDayClick", FirebaseAnalytics.Param.INDEX, "onEventRewind", "timelineTimeInMs", "isForward", "onSpeedClick", LogWriteConstants.SPEED, "onStreamLoading", "isLoading", "onStreamTimeReceived", "playerTimeInMillis", "(Ljava/lang/Long;)V", "onVideoPlayerError", "onVideoRefresh", "openDoor", "provideCameraStream", "additionalTimeInMs", "startTimeInMs", "isInit", "(JLjava/lang/Long;Z)V", "provideIntercomStream", "(JLjava/lang/Long;)V", "refreshEvents", "selectedDay", "reportEvent", "eventId", "params", "", "", "reportVideoLoadedEvent", "resetAxxonTimeline", "saveDownload", "model", "saveScreenshot", "bitmap", "Landroid/graphics/Bitmap;", "saveScreenshotUsingFile", "saveScreenshotUsingMediaStore", "scrollEventList", "selectedDayInMs", "day", "selectedDayInMsOrNull", "(I)Ljava/lang/Long;", "sendEvent", NotificationCompat.CATEGORY_EVENT, "setDayList", VideoPlayerViewModel.DAY_LIST, "setDayStartTime", "value", "setDoubleTapHintShown", "setDownloadCompleted", "setDownloadError", "setIsFavorite", "setIsLive", "setIsMenuShown", "setIsOpenDoorLoading", "setPlaybackSpeed", "setPlayerTime", "setSelectedDayId", "setStreamStartTime", "setStreamTime", "setStreamUrl", "setVideoLoadStartTime", "setVolume", "tryToAddDownload", "startTime", "duration", "updateDownloadList", SelectItemDialog.ARG_LIST, "updatePlaybackValues", "Companion", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoPlayerViewModel extends ViewModel {
    public static final String AXXON_DIFF_TIME = "axxonDiffTime";
    public static final String BUILDING_SERVICES = "buildingServices";
    public static final String CAMERA_ARCHIVE_SOURCE = "cameraArchiveSource";
    public static final String CAMERA_EXPORT_SOURCE = "cameraExportSource";
    public static final String CAMERA_LIVE_SOURCE = "cameraLiveSource";
    public static final String CAMERA_URL = "cameraUrl";
    public static final String DAY_LIST = "dayList";
    public static final String DAY_START_TIME = "dayStartTime";
    public static final String DOWNLOAD_LIST = "downloadList";
    public static final String GATE_ID = "gateId";
    public static final String IS_FAVORITE = "isFavorite";
    public static final String IS_FLUSSONIC = "isFlussonic";
    public static final String IS_LIVE = "isLive";
    public static final String IS_MENU_SHOWN = "isMenuShown";
    public static final String IS_OPEN_DOOR_LOADING = "isOpenDoorLoading";
    public static final String LAST_AXXON_PLAYER_TIME = "lastAxxonPlayerTime";
    public static final String LEAVE_ORDER_DESTINATION = "leaveOrderDestination";
    public static final String PLAYBACK_SPEED = "playbackSpeed";
    public static final String PLAYBACK_SPEED_LIST = "playbackSpeedList";
    public static final String PLAYER_TIME = "playerTime";
    public static final String PREVIOUS_PAGE = "previousPage";
    public static final int REWIND_COOLDOWN = 5000;
    public static final String SELECTED_DAY_ID = "selectedDayId";
    public static final String STREAM_DESCRIPTION = "streamDescription";
    public static final String STREAM_ID = "streamId";
    public static final String STREAM_START_TIME = "streamStartTime";
    public static final String STREAM_TIME = "streamTime";
    public static final String STREAM_URL = "streamUrl";
    public static final String VIDEO_PLAYER_DESTINATION = "videoPlayerDestination";
    public static final String VIDEO_START_TIME = "videoStartTime";
    public static final String VIDEO_URL = "videoUrl";
    public static final String VOLUME_VALUE = "volumeValue";
    private final Mutex _downloadListMutex;
    private final MutableSharedFlow<PlayerEvent> _events;
    private final MutableStateFlow<Boolean> _isStreamLoading;
    private final MutableStateFlow<Boolean> _isVideoError;
    private final MutableSharedFlow<PlaybackSpeedDialogEvent> _playbackSpeedDialogEvent;
    private final MutableStateFlow<Float> _scale;
    private final MutableStateFlow<PlayerState> _screenState;
    private final MutableSharedFlow<Unit> _timelineUpdateEvent;
    private long axxonDiffTime;
    private final Pair<Integer, Boolean> buildingServices;
    private final String cameraArchiveSource;
    private final SimpleDateFormat cameraArchiveTimeFormatter;
    private final String cameraExportSource;
    private final String cameraLiveSource;
    private final String cameraUrl;
    private final ConfigInteractor configInteractor;
    private final StateFlow<List<EventItem>> currentDayGateEvents;
    private final StateFlow<Long> dayStartTime;
    private final StateFlow<List<Date>> days;
    private final StateFlow<List<DownloadItem>> downloadListFlow;
    private final SharedFlow<PlayerEvent> events;
    private final Integer gateId;
    private final GateInteractor gateInteractor;
    private final MutableLiveData<Boolean> isBadConnBannerClosed;
    private final StateFlow<Boolean> isFavorite;
    private final boolean isFlussonic;
    private final StateFlow<Boolean> isLive;
    private final StateFlow<Boolean> isMenuShown;
    private final StateFlow<Boolean> isOpenDoorEnabled;
    private final StateFlow<Boolean> isOpenDoorLoading;
    private boolean isPlayerTimeSeeked;
    private final StateFlow<Boolean> isStreamLoading;
    private final StateFlow<Boolean> isVideoError;
    private Job keepAliveAxxonJob;
    private long lastAxxonPlayerTime;
    private final Integer leaveOrderDestination;
    private final LockGateInteractor lockGateInteractor;
    private final LogInteractor logInteractor;
    private final StateFlow<SpeedPlayback> playbackSpeed;
    private final SharedFlow<PlaybackSpeedDialogEvent> playbackSpeedDialogEvent;
    private final Long playerTime;
    private final StateFlow<Float> playerVolume;
    private Job refreshPlayerTimeJob;
    private final SavedStateHandle savedStateHandle;
    private final StateFlow<Float> scale;
    private final StateFlow<PlayerState> screenState;
    private final MutableLiveData<Integer> scrollEventId;
    private final StateFlow<Integer> selectedDayId;
    private final List<SpeedPlayback> speedPlaybackValues;
    private int streamArchiveService;
    private final String streamDescription;
    private boolean streamDownloadService;
    private final Integer streamId;
    private final StreamInteractor streamInteractor;
    private StateFlow<Long> streamStartTime;
    private final StateFlow<Long> streamTime;
    private final MutableLiveData<String> streamUrl;
    private final SharedFlow<Unit> timelineUpdateEvent;
    private Job updateEventsJob;
    private final PlayerUserInteractor userInteractor;
    private final StateFlow<Long> videoLoadStartTime;
    private final Integer videoPlayerDestination;
    private final String videoUrl;

    public VideoPlayerViewModel(SavedStateHandle savedStateHandle, GateInteractor gateInteractor, StreamInteractor streamInteractor, PlayerUserInteractor userInteractor, LockGateInteractor lockGateInteractor, LogInteractor logInteractor, ConfigInteractor configInteractor) {
        StateFlow<Boolean> stateFlow;
        StateFlow<List<EventItem>> stateFlow2;
        PlayerState value;
        PlayerState.Camera camera;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(gateInteractor, "gateInteractor");
        Intrinsics.checkNotNullParameter(streamInteractor, "streamInteractor");
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        Intrinsics.checkNotNullParameter(lockGateInteractor, "lockGateInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        Intrinsics.checkNotNullParameter(configInteractor, "configInteractor");
        this.savedStateHandle = savedStateHandle;
        this.gateInteractor = gateInteractor;
        this.streamInteractor = streamInteractor;
        this.userInteractor = userInteractor;
        this.lockGateInteractor = lockGateInteractor;
        this.logInteractor = logInteractor;
        this.configInteractor = configInteractor;
        MutableStateFlow<PlayerState> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._screenState = MutableStateFlow;
        this.screenState = FlowKt.asStateFlow(MutableStateFlow);
        this.isLive = savedStateHandle.getStateFlow(IS_LIVE, true);
        MutableSharedFlow<PlayerEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 5, BufferOverflow.DROP_OLDEST, 1, null);
        this._events = MutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableSharedFlow<Unit> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._timelineUpdateEvent = MutableSharedFlow$default2;
        this.timelineUpdateEvent = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        this.isBadConnBannerClosed = new MutableLiveData<>(false);
        this.cameraArchiveTimeFormatter = new SimpleDateFormat("yyyyMMdd'T'HHmmss", new Locale("RU"));
        Pair<Integer, Boolean> pair = (Pair) savedStateHandle.get("buildingServices");
        pair = pair == null ? new Pair<>(2, false) : pair;
        this.buildingServices = pair;
        this.streamArchiveService = pair.getFirst().intValue();
        this.streamDownloadService = pair.getSecond().booleanValue();
        this.leaveOrderDestination = (Integer) savedStateHandle.get("leaveOrderDestination");
        this.videoPlayerDestination = (Integer) savedStateHandle.get("videoPlayerDestination");
        this.isFavorite = savedStateHandle.getStateFlow("isFavorite", false);
        this.videoLoadStartTime = savedStateHandle.getStateFlow(VIDEO_START_TIME, null);
        this.streamId = (Integer) savedStateHandle.get("streamId");
        this.streamDescription = (String) savedStateHandle.get("streamDescription");
        this.videoUrl = (String) savedStateHandle.get("videoUrl");
        Integer num = (Integer) savedStateHandle.get("gateId");
        this.gateId = num;
        this.cameraUrl = (String) savedStateHandle.get("cameraUrl");
        this.cameraLiveSource = (String) savedStateHandle.get("cameraLiveSource");
        this.cameraArchiveSource = (String) savedStateHandle.get("cameraArchiveSource");
        this.cameraExportSource = (String) savedStateHandle.get("cameraExportSource");
        Boolean bool = (Boolean) savedStateHandle.get("isFlussonic");
        this.isFlussonic = bool != null ? bool.booleanValue() : true;
        this.streamUrl = savedStateHandle.getLiveData(STREAM_URL, null);
        this.selectedDayId = savedStateHandle.getStateFlow(SELECTED_DAY_ID, -1);
        this.isOpenDoorLoading = savedStateHandle.getStateFlow(IS_OPEN_DOOR_LOADING, false);
        if (num != null) {
            final Flow<LockGateStatusDto> gateLockStatusById = lockGateInteractor.getGateLockStatusById(num.intValue());
            stateFlow = FlowKt.stateIn(new Flow<Boolean>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                /* renamed from: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ VideoPlayerViewModel this$0;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1$2", f = "VideoPlayerViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, VideoPlayerViewModel videoPlayerViewModel) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = videoPlayerViewModel;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
                    
                        if (r2.checkDateLock(r7.getDate()) == false) goto L18;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x005f A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r8
                            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r8 = r0.label
                            int r8 = r8 - r2
                            r0.label = r8
                            goto L19
                        L14:
                            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L19:
                            java.lang.Object r8 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L32
                            if (r2 != r3) goto L2a
                            kotlin.ResultKt.throwOnFailure(r8)
                            goto L60
                        L2a:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L32:
                            kotlin.ResultKt.throwOnFailure(r8)
                            kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                            r2 = r0
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            ru.tattelecom.intercom.domain.model.LockGateStatusDto r7 = (ru.tattelecom.intercom.domain.model.LockGateStatusDto) r7
                            if (r7 == 0) goto L4e
                            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r2 = r6.this$0
                            ru.tattelecom.intercom.domain.interactors.LockGateInteractor r2 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel.access$getLockGateInteractor$p(r2)
                            long r4 = r7.getDate()
                            boolean r2 = r2.checkDateLock(r4)
                            if (r2 != 0) goto L50
                        L4e:
                            if (r7 != 0) goto L52
                        L50:
                            r7 = r3
                            goto L53
                        L52:
                            r7 = 0
                        L53:
                            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
                            r0.label = r3
                            java.lang.Object r7 = r8.emit(r7, r0)
                            if (r7 != r1) goto L60
                            return r1
                        L60:
                            kotlin.Unit r7 = kotlin.Unit.INSTANCE
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }
            }, ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), true);
        } else {
            stateFlow = null;
        }
        this.isOpenDoorEnabled = stateFlow;
        this.days = savedStateHandle.getStateFlow(DAY_LIST, CollectionsKt.emptyList());
        this.streamTime = savedStateHandle.getStateFlow(STREAM_TIME, 0L);
        this.playerTime = (Long) savedStateHandle.get(PLAYER_TIME);
        this.dayStartTime = savedStateHandle.getStateFlow(DAY_START_TIME, null);
        this.streamStartTime = savedStateHandle.getStateFlow(STREAM_START_TIME, 0L);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._isVideoError = MutableStateFlow2;
        this.isVideoError = FlowKt.asStateFlow(MutableStateFlow2);
        this.playerVolume = savedStateHandle.getStateFlow(VOLUME_VALUE, Float.valueOf(1.0f));
        this.isMenuShown = savedStateHandle.getStateFlow(IS_MENU_SHOWN, false);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(true);
        this._isStreamLoading = MutableStateFlow3;
        this.isStreamLoading = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<Float> MutableStateFlow4 = StateFlowKt.MutableStateFlow(Float.valueOf(1.0f));
        this._scale = MutableStateFlow4;
        this.scale = FlowKt.asStateFlow(MutableStateFlow4);
        List<SpeedPlayback> list = (List) savedStateHandle.get(PLAYBACK_SPEED_LIST);
        list = list == null ? CollectionsKt.listOf((Object[]) new SpeedPlayback[]{new SpeedPlayback("0.5x", 0.5f, false), new SpeedPlayback("Обычная", 1.0f, true), new SpeedPlayback("2x", 2.0f, false), new SpeedPlayback("4x", 4.0f, false), new SpeedPlayback("8x", 8.0f, false)}) : list;
        this.speedPlaybackValues = list;
        this.playbackSpeed = savedStateHandle.getStateFlow(PLAYBACK_SPEED, list.get(1));
        MutableSharedFlow<PlaybackSpeedDialogEvent> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._playbackSpeedDialogEvent = MutableSharedFlow$default3;
        this.playbackSpeedDialogEvent = FlowKt.asSharedFlow(MutableSharedFlow$default3);
        this.downloadListFlow = savedStateHandle.getStateFlow(DOWNLOAD_LIST, CollectionsKt.emptyList());
        this._downloadListMutex = MutexKt.Mutex$default(false, 1, null);
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i < 8; i++) {
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            Date time = calendar.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
            arrayList.add(time);
            calendar.add(5, -1);
        }
        setDayList(arrayList);
        if (this.videoLoadStartTime.getValue() == null) {
            setVideoLoadStartTime(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        }
        if (this.isLive.getValue().booleanValue()) {
            setDayStartTime(Calendar.getInstance().getTimeInMillis());
            setStreamTime(0L);
        }
        Integer num2 = this.gateId;
        if (num2 != null) {
            int intValue = num2.intValue();
            refreshEvents(this.gateId.intValue(), selectedDayInMs$default(this, 0, 1, null));
            VideoPlayerViewModel videoPlayerViewModel = this;
            stateFlow2 = FlowKt.stateIn(FlowKt.combine(FlowKt.stateIn(FlowKt.combine(FlowKt.stateIn(this.gateInteractor.getEventsFlow(intValue), ViewModelKt.getViewModelScope(videoPlayerViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), CollectionsKt.emptyList()), this.selectedDayId, new VideoPlayerViewModel$2$currentDayEvents$1(this, null)), ViewModelKt.getViewModelScope(videoPlayerViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), CollectionsKt.emptyList()), this.downloadListFlow, new VideoPlayerViewModel$2$1(null)), ViewModelKt.getViewModelScope(videoPlayerViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), CollectionsKt.emptyList());
        } else {
            stateFlow2 = null;
        }
        this.currentDayGateEvents = stateFlow2;
        MutableStateFlow<PlayerState> mutableStateFlow = this._screenState;
        do {
            value = mutableStateFlow.getValue();
            if (this.gateId != null) {
                if (this.streamUrl.getValue() == null) {
                    setStreamUrl(this.videoUrl);
                }
                camera = PlayerState.Intercom.INSTANCE;
            } else {
                provideCameraStream$default(this, 0L, null, true, 3, null);
                camera = PlayerState.Camera.INSTANCE;
            }
        } while (!mutableStateFlow.compareAndSet(value, camera));
        this.scrollEventId = new MutableLiveData<>(null);
        Long l = (Long) this.savedStateHandle.get(LAST_AXXON_PLAYER_TIME);
        this.lastAxxonPlayerTime = l != null ? l.longValue() : 0L;
        Long l2 = (Long) this.savedStateHandle.get(AXXON_DIFF_TIME);
        this.axxonDiffTime = l2 != null ? l2.longValue() : 0L;
    }

    public final StateFlow<PlayerState> getScreenState() {
        return this.screenState;
    }

    public final StateFlow<Boolean> isLive() {
        return this.isLive;
    }

    public final void setIsLive(boolean isLive) {
        this.savedStateHandle.set(IS_LIVE, Boolean.valueOf(isLive));
    }

    public final SharedFlow<PlayerEvent> getEvents() {
        return this.events;
    }

    public final SharedFlow<Unit> getTimelineUpdateEvent() {
        return this.timelineUpdateEvent;
    }

    public final MutableLiveData<Boolean> isBadConnBannerClosed() {
        return this.isBadConnBannerClosed;
    }

    public final int getStreamArchiveService() {
        return this.streamArchiveService;
    }

    public final void setStreamArchiveService(int i) {
        this.streamArchiveService = i;
    }

    public final boolean getStreamDownloadService() {
        return this.streamDownloadService;
    }

    public final void setStreamDownloadService(boolean z) {
        this.streamDownloadService = z;
    }

    public final Integer getLeaveOrderDestination() {
        return this.leaveOrderDestination;
    }

    public final Integer getVideoPlayerDestination() {
        return this.videoPlayerDestination;
    }

    public final StateFlow<Boolean> isFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setIsFavorite(boolean isFavorite) {
        this.savedStateHandle.set("isFavorite", Boolean.valueOf(isFavorite));
    }

    public final StateFlow<Long> getVideoLoadStartTime() {
        return this.videoLoadStartTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVideoLoadStartTime(Long videoLoadStartTime) {
        this.savedStateHandle.set(VIDEO_START_TIME, videoLoadStartTime);
    }

    public final String getStreamDescription() {
        return this.streamDescription;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getCameraLiveSource() {
        return this.cameraLiveSource;
    }

    public final String getCameraExportSource() {
        return this.cameraExportSource;
    }

    /* renamed from: isFlussonic, reason: from getter */
    public final boolean getIsFlussonic() {
        return this.isFlussonic;
    }

    public final MutableLiveData<String> getStreamUrl() {
        return this.streamUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStreamUrl(String streamUrl) {
        this.savedStateHandle.set(STREAM_URL, streamUrl);
    }

    public final StateFlow<Integer> getSelectedDayId() {
        return this.selectedDayId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSelectedDayId(int selectedDayId) {
        Integer num = this.gateId;
        if (num != null) {
            refreshEvents(num.intValue(), selectedDayInMs(selectedDayId));
        }
        this.savedStateHandle.set(SELECTED_DAY_ID, Integer.valueOf(selectedDayId));
    }

    public final StateFlow<Boolean> isOpenDoorLoading() {
        return this.isOpenDoorLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setIsOpenDoorLoading(boolean isOpenDoorLoading) {
        this.savedStateHandle.set(IS_OPEN_DOOR_LOADING, Boolean.valueOf(isOpenDoorLoading));
    }

    public final StateFlow<Boolean> isOpenDoorEnabled() {
        return this.isOpenDoorEnabled;
    }

    public final StateFlow<List<Date>> getDays() {
        return this.days;
    }

    private final void setDayList(List<? extends Date> dayList) {
        this.savedStateHandle.set(DAY_LIST, dayList);
    }

    public final StateFlow<Long> getStreamTime() {
        return this.streamTime;
    }

    private final void setStreamTime(long streamTime) {
        this.savedStateHandle.set(STREAM_TIME, Long.valueOf(streamTime));
    }

    public final Long getPlayerTime() {
        return this.playerTime;
    }

    private final void setPlayerTime(long playerTime) {
        this.savedStateHandle.set(PLAYER_TIME, Long.valueOf(playerTime));
    }

    /* renamed from: isPlayerTimeSeeked, reason: from getter */
    public final boolean getIsPlayerTimeSeeked() {
        return this.isPlayerTimeSeeked;
    }

    public final void setPlayerTimeSeeked(boolean z) {
        this.isPlayerTimeSeeked = z;
    }

    public final StateFlow<Long> getDayStartTime() {
        return this.dayStartTime;
    }

    private final void setDayStartTime(long value) {
        this.savedStateHandle.set(DAY_START_TIME, Long.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStreamStartTime(long value) {
        this.savedStateHandle.set(STREAM_START_TIME, Long.valueOf(value));
    }

    public final StateFlow<Boolean> isVideoError() {
        return this.isVideoError;
    }

    public final StateFlow<Float> getPlayerVolume() {
        return this.playerVolume;
    }

    public final void setVolume(float value) {
        this.savedStateHandle.set(VOLUME_VALUE, Float.valueOf(value));
    }

    public final StateFlow<Boolean> isMenuShown() {
        return this.isMenuShown;
    }

    private final void setIsMenuShown(boolean isMenuShown) {
        this.savedStateHandle.set(IS_MENU_SHOWN, Boolean.valueOf(isMenuShown));
    }

    public final StateFlow<Boolean> isStreamLoading() {
        return this.isStreamLoading;
    }

    public final StateFlow<Float> getScale() {
        return this.scale;
    }

    public final List<SpeedPlayback> getSpeedPlaybackValues() {
        return this.speedPlaybackValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlaybackValues() {
        this.savedStateHandle.set(PLAYBACK_SPEED_LIST, this.speedPlaybackValues);
    }

    public final StateFlow<SpeedPlayback> getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlaybackSpeed(SpeedPlayback playbackSpeed) {
        this.savedStateHandle.set(PLAYBACK_SPEED, playbackSpeed);
    }

    public final SharedFlow<PlaybackSpeedDialogEvent> getPlaybackSpeedDialogEvent() {
        return this.playbackSpeedDialogEvent;
    }

    public final StateFlow<List<EventItem>> getCurrentDayGateEvents$videoplayer_release() {
        return this.currentDayGateEvents;
    }

    public final StateFlow<List<DownloadItem>> getDownloadListFlow() {
        return this.downloadListFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDownloadList(List<DownloadItem> list) {
        this.savedStateHandle.set(DOWNLOAD_LIST, list);
    }

    static /* synthetic */ void provideIntercomStream$default(VideoPlayerViewModel videoPlayerViewModel, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = selectedDayInMsOrNull$default(videoPlayerViewModel, 0, 1, null);
        }
        videoPlayerViewModel.provideIntercomStream(j, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideIntercomStream(long additionalTimeInMs, Long startTimeInMs) {
        String str;
        Boolean value;
        Long valueOf = startTimeInMs != null ? Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(startTimeInMs.longValue())) : null;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(additionalTimeInMs);
        String value2 = this.streamUrl.getValue();
        String substringBeforeLast$default = value2 != null ? StringsKt.substringBeforeLast$default(value2, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null) : null;
        String value3 = this.streamUrl.getValue();
        String substringAfterLast$default = value3 != null ? StringsKt.substringAfterLast$default(value3, "?", (String) null, 2, (Object) null) : null;
        if (valueOf != null) {
            str = "archive-" + valueOf + "-" + seconds + ".m3u8?";
        } else {
            str = "mpegts?";
        }
        setStreamUrl(substringBeforeLast$default + RemoteSettings.FORWARD_SLASH_STRING + str + substringAfterLast$default);
        MutableStateFlow<Boolean> mutableStateFlow = this._isStreamLoading;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, false));
    }

    static /* synthetic */ void provideCameraStream$default(VideoPlayerViewModel videoPlayerViewModel, long j, Long l, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            l = selectedDayInMsOrNull$default(videoPlayerViewModel, 0, 1, null);
        }
        if ((i & 4) != 0) {
            z = false;
        }
        videoPlayerViewModel.provideCameraStream(j, l, z);
    }

    private final void provideCameraStream(long additionalTimeInMs, Long startTimeInMs, boolean isInit) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$provideCameraStream$1(this, startTimeInMs != null ? Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(startTimeInMs.longValue())) : null, additionalTimeInMs, isInit, null), 3, null);
    }

    private final void refreshEvents(int gateId, long selectedDay) {
        Job launch$default;
        Job job = this.updateEventsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$refreshEvents$1(this, gateId, selectedDay, null), 3, null);
        this.updateEventsJob = launch$default;
    }

    public final MutableLiveData<Integer> getScrollEventId() {
        return this.scrollEventId;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onEventRewind(long r10, boolean r12) {
        /*
            r9 = this;
            androidx.lifecycle.MutableLiveData<java.lang.Integer> r0 = r9.scrollEventId
            kotlinx.coroutines.flow.StateFlow<java.util.List<ru.tattelecom.intercom.feature.videoplayer.model.EventItem>> r1 = r9.currentDayGateEvents
            if (r1 == 0) goto L77
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L77
            r2 = 0
            r3 = -1
            if (r12 == 0) goto L37
            int r12 = r1.size()
            java.util.ListIterator r12 = r1.listIterator(r12)
        L1a:
            boolean r4 = r12.hasPrevious()
            if (r4 == 0) goto L5e
            java.lang.Object r4 = r12.previous()
            ru.tattelecom.intercom.feature.videoplayer.model.EventItem r4 = (ru.tattelecom.intercom.feature.videoplayer.model.EventItem) r4
            java.util.Date r4 = r4.getStartDate()
            long r4 = r4.getTime()
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 <= 0) goto L1a
            int r10 = r12.nextIndex()
            goto L5f
        L37:
            java.util.Iterator r12 = r1.iterator()
            r4 = r2
        L3c:
            boolean r5 = r12.hasNext()
            if (r5 == 0) goto L5e
            java.lang.Object r5 = r12.next()
            ru.tattelecom.intercom.feature.videoplayer.model.EventItem r5 = (ru.tattelecom.intercom.feature.videoplayer.model.EventItem) r5
            java.util.Date r5 = r5.getStartDate()
            long r5 = r5.getTime()
            r7 = 5000(0x1388, float:7.006E-42)
            long r7 = (long) r7
            long r7 = r10 - r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L5b
            r10 = r4
            goto L5f
        L5b:
            int r4 = r4 + 1
            goto L3c
        L5e:
            r10 = r3
        L5f:
            if (r10 == r3) goto L72
            java.lang.Object r11 = r1.get(r10)
            ru.tattelecom.intercom.feature.videoplayer.model.EventItem r11 = (ru.tattelecom.intercom.feature.videoplayer.model.EventItem) r11
            java.util.Date r11 = r11.getStartDate()
            long r11 = r11.getTime()
            r9.onArchiveTimeSelected(r11, r2)
        L72:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L78
        L77:
            r10 = 0
        L78:
            r0.setValue(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel.onEventRewind(long, boolean):void");
    }

    public static /* synthetic */ void onArchiveTimeSelected$default(VideoPlayerViewModel videoPlayerViewModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        videoPlayerViewModel.onArchiveTimeSelected(j, z);
    }

    public final void onArchiveTimeSelected(long timeInMs, boolean isNeedToScrollEventList) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$onArchiveTimeSelected$1(this, timeInMs, isNeedToScrollEventList, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollEventList(long timeInMs) {
        Integer num;
        List<EventItem> value;
        int i;
        MutableLiveData<Integer> mutableLiveData = this.scrollEventId;
        StateFlow<List<EventItem>> stateFlow = this.currentDayGateEvents;
        if (stateFlow == null || (value = stateFlow.getValue()) == null) {
            num = null;
        } else {
            Iterator<EventItem> it = value.iterator();
            int i2 = 0;
            while (true) {
                i = -1;
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (it.next().getStartDate().getTime() <= timeInMs) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                ListIterator<EventItem> listIterator = value.listIterator(value.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    } else if (listIterator.previous().getStartDate().getTime() > timeInMs) {
                        i = listIterator.nextIndex();
                        break;
                    }
                }
            } else {
                i = i2;
            }
            num = Integer.valueOf(i);
        }
        mutableLiveData.setValue(num);
    }

    static /* synthetic */ Long selectedDayInMsOrNull$default(VideoPlayerViewModel videoPlayerViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = videoPlayerViewModel.selectedDayId.getValue().intValue();
        }
        return videoPlayerViewModel.selectedDayInMsOrNull(i);
    }

    private final Long selectedDayInMsOrNull(int day) {
        if (day < 0 || day >= 7) {
            return null;
        }
        return Long.valueOf(this.days.getValue().get(6 - day).getTime());
    }

    static /* synthetic */ long selectedDayInMs$default(VideoPlayerViewModel videoPlayerViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = videoPlayerViewModel.selectedDayId.getValue().intValue();
        }
        return videoPlayerViewModel.selectedDayInMs(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long selectedDayInMs(int day) {
        if (day >= 0 && day < 7) {
            return this.days.getValue().get(6 - day).getTime();
        }
        return this.days.getValue().get(0).getTime();
    }

    public final void openDoor() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$openDoor$1(this, null), 3, null);
    }

    public final void onStreamLoading(boolean isLoading) {
        Boolean value;
        Job launch$default;
        MutableStateFlow<Boolean> mutableStateFlow = this._isStreamLoading;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(isLoading)));
        if (Intrinsics.areEqual(this.screenState.getValue(), PlayerState.Intercom.INSTANCE) || Intrinsics.areEqual(this.screenState.getValue(), PlayerState.Camera.INSTANCE)) {
            if (!isLoading) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$onStreamLoading$2(this, null), 3, null);
                this.refreshPlayerTimeJob = launch$default;
            } else {
                Job job = this.refreshPlayerTimeJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAxxonTimeline() {
        this.lastAxxonPlayerTime = 0L;
        this.axxonDiffTime = 0L;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.savedStateHandle.set(AXXON_DIFF_TIME, Long.valueOf(this.axxonDiffTime));
        this.savedStateHandle.set(LAST_AXXON_PLAYER_TIME, Long.valueOf(this.lastAxxonPlayerTime));
        Job job = this.updateEventsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.refreshPlayerTimeJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        super.onCleared();
    }

    public final void onStreamTimeReceived(Long playerTimeInMillis) {
        if (playerTimeInMillis != null) {
            if (Intrinsics.areEqual(this.screenState.getValue(), PlayerState.Camera.INSTANCE) && !this.isFlussonic) {
                long longValue = playerTimeInMillis.longValue();
                long j = this.lastAxxonPlayerTime;
                if (longValue < j) {
                    this.axxonDiffTime += j - playerTimeInMillis.longValue();
                }
                setStreamTime(playerTimeInMillis.longValue() + this.axxonDiffTime + this.streamStartTime.getValue().longValue());
                setPlayerTime(playerTimeInMillis.longValue() + this.axxonDiffTime);
                this.lastAxxonPlayerTime = playerTimeInMillis.longValue();
                return;
            }
            setStreamTime(playerTimeInMillis.longValue() + this.streamStartTime.getValue().longValue());
            setPlayerTime(playerTimeInMillis.longValue());
        }
    }

    public final void onDayClick(int index) {
        Boolean value;
        setIsLive(!(index >= 0 && index < 7));
        setSelectedDayId(index);
        MutableStateFlow<Boolean> mutableStateFlow = this._isStreamLoading;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, true));
        resetAxxonTimeline();
        setStreamStartTime(0L);
        if (index >= 0 && index < 7) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.days.getValue().get(6 - index).getTime());
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            setDayStartTime(calendar.getTimeInMillis());
            scrollEventList(calendar.getTimeInMillis());
            setStreamTime(0L);
        } else {
            Calendar calendar2 = Calendar.getInstance();
            setDayStartTime(calendar2.getTimeInMillis());
            scrollEventList(calendar2.getTimeInMillis());
            setStreamTime(calendar2.getTimeInMillis());
        }
        PlayerState value2 = this.screenState.getValue();
        if (Intrinsics.areEqual(value2, PlayerState.Intercom.INSTANCE)) {
            provideIntercomStream$default(this, TimeUnit.DAYS.toMillis(1L), null, 2, null);
        } else if (Intrinsics.areEqual(value2, PlayerState.Camera.INSTANCE)) {
            provideCameraStream$default(this, 0L, null, false, 7, null);
        }
    }

    public final String getUserToken() {
        return this.userInteractor.getUserToken();
    }

    public final String convertTimeToPattern(long cursorValue) {
        String format = new SimpleDateFormat("HH:mm:ss", new Locale("RU", "ru")).format(Long.valueOf(cursorValue));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final void changeFavoriteStatus() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$changeFavoriteStatus$1(this, null), 3, null);
    }

    public final void saveScreenshot(Context context, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$saveScreenshot$1(this, bitmap, context, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job saveScreenshotUsingFile(Bitmap bitmap) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$saveScreenshotUsingFile$1(this, bitmap, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveScreenshotUsingMediaStore(Context context, Bitmap bitmap) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", generateScreenshotFilename());
        contentValues.put("mime_type", MimeTypes.IMAGE_JPEG);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + File.separator + "Мой дом");
        ContentResolver contentResolver = context != null ? context.getContentResolver() : null;
        Uri insert = contentResolver != null ? contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) : null;
        if (insert != null) {
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            try {
                OutputStream outputStream = openOutputStream;
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(openOutputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(openOutputStream, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateScreenshotFilename() {
        return "Мой дом " + new SimpleDateFormat("d-MM-HH-mm-ss", new Locale("ru", "RU")).format(Long.valueOf(new Date().getTime())) + ".jpg";
    }

    public final void onSpeedClick(SpeedPlayback speed) {
        Intrinsics.checkNotNullParameter(speed, "speed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$onSpeedClick$1(speed, this, null), 3, null);
    }

    public final void changeMenuState(boolean isShown) {
        setIsMenuShown(isShown);
    }

    public final void onVideoPlayerError() {
        MutableStateFlow<Boolean> mutableStateFlow = this._isVideoError;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), true)) {
        }
    }

    public final void onVideoRefresh() {
        String value = this.streamUrl.getValue();
        setStreamUrl(null);
        setStreamUrl(value);
        MutableStateFlow<Boolean> mutableStateFlow = this._isVideoError;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), false)) {
        }
    }

    public final void checkVpnConnection(Context context) {
        try {
            if (checkConnection(context)) {
                return;
            }
            sendEvent(new PlayerEvent.ShowCustomSnackBar(null, 0, Integer.valueOf(R.string.msg_bad_connection_error), 0, Integer.valueOf(R.string.good), 0, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$checkVpnConnection$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VideoPlayerViewModel.this.isBadConnBannerClosed().setValue(true);
                }
            }, false, 0, 427, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final boolean checkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) (context != null ? context.getSystemService("connectivity") : null);
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        Integer valueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
        Integer valueOf2 = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getSubtype()) : null;
        NetworkCapabilities networkCapabilities = (connectivityManager != null ? connectivityManager.getActiveNetwork() : null) != null ? connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()) : null;
        if ((valueOf != null && valueOf.intValue() == 17) || (networkCapabilities != null && networkCapabilities.hasTransport(4))) {
            return false;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return true;
        }
        return checkSubType(valueOf2);
    }

    private final boolean checkSubType(Integer netSubType) {
        if (netSubType != null && netSubType.intValue() == 7) {
            return false;
        }
        if (netSubType != null && netSubType.intValue() == 4) {
            return false;
        }
        if (netSubType != null && netSubType.intValue() == 2) {
            return false;
        }
        if (netSubType != null && netSubType.intValue() == 1) {
            return false;
        }
        if (netSubType != null && netSubType.intValue() == 11) {
            return false;
        }
        return (netSubType != null && netSubType.intValue() == 5) || (netSubType != null && netSubType.intValue() == 6) || ((netSubType != null && netSubType.intValue() == 8) || ((netSubType != null && netSubType.intValue() == 10) || ((netSubType != null && netSubType.intValue() == 9) || ((netSubType != null && netSubType.intValue() == 3) || ((netSubType != null && netSubType.intValue() == 14) || ((netSubType != null && netSubType.intValue() == 12) || ((netSubType != null && netSubType.intValue() == 15) || (netSubType != null && netSubType.intValue() == 13))))))));
    }

    public final void setDoubleTapHintShown() {
        this.userInteractor.setDoubleTapHintShownState(true);
    }

    public final void maybeShowDoubleTapBanner() {
        if (this.userInteractor.getDoubleTapHintShownState()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$maybeShowDoubleTapBanner$1(this, null), 3, null);
    }

    public final void sendEvent(PlayerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$sendEvent$1(this, event, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportEvent$default(VideoPlayerViewModel videoPlayerViewModel, int i, Map map, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        videoPlayerViewModel.reportEvent(i, map);
    }

    public final void reportEvent(int eventId, Map<String, ? extends Object> params) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$reportEvent$1(this, eventId, params, null), 3, null);
    }

    public final boolean isToolTipRequires(ConfigInteractor.ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        return this.configInteractor.isToolTipRequires(toolTip) && Intrinsics.areEqual(this.screenState.getValue(), PlayerState.Intercom.INSTANCE);
    }

    public final void onCloseToolTip(ConfigInteractor.ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        this.configInteractor.setToolTipSeen(toolTip);
    }

    public final void tryToAddDownload(long startTime, long duration, String eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$tryToAddDownload$1(this, duration, startTime, eventId, null), 3, null);
    }

    public final void saveDownload(DownloadDto model) {
        Intrinsics.checkNotNullParameter(model, "model");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$saveDownload$1(this, model, null), 3, null);
    }

    public static /* synthetic */ Object getDownload$default(VideoPlayerViewModel videoPlayerViewModel, long j, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return videoPlayerViewModel.getDownload(j, str, continuation);
    }

    public final Object getDownload(long j, String str, Continuation<? super DownloadDto> continuation) {
        Deferred async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$getDownload$2(this, j, str, null), 3, null);
        return async$default.await(continuation);
    }

    public final void changeDownloadState(long downloadId, int percentage) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$changeDownloadState$1(this, downloadId, percentage, null), 3, null);
    }

    public final void setDownloadCompleted(long downloadId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$setDownloadCompleted$1(this, downloadId, null), 3, null);
    }

    public final void setDownloadError(long downloadId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$setDownloadError$1(this, downloadId, null), 3, null);
    }

    public final void reportVideoLoadedEvent(long timeInMs) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VideoPlayerViewModel$reportVideoLoadedEvent$1(this, timeInMs, null), 3, null);
    }
}
