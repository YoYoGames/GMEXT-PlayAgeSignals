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
 * @function_partial play_age_signals_request_access
 * @param {Function} callback
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
 * @function_partial play_age_signals_test_set_access_result
 * @param {Enum.PlayAgeSignalsStatus} status
 * @function_end
 */

/**
 * @function_partial play_age_signals_test_set_result
 * @param {Enum.PlayAgeSignalsAgeRangeSource} age_range_source
 * @param {Real} age_lower
 * @param {Real} age_upper
 * @param {Enum.PlayAgeSignalsSignificantChangeStatus} significant_change_status
 * @param {Real} significant_change_approval_date_ms
 * @param {String} install_id
 * @function_end
 */

/**
 * @function_partial play_age_signals_test_set_error
 * @param {Enum.PlayAgeSignalsErrorCode} error_code
 * @function_end
 */

/**
 * @struct_partial PlayAgeSignalsAccessResult
 * @member {Bool} success
 * @member {Enum.PlayAgeSignalsStatus} status
 * @member {Enum.PlayAgeSignalsErrorCode} error_code
 * @member {String} error_message
 * @struct_end
 */

/**
 * @struct_partial PlayAgeSignalsResult
 * @member {Bool} success
 * @member {Enum.PlayAgeSignalsAgeRangeSource} age_range_source
 * @member {Real} age_lower
 * @member {Real} age_upper
 * @member {Enum.PlayAgeSignalsSignificantChangeStatus} significant_change_status
 * @member {Real} significant_change_approval_date_ms
 * @member {String} install_id
 * @member {Enum.PlayAgeSignalsErrorCode} error_code
 * @member {String} error_message
 * @struct_end
 */

/**
 * @enum_partial PlayAgeSignalsStatus
 * @member None
 * @member Shared
 * @member NotShared
 * @member VerificationRequired
 * @enum_end
 */

/**
 * @enum_partial PlayAgeSignalsAgeRangeSource
 * @member None
 * @member TierA
 * @member TierB
 * @member TierC
 * @member TierD
 * @enum_end
 */

/**
 * @enum_partial PlayAgeSignalsSignificantChangeStatus
 * @member None
 * @member Approved
 * @member Pending
 * @member Declined
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

