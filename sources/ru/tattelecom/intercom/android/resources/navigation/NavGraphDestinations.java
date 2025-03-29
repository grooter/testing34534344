package ru.tattelecom.intercom.android.resources.navigation;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragmentKt;

/* compiled from: NavGraphDestinations.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/android/resources/navigation/NavGraphDestinations;", "", "()V", TtmlNode.ATTR_ID, "", "getId", "()I", "idCounter", "getIdCounter", "setIdCounter", "(I)V", "Action", "Dest", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NavGraphDestinations {
    public static final NavGraphDestinations INSTANCE = new NavGraphDestinations();
    private static final int id;
    private static int idCounter;

    private NavGraphDestinations() {
    }

    public final int getIdCounter() {
        return idCounter;
    }

    public final void setIdCounter(int i) {
        idCounter = i;
    }

    static {
        int i = idCounter;
        idCounter = i + 1;
        id = i;
    }

    public final int getId() {
        return id;
    }

    /* compiled from: NavGraphDestinations.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bE\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0011\u00101\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0011\u00105\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0011\u00107\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0011\u00109\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0011\u0010;\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0011\u0010=\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0011\u0010?\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0011\u0010A\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006R\u0011\u0010C\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R\u0011\u0010E\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0011\u0010G\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006¨\u0006I"}, d2 = {"Lru/tattelecom/intercom/android/resources/navigation/NavGraphDestinations$Dest;", "", "()V", "accessManagement", "", "getAccessManagement", "()I", "addAddress", "getAddAddress", "callSettings", "getCallSettings", "callsSchedule", "getCallsSchedule", "chat", "getChat", "connectServices", "getConnectServices", "download", "getDownload", "eventLog", "getEventLog", "faceDetect", "getFaceDetect", "generateQrCode", "getGenerateQrCode", "grantAccess", "getGrantAccess", "home", "getHome", "homeBottomSheet", "getHomeBottomSheet", NavArg.INTERCOM_EMERGENCY_CODE, "getIntercomEmergencyCode", "intercomError", "getIntercomError", "inviteUser", "getInviteUser", "logIn", "getLogIn", "officeMap", "getOfficeMap", "officeMapFilter", "getOfficeMapFilter", "officeMapHuawei", "getOfficeMapHuawei", "player", "getPlayer", "profile", "getProfile", "profileDetails", "getProfileDetails", CommonConstant.KEY_QR_CODE, "getQrCode", "registration", "getRegistration", RequestStateFragmentKt.REQUEST_STATE, "getRequestState", "scanQrCode", "getScanQrCode", "selectPlaybackSpeed", "getSelectPlaybackSpeed", "temporaryAccess", "getTemporaryAccess", "trial", "getTrial", "tutorial", "getTutorial", "verify", "getVerify", "videoPlayer", "getVideoPlayer", "welcomeScreen", "getWelcomeScreen", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Dest {
        public static final Dest INSTANCE = new Dest();
        private static final int accessManagement;
        private static final int addAddress;
        private static final int callSettings;
        private static final int callsSchedule;
        private static final int chat;
        private static final int connectServices;
        private static final int download;
        private static final int eventLog;
        private static final int faceDetect;
        private static final int generateQrCode;
        private static final int grantAccess;
        private static final int home;
        private static final int homeBottomSheet;
        private static final int intercomEmergencyCode;
        private static final int intercomError;
        private static final int inviteUser;
        private static final int logIn;
        private static final int officeMap;
        private static final int officeMapFilter;
        private static final int officeMapHuawei;
        private static final int player;
        private static final int profile;
        private static final int profileDetails;
        private static final int qrCode;
        private static final int registration;
        private static final int requestState;
        private static final int scanQrCode;
        private static final int selectPlaybackSpeed;
        private static final int temporaryAccess;
        private static final int trial;
        private static final int tutorial;
        private static final int verify;
        private static final int videoPlayer;
        private static final int welcomeScreen;

        private Dest() {
        }

        static {
            NavGraphDestinations navGraphDestinations = NavGraphDestinations.INSTANCE;
            int idCounter = navGraphDestinations.getIdCounter();
            navGraphDestinations.setIdCounter(idCounter + 1);
            accessManagement = idCounter;
            NavGraphDestinations navGraphDestinations2 = NavGraphDestinations.INSTANCE;
            int idCounter2 = navGraphDestinations2.getIdCounter();
            navGraphDestinations2.setIdCounter(idCounter2 + 1);
            addAddress = idCounter2;
            NavGraphDestinations navGraphDestinations3 = NavGraphDestinations.INSTANCE;
            int idCounter3 = navGraphDestinations3.getIdCounter();
            navGraphDestinations3.setIdCounter(idCounter3 + 1);
            callSettings = idCounter3;
            NavGraphDestinations navGraphDestinations4 = NavGraphDestinations.INSTANCE;
            int idCounter4 = navGraphDestinations4.getIdCounter();
            navGraphDestinations4.setIdCounter(idCounter4 + 1);
            callsSchedule = idCounter4;
            NavGraphDestinations navGraphDestinations5 = NavGraphDestinations.INSTANCE;
            int idCounter5 = navGraphDestinations5.getIdCounter();
            navGraphDestinations5.setIdCounter(idCounter5 + 1);
            chat = idCounter5;
            NavGraphDestinations navGraphDestinations6 = NavGraphDestinations.INSTANCE;
            int idCounter6 = navGraphDestinations6.getIdCounter();
            navGraphDestinations6.setIdCounter(idCounter6 + 1);
            connectServices = idCounter6;
            NavGraphDestinations navGraphDestinations7 = NavGraphDestinations.INSTANCE;
            int idCounter7 = navGraphDestinations7.getIdCounter();
            navGraphDestinations7.setIdCounter(idCounter7 + 1);
            download = idCounter7;
            NavGraphDestinations navGraphDestinations8 = NavGraphDestinations.INSTANCE;
            int idCounter8 = navGraphDestinations8.getIdCounter();
            navGraphDestinations8.setIdCounter(idCounter8 + 1);
            eventLog = idCounter8;
            NavGraphDestinations navGraphDestinations9 = NavGraphDestinations.INSTANCE;
            int idCounter9 = navGraphDestinations9.getIdCounter();
            navGraphDestinations9.setIdCounter(idCounter9 + 1);
            faceDetect = idCounter9;
            NavGraphDestinations navGraphDestinations10 = NavGraphDestinations.INSTANCE;
            int idCounter10 = navGraphDestinations10.getIdCounter();
            navGraphDestinations10.setIdCounter(idCounter10 + 1);
            generateQrCode = idCounter10;
            NavGraphDestinations navGraphDestinations11 = NavGraphDestinations.INSTANCE;
            int idCounter11 = navGraphDestinations11.getIdCounter();
            navGraphDestinations11.setIdCounter(idCounter11 + 1);
            grantAccess = idCounter11;
            NavGraphDestinations navGraphDestinations12 = NavGraphDestinations.INSTANCE;
            int idCounter12 = navGraphDestinations12.getIdCounter();
            navGraphDestinations12.setIdCounter(idCounter12 + 1);
            home = idCounter12;
            NavGraphDestinations navGraphDestinations13 = NavGraphDestinations.INSTANCE;
            int idCounter13 = navGraphDestinations13.getIdCounter();
            navGraphDestinations13.setIdCounter(idCounter13 + 1);
            homeBottomSheet = idCounter13;
            NavGraphDestinations navGraphDestinations14 = NavGraphDestinations.INSTANCE;
            int idCounter14 = navGraphDestinations14.getIdCounter();
            navGraphDestinations14.setIdCounter(idCounter14 + 1);
            intercomEmergencyCode = idCounter14;
            NavGraphDestinations navGraphDestinations15 = NavGraphDestinations.INSTANCE;
            int idCounter15 = navGraphDestinations15.getIdCounter();
            navGraphDestinations15.setIdCounter(idCounter15 + 1);
            intercomError = idCounter15;
            NavGraphDestinations navGraphDestinations16 = NavGraphDestinations.INSTANCE;
            int idCounter16 = navGraphDestinations16.getIdCounter();
            navGraphDestinations16.setIdCounter(idCounter16 + 1);
            inviteUser = idCounter16;
            NavGraphDestinations navGraphDestinations17 = NavGraphDestinations.INSTANCE;
            int idCounter17 = navGraphDestinations17.getIdCounter();
            navGraphDestinations17.setIdCounter(idCounter17 + 1);
            logIn = idCounter17;
            NavGraphDestinations navGraphDestinations18 = NavGraphDestinations.INSTANCE;
            int idCounter18 = navGraphDestinations18.getIdCounter();
            navGraphDestinations18.setIdCounter(idCounter18 + 1);
            officeMap = idCounter18;
            NavGraphDestinations navGraphDestinations19 = NavGraphDestinations.INSTANCE;
            int idCounter19 = navGraphDestinations19.getIdCounter();
            navGraphDestinations19.setIdCounter(idCounter19 + 1);
            officeMapFilter = idCounter19;
            NavGraphDestinations navGraphDestinations20 = NavGraphDestinations.INSTANCE;
            int idCounter20 = navGraphDestinations20.getIdCounter();
            navGraphDestinations20.setIdCounter(idCounter20 + 1);
            officeMapHuawei = idCounter20;
            NavGraphDestinations navGraphDestinations21 = NavGraphDestinations.INSTANCE;
            int idCounter21 = navGraphDestinations21.getIdCounter();
            navGraphDestinations21.setIdCounter(idCounter21 + 1);
            player = idCounter21;
            NavGraphDestinations navGraphDestinations22 = NavGraphDestinations.INSTANCE;
            int idCounter22 = navGraphDestinations22.getIdCounter();
            navGraphDestinations22.setIdCounter(idCounter22 + 1);
            profile = idCounter22;
            NavGraphDestinations navGraphDestinations23 = NavGraphDestinations.INSTANCE;
            int idCounter23 = navGraphDestinations23.getIdCounter();
            navGraphDestinations23.setIdCounter(idCounter23 + 1);
            profileDetails = idCounter23;
            NavGraphDestinations navGraphDestinations24 = NavGraphDestinations.INSTANCE;
            int idCounter24 = navGraphDestinations24.getIdCounter();
            navGraphDestinations24.setIdCounter(idCounter24 + 1);
            qrCode = idCounter24;
            NavGraphDestinations navGraphDestinations25 = NavGraphDestinations.INSTANCE;
            int idCounter25 = navGraphDestinations25.getIdCounter();
            navGraphDestinations25.setIdCounter(idCounter25 + 1);
            registration = idCounter25;
            NavGraphDestinations navGraphDestinations26 = NavGraphDestinations.INSTANCE;
            int idCounter26 = navGraphDestinations26.getIdCounter();
            navGraphDestinations26.setIdCounter(idCounter26 + 1);
            requestState = idCounter26;
            NavGraphDestinations navGraphDestinations27 = NavGraphDestinations.INSTANCE;
            int idCounter27 = navGraphDestinations27.getIdCounter();
            navGraphDestinations27.setIdCounter(idCounter27 + 1);
            scanQrCode = idCounter27;
            NavGraphDestinations navGraphDestinations28 = NavGraphDestinations.INSTANCE;
            int idCounter28 = navGraphDestinations28.getIdCounter();
            navGraphDestinations28.setIdCounter(idCounter28 + 1);
            selectPlaybackSpeed = idCounter28;
            NavGraphDestinations navGraphDestinations29 = NavGraphDestinations.INSTANCE;
            int idCounter29 = navGraphDestinations29.getIdCounter();
            navGraphDestinations29.setIdCounter(idCounter29 + 1);
            temporaryAccess = idCounter29;
            NavGraphDestinations navGraphDestinations30 = NavGraphDestinations.INSTANCE;
            int idCounter30 = navGraphDestinations30.getIdCounter();
            navGraphDestinations30.setIdCounter(idCounter30 + 1);
            trial = idCounter30;
            NavGraphDestinations navGraphDestinations31 = NavGraphDestinations.INSTANCE;
            int idCounter31 = navGraphDestinations31.getIdCounter();
            navGraphDestinations31.setIdCounter(idCounter31 + 1);
            tutorial = idCounter31;
            NavGraphDestinations navGraphDestinations32 = NavGraphDestinations.INSTANCE;
            int idCounter32 = navGraphDestinations32.getIdCounter();
            navGraphDestinations32.setIdCounter(idCounter32 + 1);
            verify = idCounter32;
            NavGraphDestinations navGraphDestinations33 = NavGraphDestinations.INSTANCE;
            int idCounter33 = navGraphDestinations33.getIdCounter();
            navGraphDestinations33.setIdCounter(idCounter33 + 1);
            videoPlayer = idCounter33;
            NavGraphDestinations navGraphDestinations34 = NavGraphDestinations.INSTANCE;
            int idCounter34 = navGraphDestinations34.getIdCounter();
            navGraphDestinations34.setIdCounter(idCounter34 + 1);
            welcomeScreen = idCounter34;
        }

        public final int getAccessManagement() {
            return accessManagement;
        }

        public final int getAddAddress() {
            return addAddress;
        }

        public final int getCallSettings() {
            return callSettings;
        }

        public final int getCallsSchedule() {
            return callsSchedule;
        }

        public final int getChat() {
            return chat;
        }

        public final int getConnectServices() {
            return connectServices;
        }

        public final int getDownload() {
            return download;
        }

        public final int getEventLog() {
            return eventLog;
        }

        public final int getFaceDetect() {
            return faceDetect;
        }

        public final int getGenerateQrCode() {
            return generateQrCode;
        }

        public final int getGrantAccess() {
            return grantAccess;
        }

        public final int getHome() {
            return home;
        }

        public final int getHomeBottomSheet() {
            return homeBottomSheet;
        }

        public final int getIntercomEmergencyCode() {
            return intercomEmergencyCode;
        }

        public final int getIntercomError() {
            return intercomError;
        }

        public final int getInviteUser() {
            return inviteUser;
        }

        public final int getLogIn() {
            return logIn;
        }

        public final int getOfficeMap() {
            return officeMap;
        }

        public final int getOfficeMapFilter() {
            return officeMapFilter;
        }

        public final int getOfficeMapHuawei() {
            return officeMapHuawei;
        }

        public final int getPlayer() {
            return player;
        }

        public final int getProfile() {
            return profile;
        }

        public final int getProfileDetails() {
            return profileDetails;
        }

        public final int getQrCode() {
            return qrCode;
        }

        public final int getRegistration() {
            return registration;
        }

        public final int getRequestState() {
            return requestState;
        }

        public final int getScanQrCode() {
            return scanQrCode;
        }

        public final int getSelectPlaybackSpeed() {
            return selectPlaybackSpeed;
        }

        public final int getTemporaryAccess() {
            return temporaryAccess;
        }

        public final int getTrial() {
            return trial;
        }

        public final int getTutorial() {
            return tutorial;
        }

        public final int getVerify() {
            return verify;
        }

        public final int getVideoPlayer() {
            return videoPlayer;
        }

        public final int getWelcomeScreen() {
            return welcomeScreen;
        }
    }

    /* compiled from: NavGraphDestinations.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b?\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0011\u00101\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0011\u00105\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0011\u00107\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0011\u00109\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0011\u0010;\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0011\u0010=\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0011\u0010?\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0011\u0010A\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006¨\u0006C"}, d2 = {"Lru/tattelecom/intercom/android/resources/navigation/NavGraphDestinations$Action;", "", "()V", "toAccessManagement", "", "getToAccessManagement", "()I", "toAddAddress", "getToAddAddress", "toCallSettings", "getToCallSettings", "toCallsSchedule", "getToCallsSchedule", "toChat", "getToChat", "toConnectServices", "getToConnectServices", "toDownload", "getToDownload", "toFaceDetect", "getToFaceDetect", "toGrantAccess", "getToGrantAccess", "toHome", "getToHome", "toHomeBottomSheet", "getToHomeBottomSheet", "toIntercomEmergencyCode", "getToIntercomEmergencyCode", "toIntercomError", "getToIntercomError", "toLogIn", "getToLogIn", "toOfficeMap", "getToOfficeMap", "toOfficeMapFilter", "getToOfficeMapFilter", "toOfficeMapHuawei", "getToOfficeMapHuawei", "toPlayer", "getToPlayer", "toProfile", "getToProfile", "toProfileDetails", "getToProfileDetails", "toQrCode", "getToQrCode", "toRegistration", "getToRegistration", "toRequestState", "getToRequestState", "toScanQrCode", "getToScanQrCode", "toSelectPlaybackSpeed", "getToSelectPlaybackSpeed", "toTemporaryAccess", "getToTemporaryAccess", "toTrial", "getToTrial", "toTutorial", "getToTutorial", "toVerify", "getToVerify", "toVideoPlayer", "getToVideoPlayer", "toWelcomeScreen", "getToWelcomeScreen", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Action {
        public static final Action INSTANCE = new Action();
        private static final int toAccessManagement;
        private static final int toAddAddress;
        private static final int toCallSettings;
        private static final int toCallsSchedule;
        private static final int toChat;
        private static final int toConnectServices;
        private static final int toDownload;
        private static final int toFaceDetect;
        private static final int toGrantAccess;
        private static final int toHome;
        private static final int toHomeBottomSheet;
        private static final int toIntercomEmergencyCode;
        private static final int toIntercomError;
        private static final int toLogIn;
        private static final int toOfficeMap;
        private static final int toOfficeMapFilter;
        private static final int toOfficeMapHuawei;
        private static final int toPlayer;
        private static final int toProfile;
        private static final int toProfileDetails;
        private static final int toQrCode;
        private static final int toRegistration;
        private static final int toRequestState;
        private static final int toScanQrCode;
        private static final int toSelectPlaybackSpeed;
        private static final int toTemporaryAccess;
        private static final int toTrial;
        private static final int toTutorial;
        private static final int toVerify;
        private static final int toVideoPlayer;
        private static final int toWelcomeScreen;

        private Action() {
        }

        static {
            NavGraphDestinations navGraphDestinations = NavGraphDestinations.INSTANCE;
            int idCounter = navGraphDestinations.getIdCounter();
            navGraphDestinations.setIdCounter(idCounter + 1);
            toAccessManagement = idCounter;
            NavGraphDestinations navGraphDestinations2 = NavGraphDestinations.INSTANCE;
            int idCounter2 = navGraphDestinations2.getIdCounter();
            navGraphDestinations2.setIdCounter(idCounter2 + 1);
            toAddAddress = idCounter2;
            NavGraphDestinations navGraphDestinations3 = NavGraphDestinations.INSTANCE;
            int idCounter3 = navGraphDestinations3.getIdCounter();
            navGraphDestinations3.setIdCounter(idCounter3 + 1);
            toCallSettings = idCounter3;
            NavGraphDestinations navGraphDestinations4 = NavGraphDestinations.INSTANCE;
            int idCounter4 = navGraphDestinations4.getIdCounter();
            navGraphDestinations4.setIdCounter(idCounter4 + 1);
            toCallsSchedule = idCounter4;
            NavGraphDestinations navGraphDestinations5 = NavGraphDestinations.INSTANCE;
            int idCounter5 = navGraphDestinations5.getIdCounter();
            navGraphDestinations5.setIdCounter(idCounter5 + 1);
            toChat = idCounter5;
            NavGraphDestinations navGraphDestinations6 = NavGraphDestinations.INSTANCE;
            int idCounter6 = navGraphDestinations6.getIdCounter();
            navGraphDestinations6.setIdCounter(idCounter6 + 1);
            toConnectServices = idCounter6;
            NavGraphDestinations navGraphDestinations7 = NavGraphDestinations.INSTANCE;
            int idCounter7 = navGraphDestinations7.getIdCounter();
            navGraphDestinations7.setIdCounter(idCounter7 + 1);
            toDownload = idCounter7;
            NavGraphDestinations navGraphDestinations8 = NavGraphDestinations.INSTANCE;
            int idCounter8 = navGraphDestinations8.getIdCounter();
            navGraphDestinations8.setIdCounter(idCounter8 + 1);
            toFaceDetect = idCounter8;
            NavGraphDestinations navGraphDestinations9 = NavGraphDestinations.INSTANCE;
            int idCounter9 = navGraphDestinations9.getIdCounter();
            navGraphDestinations9.setIdCounter(idCounter9 + 1);
            toGrantAccess = idCounter9;
            NavGraphDestinations navGraphDestinations10 = NavGraphDestinations.INSTANCE;
            int idCounter10 = navGraphDestinations10.getIdCounter();
            navGraphDestinations10.setIdCounter(idCounter10 + 1);
            toHome = idCounter10;
            NavGraphDestinations navGraphDestinations11 = NavGraphDestinations.INSTANCE;
            int idCounter11 = navGraphDestinations11.getIdCounter();
            navGraphDestinations11.setIdCounter(idCounter11 + 1);
            toHomeBottomSheet = idCounter11;
            NavGraphDestinations navGraphDestinations12 = NavGraphDestinations.INSTANCE;
            int idCounter12 = navGraphDestinations12.getIdCounter();
            navGraphDestinations12.setIdCounter(idCounter12 + 1);
            toIntercomEmergencyCode = idCounter12;
            NavGraphDestinations navGraphDestinations13 = NavGraphDestinations.INSTANCE;
            int idCounter13 = navGraphDestinations13.getIdCounter();
            navGraphDestinations13.setIdCounter(idCounter13 + 1);
            toIntercomError = idCounter13;
            NavGraphDestinations navGraphDestinations14 = NavGraphDestinations.INSTANCE;
            int idCounter14 = navGraphDestinations14.getIdCounter();
            navGraphDestinations14.setIdCounter(idCounter14 + 1);
            toLogIn = idCounter14;
            NavGraphDestinations navGraphDestinations15 = NavGraphDestinations.INSTANCE;
            int idCounter15 = navGraphDestinations15.getIdCounter();
            navGraphDestinations15.setIdCounter(idCounter15 + 1);
            toOfficeMap = idCounter15;
            NavGraphDestinations navGraphDestinations16 = NavGraphDestinations.INSTANCE;
            int idCounter16 = navGraphDestinations16.getIdCounter();
            navGraphDestinations16.setIdCounter(idCounter16 + 1);
            toOfficeMapFilter = idCounter16;
            NavGraphDestinations navGraphDestinations17 = NavGraphDestinations.INSTANCE;
            int idCounter17 = navGraphDestinations17.getIdCounter();
            navGraphDestinations17.setIdCounter(idCounter17 + 1);
            toOfficeMapHuawei = idCounter17;
            NavGraphDestinations navGraphDestinations18 = NavGraphDestinations.INSTANCE;
            int idCounter18 = navGraphDestinations18.getIdCounter();
            navGraphDestinations18.setIdCounter(idCounter18 + 1);
            toPlayer = idCounter18;
            NavGraphDestinations navGraphDestinations19 = NavGraphDestinations.INSTANCE;
            int idCounter19 = navGraphDestinations19.getIdCounter();
            navGraphDestinations19.setIdCounter(idCounter19 + 1);
            toProfile = idCounter19;
            NavGraphDestinations navGraphDestinations20 = NavGraphDestinations.INSTANCE;
            int idCounter20 = navGraphDestinations20.getIdCounter();
            navGraphDestinations20.setIdCounter(idCounter20 + 1);
            toProfileDetails = idCounter20;
            NavGraphDestinations navGraphDestinations21 = NavGraphDestinations.INSTANCE;
            int idCounter21 = navGraphDestinations21.getIdCounter();
            navGraphDestinations21.setIdCounter(idCounter21 + 1);
            toQrCode = idCounter21;
            NavGraphDestinations navGraphDestinations22 = NavGraphDestinations.INSTANCE;
            int idCounter22 = navGraphDestinations22.getIdCounter();
            navGraphDestinations22.setIdCounter(idCounter22 + 1);
            toRegistration = idCounter22;
            NavGraphDestinations navGraphDestinations23 = NavGraphDestinations.INSTANCE;
            int idCounter23 = navGraphDestinations23.getIdCounter();
            navGraphDestinations23.setIdCounter(idCounter23 + 1);
            toRequestState = idCounter23;
            NavGraphDestinations navGraphDestinations24 = NavGraphDestinations.INSTANCE;
            int idCounter24 = navGraphDestinations24.getIdCounter();
            navGraphDestinations24.setIdCounter(idCounter24 + 1);
            toScanQrCode = idCounter24;
            NavGraphDestinations navGraphDestinations25 = NavGraphDestinations.INSTANCE;
            int idCounter25 = navGraphDestinations25.getIdCounter();
            navGraphDestinations25.setIdCounter(idCounter25 + 1);
            toSelectPlaybackSpeed = idCounter25;
            NavGraphDestinations navGraphDestinations26 = NavGraphDestinations.INSTANCE;
            int idCounter26 = navGraphDestinations26.getIdCounter();
            navGraphDestinations26.setIdCounter(idCounter26 + 1);
            toTemporaryAccess = idCounter26;
            NavGraphDestinations navGraphDestinations27 = NavGraphDestinations.INSTANCE;
            int idCounter27 = navGraphDestinations27.getIdCounter();
            navGraphDestinations27.setIdCounter(idCounter27 + 1);
            toTrial = idCounter27;
            NavGraphDestinations navGraphDestinations28 = NavGraphDestinations.INSTANCE;
            int idCounter28 = navGraphDestinations28.getIdCounter();
            navGraphDestinations28.setIdCounter(idCounter28 + 1);
            toTutorial = idCounter28;
            NavGraphDestinations navGraphDestinations29 = NavGraphDestinations.INSTANCE;
            int idCounter29 = navGraphDestinations29.getIdCounter();
            navGraphDestinations29.setIdCounter(idCounter29 + 1);
            toVerify = idCounter29;
            NavGraphDestinations navGraphDestinations30 = NavGraphDestinations.INSTANCE;
            int idCounter30 = navGraphDestinations30.getIdCounter();
            navGraphDestinations30.setIdCounter(idCounter30 + 1);
            toVideoPlayer = idCounter30;
            NavGraphDestinations navGraphDestinations31 = NavGraphDestinations.INSTANCE;
            int idCounter31 = navGraphDestinations31.getIdCounter();
            navGraphDestinations31.setIdCounter(idCounter31 + 1);
            toWelcomeScreen = idCounter31;
        }

        public final int getToAccessManagement() {
            return toAccessManagement;
        }

        public final int getToAddAddress() {
            return toAddAddress;
        }

        public final int getToCallSettings() {
            return toCallSettings;
        }

        public final int getToCallsSchedule() {
            return toCallsSchedule;
        }

        public final int getToChat() {
            return toChat;
        }

        public final int getToConnectServices() {
            return toConnectServices;
        }

        public final int getToDownload() {
            return toDownload;
        }

        public final int getToFaceDetect() {
            return toFaceDetect;
        }

        public final int getToGrantAccess() {
            return toGrantAccess;
        }

        public final int getToHome() {
            return toHome;
        }

        public final int getToHomeBottomSheet() {
            return toHomeBottomSheet;
        }

        public final int getToIntercomEmergencyCode() {
            return toIntercomEmergencyCode;
        }

        public final int getToIntercomError() {
            return toIntercomError;
        }

        public final int getToLogIn() {
            return toLogIn;
        }

        public final int getToOfficeMap() {
            return toOfficeMap;
        }

        public final int getToOfficeMapFilter() {
            return toOfficeMapFilter;
        }

        public final int getToOfficeMapHuawei() {
            return toOfficeMapHuawei;
        }

        public final int getToPlayer() {
            return toPlayer;
        }

        public final int getToProfile() {
            return toProfile;
        }

        public final int getToProfileDetails() {
            return toProfileDetails;
        }

        public final int getToQrCode() {
            return toQrCode;
        }

        public final int getToRegistration() {
            return toRegistration;
        }

        public final int getToRequestState() {
            return toRequestState;
        }

        public final int getToScanQrCode() {
            return toScanQrCode;
        }

        public final int getToSelectPlaybackSpeed() {
            return toSelectPlaybackSpeed;
        }

        public final int getToTemporaryAccess() {
            return toTemporaryAccess;
        }

        public final int getToTrial() {
            return toTrial;
        }

        public final int getToTutorial() {
            return toTutorial;
        }

        public final int getToVerify() {
            return toVerify;
        }

        public final int getToVideoPlayer() {
            return toVideoPlayer;
        }

        public final int getToWelcomeScreen() {
            return toWelcomeScreen;
        }
    }
}
