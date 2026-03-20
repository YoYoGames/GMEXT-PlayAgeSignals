/**
 * @module home
 * @title Play Age Signals Extension
 * @desc Welcome to the Play Age Signals extension wiki!
 * 
 * Play Age Signals is a GameMaker extension that integrates the
 * [Google Play Age Signals API](https://developer.android.com/google/play/age-signals/use-age-signals-api).
 * 
 * The API allows the application to retrieve signals about the user's age category and supervision status. This is useful for:
 * 
 * - Compliance with child protection regulations
 * - Restricting features for minors
 * - Enabling parental supervision flows
 * - Adjusting content based on age range
 * 
 * The extension supports:
 * 
 * - Real Play Age Signals API
 * - FakeAgeSignalsManager for testing (see {func.play_age_signals_test_use_fake_manager})
 * 
 * ## Notes
 * 
 * - Age signals may only be available for users in supported
 *   regions.
 * 
 * - Some devices may return `API_NOT_AVAILABLE` if the Play
 *   services version is too old.
 * 
 * Basic example of usage:
 * 
 * ```gml
 * if (play_age_signals_init())
 * {
 *     play_age_signals_check(function(result)
 *     {
 *         if (!result.success)
 *         {
 *             show_debug_message("Error: " + result.error_message);
 *             return;
 *         }
 * 
 *         switch (result.status)
 *         {
 *             case PlayAgeSignalsVerificationStatus.VERIFIED:
 *                 show_debug_message("Adult verified");
 *             break;
 * 
 *             case PlayAgeSignalsVerificationStatus.SUPERVISED:
 *                 show_debug_message("Supervised user");
 *             break;
 *         }
 *     });
 * }
 * ```
 * 
 * @section_func
 * @ref play_age_signals_init
 * @ref play_age_signals_is_available
 * @ref play_age_signals_check
 * @ref play_age_signals_test_use_fake_manager
 * @ref play_age_signals_test_set_result
 * @ref play_age_signals_test_set_error
 * @section_end
 * 
 * @section_struct
 * @ref PlayAgeSignalsResult
 * @section_end
 * 
 * @section_const
 * @ref PlayAgeSignalsVerificationStatus
 * @ref PlayAgeSignalsErrorCode
 * @section_end
 * 
 * @module_end
 */

/**
 * @function play_age_signals_init
 * @desc Initializes the Play Age Signals manager. Returns whether the initialisation was successful.
 * @returns {Bool}
 * @example
 * ```gml
 * if (play_age_signals_init())
 * {
 *     show_debug_message("Age Signals initialized");
 * }
 * ```
 * @func_end
 */

/**
 * @function play_age_signals_is_available
 * @desc Checks if the API manager is available.
 * @returns {Bool}
 * @example
 * ```gml
 * if (play_age_signals_is_available())
 * {
 *     show_debug_message("API available");
 * }
 * ```
 * @func_end
 */

/**
 * @function play_age_signals_check
 * @desc Requests the age signals information. This is an asynchronous call. You must pass a callback function, which receives a ${struct.PlayAgeSignalsResult} struct when it is called.
 * @param {Function} callback
 * 
 * @event callback
 * @member {Struct.PlayAgeSignalsResult} result The result fo the requested check.
 * @event_end
 * 
 * @example
 * ```gml
 * play_age_signals_check(function(result)
 * {
 *     if (!result.success)
 *     {
 *         show_debug_message("Age Signals error: " + string(result.error_code));
 *         return;
 *     }
 *
 *     show_debug_message("Status: " + string(result.status));
 *     show_debug_message("Age lower: " + string(result.age_lower));
 *     show_debug_message("Age upper: " + string(result.age_upper));
 * });
 * 
 * /// Example result (success):
 * {
 *     success: true,
 *     status: PlayAgeSignalsVerificationStatus.VERIFIED,
 *     age_lower: 18,
 *     age_upper: 120,
 *     approval_date_ms: -1,
 *     install_id: "abc123",
 *     error_code: PlayAgeSignalsErrorCode.NO_ERROR,
 *     error_message: ""
 * }
 * 
 * /// Example result (failure):
 * {
 *     success: false,
 *     status: PlayAgeSignalsVerificationStatus.None,
 *     age_lower: -1,
 *     age_upper: -1,
 *     approval_date_ms: -1,
 *     install_id: "",
 *     error_code: PlayAgeSignalsErrorCode.API_NOT_AVAILABLE,
 *     error_message: "Age Signals API not available"
 * }
 * ```
 * @func_end
 */

/**
 * @function play_age_signals_test_use_fake_manager
 * @desc Enables or disables the FakeAgeSignalsManager module. This is used for testing the signals API without having to use a real production environment.
 * @param {Bool} enable
 * @example
 * ```gml
 * play_age_signals_test_use_fake_manager(true);
 * ```
 * @func_end
 */

/**
 * @function play_age_signals_test_set_result
 * @desc Sets the next fake test result for success.
 * @param {Enum.PlayAgeSignalsVerificationStatus} status Age verification status.
 * @param {Real} age_lower Lower bound of the user's age range. -1 if unavailable.
 * @param {Real} age_upper Upper bound of the user's age range. -1 if unavailable.
 * @param {Real} approval_date_ms Timestamp (milliseconds since epoch) of the most recent parental approval. -1 if not available.
 * @param {String} install_id Unique identifier associated with the Play Store install.
 * @example
 * ```gml
 * play_age_signals_test_set_result(
 *     PlayAgeSignalsVerificationStatus.VERIFIED,
 *     18,
 *     120,
 *     -1,
 *     "test_install"
 * );
 * ```
 * @func_end
 */

/**
 * @function play_age_signals_test_set_error
 * @desc Forces the next fake request to return an error.
 * @param {Enum.PlayAgeSignalsErrorCode} error_code
 * @example
 * ```gml
 * play_age_signals_test_set_error(
 *     PlayAgeSignalsErrorCode.API_NOT_AVAILABLE
 * );
 * ```
 * @func_end
 */

/**
 * @struct PlayAgeSignalsResult
 * @desc Passed as argument into the callback function that is passed into play_age_signals_check().
 * @member {Bool} success Indicates if the request succeeded.
 * @member {Enum.PlayAgeSignalsVerificationStatus} status Age verification status.
 * @member {Real} age_lower Lower bound of the user's age range. -1 if unavailable.
 * @member {Real} age_upper Upper bound of the user's age range. -1 if unavailable.
 * @member {Real} approval_date_ms Timestamp (milliseconds since epoch) of the most recent parental approval. -1 if not available.
 * @member {String} install_id Unique identifier associated with the Play Store install.
 * @member {Enum.PlayAgeSignalsErrorCode} error_code Error code if the request failed.
 * @member {String} error_message Error description.
 * @struct_end
 */

/**
 * @const PlayAgeSignalsVerificationStatus
 * @member None No status available.
 * @member Verified User age has been verified.
 * @member Supervised User account is supervised.
 * @member SupervisedApprovalPending Parent approval required.
 * @member SupervisedApprovalDenied Parent approval denied.
 * @member Unknown Age status unknown.
 * @member Declared Age was self-declared.
 * @const_end
 */

/**
 * @const PlayAgeSignalsErrorCode
 * @member NoError
 * @member ApiNotAvailable API not supported on device.
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
 * @const_end
 */

