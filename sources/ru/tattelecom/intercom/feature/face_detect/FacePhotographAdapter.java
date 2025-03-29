package ru.tattelecom.intercom.feature.face_detect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.face_detect.databinding.ItemPhotoBinding;

/* compiled from: FacePhotographAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0014\u0010\u0010\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/feature/face_detect/FacePhotographAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/face_detect/Photo;", "Lru/tattelecom/intercom/feature/face_detect/FacePhotographAdapter$ViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/face_detect/databinding/ItemPhotoBinding;", "item", "ViewHolder", "feature-face-detect_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FacePhotographAdapter extends ListAdapter<Photo, ViewHolder> {
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FacePhotographAdapter(Function1<? super Integer, Unit> onClick) {
        super(new IntercomDiffUtil());
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    /* compiled from: FacePhotographAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/face_detect/FacePhotographAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/face_detect/databinding/ItemPhotoBinding;", "(Lru/tattelecom/intercom/feature/face_detect/databinding/ItemPhotoBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/face_detect/databinding/ItemPhotoBinding;", "feature-face-detect_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemPhotoBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ItemPhotoBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemPhotoBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemPhotoBinding inflate = ItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemPhotoBinding binding = holder.getBinding();
        Photo item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        bind(binding, item);
    }

    private final void bind(ItemPhotoBinding itemPhotoBinding, final Photo photo) {
        Glide.with(itemPhotoBinding.getRoot().getContext()).asBitmap().load(photo.getPhoto()).centerCrop().error(R.drawable.ic_no_video).into(itemPhotoBinding.ivSnapshot);
        itemPhotoBinding.cvRoot.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.face_detect.FacePhotographAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FacePhotographAdapter.bind$lambda$0(FacePhotographAdapter.this, photo, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(FacePhotographAdapter this$0, Photo item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onClick.invoke(Integer.valueOf(item.getId()));
    }
}
