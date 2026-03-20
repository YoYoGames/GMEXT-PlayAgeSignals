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
 * @member Verified
 * @member Supervised
 * @member SupervisedApprovalPending
 * @member SupervisedApprovalDenied
 * @member Unknown
 * @member Declared
 * @enum_end 
 */

/**
 * @enum_partial PlayAgeSignalsErrorCode
 * @member NoError
 * @member ApiNotAvailable
 * @member PlayStoreNotFound
 * @member NetworkError
 * @member PlayServicesNotFound
 * @member CannotBindToService
 * @member PlayStoreVersionOutdated
 * @member PlayServicesVersionOutdated
 * @member ClientTransientError
 * @member AppNotOwned
 * @member SdkVersionOutdated
 * @member InternalError
 * @enum_end 
 */

/**
 * @const_partial macros
 * @const_end 
 */

