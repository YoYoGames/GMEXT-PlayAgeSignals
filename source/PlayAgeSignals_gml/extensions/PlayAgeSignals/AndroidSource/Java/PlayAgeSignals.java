package ${YYAndroidPackageName};

import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.PlayAgeSignalsAccessResult;
import ${YYAndroidPackageName}.records.PlayAgeSignalsResult;
import ${YYAndroidPackageName}.GMExtWire.GMFunction;

import android.app.Activity;

import androidx.annotation.Nullable;

import com.google.android.play.agesignals.AgeSignalsAccessRequest;
import com.google.android.play.agesignals.AgeSignalsAccessResult;
import com.google.android.play.agesignals.AgeSignalsException;
import com.google.android.play.agesignals.AgeSignalsManager;
import com.google.android.play.agesignals.AgeSignalsManagerFactory;
import com.google.android.play.agesignals.AgeSignalsRequest;
import com.google.android.play.agesignals.AgeSignalsResult;
import com.google.android.play.agesignals.testing.FakeAgeSignalsManager;

import java.util.Date;

public class PlayAgeSignals extends PlayAgeSignalsInternal {

    private final Activity activity = RunnerActivity.CurrentActivity;

    private AgeSignalsManager mAgeSignalsManager = null;
    private FakeAgeSignalsManager mFakeAgeSignalsManager = null;

    private boolean mInitialized = false;
    private boolean mUseFakeManager = false;

    @Override
    public boolean play_age_signals_init() {
        try {
            if (mUseFakeManager) {
                if (mFakeAgeSignalsManager == null) {
                    mFakeAgeSignalsManager = new FakeAgeSignalsManager();
                }
                mInitialized = true;
                return true;
            }

            if (mAgeSignalsManager == null) {
                mAgeSignalsManager =
                    AgeSignalsManagerFactory.create(activity.getApplicationContext());
            }

            mInitialized = (mAgeSignalsManager != null);
            return mInitialized;
        } catch (Exception e) {
            mAgeSignalsManager = null;
            mFakeAgeSignalsManager = null;
            mInitialized = false;
            return false;
        }
    }

    @Override
    public boolean play_age_signals_is_available() {
        if (!mInitialized) return false;

        if (mUseFakeManager) {
            return mFakeAgeSignalsManager != null;
        }

        return mAgeSignalsManager != null;
    }

    @Override
    public void play_age_signals_request_access(GMFunction callback) {
        if (!play_age_signals_init()) {
            if (callback != null) {
                callback.call(makeAccessErrorResult(
                    PlayAgeSignalsErrorCode.InternalError,
                    "Failed to initialize Play Age Signals manager"
                ));
            }
            return;
        }

        AgeSignalsAccessRequest request = AgeSignalsAccessRequest.builder()
            .setActivity(activity)
            .build();

        if (mUseFakeManager) {
            if (mFakeAgeSignalsManager == null) {
                if (callback != null) {
                    callback.call(makeAccessErrorResult(
                        PlayAgeSignalsErrorCode.InternalError,
                        "FakeAgeSignalsManager is not initialized"
                    ));
                }
                return;
            }

            mFakeAgeSignalsManager
                .requestAgeSignalsAccess(request)
                .addOnSuccessListener(result -> handleAccessSuccess(callback, result))
                .addOnFailureListener(exception -> handleAccessFailure(callback, exception));

            return;
        }

        if (mAgeSignalsManager == null) {
            if (callback != null) {
                callback.call(makeAccessErrorResult(
                    PlayAgeSignalsErrorCode.InternalError,
                    "AgeSignalsManager is not initialized"
                ));
            }
            return;
        }

        mAgeSignalsManager
            .requestAgeSignalsAccess(request)
            .addOnSuccessListener(result -> handleAccessSuccess(callback, result))
            .addOnFailureListener(exception -> handleAccessFailure(callback, exception));
    }

    @Override
    public void play_age_signals_check(GMFunction callback) {
        if (!play_age_signals_init()) {
            if (callback != null) {
                callback.call(makeErrorResult(
                    PlayAgeSignalsErrorCode.InternalError,
                    "Failed to initialize Play Age Signals manager"
                ));
            }
            return;
        }

        AgeSignalsRequest request = AgeSignalsRequest.builder().build();

        if (mUseFakeManager) {
            if (mFakeAgeSignalsManager == null) {
                if (callback != null) {
                    callback.call(makeErrorResult(
                        PlayAgeSignalsErrorCode.InternalError,
                        "FakeAgeSignalsManager is not initialized"
                    ));
                }
                return;
            }

            mFakeAgeSignalsManager
                .checkAgeSignals(request)
                .addOnSuccessListener(result -> handleSuccess(callback, result))
                .addOnFailureListener(exception -> handleFailure(callback, exception));

            return;
        }

        if (mAgeSignalsManager == null) {
            if (callback != null) {
                callback.call(makeErrorResult(
                    PlayAgeSignalsErrorCode.InternalError,
                    "AgeSignalsManager is not initialized"
                ));
            }
            return;
        }

        mAgeSignalsManager
            .checkAgeSignals(request)
            .addOnSuccessListener(result -> handleSuccess(callback, result))
            .addOnFailureListener(exception -> handleFailure(callback, exception));
    }

    @Override
    public void play_age_signals_test_use_fake_manager(boolean enable) {
        mUseFakeManager = enable;
        mInitialized = false;
        mAgeSignalsManager = null;
        mFakeAgeSignalsManager = null;
    }

    @Override
    public void play_age_signals_test_set_access_result(PlayAgeSignalsStatus status) {
        if (!mUseFakeManager) return;
        if (!play_age_signals_init()) return;
        if (mFakeAgeSignalsManager == null) return;

        Integer statusValue = mapAgeSignalsStatusValue(status);
        if (statusValue == null) return;

        AgeSignalsAccessResult result = AgeSignalsAccessResult.builder()
            .setAgeSignalsStatus(statusValue)
            .build();

        mFakeAgeSignalsManager.setNextAgeSignalsAccessResult(result);
    }

    @Override
    public void play_age_signals_test_set_result(
        PlayAgeSignalsAgeRangeSource age_range_source,
        int age_lower,
        int age_upper,
        PlayAgeSignalsSignificantChangeStatus significant_change_status,
        double significant_change_approval_date_ms,
        String install_id
    ) {
        if (!mUseFakeManager) return;
        if (!play_age_signals_init()) return;
        if (mFakeAgeSignalsManager == null) return;

        AgeSignalsResult.Builder builder = AgeSignalsResult.builder();

        Integer ageRangeSourceValue = mapAgeRangeSourceValue(age_range_source);
        if (ageRangeSourceValue != null) {
            builder.setAgeRangeSource(ageRangeSourceValue);
        }

        if (age_lower >= 0) {
            builder.setAgeLower(age_lower);
        }

        if (age_upper >= 0) {
            builder.setAgeUpper(age_upper);
        }

        Integer significantChangeStatusValue =
            mapSignificantChangeStatusValue(significant_change_status);
        if (significantChangeStatusValue != null) {
            builder.setSignificantChangeStatus(significantChangeStatusValue);
        }

        if (significant_change_approval_date_ms >= 0.0) {
            builder.setSignificantChangeApprovalDate(
                new Date((long) significant_change_approval_date_ms)
            );
        }

        if (install_id != null && !install_id.isEmpty()) {
            builder.setInstallId(install_id);
        }

        mFakeAgeSignalsManager.setNextAgeSignalsResult(builder.build());
    }

    @Override
    public void play_age_signals_test_set_error(PlayAgeSignalsErrorCode error_code) {
        if (!mUseFakeManager) return;
        if (!play_age_signals_init()) return;
        if (mFakeAgeSignalsManager == null) return;

        mFakeAgeSignalsManager.setNextAgeSignalsException(
            new AgeSignalsException(error_code.value())
        );
    }

    private void handleAccessSuccess(GMFunction callback, AgeSignalsAccessResult result) {
        if (callback == null) return;
        callback.call(makeAccessSuccessResult(result));
    }

    private void handleAccessFailure(GMFunction callback, Exception exception) {
        if (callback == null) return;

        ErrorInfo errorInfo = getErrorInfo(exception);
        callback.call(makeAccessErrorResult(errorInfo.code, errorInfo.message));
    }

    private void handleSuccess(GMFunction callback, AgeSignalsResult result) {
        if (callback == null) return;
        callback.call(makeSuccessResult(result));
    }

    private void handleFailure(GMFunction callback, Exception exception) {
        if (callback == null) return;

        ErrorInfo errorInfo = getErrorInfo(exception);
        callback.call(makeErrorResult(errorInfo.code, errorInfo.message));
    }

    private ErrorInfo getErrorInfo(Exception exception) {
        PlayAgeSignalsErrorCode errorCode = PlayAgeSignalsErrorCode.InternalError;
        String message = "Unknown Play Age Signals error";

        if (exception instanceof AgeSignalsException) {
            AgeSignalsException ageSignalsException = (AgeSignalsException) exception;
            errorCode = mapErrorCodeEnum(ageSignalsException.getErrorCode());

            if (ageSignalsException.getMessage() != null) {
                message = ageSignalsException.getMessage();
            }
        } else if (exception != null && exception.getMessage() != null) {
            message = exception.getMessage();
        }

        return new ErrorInfo(errorCode, message);
    }

    private PlayAgeSignalsAccessResult makeAccessSuccessResult(AgeSignalsAccessResult result) {
        return new PlayAgeSignalsAccessResult(
            true,
            mapAgeSignalsStatusEnum(result.ageSignalsStatus()),
            PlayAgeSignalsErrorCode.NoError,
            ""
        );
    }

    private PlayAgeSignalsAccessResult makeAccessErrorResult(
        PlayAgeSignalsErrorCode errorCode,
        String message
    ) {
        return new PlayAgeSignalsAccessResult(
            false,
            PlayAgeSignalsStatus.None,
            errorCode,
            message != null ? message : ""
        );
    }

    private PlayAgeSignalsResult makeSuccessResult(AgeSignalsResult result) {
        return new PlayAgeSignalsResult(
            true,
            mapAgeRangeSourceEnum(result.ageRangeSource()),
            nullableInt(result.ageLower(), -1),
            nullableInt(result.ageUpper(), -1),
            mapSignificantChangeStatusEnum(result.significantChangeStatus()),
            nullableDateToMs(result.significantChangeApprovalDate()),
            safeString(result.installId()),
            PlayAgeSignalsErrorCode.NoError,
            ""
        );
    }

    private PlayAgeSignalsResult makeErrorResult(
        PlayAgeSignalsErrorCode errorCode,
        String message
    ) {
        return new PlayAgeSignalsResult(
            false,
            PlayAgeSignalsAgeRangeSource.None,
            -1,
            -1,
            PlayAgeSignalsSignificantChangeStatus.None,
            -1.0,
            "",
            errorCode,
            message != null ? message : ""
        );
    }

    private PlayAgeSignalsStatus mapAgeSignalsStatusEnum(@Nullable Integer status) {
        if (status == null) {
            return PlayAgeSignalsStatus.None;
        }

        switch (status) {
            case com.google.android.play.agesignals.model.AgeSignalsStatus.SHARED:
                return PlayAgeSignalsStatus.Shared;

            case com.google.android.play.agesignals.model.AgeSignalsStatus.NOT_SHARED:
                return PlayAgeSignalsStatus.NotShared;

            case com.google.android.play.agesignals.model.AgeSignalsStatus.VERIFICATION_REQUIRED:
                return PlayAgeSignalsStatus.VerificationRequired;

            default:
                return PlayAgeSignalsStatus.None;
        }
    }

    @Nullable
    private Integer mapAgeSignalsStatusValue(@Nullable PlayAgeSignalsStatus status) {
        if (status == null) return null;

        switch (status) {
            case Shared:
                return com.google.android.play.agesignals.model.AgeSignalsStatus.SHARED;

            case NotShared:
                return com.google.android.play.agesignals.model.AgeSignalsStatus.NOT_SHARED;

            case VerificationRequired:
                return com.google.android.play.agesignals.model.AgeSignalsStatus.VERIFICATION_REQUIRED;

            case None:
            default:
                return null;
        }
    }

    private PlayAgeSignalsAgeRangeSource mapAgeRangeSourceEnum(@Nullable Integer source) {
        if (source == null) {
            return PlayAgeSignalsAgeRangeSource.None;
        }

        switch (source) {
            case com.google.android.play.agesignals.model.AgeRangeSource.TIER_A:
                return PlayAgeSignalsAgeRangeSource.TierA;

            case com.google.android.play.agesignals.model.AgeRangeSource.TIER_B:
                return PlayAgeSignalsAgeRangeSource.TierB;

            case com.google.android.play.agesignals.model.AgeRangeSource.TIER_C:
                return PlayAgeSignalsAgeRangeSource.TierC;

            case com.google.android.play.agesignals.model.AgeRangeSource.TIER_D:
                return PlayAgeSignalsAgeRangeSource.TierD;

            default:
                return PlayAgeSignalsAgeRangeSource.None;
        }
    }

    @Nullable
    private Integer mapAgeRangeSourceValue(@Nullable PlayAgeSignalsAgeRangeSource source) {
        if (source == null) return null;

        switch (source) {
            case TierA:
                return com.google.android.play.agesignals.model.AgeRangeSource.TIER_A;

            case TierB:
                return com.google.android.play.agesignals.model.AgeRangeSource.TIER_B;

            case TierC:
                return com.google.android.play.agesignals.model.AgeRangeSource.TIER_C;

            case TierD:
                return com.google.android.play.agesignals.model.AgeRangeSource.TIER_D;

            case None:
            default:
                return null;
        }
    }

    private PlayAgeSignalsSignificantChangeStatus mapSignificantChangeStatusEnum(
        @Nullable Integer status
    ) {
        if (status == null) {
            return PlayAgeSignalsSignificantChangeStatus.None;
        }

        switch (status) {
            case com.google.android.play.agesignals.model.SignificantChangeStatus.APPROVED:
                return PlayAgeSignalsSignificantChangeStatus.Approved;

            case com.google.android.play.agesignals.model.SignificantChangeStatus.PENDING:
                return PlayAgeSignalsSignificantChangeStatus.Pending;

            case com.google.android.play.agesignals.model.SignificantChangeStatus.DECLINED:
                return PlayAgeSignalsSignificantChangeStatus.Declined;

            default:
                return PlayAgeSignalsSignificantChangeStatus.None;
        }
    }

    @Nullable
    private Integer mapSignificantChangeStatusValue(
        @Nullable PlayAgeSignalsSignificantChangeStatus status
    ) {
        if (status == null) return null;

        switch (status) {
            case Approved:
                return com.google.android.play.agesignals.model.SignificantChangeStatus.APPROVED;

            case Pending:
                return com.google.android.play.agesignals.model.SignificantChangeStatus.PENDING;

            case Declined:
                return com.google.android.play.agesignals.model.SignificantChangeStatus.DECLINED;

            case None:
            default:
                return null;
        }
    }

    private PlayAgeSignalsErrorCode mapErrorCodeEnum(int errorCode) {
        switch (errorCode) {
            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.NO_ERROR:
                return PlayAgeSignalsErrorCode.NoError;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.API_NOT_AVAILABLE:
                return PlayAgeSignalsErrorCode.ApiNotAvailable;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_STORE_NOT_FOUND:
                return PlayAgeSignalsErrorCode.PlayStoreNotFound;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.NETWORK_ERROR:
                return PlayAgeSignalsErrorCode.NetworkError;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_SERVICES_NOT_FOUND:
                return PlayAgeSignalsErrorCode.PlayServicesNotFound;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.CANNOT_BIND_TO_SERVICE:
                return PlayAgeSignalsErrorCode.CannotBindToService;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_STORE_VERSION_OUTDATED:
                return PlayAgeSignalsErrorCode.PlayStoreVersionOutdated;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_SERVICES_VERSION_OUTDATED:
                return PlayAgeSignalsErrorCode.PlayServicesVersionOutdated;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.CLIENT_TRANSIENT_ERROR:
                return PlayAgeSignalsErrorCode.ClientTransientError;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.APP_NOT_OWNED:
                return PlayAgeSignalsErrorCode.AppNotOwned;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.SDK_VERSION_OUTDATED:
                return PlayAgeSignalsErrorCode.SdkVersionOutdated;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.INTERNAL_ERROR:
            default:
                return PlayAgeSignalsErrorCode.InternalError;
        }
    }

    private int nullableInt(@Nullable Integer value, int fallback) {
        return value != null ? value : fallback;
    }

    private double nullableDateToMs(@Nullable Date value) {
        if (value == null) {
            return -1.0;
        }
        return (double) value.getTime();
    }

    private String safeString(@Nullable String value) {
        return value != null ? value : "";
    }

    private static final class ErrorInfo {
        final PlayAgeSignalsErrorCode code;
        final String message;

        ErrorInfo(PlayAgeSignalsErrorCode code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}