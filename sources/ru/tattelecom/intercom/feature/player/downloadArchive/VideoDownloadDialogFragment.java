package ru.tattelecom.intercom.feature.player.downloadArchive;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;
import ru.tattelecom.intercom.feature.player.R;
import ru.tattelecom.intercom.feature.player.databinding.FragmentVideoDownloadBinding;

/* compiled from: VideoDownloadDialogFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020 H\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u000204H\u0002J\u001c\u00105\u001a\u00020.2\u0006\u0010\"\u001a\u00020 2\n\u00106\u001a\u000207\"\u00020\u0004H\u0002J\b\u00108\u001a\u00020.H\u0002J\b\u00109\u001a\u00020.H\u0002J\u0010\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0013j\b\u0012\u0004\u0012\u00020\u000f`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006>"}, d2 = {"Lru/tattelecom/intercom/feature/player/downloadArchive/VideoDownloadDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "availableDate", "", "binding", "Lru/tattelecom/intercom/feature/player/databinding/FragmentVideoDownloadBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/player/databinding/FragmentVideoDownloadBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "calendar", "Ljava/util/Calendar;", "dateArray", "", "", "durationAdapter", "Landroid/widget/ArrayAdapter;", "durationArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedDay", "selectedDurationPosition", "state", CrashHianalyticsData.TIME, "viewModel", "Lru/tattelecom/intercom/feature/player/PlayerViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/player/PlayerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkSelectedTime", "", "getBackground", "isError", "getDateArray", "getTheme", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "resetCalendar", "resetData", "resetDurationList", "returnDateFromString", "Ljava/util/Date;", "setError", "types", "", "setInfoUi", "setSettingUi", "withZero", "number", "", "BundleKeys", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VideoDownloadDialogFragment extends DialogFragment {
    public static final String AVAILABLE_DAYS = "available_days";
    public static final String ERROR = "error";
    public static final String STATE = "state";
    public static final String SUCCESS = "complete";
    private int availableDate;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private final Calendar calendar;
    private List<String> dateArray;
    private ArrayAdapter<String> durationAdapter;
    private ArrayList<String> durationArray;
    private int selectedDay;
    private int selectedDurationPosition;
    private String state;
    private String time;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(VideoDownloadDialogFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/player/databinding/FragmentVideoDownloadBinding;", 0))};

    public VideoDownloadDialogFragment() {
        final VideoDownloadDialogFragment videoDownloadDialogFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(videoDownloadDialogFragment, FragmentVideoDownloadBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(videoDownloadDialogFragment, Reflection.getOrCreateKotlinClass(PlayerViewModel.class), new Function0<ViewModelStore>() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return Fragment.this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? videoDownloadDialogFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        this.calendar = calendar;
        this.durationArray = new ArrayList<>();
        this.availableDate = 7;
        this.dateArray = CollectionsKt.emptyList();
        this.selectedDay = this.availableDate - 1;
        this.time = "00:00:00";
        this.state = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentVideoDownloadBinding getBinding() {
        return (FragmentVideoDownloadBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final PlayerViewModel getViewModel() {
        return (PlayerViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.AppTheme_RoundedCornersDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (getArguments() != null) {
            Bundle requireArguments = requireArguments();
            if (requireArguments.getString("state") != null) {
                String string = requireArguments.getString("state");
                Intrinsics.checkNotNull(string);
                this.state = string;
            }
            if (requireArguments.getInt(AVAILABLE_DAYS) != 0) {
                this.availableDate = requireArguments.getInt(AVAILABLE_DAYS);
            }
        }
        return inflater.inflate(R.layout.fragment_video_download, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Window window2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getResources().getConfiguration().orientation == 2) {
            dismiss();
        }
        Dialog dialog = getDialog();
        WindowManager.LayoutParams layoutParams = null;
        WindowManager.LayoutParams attributes = (dialog == null || (window2 = dialog.getWindow()) == null) ? null : window2.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        FragmentVideoDownloadBinding binding = getBinding();
        String str = this.state;
        if (Intrinsics.areEqual(str, "error")) {
            ImageView ivDownloadSuccessful = binding.ivDownloadSuccessful;
            Intrinsics.checkNotNullExpressionValue(ivDownloadSuccessful, "ivDownloadSuccessful");
            ivDownloadSuccessful.setVisibility(8);
            binding.tvInfoTitle.setText(R.string.something_wrong);
            binding.tvInfoContent.setText(R.string.video_loading_error);
            binding.btnClose.setText(R.string.good);
            setInfoUi();
            return;
        }
        if (Intrinsics.areEqual(str, SUCCESS)) {
            ImageView ivDownloadSuccessful2 = binding.ivDownloadSuccessful;
            Intrinsics.checkNotNullExpressionValue(ivDownloadSuccessful2, "ivDownloadSuccessful");
            ivDownloadSuccessful2.setVisibility(0);
            binding.tvInfoTitle.setText(R.string.download_completed);
            binding.tvInfoContent.setText(R.string.video_downloaded_successfully);
            binding.btnClose.setText(R.string.great);
            setInfoUi();
            return;
        }
        setSettingUi();
    }

    private final void setInfoUi() {
        FragmentVideoDownloadBinding binding = getBinding();
        LinearLayout llDownloadSetting = binding.llDownloadSetting;
        Intrinsics.checkNotNullExpressionValue(llDownloadSetting, "llDownloadSetting");
        llDownloadSetting.setVisibility(8);
        LinearLayout llDownloadInfo = binding.llDownloadInfo;
        Intrinsics.checkNotNullExpressionValue(llDownloadInfo, "llDownloadInfo");
        llDownloadInfo.setVisibility(0);
        binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoDownloadDialogFragment.setInfoUi$lambda$3$lambda$2(VideoDownloadDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setInfoUi$lambda$3$lambda$2(VideoDownloadDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void setSettingUi() {
        FragmentVideoDownloadBinding binding = getBinding();
        LinearLayout llDownloadSetting = binding.llDownloadSetting;
        Intrinsics.checkNotNullExpressionValue(llDownloadSetting, "llDownloadSetting");
        int i = 0;
        llDownloadSetting.setVisibility(0);
        LinearLayout llDownloadInfo = binding.llDownloadInfo;
        Intrinsics.checkNotNullExpressionValue(llDownloadInfo, "llDownloadInfo");
        llDownloadInfo.setVisibility(8);
        if (getViewModel().getSelectedDay().getValue() != null && getViewModel().getDays().getValue() != null) {
            Integer value = getViewModel().getSelectedDay().getValue();
            if (value == null || value.intValue() != 7) {
                Integer value2 = getViewModel().getSelectedDay().getValue();
                Intrinsics.checkNotNull(value2);
                i = 6 - value2.intValue();
            }
            this.selectedDay = i;
            long longValue = getViewModel().getStreamTimeInSeconds().getValue().longValue();
            long j = 60;
            long j2 = longValue / j;
            this.time = withZero(j2 / j) + ":" + withZero(j2 % j) + ":" + withZero(longValue % j);
        }
        final MaterialAutoCompleteTextView materialAutoCompleteTextView = getBinding().tvSelectDate;
        if (this.availableDate < 4) {
            getBinding().tvSelectDate.setDropDownHeight(-2);
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 180.0f;
        List<String> dateArray = getDateArray(this.availableDate);
        this.dateArray = dateArray;
        materialAutoCompleteTextView.setText(dateArray.get(this.selectedDay));
        materialAutoCompleteTextView.setAdapter(new ArrayAdapter(requireContext(), R.layout.item_dropdown_menu, this.dateArray));
        materialAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j3) {
                VideoDownloadDialogFragment.setSettingUi$lambda$9$lambda$6(VideoDownloadDialogFragment.this, adapterView, view, i2, j3);
            }
        });
        materialAutoCompleteTextView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoDownloadDialogFragment.setSettingUi$lambda$9$lambda$7(Ref.BooleanRef.this, materialAutoCompleteTextView, floatRef, this, view);
            }
        });
        materialAutoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda4
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                VideoDownloadDialogFragment.setSettingUi$lambda$9$lambda$8(Ref.FloatRef.this, this, booleanRef);
            }
        });
        resetData();
        this.durationAdapter = new ArrayAdapter<>(requireContext(), R.layout.item_dropdown_menu, this.durationArray);
        final MaterialAutoCompleteTextView materialAutoCompleteTextView2 = getBinding().tvSelectTime;
        materialAutoCompleteTextView2.setText(this.time);
        materialAutoCompleteTextView2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoDownloadDialogFragment.setSettingUi$lambda$12$lambda$11(VideoDownloadDialogFragment.this, materialAutoCompleteTextView2, view);
            }
        });
        final MaterialAutoCompleteTextView materialAutoCompleteTextView3 = getBinding().tvSelectDuration;
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        floatRef2.element = 180.0f;
        materialAutoCompleteTextView3.setText(this.durationArray.get(this.selectedDurationPosition));
        materialAutoCompleteTextView3.setAdapter(this.durationAdapter);
        materialAutoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda6
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j3) {
                VideoDownloadDialogFragment.setSettingUi$lambda$16$lambda$13(VideoDownloadDialogFragment.this, adapterView, view, i2, j3);
            }
        });
        materialAutoCompleteTextView3.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoDownloadDialogFragment.setSettingUi$lambda$16$lambda$14(Ref.BooleanRef.this, materialAutoCompleteTextView3, floatRef2, this, view);
            }
        });
        materialAutoCompleteTextView3.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda8
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                VideoDownloadDialogFragment.setSettingUi$lambda$16$lambda$15(Ref.FloatRef.this, this, booleanRef2);
            }
        });
        MaterialButton materialButton = getBinding().btnDownload;
        materialButton.setEnabled(checkSelectedTime());
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoDownloadDialogFragment.setSettingUi$lambda$18$lambda$17(VideoDownloadDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$9$lambda$6(VideoDownloadDialogFragment this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedDay = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$9$lambda$7(Ref.BooleanRef isShowing, MaterialAutoCompleteTextView this_apply, Ref.FloatRef rotationValue, VideoDownloadDialogFragment this$0, View view) {
        boolean z;
        Intrinsics.checkNotNullParameter(isShowing, "$isShowing");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(rotationValue, "$rotationValue");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isShowing.element) {
            this_apply.dismissDropDown();
            rotationValue.element = 0.0f;
            z = false;
        } else {
            this_apply.showDropDown();
            rotationValue.element = 180.0f;
            z = true;
        }
        isShowing.element = z;
        this$0.getBinding().ivArrowDate.animate().rotation(rotationValue.element).setInterpolator(new LinearInterpolator()).setDuration(100L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$9$lambda$8(Ref.FloatRef rotationValue, VideoDownloadDialogFragment this$0, Ref.BooleanRef isShowing) {
        Intrinsics.checkNotNullParameter(rotationValue, "$rotationValue");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(isShowing, "$isShowing");
        rotationValue.element = rotationValue.element == 0.0f ? 180.0f : 0.0f;
        this$0.getBinding().ivArrowDate.animate().rotation(rotationValue.element).setInterpolator(new LinearInterpolator()).setDuration(100L).start();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new VideoDownloadDialogFragment$setSettingUi$3$3$1(isShowing, null), 3, null);
        this$0.resetData();
        this$0.setError(!this$0.checkSelectedTime(), 2, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$12$lambda$11(final VideoDownloadDialogFragment this$0, final MaterialAutoCompleteTextView this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        final MaterialTimePicker build = new MaterialTimePicker.Builder().setTimeFormat(1).setHour(this$0.calendar.get(11)).setMinute(this$0.calendar.get(12)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        build.addOnPositiveButtonClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoDownloadDialogFragment.setSettingUi$lambda$12$lambda$11$lambda$10(VideoDownloadDialogFragment.this, build, this_apply, view2);
            }
        });
        build.show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$12$lambda$11$lambda$10(VideoDownloadDialogFragment this$0, MaterialTimePicker timePicker, MaterialAutoCompleteTextView this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(timePicker, "$timePicker");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        String str = this$0.withZero(timePicker.getHour()) + ":" + this$0.withZero(timePicker.getMinute()) + ":00";
        this$0.time = str;
        this_apply.setText(str);
        this$0.resetData();
        this$0.getBinding().tvSelectDuration.setText((CharSequence) this$0.durationArray.get(this$0.selectedDurationPosition), false);
        ArrayAdapter<String> arrayAdapter = this$0.durationAdapter;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
        if (this$0.checkSelectedTime()) {
            this$0.setError(false, 2, 3);
        } else {
            this$0.setError(true, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$16$lambda$13(VideoDownloadDialogFragment this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectedDurationPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$16$lambda$14(Ref.BooleanRef isShowing, MaterialAutoCompleteTextView this_apply, Ref.FloatRef rotationValue, VideoDownloadDialogFragment this$0, View view) {
        boolean z;
        Intrinsics.checkNotNullParameter(isShowing, "$isShowing");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(rotationValue, "$rotationValue");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isShowing.element) {
            this_apply.dismissDropDown();
            rotationValue.element = 0.0f;
            z = false;
        } else {
            this_apply.showDropDown();
            rotationValue.element = 180.0f;
            z = true;
        }
        isShowing.element = z;
        this$0.getBinding().ivArrowDuration.animate().rotation(rotationValue.element).setInterpolator(new LinearInterpolator()).setDuration(100L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$16$lambda$15(Ref.FloatRef rotationValue, VideoDownloadDialogFragment this$0, Ref.BooleanRef isShowing) {
        Intrinsics.checkNotNullParameter(rotationValue, "$rotationValue");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(isShowing, "$isShowing");
        rotationValue.element = rotationValue.element == 0.0f ? 180.0f : 0.0f;
        this$0.getBinding().ivArrowDuration.animate().rotation(rotationValue.element).setInterpolator(new LinearInterpolator()).setDuration(100L).start();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new VideoDownloadDialogFragment$setSettingUi$5$3$1(isShowing, null), 3, null);
        this$0.setError(!this$0.checkSelectedTime(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSettingUi$lambda$18$lambda$17(VideoDownloadDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().getDownloadSettings().setValue(new Pair<>(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(this$0.returnDateFromString().getTime())), Integer.valueOf((this$0.selectedDurationPosition + 1) * 60)));
        this$0.dismiss();
    }

    private final boolean checkSelectedTime() {
        return this.calendar.getTime().getTime() < new Date().getTime() - TimeUnit.MINUTES.toMillis(10L);
    }

    private final int getBackground(boolean isError) {
        return isError ? R.drawable.bg_rounded_gray_shape_error_12dp : R.drawable.bg_rounded_gray_shape_12dp;
    }

    private final List<String> getDateArray(int availableDate) {
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        if (1 <= availableDate) {
            int i = 1;
            while (true) {
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                Date time = calendar.getTime();
                Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                arrayList.add(ExtensionsKt.format$default(time, "dd.MM.yy (EEEE)", null, null, 6, null));
                calendar.add(5, -1);
                if (i == availableDate) {
                    break;
                }
                i++;
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str : arrayList2) {
            String substringBefore$default = StringsKt.substringBefore$default(str, "(", (String) null, 2, (Object) null);
            String substringAfter$default = StringsKt.substringAfter$default(str, "(", (String) null, 2, (Object) null);
            if (substringAfter$default.length() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append((Object) CharsKt.titlecase(substringAfter$default.charAt(0)));
                String substring = substringAfter$default.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                sb.append(substring);
                substringAfter$default = sb.toString();
            }
            arrayList3.add(substringBefore$default + "(" + substringAfter$default);
        }
        return arrayList3;
    }

    private final String withZero(long number) {
        if (number / 10 != 0) {
            return String.valueOf(number);
        }
        return SessionDescription.SUPPORTED_SDP_VERSION + number;
    }

    private final void resetData() {
        resetCalendar();
        resetDurationList();
    }

    private final void resetCalendar() {
        this.calendar.setTime(returnDateFromString());
    }

    private final Date returnDateFromString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy (EEEE) HH:mm:ss", new Locale("RU"));
        try {
            String str = this.dateArray.get(this.selectedDay);
            Date parse = simpleDateFormat.parse(((Object) str) + " " + this.time);
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type java.util.Date");
            return parse;
        } catch (Exception e) {
            e.printStackTrace();
            Date time = this.calendar.getTime();
            Intrinsics.checkNotNull(time);
            return time;
        }
    }

    private final void resetDurationList() {
        this.durationArray.clear();
        int i = 1;
        while (true) {
            Calendar calendar = this.calendar;
            calendar.set(12, calendar.get(12) + 1);
            ArrayList<String> arrayList = this.durationArray;
            Date time = this.calendar.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
            arrayList.add(ExtensionsKt.format$default(time, "HH:mm:ss", null, null, 6, null) + " (" + i + " мин)");
            if (i == 10) {
                Calendar calendar2 = this.calendar;
                calendar2.set(12, calendar2.get(12) - 10);
                return;
            }
            i++;
        }
    }

    private final void setError(boolean isError, int... types) {
        for (int i : types) {
            if (i == 1) {
                TextView tvDateError = getBinding().tvDateError;
                Intrinsics.checkNotNullExpressionValue(tvDateError, "tvDateError");
                tvDateError.setVisibility(isError ? 0 : 8);
                getBinding().tvSelectDate.setBackground(ContextCompat.getDrawable(requireContext(), getBackground(isError)));
            } else if (i == 2) {
                TextView tvTimeError = getBinding().tvTimeError;
                Intrinsics.checkNotNullExpressionValue(tvTimeError, "tvTimeError");
                tvTimeError.setVisibility(isError ? 0 : 8);
                getBinding().tvSelectTime.setBackground(ContextCompat.getDrawable(requireContext(), getBackground(isError)));
            } else if (i == 3) {
                TextView tvDurationError = getBinding().tvDurationError;
                Intrinsics.checkNotNullExpressionValue(tvDurationError, "tvDurationError");
                tvDurationError.setVisibility(isError ? 0 : 8);
                getBinding().tvSelectDuration.setBackground(ContextCompat.getDrawable(requireContext(), getBackground(isError)));
            }
        }
        getBinding().btnDownload.setEnabled(!isError);
    }
}
