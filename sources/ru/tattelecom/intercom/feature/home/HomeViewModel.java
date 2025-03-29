package ru.tattelecom.intercom.feature.home;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
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
import ru.tattelecom.intercom.android.resources.ConnectionChecker;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.helper.ApartmentServiceName;
import ru.tattelecom.intercom.data.local.entity.AddressWithIntercomsAndStreams;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity;
import ru.tattelecom.intercom.data.local.entity.LockGateEntity;
import ru.tattelecom.intercom.data.prefs.TutorialPrefsSource;
import ru.tattelecom.intercom.domain.contracts.AdvBottomSheetInteractor;
import ru.tattelecom.intercom.domain.interactors.AddressInteractor;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.domain.model.AdvBottomSheetDto;
import ru.tattelecom.intercom.domain.model.DefaultThemeDto;
import ru.tattelecom.intercom.domain.model.TrialDto;
import ru.tattelecom.intercom.feature.home.model.HomeEvent;
import ru.tattelecom.intercom.feature.home.model.HomeScreenState;
import ru.tattelecom.intercom.feature.home.model.OpenChatEvent;
import ru.tattelecom.intercom.feature.home.model.OpenStreamEvent;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u0010s\u001a\u00020tJ\u0010\u0010u\u001a\u00020t2\b\u0010v\u001a\u0004\u0018\u00010wJ\u0006\u0010x\u001a\u00020tJ\u000e\u0010y\u001a\u00020t2\u0006\u0010z\u001a\u00020{J)\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010}0\u00182\u0006\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0086@¢\u0006\u0003\u0010\u0082\u0001J\u0007\u0010\u0083\u0001\u001a\u00020tJ%\u0010\u0084\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020#0-2\u0007\u0010\u0085\u0001\u001a\u00020\u001fH\u0082@¢\u0006\u0003\u0010\u0086\u0001J$\u0010\u0087\u0001\u001a\u00020t2\u0007\u0010\u0088\u0001\u001a\u00020.2\u0007\u0010\u0089\u0001\u001a\u00020.2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010.J\u0011\u0010\u008b\u0001\u001a\u00020#2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J1\u0010\u008e\u0001\u001a\u00020t2 \u0010\u008f\u0001\u001a\u001b\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020t0\u0091\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0092\u00010\u0090\u0001H\u0002¢\u0006\u0003\u0010\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u00020tJ\u0011\u0010\u0095\u0001\u001a\u00020t2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020t2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\u0007\u0010\u0099\u0001\u001a\u00020tJ\u000f\u0010\u009a\u0001\u001a\u00020t2\u0006\u0010z\u001a\u00020{J\u0007\u0010\u009b\u0001\u001a\u00020tJ#\u0010\u009c\u0001\u001a\u00020t2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u001f2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010.¢\u0006\u0003\u0010\u009f\u0001J\u0018\u0010 \u0001\u001a\u00020t2\u000f\b\u0002\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020#0\u001eJ\u0019\u0010¢\u0001\u001a\u00020t2\u0007\u0010£\u0001\u001a\u00020\u001f2\u0007\u0010¤\u0001\u001a\u00020#J\u0010\u0010¥\u0001\u001a\u00020t2\u0007\u0010£\u0001\u001a\u00020\u001fJ\u000f\u0010¦\u0001\u001a\u00020t2\u0006\u0010z\u001a\u00020{J\u0010\u0010§\u0001\u001a\u00020t2\u0007\u0010¨\u0001\u001a\u00020\u001fJ\u001a\u0010©\u0001\u001a\u00020t2\u0007\u0010¨\u0001\u001a\u00020\u001f2\b\u0010ª\u0001\u001a\u00030«\u0001JO\u0010¬\u0001\u001a\u00020t2\u0007\u0010\u00ad\u0001\u001a\u00020.2\u0007\u0010®\u0001\u001a\u00020.2\u0007\u0010¯\u0001\u001a\u00020.2\u0007\u0010°\u0001\u001a\u00020.2\u0007\u0010±\u0001\u001a\u00020.2\u0007\u0010²\u0001\u001a\u00020.2\u0007\u0010³\u0001\u001a\u00020.2\u0007\u0010´\u0001\u001a\u00020.J\u001a\u0010µ\u0001\u001a\u00020t2\u0006\u0010h\u001a\u00020#2\u0007\u0010\u009d\u0001\u001a\u00020\u001fH\u0002J\u001a\u0010¶\u0001\u001a\u00020t2\u0006\u0010h\u001a\u00020#2\u0007\u0010\u009d\u0001\u001a\u00020\u001fH\u0002J#\u0010·\u0001\u001a\u00020t2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u001f2\t\u0010¹\u0001\u001a\u0004\u0018\u00010.¢\u0006\u0003\u0010\u009f\u0001J\u0014\u0010º\u0001\u001a\u00020#*\t\u0012\u0005\u0012\u00030»\u00010\u0019H\u0002J\u0014\u0010¼\u0001\u001a\u00020\u001f*\t\u0012\u0005\u0012\u00030»\u00010\u0019H\u0002J)\u0010½\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u0018*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u0018H\u0002J\u001a\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\t\u0012\u0005\u0012\u00030¿\u00010\u0019H\u0002R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00190\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010,\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0006\u0012\u0004\u0018\u00010.0-0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020#0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020#0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020#0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00190\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020#0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00190\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020#0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020#0\u0018¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018¢\u0006\b\n\u0000\u001a\u0004\bD\u0010@R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020&0\u0018¢\u0006\b\n\u0000\u001a\u0004\bF\u0010@R\u0019\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\b\n\u0000\u001a\u0004\bH\u0010@R\u0019\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010@R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020+0L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR'\u0010O\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0006\u0012\u0004\u0018\u00010.0-0L¢\u0006\b\n\u0000\u001a\u0004\bP\u0010NR\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020.0\u0018¢\u0006\b\n\u0000\u001a\u0004\bR\u0010@R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020#0\u0018¢\u0006\b\n\u0000\u001a\u0004\bT\u0010@R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u0002020L¢\u0006\b\n\u0000\u001a\u0004\bV\u0010NR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0018¢\u0006\b\n\u0000\u001a\u0004\bX\u0010@R\u001f\u0010Y\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010@R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010]\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b^\u0010@R\u001f\u0010_\u001a\u0010\u0012\f\u0012\n a*\u0004\u0018\u00010#0#0`¢\u0006\b\n\u0000\u001a\u0004\b_\u0010bR(\u0010c\u001a\u0010\u0012\f\u0012\n a*\u0004\u0018\u00010#0#0`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010b\"\u0004\bd\u0010eR\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020#0\u001c¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020#0\u001c¢\u0006\b\n\u0000\u001a\u0004\bh\u0010gR\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020#0\u001c¢\u0006\b\n\u0000\u001a\u0004\bi\u0010gR\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020#0\u001e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020m0\u001c¢\u0006\b\n\u0000\u001a\u0004\bn\u0010gR\u0011\u0010o\u001a\u00020p¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "addressInteractor", "Lru/tattelecom/intercom/domain/interactors/AddressInteractor;", "intercomInteractor", "Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;", "familyAccessInteractor", "Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;", "tutorialPrefsSource", "Lru/tattelecom/intercom/data/prefs/TutorialPrefsSource;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "configInteractor", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;", "gateInteractor", "Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "lockGateInteractor", "Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "advBottomSheetInteractor", "Lru/tattelecom/intercom/domain/contracts/AdvBottomSheetInteractor;", "(Lru/tattelecom/intercom/domain/interactors/AddressInteractor;Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;Lru/tattelecom/intercom/data/prefs/TutorialPrefsSource;Lru/tattelecom/intercom/domain/interactors/LogInteractor;Lru/tattelecom/intercom/domain/interactors/UserInteractor;Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;Lru/tattelecom/intercom/domain/interactors/GateInteractor;Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;Lru/tattelecom/intercom/domain/contracts/AdvBottomSheetInteractor;)V", "_addresses", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/tattelecom/intercom/feature/home/HomeItem;", "_addressesFromDatabase", "Lkotlinx/coroutines/flow/StateFlow;", "_collapsedAddressIds", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_collapsedAddresses", "_eventAskNotificationPermission", "Lkotlinx/coroutines/channels/Channel;", "", "_eventOpenCallsSchedule", "_eventOpenChat", "Lru/tattelecom/intercom/feature/home/model/OpenChatEvent;", "_eventOpenErrorDialog", "_eventOpenIntercomEmergencyCode", "_eventOpenStream", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lru/tattelecom/intercom/feature/home/model/OpenStreamEvent;", "_eventShareCode", "Lkotlin/Pair;", "", "_eventShowMessage", "_eventShowSnack", "_events", "Lru/tattelecom/intercom/feature/home/model/HomeEvent;", "_isError", "_isInProgress", "_isLoading", "_isLoadingGateIds", "_isRefreshing", "_isTempCodeLoadingIds", "_openTutorialBannerVisibility", "_statusLockGate", "Lru/tattelecom/intercom/data/local/entity/LockGateEntity;", "_trialFlow", "Lru/tattelecom/intercom/domain/model/TrialDto;", "cameraList", "getCameraList", "()Lkotlinx/coroutines/flow/Flow;", "eventAskNotificationPermission", "getEventAskNotificationPermission", "eventOpenCallsSchedule", "getEventOpenCallsSchedule", "eventOpenChat", "getEventOpenChat", "eventOpenErrorDialog", "getEventOpenErrorDialog", "eventOpenIntercomEmergencyCode", "getEventOpenIntercomEmergencyCode", "eventOpenStream", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventOpenStream", "()Lkotlinx/coroutines/flow/SharedFlow;", "eventShareCode", "getEventShareCode", "eventShowMessage", "getEventShowMessage", "eventShowSnack", "getEventShowSnack", "events", "getEvents", "favoriteListIsEmpty", "getFavoriteListIsEmpty", "favoritesList", "getFavoritesList", "inProgressJob", "Lkotlinx/coroutines/Job;", "intercomList", "getIntercomList", "isBadConnBannerClosed", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "()Landroidx/lifecycle/MutableLiveData;", "isFavoritesOpened", "setFavoritesOpened", "(Landroidx/lifecycle/MutableLiveData;)V", "isInProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "isLoading", "isRefreshing", "isToolTipShownFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "screenState", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", "getScreenState", "toolTipMutex", "Lkotlinx/coroutines/sync/Mutex;", "getToolTipMutex", "()Lkotlinx/coroutines/sync/Mutex;", "askNotificationPermission", "", "checkConnection", "context", "Landroid/content/Context;", "closeBanner", "generateTemporaryCodeButtonClick", "stream", "Lru/tattelecom/intercom/feature/home/HomeStream;", "getAdvBottomSheet", "Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;", "theme", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "defaultTheme", "Lru/tattelecom/intercom/domain/model/DefaultThemeDto;", "(Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;Lru/tattelecom/intercom/domain/model/DefaultThemeDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppConfig", "getBuildingServices", LogWriteConstants.BUILDING_ID, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChatConfig", "phone", "formattedPhone", "chatAction", "isToolTipRequires", "toolTip", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor$ToolTips;", "launchCancellableJob", "job", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "notificationPermissionRequested", "onAddressClick", "address", "Lru/tattelecom/intercom/feature/home/HomeAddress;", "onCloseToolTip", "onDisableDoNotDisturbClick", "onFavoritesClick", "onInProgressCancel", "onOpenGateClick", "gateId", NavArg.INTERCOM_LOGIN, "(Ljava/lang/Integer;Ljava/lang/String;)V", "onRefreshAddresses", "loading", "onSetCallsMutedClick", NavArg.INTERCOM_ID, "mutedNow", "onSetCallsScheduleClick", "onStreamClick", "reportEvent", "buttonId", "reportEventAdv", "advId", "", "sendApplicationVersion", "appVersionName", "appVersionCode", "deviceOsVersion", "deviceApiVersion", "providerName", "deviceName", "connectionType", "batteryLevel", "setGateLoading", "setTempCodeLoading", "shareTemporaryCode", "temporaryCode", "buildingInfo", "isAbilityStreamDownload", "Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", "toAvailableStreamArchiveDays", "toFilteredList", "toHomeList", "Lru/tattelecom/intercom/data/local/entity/AddressWithIntercomsAndStreams;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HomeViewModel extends ViewModel {
    private final Flow<List<HomeItem>> _addresses;
    private final StateFlow<List<HomeItem>> _addressesFromDatabase;
    private final MutableStateFlow<List<Integer>> _collapsedAddressIds;
    private final StateFlow<List<HomeItem>> _collapsedAddresses;
    private final Channel<Boolean> _eventAskNotificationPermission;
    private final Channel<Integer> _eventOpenCallsSchedule;
    private final Channel<OpenChatEvent> _eventOpenChat;
    private final Channel<Integer> _eventOpenErrorDialog;
    private final Channel<Integer> _eventOpenIntercomEmergencyCode;
    private final MutableSharedFlow<OpenStreamEvent> _eventOpenStream;
    private final MutableSharedFlow<Pair<Integer, String>> _eventShareCode;
    private final Channel<String> _eventShowMessage;
    private final Channel<Boolean> _eventShowSnack;
    private final MutableSharedFlow<HomeEvent> _events;
    private final MutableStateFlow<Boolean> _isError;
    private final MutableStateFlow<Boolean> _isInProgress;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<List<Integer>> _isLoadingGateIds;
    private final MutableStateFlow<Boolean> _isRefreshing;
    private final MutableStateFlow<List<Integer>> _isTempCodeLoadingIds;
    private final MutableStateFlow<Boolean> _openTutorialBannerVisibility;
    private final Flow<List<LockGateEntity>> _statusLockGate;
    private final Flow<TrialDto> _trialFlow;
    private final AddressInteractor addressInteractor;
    private final AdvBottomSheetInteractor advBottomSheetInteractor;
    private final Flow<List<HomeItem>> cameraList;
    private final ConfigInteractor configInteractor;
    private final Flow<Boolean> eventAskNotificationPermission;
    private final Flow<Integer> eventOpenCallsSchedule;
    private final Flow<OpenChatEvent> eventOpenChat;
    private final Flow<Integer> eventOpenErrorDialog;
    private final Flow<Integer> eventOpenIntercomEmergencyCode;
    private final SharedFlow<OpenStreamEvent> eventOpenStream;
    private final SharedFlow<Pair<Integer, String>> eventShareCode;
    private final Flow<String> eventShowMessage;
    private final Flow<Boolean> eventShowSnack;
    private final SharedFlow<HomeEvent> events;
    private final FamilyAccessInteractor familyAccessInteractor;
    private final Flow<Boolean> favoriteListIsEmpty;
    private final Flow<List<HomeItem>> favoritesList;
    private final GateInteractor gateInteractor;
    private Job inProgressJob;
    private final IntercomInteractor intercomInteractor;
    private final Flow<List<HomeItem>> intercomList;
    private final MutableLiveData<Boolean> isBadConnBannerClosed;
    private MutableLiveData<Boolean> isFavoritesOpened;
    private final StateFlow<Boolean> isInProgress;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<Boolean> isRefreshing;
    private final MutableStateFlow<Boolean> isToolTipShownFlow;
    private final LockGateInteractor lockGateInteractor;
    private final LogInteractor logInteractor;
    private final StateFlow<HomeScreenState> screenState;
    private final Mutex toolTipMutex;
    private final TutorialPrefsSource tutorialPrefsSource;
    private final UserInteractor userInteractor;

    public HomeViewModel(AddressInteractor addressInteractor, IntercomInteractor intercomInteractor, FamilyAccessInteractor familyAccessInteractor, TutorialPrefsSource tutorialPrefsSource, LogInteractor logInteractor, UserInteractor userInteractor, ConfigInteractor configInteractor, GateInteractor gateInteractor, LockGateInteractor lockGateInteractor, AdvBottomSheetInteractor advBottomSheetInteractor) {
        Intrinsics.checkNotNullParameter(addressInteractor, "addressInteractor");
        Intrinsics.checkNotNullParameter(intercomInteractor, "intercomInteractor");
        Intrinsics.checkNotNullParameter(familyAccessInteractor, "familyAccessInteractor");
        Intrinsics.checkNotNullParameter(tutorialPrefsSource, "tutorialPrefsSource");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        Intrinsics.checkNotNullParameter(configInteractor, "configInteractor");
        Intrinsics.checkNotNullParameter(gateInteractor, "gateInteractor");
        Intrinsics.checkNotNullParameter(lockGateInteractor, "lockGateInteractor");
        Intrinsics.checkNotNullParameter(advBottomSheetInteractor, "advBottomSheetInteractor");
        this.addressInteractor = addressInteractor;
        this.intercomInteractor = intercomInteractor;
        this.familyAccessInteractor = familyAccessInteractor;
        this.tutorialPrefsSource = tutorialPrefsSource;
        this.logInteractor = logInteractor;
        this.userInteractor = userInteractor;
        this.configInteractor = configInteractor;
        this.gateInteractor = gateInteractor;
        this.lockGateInteractor = lockGateInteractor;
        this.advBottomSheetInteractor = advBottomSheetInteractor;
        Flow<List<LockGateEntity>> statusLockGate = lockGateInteractor.statusLockGate();
        this._statusLockGate = statusLockGate;
        final Flow<List<AddressWithIntercomsAndStreams>> addressesAsFlow = addressInteractor.getAddressesAsFlow();
        Flow<List<? extends HomeItem>> flow = new Flow<List<? extends HomeItem>>() { // from class: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ HomeViewModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1$2", f = "HomeViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, HomeViewModel homeViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = homeViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4f
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r5 = (java.util.List) r5
                        if (r5 == 0) goto L45
                        ru.tattelecom.intercom.feature.home.HomeViewModel r2 = r4.this$0
                        java.util.List r5 = ru.tattelecom.intercom.feature.home.HomeViewModel.access$toHomeList(r2, r5)
                        goto L46
                    L45:
                        r5 = 0
                    L46:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends HomeItem>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        HomeViewModel homeViewModel = this;
        StateFlow<List<HomeItem>> stateIn = FlowKt.stateIn(flow, ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.INSTANCE.getLazily(), null);
        this._addressesFromDatabase = stateIn;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isError = MutableStateFlow;
        MutableStateFlow<List<Integer>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._collapsedAddressIds = MutableStateFlow2;
        MutableStateFlow<List<Integer>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._isLoadingGateIds = MutableStateFlow3;
        MutableStateFlow<List<Integer>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._isTempCodeLoadingIds = MutableStateFlow4;
        StateFlow<List<HomeItem>> stateIn2 = FlowKt.stateIn(FlowKt.flowCombine(stateIn, MutableStateFlow2, new HomeViewModel$_collapsedAddresses$1(this, null)), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.INSTANCE.getEagerly(), null);
        this._collapsedAddresses = stateIn2;
        final Flow<List<HomeItem>> debounce = FlowKt.debounce(FlowKt.combine(stateIn2, statusLockGate, MutableStateFlow3, MutableStateFlow4, new HomeViewModel$_addresses$1(this, null)), 100L);
        this._addresses = debounce;
        MutableStateFlow<Boolean> MutableStateFlow5 = StateFlowKt.MutableStateFlow(false);
        this._openTutorialBannerVisibility = MutableStateFlow5;
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow6;
        this.isLoading = MutableStateFlow6;
        Flow<TrialDto> trialFlow = configInteractor.getTrialFlow();
        this._trialFlow = trialFlow;
        this.screenState = FlowKt.stateIn(FlowKt.debounce(FlowKt.combine(stateIn2, MutableStateFlow, MutableStateFlow5, MutableStateFlow6, trialFlow, new HomeViewModel$screenState$1(this, null)), 50L), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.INSTANCE.getEagerly(), HomeScreenState.FirstOpen.INSTANCE);
        this.cameraList = toFilteredList(new Flow<List<? extends HomeItem>>() { // from class: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2$2", f = "HomeViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r9
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2$2$1 r0 = (ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r9 = r0.label
                        int r9 = r9 - r2
                        r0.label = r9
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2$2$1 r0 = new ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2$2$1
                        r0.<init>(r9)
                    L19:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L76
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r8 = (java.util.List) r8
                        if (r8 == 0) goto L6c
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Collection r2 = (java.util.Collection) r2
                        java.util.Iterator r8 = r8.iterator()
                    L4b:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto L69
                        java.lang.Object r4 = r8.next()
                        r5 = r4
                        ru.tattelecom.intercom.feature.home.HomeItem r5 = (ru.tattelecom.intercom.feature.home.HomeItem) r5
                        boolean r6 = r5 instanceof ru.tattelecom.intercom.feature.home.HomeStream
                        if (r6 == 0) goto L65
                        ru.tattelecom.intercom.feature.home.HomeStream r5 = (ru.tattelecom.intercom.feature.home.HomeStream) r5
                        boolean r5 = r5.isIntercom()
                        if (r5 == 0) goto L65
                        goto L4b
                    L65:
                        r2.add(r4)
                        goto L4b
                    L69:
                        java.util.List r2 = (java.util.List) r2
                        goto L6d
                    L6c:
                        r2 = 0
                    L6d:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r2, r0)
                        if (r8 != r1) goto L76
                        return r1
                    L76:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends HomeItem>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        this.intercomList = toFilteredList(new Flow<List<? extends HomeItem>>() { // from class: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3$2", f = "HomeViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r9
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3$2$1 r0 = (ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r9 = r0.label
                        int r9 = r9 - r2
                        r0.label = r9
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3$2$1 r0 = new ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3$2$1
                        r0.<init>(r9)
                    L19:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L76
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r8 = (java.util.List) r8
                        if (r8 == 0) goto L6c
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Collection r2 = (java.util.Collection) r2
                        java.util.Iterator r8 = r8.iterator()
                    L4b:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto L69
                        java.lang.Object r4 = r8.next()
                        r5 = r4
                        ru.tattelecom.intercom.feature.home.HomeItem r5 = (ru.tattelecom.intercom.feature.home.HomeItem) r5
                        boolean r6 = r5 instanceof ru.tattelecom.intercom.feature.home.HomeStream
                        if (r6 == 0) goto L65
                        ru.tattelecom.intercom.feature.home.HomeStream r5 = (ru.tattelecom.intercom.feature.home.HomeStream) r5
                        boolean r5 = r5.isIntercom()
                        if (r5 != 0) goto L65
                        goto L4b
                    L65:
                        r2.add(r4)
                        goto L4b
                    L69:
                        java.util.List r2 = (java.util.List) r2
                        goto L6d
                    L6c:
                        r2 = 0
                    L6d:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r2, r0)
                        if (r8 != r1) goto L76
                        return r1
                    L76:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends HomeItem>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        Flow<List<HomeItem>> filteredList = toFilteredList(new Flow<List<? extends HomeItem>>() { // from class: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4$2", f = "HomeViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r9
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4$2$1 r0 = (ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r9 = r0.label
                        int r9 = r9 - r2
                        r0.label = r9
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4$2$1 r0 = new ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4$2$1
                        r0.<init>(r9)
                    L19:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L76
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r8 = (java.util.List) r8
                        if (r8 == 0) goto L6c
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Collection r2 = (java.util.Collection) r2
                        java.util.Iterator r8 = r8.iterator()
                    L4b:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto L69
                        java.lang.Object r4 = r8.next()
                        r5 = r4
                        ru.tattelecom.intercom.feature.home.HomeItem r5 = (ru.tattelecom.intercom.feature.home.HomeItem) r5
                        boolean r6 = r5 instanceof ru.tattelecom.intercom.feature.home.HomeStream
                        if (r6 == 0) goto L65
                        ru.tattelecom.intercom.feature.home.HomeStream r5 = (ru.tattelecom.intercom.feature.home.HomeStream) r5
                        boolean r5 = r5.isFavorite()
                        if (r5 != 0) goto L65
                        goto L4b
                    L65:
                        r2.add(r4)
                        goto L4b
                    L69:
                        java.util.List r2 = (java.util.List) r2
                        goto L6d
                    L6c:
                        r2 = 0
                    L6d:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r2, r0)
                        if (r8 != r1) goto L76
                        return r1
                    L76:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$map$4.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends HomeItem>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        this.favoritesList = filteredList;
        this.isFavoritesOpened = new MutableLiveData<>(false);
        final Flow flowCombine = FlowKt.flowCombine(StateFlowKt.MutableStateFlow(null), filteredList, new HomeViewModel$favoriteListIsEmpty$1(null));
        this.favoriteListIsEmpty = FlowKt.take(new Flow<Boolean>() { // from class: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1$2", f = "HomeViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1$2$1 r0 = (ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1$2$1 r0 = new ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L48
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        if (r2 == 0) goto L48
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, 1);
        MutableStateFlow<Boolean> MutableStateFlow7 = StateFlowKt.MutableStateFlow(false);
        this._isRefreshing = MutableStateFlow7;
        this.isRefreshing = MutableStateFlow7;
        MutableStateFlow<Boolean> MutableStateFlow8 = StateFlowKt.MutableStateFlow(false);
        this._isInProgress = MutableStateFlow8;
        this.isInProgress = MutableStateFlow8;
        MutableSharedFlow<Pair<Integer, String>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._eventShareCode = MutableSharedFlow$default;
        this.eventShareCode = MutableSharedFlow$default;
        Channel<Boolean> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowSnack = Channel$default;
        this.eventShowSnack = FlowKt.receiveAsFlow(Channel$default);
        Channel<String> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowMessage = Channel$default2;
        this.eventShowMessage = FlowKt.receiveAsFlow(Channel$default2);
        MutableSharedFlow<OpenStreamEvent> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._eventOpenStream = MutableSharedFlow$default2;
        this.eventOpenStream = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        Channel<Integer> Channel$default3 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventOpenCallsSchedule = Channel$default3;
        this.eventOpenCallsSchedule = FlowKt.receiveAsFlow(Channel$default3);
        Channel<Integer> Channel$default4 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventOpenIntercomEmergencyCode = Channel$default4;
        this.eventOpenIntercomEmergencyCode = FlowKt.receiveAsFlow(Channel$default4);
        Channel<Integer> Channel$default5 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventOpenErrorDialog = Channel$default5;
        this.eventOpenErrorDialog = FlowKt.receiveAsFlow(Channel$default5);
        Channel<Boolean> Channel$default6 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventAskNotificationPermission = Channel$default6;
        this.eventAskNotificationPermission = FlowKt.receiveAsFlow(Channel$default6);
        MutableSharedFlow<HomeEvent> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._events = MutableSharedFlow$default3;
        this.events = FlowKt.asSharedFlow(MutableSharedFlow$default3);
        Channel<OpenChatEvent> Channel$default7 = ChannelKt.Channel$default(-1, null, null, 6, null);
        this._eventOpenChat = Channel$default7;
        this.eventOpenChat = FlowKt.receiveAsFlow(Channel$default7);
        this.isBadConnBannerClosed = new MutableLiveData<>(false);
        onRefreshAddresses(MutableStateFlow6);
        this.toolTipMutex = MutexKt.Mutex$default(false, 1, null);
        this.isToolTipShownFlow = StateFlowKt.MutableStateFlow(false);
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<HomeScreenState> getScreenState() {
        return this.screenState;
    }

    public final Flow<List<HomeItem>> getCameraList() {
        return this.cameraList;
    }

    public final Flow<List<HomeItem>> getIntercomList() {
        return this.intercomList;
    }

    public final Flow<List<HomeItem>> getFavoritesList() {
        return this.favoritesList;
    }

    public final MutableLiveData<Boolean> isFavoritesOpened() {
        return this.isFavoritesOpened;
    }

    public final void setFavoritesOpened(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isFavoritesOpened = mutableLiveData;
    }

    public final Flow<Boolean> getFavoriteListIsEmpty() {
        return this.favoriteListIsEmpty;
    }

    public final StateFlow<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public final StateFlow<Boolean> isInProgress() {
        return this.isInProgress;
    }

    public final SharedFlow<Pair<Integer, String>> getEventShareCode() {
        return this.eventShareCode;
    }

    public final Flow<Boolean> getEventShowSnack() {
        return this.eventShowSnack;
    }

    public final Flow<String> getEventShowMessage() {
        return this.eventShowMessage;
    }

    public final SharedFlow<OpenStreamEvent> getEventOpenStream() {
        return this.eventOpenStream;
    }

    public final Flow<Integer> getEventOpenCallsSchedule() {
        return this.eventOpenCallsSchedule;
    }

    public final Flow<Integer> getEventOpenIntercomEmergencyCode() {
        return this.eventOpenIntercomEmergencyCode;
    }

    public final Flow<Integer> getEventOpenErrorDialog() {
        return this.eventOpenErrorDialog;
    }

    public final Flow<Boolean> getEventAskNotificationPermission() {
        return this.eventAskNotificationPermission;
    }

    public final SharedFlow<HomeEvent> getEvents() {
        return this.events;
    }

    public final Flow<OpenChatEvent> getEventOpenChat() {
        return this.eventOpenChat;
    }

    public final MutableLiveData<Boolean> isBadConnBannerClosed() {
        return this.isBadConnBannerClosed;
    }

    public final Object getAdvBottomSheet(AdvBottomSheetDesignTheme advBottomSheetDesignTheme, DefaultThemeDto defaultThemeDto, Continuation<? super Flow<AdvBottomSheetDto>> continuation) {
        return this.advBottomSheetInteractor.updateAdv(advBottomSheetDesignTheme, defaultThemeDto, continuation);
    }

    public final void getAppConfig() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$getAppConfig$1(this, null), 3, null);
    }

    public final void checkConnection(Context context) {
        try {
            String token = this.userInteractor.getToken();
            if (token == null || token.length() == 0 || ConnectionChecker.INSTANCE.checkConnection(context)) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$checkConnection$1(this, null), 3, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onRefreshAddresses$default(HomeViewModel homeViewModel, MutableStateFlow mutableStateFlow, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableStateFlow = homeViewModel._isRefreshing;
        }
        homeViewModel.onRefreshAddresses(mutableStateFlow);
    }

    public final void onRefreshAddresses(MutableStateFlow<Boolean> loading) {
        Intrinsics.checkNotNullParameter(loading, "loading");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$onRefreshAddresses$1(loading, this, null), 3, null);
    }

    public final void askNotificationPermission() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$askNotificationPermission$1(this, null), 3, null);
    }

    public final void closeBanner() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$closeBanner$1(this, null), 3, null);
    }

    public final void onAddressClick(HomeAddress address) {
        List<Integer> value;
        List mutableList;
        Intrinsics.checkNotNullParameter(address, "address");
        MutableStateFlow<List<Integer>> mutableStateFlow = this._collapsedAddressIds;
        do {
            value = mutableStateFlow.getValue();
            mutableList = CollectionsKt.toMutableList((Collection) value);
            if (mutableList.contains(Integer.valueOf(address.getId()))) {
                mutableList.remove(Integer.valueOf(address.getId()));
            } else {
                mutableList.add(Integer.valueOf(address.getId()));
            }
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.toList(mutableList)));
    }

    public final void onStreamClick(HomeStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        boolean isIntercom = stream.isIntercom();
        reportEvent(isIntercom ? 14 : 17);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$onStreamClick$1(this, stream, isIntercom, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getBuildingServices(int r5, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, java.lang.Boolean>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.tattelecom.intercom.feature.home.HomeViewModel$getBuildingServices$1
            if (r0 == 0) goto L14
            r0 = r6
            ru.tattelecom.intercom.feature.home.HomeViewModel$getBuildingServices$1 r0 = (ru.tattelecom.intercom.feature.home.HomeViewModel$getBuildingServices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            ru.tattelecom.intercom.feature.home.HomeViewModel$getBuildingServices$1 r0 = new ru.tattelecom.intercom.feature.home.HomeViewModel$getBuildingServices$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            ru.tattelecom.intercom.feature.home.HomeViewModel r5 = (ru.tattelecom.intercom.feature.home.HomeViewModel) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.tattelecom.intercom.domain.interactors.AddressInteractor r6 = r4.addressInteractor
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.getBuildingServices(r5, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r5 = r4
        L4b:
            java.util.List r6 = (java.util.List) r6
            int r0 = r5.toAvailableStreamArchiveDays(r6)
            boolean r5 = r5.isAbilityStreamDownload(r6)
            kotlin.Pair r6 = new kotlin.Pair
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r6.<init>(r0, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel.getBuildingServices(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setGateLoading(boolean isLoading, int gateId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$setGateLoading$1(this, isLoading, gateId, null), 3, null);
    }

    public final void onOpenGateClick(Integer gateId, String intercomLogin) {
        reportEvent(16);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$onOpenGateClick$1(gateId, intercomLogin, this, null), 3, null);
    }

    public final void onFavoritesClick(HomeStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$onFavoritesClick$1(stream, this, null), 3, null);
    }

    public final Mutex getToolTipMutex() {
        return this.toolTipMutex;
    }

    public final MutableStateFlow<Boolean> isToolTipShownFlow() {
        return this.isToolTipShownFlow;
    }

    public final boolean isToolTipRequires(ConfigInteractor.ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        return this.configInteractor.isToolTipRequires(toolTip);
    }

    public final void onCloseToolTip(ConfigInteractor.ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        this.configInteractor.setToolTipSeen(toolTip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTempCodeLoading(boolean isLoading, int gateId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$setTempCodeLoading$1(this, isLoading, gateId, null), 3, null);
    }

    public final void generateTemporaryCodeButtonClick(HomeStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        reportEvent(85);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$generateTemporaryCodeButtonClick$1(this, stream, null), 3, null);
    }

    public final void shareTemporaryCode(Integer temporaryCode, String buildingInfo) {
        reportEvent(86);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$shareTemporaryCode$1(this, temporaryCode, buildingInfo, null), 3, null);
    }

    public final void onDisableDoNotDisturbClick() {
        launchCancellableJob(new HomeViewModel$onDisableDoNotDisturbClick$1(this, null));
    }

    public final void onSetCallsMutedClick(int intercomId, boolean mutedNow) {
        launchCancellableJob(new HomeViewModel$onSetCallsMutedClick$1(this, intercomId, mutedNow, null));
    }

    public final void onSetCallsScheduleClick(int intercomId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$onSetCallsScheduleClick$1(this, intercomId, null), 3, null);
    }

    private final void launchCancellableJob(Function1<? super Continuation<? super Unit>, ? extends Object> job) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$launchCancellableJob$1(this, job, null), 3, null);
        this.inProgressJob = launch$default;
    }

    public final void onInProgressCancel() {
        Job job = this.inProgressJob;
        if (job != null) {
            job.cancel(new CancellationException("job_canceled"));
        }
        this._isInProgress.setValue(false);
    }

    public final void notificationPermissionRequested() {
        this.userInteractor.notificationPermissionRequested();
    }

    public final void reportEventAdv(int buttonId, long advId) {
        this.logInteractor.reportEvent(buttonId, MapsKt.mapOf(TuplesKt.to(LogInteractor.ADV_ID, Long.valueOf(advId))));
    }

    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ru.tattelecom.intercom.feature.home.HomeItem> toHomeList(java.util.List<ru.tattelecom.intercom.data.local.entity.AddressWithIntercomsAndStreams> r38) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel.toHomeList(java.util.List):java.util.List");
    }

    private final int toAvailableStreamArchiveDays(List<ApartmentServicesEntity> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ApartmentServicesEntity apartmentServicesEntity = (ApartmentServicesEntity) obj;
            if (Intrinsics.areEqual(apartmentServicesEntity.getName(), ApartmentServiceName.STREAM_ARCHIVE_7DAYS) && Intrinsics.areEqual((Object) apartmentServicesEntity.getActive(), (Object) true)) {
                break;
            }
        }
        return obj != null ? 7 : 2;
    }

    private final boolean isAbilityStreamDownload(List<ApartmentServicesEntity> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ApartmentServicesEntity apartmentServicesEntity = (ApartmentServicesEntity) obj;
            if (Intrinsics.areEqual(apartmentServicesEntity.getName(), ApartmentServiceName.VIDEO_DOWNLOAD_ABILITY) && Intrinsics.areEqual((Object) apartmentServicesEntity.getActive(), (Object) true)) {
                break;
            }
        }
        return obj != null;
    }

    public final void sendApplicationVersion(String appVersionName, String appVersionCode, String deviceOsVersion, String deviceApiVersion, String providerName, String deviceName, String connectionType, String batteryLevel) {
        Intrinsics.checkNotNullParameter(appVersionName, "appVersionName");
        Intrinsics.checkNotNullParameter(appVersionCode, "appVersionCode");
        Intrinsics.checkNotNullParameter(deviceOsVersion, "deviceOsVersion");
        Intrinsics.checkNotNullParameter(deviceApiVersion, "deviceApiVersion");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(connectionType, "connectionType");
        Intrinsics.checkNotNullParameter(batteryLevel, "batteryLevel");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$sendApplicationVersion$1(this, appVersionName, appVersionCode, deviceOsVersion, deviceApiVersion, providerName, deviceName, connectionType, batteryLevel, null), 3, null);
    }

    public final void getChatConfig(String phone, String formattedPhone, String chatAction) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(formattedPhone, "formattedPhone");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$getChatConfig$1(chatAction, this, phone, formattedPhone, null), 3, null);
    }

    private final Flow<List<HomeItem>> toFilteredList(final Flow<? extends List<? extends HomeItem>> flow) {
        return (Flow) new Flow<List<? extends HomeItem>>() { // from class: ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1$2", f = "HomeViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r11
                        ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r11 = r0.label
                        int r11 = r11 - r2
                        r0.label = r11
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1$2$1
                        r0.<init>(r11)
                    L19:
                        java.lang.Object r11 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L33
                        if (r2 != r3) goto L2b
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto Lb6
                    L2b:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L33:
                        kotlin.ResultKt.throwOnFailure(r11)
                        kotlinx.coroutines.flow.FlowCollector r11 = r9.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r10 = (java.util.List) r10
                        if (r10 == 0) goto Lac
                        r2 = r10
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r4.<init>()
                        java.util.Collection r4 = (java.util.Collection) r4
                        java.util.Iterator r2 = r2.iterator()
                    L4d:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L7c
                        java.lang.Object r5 = r2.next()
                        r6 = r5
                        ru.tattelecom.intercom.feature.home.HomeItem r6 = (ru.tattelecom.intercom.feature.home.HomeItem) r6
                        boolean r7 = r6 instanceof ru.tattelecom.intercom.feature.home.HomeAddress
                        if (r7 == 0) goto L78
                        int r7 = r10.indexOf(r6)
                        int r7 = r7 + 2
                        int r8 = r10.size()
                        if (r7 > r8) goto L4d
                        int r6 = r10.indexOf(r6)
                        int r6 = r6 + r3
                        java.lang.Object r6 = r10.get(r6)
                        boolean r6 = r6 instanceof ru.tattelecom.intercom.feature.home.HomeAddress
                        if (r6 == 0) goto L78
                        goto L4d
                    L78:
                        r4.add(r5)
                        goto L4d
                    L7c:
                        java.util.List r4 = (java.util.List) r4
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.ArrayList r10 = new java.util.ArrayList
                        r10.<init>()
                        java.util.Collection r10 = (java.util.Collection) r10
                        java.util.Iterator r2 = r4.iterator()
                    L8b:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto La9
                        java.lang.Object r4 = r2.next()
                        r5 = r4
                        ru.tattelecom.intercom.feature.home.HomeItem r5 = (ru.tattelecom.intercom.feature.home.HomeItem) r5
                        boolean r6 = r5 instanceof ru.tattelecom.intercom.feature.home.HomeStream
                        if (r6 == 0) goto La5
                        ru.tattelecom.intercom.feature.home.HomeStream r5 = (ru.tattelecom.intercom.feature.home.HomeStream) r5
                        boolean r5 = r5.isCollapsed()
                        if (r5 == 0) goto La5
                        goto L8b
                    La5:
                        r10.add(r4)
                        goto L8b
                    La9:
                        java.util.List r10 = (java.util.List) r10
                        goto Lad
                    Lac:
                        r10 = 0
                    Lad:
                        r0.label = r3
                        java.lang.Object r10 = r11.emit(r10, r0)
                        if (r10 != r1) goto Lb6
                        return r1
                    Lb6:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$toFilteredList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends HomeItem>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}
