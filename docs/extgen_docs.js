/**
 * @function_partial play_age_signals_init
 * @returns {Bool} 
 * @function_end 
 */

/**
 * @function_partial play_age_signals_is_available
 * @returns {Bool} 
 * @function_end 
 */

/**
 * @function_partial play_age_signals_check
 * @param {Function} callback
 * @function_end 
 */

/**
 * @function_partial play_age_signals_test_use_fake_manager
 * @param {Bool} enable
 * @function_end 
 */

/**
 * @function_partial play_age_signals_test_set_result
 * @param {Enum.PlayAgeSignalsVerificationStatus} status
 * @param {Real} age_lower
 * @param {Real} age_upper
 * @param {Real} approval_date_ms
 * @param {String} install_id
 * @function_end 
 */

/**
 * @function_partial play_age_signals_test_set_error
 * @param {Enum.PlayAgeSignalsErrorCode} error_code
 * @function_end 
 */

/**
 * @struct_partial PlayAgeSignalsResult
 * @member {Bool} success
 * @member {Enum.PlayAgeSignalsVerificationStatus} status
 * @member {Real} age_lower
 * @member {Real} age_upper
 * @member {Real} approval_date_ms
 * @member {String} install_id
 * @member {Enum.PlayAgeSignalsErrorCode} error_code
 * @member {String} error_message
 * @struct_end 
 */

/**
 * @enum_partial PlayAgeSignalsVerificationStatus
 * @member None
 * @member VERIFIED
 * @member SUPERVISED
 * @member SUPERVISED_APPROVAL_PENDING
 * @member SUPERVISED_APPROVAL_DENIED
 * @member UNKNOWN
 * @member DECLARED
 * @enum_end 
 */

/**
 * @enum_partial PlayAgeSignalsErrorCode
 * @member NO_ERROR
 * @member API_NOT_AVAILABLE
 * @member PLAY_STORE_NOT_FOUND
 * @member NETWORK_ERROR
 * @member PLAY_SERVICES_NOT_FOUND
 * @member CANNOT_BIND_TO_SERVICE
 * @member PLAY_STORE_VERSION_OUTDATED
 * @member PLAY_SERVICES_VERSION_OUTDATED
 * @member CLIENT_TRANSIENT_ERROR
 * @member APP_NOT_OWNED
 * @member SDK_VERSION_OUTDATED
 * @member INTERNAL_ERROR
 * @enum_end 
 */

/**
 * @const_partial macros
 * @const_end 
 */

