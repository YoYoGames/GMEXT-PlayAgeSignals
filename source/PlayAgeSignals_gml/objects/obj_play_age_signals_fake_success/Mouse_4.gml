// Configure a complete successful fake flow.
play_age_signals_test_use_fake_manager(true);

if (!play_age_signals_init())
{
    show_debug_message("Fake Play Age Signals initialization failed.");
    exit;
}

play_age_signals_test_set_access_result(
    PlayAgeSignalsStatus.Shared
);

play_age_signals_test_set_result(
    PlayAgeSignalsAgeRangeSource.TierB,
    13,
    17,
    PlayAgeSignalsSignificantChangeStatus.None,
    -1,
    "fake_install_id"
);

play_age_signals_request_access(function(access_result)
{
    if (!access_result.success)
    {
        show_debug_message("Fake access request failed");
        show_debug_message("error_code: " + string(access_result.error_code));
        show_debug_message("error_message: " + access_result.error_message);
        return;
    }

    show_debug_message("access_status: " + string(access_result.status));

    if (access_result.status != PlayAgeSignalsStatus.Shared)
    {
        show_debug_message("Expected Shared access status.");
        return;
    }

    play_age_signals_check(function(signals_result)
    {
        if (!signals_result.success)
        {
            show_debug_message("Fake Age Signals check failed");
            show_debug_message("error_code: " + string(signals_result.error_code));
            show_debug_message("error_message: " + signals_result.error_message);
            return;
        }

        show_debug_message("age_range_source: " + string(signals_result.age_range_source));
        show_debug_message("age_lower: " + string(signals_result.age_lower));
        show_debug_message("age_upper: " + string(signals_result.age_upper));
        show_debug_message("significant_change_status: " + string(signals_result.significant_change_status));
        show_debug_message("significant_change_approval_date_ms: " + string(signals_result.significant_change_approval_date_ms));
        show_debug_message("install_id: " + signals_result.install_id);
    });
});
