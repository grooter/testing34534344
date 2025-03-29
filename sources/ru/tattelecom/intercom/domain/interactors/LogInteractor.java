package ru.tattelecom.intercom.domain.interactors;

import com.yandex.metrica.YandexMetrica;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.dao.RemoteLogsDao;
import ru.tattelecom.intercom.data.local.entity.RemoteLogEntity;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.source.LogRemote;

/* compiled from: LogInteractor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J(\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aJ\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "", "prefsSource", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "logsDao", "Lru/tattelecom/intercom/data/local/dao/RemoteLogsDao;", "logsRemote", "Lru/tattelecom/intercom/data/remote/source/LogRemote;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/local/dao/RemoteLogsDao;Lru/tattelecom/intercom/data/remote/source/LogRemote;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "executorService", "Ljava/util/concurrent/ExecutorService;", "addToDatabase", "", "remoteLogEntity", "Lru/tattelecom/intercom/data/local/entity/RemoteLogEntity;", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearDatabase", "featRemoteLogging", "", "reportEvent", "buttonId", "", "params", "", "", "send", NavArg.SEND_LOGS_TOKEN, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "RemoteLogHelper", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogInteractor {
    public static final String ADV_ID = "adv_id";
    public static final String BUTTON_ID = "button_id";
    public static final String PHONE_NUMBER = "phone_number";
    private final AppCoroutineDispatchers dispatchers;
    private ExecutorService executorService;
    private final RemoteLogsDao logsDao;
    private final LogRemote logsRemote;
    private final UserPrefsSource prefsSource;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Integer, String> buttonIdNameMap = MapsKt.mapOf(TuplesKt.to(7, "Стать абонентом"), TuplesKt.to(8, "Подтверждение отправки заявки из профиля"), TuplesKt.to(9, "Видеоархив домофона последних 2 дней"), TuplesKt.to(10, "Видеоархив домофона первых 5 дней"), TuplesKt.to(11, "Видеоархив домофона первых 5 дней"), TuplesKt.to(12, "Оставить заявку"), TuplesKt.to(13, "Подтверждение отправки заявки из архива"), TuplesKt.to(14, "Открытие видеотрансляции домофона"), TuplesKt.to(15, "Открытие двери"), TuplesKt.to(16, "Открытие двери"), TuplesKt.to(17, "Открытие видеотрансляции камеры БД"), TuplesKt.to(18, "Открытие страницы журнала событий"), TuplesKt.to(19, "Открытие записи звонка в журнале событий"), TuplesKt.to(20, "Принятие звонка"), TuplesKt.to(21, "Завершение звонка"), TuplesKt.to(22, "Открытие двери"), TuplesKt.to(23, "Открытие двери"), TuplesKt.to(24, "Завершение звонка"), TuplesKt.to(25, "Переход в чат с оператором"), TuplesKt.to(27, "Переход в чат с оператором"), TuplesKt.to(28, "Закрытие уведомления о недоступности функционала"), TuplesKt.to(29, "Отображение окна аварийного кода"), TuplesKt.to(30, "Отображение окна аварийного кода"), TuplesKt.to(31, "Дополнительный регистрационный токен"), TuplesKt.to(34, "Подтверждение отправки заявки из главного экрана"), TuplesKt.to(35, "Онбординг. Начать пользоваться"), TuplesKt.to(36, "Подтверждение отправки заявки на подключение"), TuplesKt.to(37, "Скачать архив"), TuplesKt.to(38, "Скачивание архива недоступно"), TuplesKt.to(39, "Оставить заявку из плеера домофона"), TuplesKt.to(40, "Ошибка при скачивании видео домофона"), TuplesKt.to(41, "Скачать архив камеры БД"), TuplesKt.to(44, "Ошибка при скачивании видео"), TuplesKt.to(45, "Карта офисов"), TuplesKt.to(49, "Ошибка при отправке заявки"), TuplesKt.to(51, "Удаление записи звонка у меня"), TuplesKt.to(52, "Удаление записи звонка у всех"), TuplesKt.to(53, "Отмена удаления записи звонка"), TuplesKt.to(54, "Уведомление о недоступности удаления звонков"), TuplesKt.to(55, "Оставить заявку при попытке удалить запись о звонке"), TuplesKt.to(56, "Подтверждение отправки заявки при попытке удалить запись в журнале событий"), TuplesKt.to(57, "Открытие записи ключа в журнале событий + открытие записи ключа в фильтре \"Ключи\""), TuplesKt.to(58, "Переход в фильтр \"Ключи\" в журнале событий"), TuplesKt.to(59, "Оставить заявку на баннере в списке ключей"), TuplesKt.to(60, "Закрытие баннера на странице ключей"), TuplesKt.to(61, "Подтверждение отправки заявки после клика на баннере \"тип событий ключи недоступен\""), TuplesKt.to(62, "Отображение окна о недоступности функционала при попытке открыть запись прохода по ключу в фильтре \"ключи\" и в фильтре \"все\""), TuplesKt.to(63, "Оставить заявку из уведомления о недоступности просмотра проходов по ключу"), TuplesKt.to(64, "Подтверждение отправки заявки из уведомления о недоступности просмотра проходов по ключу"), TuplesKt.to(65, "Удаление записи ключа у меня"), TuplesKt.to(66, "Удаление записи ключа у всех"), TuplesKt.to(67, "Отмена удаления записи ключа"), TuplesKt.to(68, "Попытка удаления ключа при недоступности функционала"), TuplesKt.to(70, "Успешное добавление пользователя через СМС"), TuplesKt.to(71, "Генерация qr code"), TuplesKt.to(72, "Ошибка генерации qr-code"), TuplesKt.to(73, "Неверный регистрационный логин"), TuplesKt.to(74, "Ошибка при считывании qr-code"), TuplesKt.to(75, "Успешное добавление квартиры qr-code"), TuplesKt.to(79, "Генерация кода в профиле"), TuplesKt.to(80, "Поделиться кодом на странице профиля"), TuplesKt.to(83, "Ошибка генерации кода на странице профиля/на главном экране"), TuplesKt.to(84, "Ошибка удаления кода на странице профиля"), TuplesKt.to(85, "Генерация кода на главной странице"), TuplesKt.to(86, "Поделиться кодом на главном экране"), TuplesKt.to(88, "Подтверждение отправки заявки из экрана без адресов"), TuplesKt.to(89, "Клик на событие \"Код\""), TuplesKt.to(90, "Выход из Онбординга (первый экран)"), TuplesKt.to(91, "Выход из Онбординга (второй экран)"), TuplesKt.to(92, "Выход из Онбординга (третий экран)"), TuplesKt.to(100, "Попытка удаления звонка при недоступности функционала"), TuplesKt.to(102, "Клик по иконке возврата к боттом шит"), TuplesKt.to(103, "Оставить заявку в боттом шит"), TuplesKt.to(104, "Подтвердить отправку заявки в боттом шит"), TuplesKt.to(105, "Сделать снимок экрана в плеере"), TuplesKt.to(106, "Выбор скорости воспроизведения"), TuplesKt.to(107, "Переход к режиму \"live\""), TuplesKt.to(108, "Выход из Онбординга (четвертый экран)"), TuplesKt.to(109, "Активация пробного периода с первого входа"), TuplesKt.to(115, "Что нового"), TuplesKt.to(116, "Скрытие баннера онбординга"), TuplesKt.to(117, "Получение первого кадра видеопотока в плеере"), TuplesKt.to(119, "Уведомление о количестве оставшихся дней (Button)"), TuplesKt.to(121, "Переход к заявке на услуги из онбординга с количеством оставшихся дней (Button)"), TuplesKt.to(123, "Отправка заявки из экрана онбординга с количеством оставшихся дней ПП (Button)"), TuplesKt.to(124, "Отправка заявки из экрана онбординга с экрана об окончании ПП"), TuplesKt.to(125, "Переход к заявке на услуги из онбординга с окончанием ПП"), TuplesKt.to(126, "Попытка закрыть первый экран онбординга"), TuplesKt.to(127, "Скачивание любого события из плеера"));

    public LogInteractor(UserPrefsSource prefsSource, RemoteLogsDao logsDao, LogRemote logsRemote, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(prefsSource, "prefsSource");
        Intrinsics.checkNotNullParameter(logsDao, "logsDao");
        Intrinsics.checkNotNullParameter(logsRemote, "logsRemote");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.prefsSource = prefsSource;
        this.logsDao = logsDao;
        this.logsRemote = logsRemote;
        this.dispatchers = dispatchers;
    }

    public final boolean featRemoteLogging() {
        return this.prefsSource.getFeatRemoteLogging();
    }

    public final Object send(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new LogInteractor$send$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new LogInteractor$clear$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object clearDatabase(Continuation<? super Unit> continuation) {
        Object clear = this.logsDao.clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }

    public final void addToDatabase(final RemoteLogEntity remoteLogEntity) {
        Intrinsics.checkNotNullParameter(remoteLogEntity, "remoteLogEntity");
        try {
            if (this.executorService == null) {
                this.executorService = Executors.newSingleThreadExecutor();
            }
            Runnable runnable = new Runnable() { // from class: ru.tattelecom.intercom.domain.interactors.LogInteractor$addToDatabase$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteLogsDao remoteLogsDao;
                    RemoteLogsDao remoteLogsDao2;
                    RemoteLogsDao remoteLogsDao3;
                    try {
                        remoteLogsDao = LogInteractor.this.logsDao;
                        remoteLogsDao.insertLog(remoteLogEntity);
                        remoteLogsDao2 = LogInteractor.this.logsDao;
                        if (remoteLogsDao2.getLogsCount() >= 1500) {
                            remoteLogsDao3 = LogInteractor.this.logsDao;
                            remoteLogsDao3.deleteOldLogs(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            ExecutorService executorService = this.executorService;
            if (executorService != null) {
                executorService.submit(runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportEvent$default(LogInteractor logInteractor, int i, Map map, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        logInteractor.reportEvent(i, map);
    }

    public final void reportEvent(int buttonId, Map<String, ? extends Object> params) {
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(BUTTON_ID, Integer.valueOf(buttonId)), TuplesKt.to(PHONE_NUMBER, this.prefsSource.getPhoneNumber()));
        if (params != null) {
            mutableMapOf.putAll(params);
        }
        String str = buttonIdNameMap.get(Integer.valueOf(buttonId));
        if (str == null) {
            str = "";
        }
        YandexMetrica.reportEvent(str, (Map<String, Object>) mutableMapOf);
    }

    /* compiled from: LogInteractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/LogInteractor$RemoteLogHelper;", "", "()V", "PURGE_SIZE", "", "PURGE_THRESHOLD", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RemoteLogHelper {
        public static final RemoteLogHelper INSTANCE = new RemoteLogHelper();
        public static final int PURGE_SIZE = 100;
        public static final int PURGE_THRESHOLD = 1500;

        private RemoteLogHelper() {
        }
    }

    /* compiled from: LogInteractor.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/LogInteractor$Companion;", "", "()V", "ADV_ID", "", "BUTTON_ID", "PHONE_NUMBER", "buttonIdNameMap", "", "", "getButtonIdNameMap", "()Ljava/util/Map;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Integer, String> getButtonIdNameMap() {
            return LogInteractor.buttonIdNameMap;
        }
    }
}
