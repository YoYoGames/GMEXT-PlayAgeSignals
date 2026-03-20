// ##### extgen :: Auto-generated file do not edit!! #####

// #####################################################################
// # Macros
// #####################################################################

// #####################################################################
// # Enums
// #####################################################################

enum PlayAgeSignalsVerificationStatus
{
    None = -1,
    Verified = 0,
    Supervised = 1,
    SupervisedApprovalPending = 2,
    SupervisedApprovalDenied = 3,
    Unknown = 4,
    Declared = 5
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
    self.status = undefined;
    self.age_lower = undefined;
    self.age_upper = undefined;
    self.approval_date_ms = undefined;
    self.install_id = undefined;
    self.error_code = undefined;
    self.error_message = undefined;

}

// #####################################################################
// # Codecs
// #####################################################################

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

        // field: status, type: enum PlayAgeSignalsVerificationStatus

        if (!is_numeric(self.status)) show_error($"{_where} :: self.status expected number", true);
        buffer_write(_buffer, buffer_s32, self.status);

        // field: age_lower, type: Int32
        if (!is_numeric(self.age_lower)) show_error($"{_where} :: self.age_lower expected number", true);
        buffer_write(_buffer, buffer_s32, self.age_lower);

        // field: age_upper, type: Int32
        if (!is_numeric(self.age_upper)) show_error($"{_where} :: self.age_upper expected number", true);
        buffer_write(_buffer, buffer_s32, self.age_upper);

        // field: approval_date_ms, type: Float64
        if (!is_numeric(self.approval_date_ms)) show_error($"{_where} :: self.approval_date_ms expected number", true);
        buffer_write(_buffer, buffer_f64, self.approval_date_ms);

        // field: install_id, type: String
        if (!is_string(self.install_id)) show_error($"{_where} :: self.install_id expected string", true);
        buffer_write(_buffer, buffer_u32, string_length(self.install_id));
        buffer_write(_buffer, buffer_string, self.install_id);

        // field: error_code, type: enum PlayAgeSignalsErrorCode

        if (!is_numeric(self.error_code)) show_error($"{_where} :: self.error_code expected number", true);
        buffer_write(_buffer, buffer_s32, self.error_code);

        // field: error_message, type: String
        if (!is_string(self.error_message)) show_error($"{_where} :: self.error_message expected string", true);
        buffer_write(_buffer, buffer_u32, string_length(self.error_message));
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

        // field: status, type: enum PlayAgeSignalsVerificationStatus
        self.status = buffer_read(_buffer, buffer_s32);

        // field: age_lower, type: Int32
        self.age_lower = buffer_read(_buffer, buffer_s32);

        // field: age_upper, type: Int32
        self.age_upper = buffer_read(_buffer, buffer_s32);

        // field: approval_date_ms, type: Float64
        self.approval_date_ms = buffer_read(_buffer, buffer_f64);

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
function play_age_signals_check(_callback)
{
    static __dispatcher = __PlayAgeSignals_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    var _return_value = __play_age_signals_check(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return _return_value;
}

// Skipping function play_age_signals_test_use_fake_manager (no wrapper is required)


/**
 * @param {Enum.PlayAgeSignalsVerificationStatus} _status
 * @param {Real} _age_lower
 * @param {Real} _age_upper
 * @param {Real} _approval_date_ms
 * @param {String} _install_id
 */
function play_age_signals_test_set_result(_status, _age_lower, _age_upper, _approval_date_ms, _install_id)
{
    var __args_buffer = __ext_core_get_args_buffer();

    // param: _status, type: enum PlayAgeSignalsVerificationStatus

    if (!is_numeric(_status)) show_error($"{_GMFUNCTION_} :: _status expected number", true);
    buffer_write(__args_buffer, buffer_s32, _status);

    // param: _age_lower, type: Int32
    if (!is_numeric(_age_lower)) show_error($"{_GMFUNCTION_} :: _age_lower expected number", true);
    buffer_write(__args_buffer, buffer_s32, _age_lower);

    // param: _age_upper, type: Int32
    if (!is_numeric(_age_upper)) show_error($"{_GMFUNCTION_} :: _age_upper expected number", true);
    buffer_write(__args_buffer, buffer_s32, _age_upper);

    // param: _approval_date_ms, type: Float64
    if (!is_numeric(_approval_date_ms)) show_error($"{_GMFUNCTION_} :: _approval_date_ms expected number", true);
    buffer_write(__args_buffer, buffer_f64, _approval_date_ms);

    // param: _install_id, type: String
    if (!is_string(_install_id)) show_error($"{_GMFUNCTION_} :: _install_id expected string", true);
    buffer_write(__args_buffer, buffer_u32, string_length(_install_id));
    buffer_write(__args_buffer, buffer_string, _install_id);

    var _return_value = __play_age_signals_test_set_result(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return _return_value;
}

/**
 * @param {Enum.PlayAgeSignalsErrorCode} _error_code
 */
function play_age_signals_test_set_error(_error_code)
{
    var __args_buffer = __ext_core_get_args_buffer();

    // param: _error_code, type: enum PlayAgeSignalsErrorCode

    if (!is_numeric(_error_code)) show_error($"{_GMFUNCTION_} :: _error_code expected number", true);
    buffer_write(__args_buffer, buffer_s32, _error_code);

    var _return_value = __play_age_signals_test_set_error(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return _return_value;
}

/// @ignore
function __PlayAgeSignals_get_decoders()
{
    static __decoders = [
        __PlayAgeSignalsResult_decode
    ];
    return __decoders;
}
/// @ignore
function __PlayAgeSignals_get_dispatcher()
{
    static __dispatcher = new __GMNativeFunctionDispatcher(__PlayAgeSignals_invocation_handler, __PlayAgeSignals_get_decoders());
    return __dispatcher;
}
