// ##### extgen :: Auto-generated file do not edit!! #####

// #####################################################################
// # Macros
// #####################################################################

// #####################################################################
// # Enums
// #####################################################################

enum PlayAgeSignalsStatus
{
    None = -1,
    Shared = 0,
    NotShared = 1,
    VerificationRequired = 2
}

enum PlayAgeSignalsAgeRangeSource
{
    None = -1,
    TierA = 0,
    TierB = 1,
    TierC = 2,
    TierD = 3
}

enum PlayAgeSignalsSignificantChangeStatus
{
    None = -1,
    Approved = 0,
    Pending = 1,
    Declined = 2
}

enum PlayAgeSignalsErrorCode
{
    NoError = 0,
    ApiNotAvailable = -1,
    PlayStoreNotFound = -2,
    NetworkError = -3,
    PlayServicesNotFound = -4,
    CannotBindToService = -5,
    PlayStoreVersionOutdated = -6,
    PlayServicesVersionOutdated = -7,
    ClientTransientError = -8,
    AppNotOwned = -9,
    SdkVersionOutdated = -10,
    InternalError = -100
}

// #####################################################################
// # Constructors
// #####################################################################

/**
 * @returns {Struct.PlayAgeSignalsAccessResult}
 */
function PlayAgeSignalsAccessResult() constructor
{
    /**
     * Internally generated hash for quick validation
     * @ignore
     */
    static __uid = 711899528;

    self.success = undefined;
    self.status = undefined;
    self.error_code = undefined;
    self.error_message = undefined;

}

/**
 * @returns {Struct.PlayAgeSignalsResult}
 */
function PlayAgeSignalsResult() constructor
{
    /**
     * Internally generated hash for quick validation
     * @ignore
     */
    static __uid = 2785537754;

    self.success = undefined;
    self.age_range_source = undefined;
    self.age_lower = undefined;
    self.age_upper = undefined;
    self.significant_change_status = undefined;
    self.significant_change_approval_date_ms = undefined;
    self.install_id = undefined;
    self.error_code = undefined;
    self.error_message = undefined;

}

// #####################################################################
// # Codecs
// #####################################################################

/**
 * @func __PlayAgeSignalsAccessResult_encode(_inst, _buffer, _offset, _where)
 * @param {Struct.PlayAgeSignalsAccessResult} _inst
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @param {String} _where
 * @ignore
 */
function __PlayAgeSignalsAccessResult_encode(_inst, _buffer, _offset, _where = _GMFUNCTION_)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);
    with (_inst)
    {
        // field: success, type: Bool
        if (!is_bool(self.success)) show_error($"{_where} :: self.success expected bool", true);
        buffer_write(_buffer, buffer_bool, self.success);

        // field: status, type: enum PlayAgeSignalsStatus

        if (!is_numeric(self.status)) show_error($"{_where} :: self.status expected number", true);
        buffer_write(_buffer, buffer_s32, self.status);

        // field: error_code, type: enum PlayAgeSignalsErrorCode

        if (!is_numeric(self.error_code)) show_error($"{_where} :: self.error_code expected number", true);
        buffer_write(_buffer, buffer_s32, self.error_code);

        // field: error_message, type: String
        if (!is_string(self.error_message)) show_error($"{_where} :: self.error_message expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.error_message));
        buffer_write(_buffer, buffer_string, self.error_message);

    }
}

/**
 * @func __PlayAgeSignalsAccessResult_decode(_buffer, _offset)
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @returns {Struct.PlayAgeSignalsAccessResult}
 * @ignore
 */
function __PlayAgeSignalsAccessResult_decode(_buffer, _offset)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);

    _inst = new PlayAgeSignalsAccessResult();
    with (_inst)
    {
        // field: success, type: Bool
        self.success = buffer_read(_buffer, buffer_bool);

        // field: status, type: enum PlayAgeSignalsStatus
        self.status = buffer_read(_buffer, buffer_s32);

        // field: error_code, type: enum PlayAgeSignalsErrorCode
        self.error_code = buffer_read(_buffer, buffer_s32);

        // field: error_message, type: String
        buffer_read(_buffer, buffer_u32);
        self.error_message = buffer_read(_buffer, buffer_string);

    }

    return _inst;
}

/**
 * @func __PlayAgeSignalsResult_encode(_inst, _buffer, _offset, _where)
 * @param {Struct.PlayAgeSignalsResult} _inst
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @param {String} _where
 * @ignore
 */
function __PlayAgeSignalsResult_encode(_inst, _buffer, _offset, _where = _GMFUNCTION_)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);
    with (_inst)
    {
        // field: success, type: Bool
        if (!is_bool(self.success)) show_error($"{_where} :: self.success expected bool", true);
        buffer_write(_buffer, buffer_bool, self.success);

        // field: age_range_source, type: enum PlayAgeSignalsAgeRangeSource

        if (!is_numeric(self.age_range_source)) show_error($"{_where} :: self.age_range_source expected number", true);
        buffer_write(_buffer, buffer_s32, self.age_range_source);

        // field: age_lower, type: Int32
        if (!is_numeric(self.age_lower)) show_error($"{_where} :: self.age_lower expected number", true);
        buffer_write(_buffer, buffer_s32, self.age_lower);

        // field: age_upper, type: Int32
        if (!is_numeric(self.age_upper)) show_error($"{_where} :: self.age_upper expected number", true);
        buffer_write(_buffer, buffer_s32, self.age_upper);

        // field: significant_change_status, type: enum PlayAgeSignalsSignificantChangeStatus

        if (!is_numeric(self.significant_change_status)) show_error($"{_where} :: self.significant_change_status expected number", true);
        buffer_write(_buffer, buffer_s32, self.significant_change_status);

        // field: significant_change_approval_date_ms, type: Float64
        if (!is_numeric(self.significant_change_approval_date_ms)) show_error($"{_where} :: self.significant_change_approval_date_ms expected number", true);
        buffer_write(_buffer, buffer_f64, self.significant_change_approval_date_ms);

        // field: install_id, type: String
        if (!is_string(self.install_id)) show_error($"{_where} :: self.install_id expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.install_id));
        buffer_write(_buffer, buffer_string, self.install_id);

        // field: error_code, type: enum PlayAgeSignalsErrorCode

        if (!is_numeric(self.error_code)) show_error($"{_where} :: self.error_code expected number", true);
        buffer_write(_buffer, buffer_s32, self.error_code);

        // field: error_message, type: String
        if (!is_string(self.error_message)) show_error($"{_where} :: self.error_message expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.error_message));
        buffer_write(_buffer, buffer_string, self.error_message);

    }
}

/**
 * @func __PlayAgeSignalsResult_decode(_buffer, _offset)
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @returns {Struct.PlayAgeSignalsResult}
 * @ignore
 */
function __PlayAgeSignalsResult_decode(_buffer, _offset)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);

    _inst = new PlayAgeSignalsResult();
    with (_inst)
    {
        // field: success, type: Bool
        self.success = buffer_read(_buffer, buffer_bool);

        // field: age_range_source, type: enum PlayAgeSignalsAgeRangeSource
        self.age_range_source = buffer_read(_buffer, buffer_s32);

        // field: age_lower, type: Int32
        self.age_lower = buffer_read(_buffer, buffer_s32);

        // field: age_upper, type: Int32
        self.age_upper = buffer_read(_buffer, buffer_s32);

        // field: significant_change_status, type: enum PlayAgeSignalsSignificantChangeStatus
        self.significant_change_status = buffer_read(_buffer, buffer_s32);

        // field: significant_change_approval_date_ms, type: Float64
        self.significant_change_approval_date_ms = buffer_read(_buffer, buffer_f64);

        // field: install_id, type: String
        buffer_read(_buffer, buffer_u32);
        self.install_id = buffer_read(_buffer, buffer_string);

        // field: error_code, type: enum PlayAgeSignalsErrorCode
        self.error_code = buffer_read(_buffer, buffer_s32);

        // field: error_message, type: String
        buffer_read(_buffer, buffer_u32);
        self.error_message = buffer_read(_buffer, buffer_string);

    }

    return _inst;
}

// #####################################################################
// # Functions
// #####################################################################

// Skipping function play_age_signals_init (no wrapper is required)


// Skipping function play_age_signals_is_available (no wrapper is required)


/**
 * @param {Function} _callback
 */
function play_age_signals_request_access(_callback)
{
    var __available__ = __PlayAgeSignals_is_available();
    if (!__available__) return;

    var __dispatcher__ = __PlayAgeSignals_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher__);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    var __return_value__ = __play_age_signals_request_access(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

/**
 * @param {Function} _callback
 */
function play_age_signals_check(_callback)
{
    var __available__ = __PlayAgeSignals_is_available();
    if (!__available__) return;

    var __dispatcher__ = __PlayAgeSignals_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher__);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    var __return_value__ = __play_age_signals_check(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

// Skipping function play_age_signals_test_use_fake_manager (no wrapper is required)


/**
 * @param {Enum.PlayAgeSignalsStatus} _status
 */
function play_age_signals_test_set_access_result(_status)
{
    var __available__ = __PlayAgeSignals_is_available();
    if (!__available__) return;

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _status, type: enum PlayAgeSignalsStatus

    if (!is_numeric(_status)) show_error($"{_GMFUNCTION_} :: _status expected number", true);
    buffer_write(__args_buffer, buffer_s32, _status);

    var __return_value__ = __play_age_signals_test_set_access_result(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

/**
 * @param {Enum.PlayAgeSignalsAgeRangeSource} _age_range_source
 * @param {Real} _age_lower
 * @param {Real} _age_upper
 * @param {Enum.PlayAgeSignalsSignificantChangeStatus} _significant_change_status
 * @param {Real} _significant_change_approval_date_ms
 * @param {String} _install_id
 */
function play_age_signals_test_set_result(_age_range_source, _age_lower, _age_upper, _significant_change_status, _significant_change_approval_date_ms, _install_id)
{
    var __available__ = __PlayAgeSignals_is_available();
    if (!__available__) return;

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _age_range_source, type: enum PlayAgeSignalsAgeRangeSource

    if (!is_numeric(_age_range_source)) show_error($"{_GMFUNCTION_} :: _age_range_source expected number", true);
    buffer_write(__args_buffer, buffer_s32, _age_range_source);

    // param: _age_lower, type: Int32
    if (!is_numeric(_age_lower)) show_error($"{_GMFUNCTION_} :: _age_lower expected number", true);
    buffer_write(__args_buffer, buffer_s32, _age_lower);

    // param: _age_upper, type: Int32
    if (!is_numeric(_age_upper)) show_error($"{_GMFUNCTION_} :: _age_upper expected number", true);
    buffer_write(__args_buffer, buffer_s32, _age_upper);

    // param: _significant_change_status, type: enum PlayAgeSignalsSignificantChangeStatus

    if (!is_numeric(_significant_change_status)) show_error($"{_GMFUNCTION_} :: _significant_change_status expected number", true);
    buffer_write(__args_buffer, buffer_s32, _significant_change_status);

    // param: _significant_change_approval_date_ms, type: Float64
    if (!is_numeric(_significant_change_approval_date_ms)) show_error($"{_GMFUNCTION_} :: _significant_change_approval_date_ms expected number", true);
    buffer_write(__args_buffer, buffer_f64, _significant_change_approval_date_ms);

    // param: _install_id, type: String
    if (!is_string(_install_id)) show_error($"{_GMFUNCTION_} :: _install_id expected string", true);
    buffer_write(__args_buffer, buffer_u32, string_byte_length(_install_id));
    buffer_write(__args_buffer, buffer_string, _install_id);

    var __return_value__ = __play_age_signals_test_set_result(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

/**
 * @param {Enum.PlayAgeSignalsErrorCode} _error_code
 */
function play_age_signals_test_set_error(_error_code)
{
    var __available__ = __PlayAgeSignals_is_available();
    if (!__available__) return;

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _error_code, type: enum PlayAgeSignalsErrorCode

    if (!is_numeric(_error_code)) show_error($"{_GMFUNCTION_} :: _error_code expected number", true);
    buffer_write(__args_buffer, buffer_s32, _error_code);

    var __return_value__ = __play_age_signals_test_set_error(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

/// @ignore
function __PlayAgeSignals_get_decoders()
{
    static __decoders__ = [
        __PlayAgeSignalsAccessResult_decode,
        __PlayAgeSignalsResult_decode
    ];
    return __decoders__;
}
/// @ignore
function __PlayAgeSignals_get_dispatcher()
{
    static __dispatcher__ = new __GMNativeFunctionDispatcher(__PlayAgeSignals_invocation_handler, __PlayAgeSignals_get_decoders());
    return __dispatcher__;
}
/// @ignore
function __PlayAgeSignals_is_available()
{
    static __available__ = extension_exists("PlayAgeSignals");
    return __available__;
}
