// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName};
import ${YYAndroidPackageName}.GMExtWire.GMFunction;
import ${YYAndroidPackageName}.GMExtWire.GMValue;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public interface PlayAgeSignalsInterface {
    public boolean play_age_signals_init();
    public boolean play_age_signals_is_available();
    public void play_age_signals_check(GMFunction callback);
    public void play_age_signals_test_use_fake_manager(boolean enable);
    public void play_age_signals_test_set_result(PlayAgeSignalsVerificationStatus status, int age_lower, int age_upper, double approval_date_ms, String install_id);
    public void play_age_signals_test_set_error(PlayAgeSignalsErrorCode error_code);
}