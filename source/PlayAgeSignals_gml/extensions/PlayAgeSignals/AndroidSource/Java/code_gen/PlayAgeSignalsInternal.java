// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName};

import java.nio.ByteBuffer;
import java.util.*;
import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.GMExtWire.GMFunction;
import ${YYAndroidPackageName}.GMExtWire.GMValue;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public abstract class PlayAgeSignalsInternal extends RunnerSocial implements PlayAgeSignalsInterface {

    private final GMExtWire.DispatchQueue __dispatch_queue = new GMExtWire.DispatchQueue();
    public double __EXT_NATIVE__PlayAgeSignals_invocation_handler(ByteBuffer __ret_buffer, double __ret_buffer_length)
    {
        return __dispatch_queue.fetch(__ret_buffer);
    }

    public double __EXT_NATIVE__play_age_signals_init()
    {
        boolean __result = play_age_signals_init();
        return __result ? 1.0 : 0.0;
    }

    public double __EXT_NATIVE__play_age_signals_is_available()
    {
        boolean __result = play_age_signals_is_available();
        return __result ? 1.0 : 0.0;
    }

    public double __EXT_NATIVE__play_age_signals_check(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: callback, type: Function
        GMFunction callback = GMExtWire.readGMFunction(__arg_buffer, __dispatch_queue);

        play_age_signals_check(callback);
        return 0;
    }

    public double __EXT_NATIVE__play_age_signals_test_use_fake_manager(double enable)
    {
        play_age_signals_test_use_fake_manager(enable != 0);
        return 0;
    }

    public double __EXT_NATIVE__play_age_signals_test_set_result(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: status, type: enum PlayAgeSignalsVerificationStatus
        PlayAgeSignalsVerificationStatus status = PlayAgeSignalsVerificationStatus.from(GMExtWire.readI32(__arg_buffer));

        // field: age_lower, type: Int32
        int age_lower = GMExtWire.readI32(__arg_buffer);

        // field: age_upper, type: Int32
        int age_upper = GMExtWire.readI32(__arg_buffer);

        // field: approval_date_ms, type: Float64
        double approval_date_ms = GMExtWire.readF64(__arg_buffer);

        // field: install_id, type: String
        String install_id = GMExtWire.readString(__arg_buffer);

        play_age_signals_test_set_result(status, age_lower, age_upper, approval_date_ms, install_id);
        return 0;
    }

    public double __EXT_NATIVE__play_age_signals_test_set_error(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: error_code, type: enum PlayAgeSignalsErrorCode
        PlayAgeSignalsErrorCode error_code = PlayAgeSignalsErrorCode.from(GMExtWire.readI32(__arg_buffer));

        play_age_signals_test_set_error(error_code);
        return 0;
    }

}