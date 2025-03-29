package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.local.dao.DownloadDAO;
import ru.tattelecom.intercom.data.local.entity.DownloadEntity;
import ru.tattelecom.intercom.domain.model.DownloadDto;

/* compiled from: UserInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.UserInteractor$getDownload$2", f = "UserInteractor.kt", i = {}, l = {110, 112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class UserInteractor$getDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DownloadDto>, Object> {
    final /* synthetic */ long $downloadId;
    final /* synthetic */ String $urlDescription;
    int label;
    final /* synthetic */ UserInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserInteractor$getDownload$2(String str, UserInteractor userInteractor, long j, Continuation<? super UserInteractor$getDownload$2> continuation) {
        super(2, continuation);
        this.$urlDescription = str;
        this.this$0 = userInteractor;
        this.$downloadId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInteractor$getDownload$2(this.$urlDescription, this.this$0, this.$downloadId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DownloadDto> continuation) {
        return ((UserInteractor$getDownload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloadDAO downloadDAO;
        DownloadDAO downloadDAO2;
        DownloadEntity downloadEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$urlDescription != null) {
                downloadDAO2 = this.this$0.downloadDAO;
                this.label = 1;
                obj = downloadDAO2.getByDescription(this.$urlDescription, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                downloadEntity = (DownloadEntity) obj;
            } else {
                downloadDAO = this.this$0.downloadDAO;
                this.label = 2;
                obj = downloadDAO.getById(this.$downloadId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                downloadEntity = (DownloadEntity) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            downloadEntity = (DownloadEntity) obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            downloadEntity = (DownloadEntity) obj;
        }
        if (downloadEntity == null) {
            return null;
        }
        return new DownloadDto(downloadEntity.getUrlDescription(), downloadEntity.getDownloadId(), downloadEntity.isIntercomStream());
    }
}
