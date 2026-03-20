package ${YYAndroidPackageName};

import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.PlayAgeSignalsResult;
import ${YYAndroidPackageName}.GMExtWire.GMFunction;

import android.app.Activity;

import androidx.annotation.Nullable;

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
    public void play_age_signals_check(GMFunction callback) {
        if (!play_age_signals_init()) {
            if (callback != null) {
                callback.call(makeErrorResult(
                    PlayAgeSignalsErrorCode.INTERNAL_ERROR,
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
                        PlayAgeSignalsErrorCode.INTERNAL_ERROR,
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
                    PlayAgeSignalsErrorCode.INTERNAL_ERROR,
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
    public void play_age_signals_test_set_result(
        PlayAgeSignalsVerificationStatus status,
        int age_lower,
        int age_upper,
        double approval_date_ms,
        String install_id
    ) {
        if (!mUseFakeManager) return;
        if (!play_age_signals_init()) return;
        if (mFakeAgeSignalsManager == null) return;

        AgeSignalsResult.Builder builder = AgeSignalsResult.builder();

        int status_value = status.value();

        // None (-1) means: do not set user status
        if (status_value >= 0) {
            builder.setUserStatus(status_value);
        }

        if (age_lower >= 0) {
            builder.setAgeLower(age_lower);
        }

        if (age_upper >= 0) {
            builder.setAgeUpper(age_upper);
        }

        if (approval_date_ms >= 0.0) {
            builder.setMostRecentApprovalDate(new Date((long) approval_date_ms));
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

    private void handleSuccess(GMFunction callback, AgeSignalsResult result) {
        if (callback == null) return;
        callback.call(makeSuccessResult(result));
    }

    private void handleFailure(GMFunction callback, Exception exception) {
        if (callback == null) return;

        PlayAgeSignalsErrorCode errorCode = PlayAgeSignalsErrorCode.INTERNAL_ERROR;
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

        callback.call(makeErrorResult(errorCode, message));
    }

    private PlayAgeSignalsResult makeSuccessResult(AgeSignalsResult result) {
        return new PlayAgeSignalsResult(
            true,
            mapVerificationStatusEnum(result.userStatus()),
            nullableInt(result.ageLower(), -1),
            nullableInt(result.ageUpper(), -1),
            nullableDateToMs(result.mostRecentApprovalDate()),
            safeString(result.installId()),
            PlayAgeSignalsErrorCode.NO_ERROR,
            ""
        );
    }

    private PlayAgeSignalsResult makeErrorResult(PlayAgeSignalsErrorCode errorCode, String message) {
        return new PlayAgeSignalsResult(
            false,
            PlayAgeSignalsVerificationStatus.None,
            -1,
            -1,
            -1.0,
            "",
            errorCode,
            message != null ? message : ""
        );
    }

    private PlayAgeSignalsVerificationStatus mapVerificationStatusEnum(@Nullable Integer status) {
        if (status == null) {
            return PlayAgeSignalsVerificationStatus.None;
        }

        switch (status) {
            case com.google.android.play.agesignals.model.AgeSignalsVerificationStatus.VERIFIED:
                return PlayAgeSignalsVerificationStatus.VERIFIED;

            case com.google.android.play.agesignals.model.AgeSignalsVerificationStatus.SUPERVISED:
                return PlayAgeSignalsVerificationStatus.SUPERVISED;

            case com.google.android.play.agesignals.model.AgeSignalsVerificationStatus.SUPERVISED_APPROVAL_PENDING:
                return PlayAgeSignalsVerificationStatus.SUPERVISED_APPROVAL_PENDING;

            case com.google.android.play.agesignals.model.AgeSignalsVerificationStatus.SUPERVISED_APPROVAL_DENIED:
                return PlayAgeSignalsVerificationStatus.SUPERVISED_APPROVAL_DENIED;

            case com.google.android.play.agesignals.model.AgeSignalsVerificationStatus.UNKNOWN:
                return PlayAgeSignalsVerificationStatus.UNKNOWN;

            case com.google.android.play.agesignals.model.AgeSignalsVerificationStatus.DECLARED:
                return PlayAgeSignalsVerificationStatus.DECLARED;

            default:
                return PlayAgeSignalsVerificationStatus.None;
        }
    }

    private PlayAgeSignalsErrorCode mapErrorCodeEnum(int errorCode) {
        switch (errorCode) {
            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.NO_ERROR:
                return PlayAgeSignalsErrorCode.NO_ERROR;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.API_NOT_AVAILABLE:
                return PlayAgeSignalsErrorCode.API_NOT_AVAILABLE;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_STORE_NOT_FOUND:
                return PlayAgeSignalsErrorCode.PLAY_STORE_NOT_FOUND;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.NETWORK_ERROR:
                return PlayAgeSignalsErrorCode.NETWORK_ERROR;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_SERVICES_NOT_FOUND:
                return PlayAgeSignalsErrorCode.PLAY_SERVICES_NOT_FOUND;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.CANNOT_BIND_TO_SERVICE:
                return PlayAgeSignalsErrorCode.CANNOT_BIND_TO_SERVICE;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_STORE_VERSION_OUTDATED:
                return PlayAgeSignalsErrorCode.PLAY_STORE_VERSION_OUTDATED;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.PLAY_SERVICES_VERSION_OUTDATED:
                return PlayAgeSignalsErrorCode.PLAY_SERVICES_VERSION_OUTDATED;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.CLIENT_TRANSIENT_ERROR:
                return PlayAgeSignalsErrorCode.CLIENT_TRANSIENT_ERROR;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.APP_NOT_OWNED:
                return PlayAgeSignalsErrorCode.APP_NOT_OWNED;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.SDK_VERSION_OUTDATED:
                return PlayAgeSignalsErrorCode.SDK_VERSION_OUTDATED;

            case com.google.android.play.agesignals.model.AgeSignalsErrorCode.INTERNAL_ERROR:
            default:
                return PlayAgeSignalsErrorCode.INTERNAL_ERROR;
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
}