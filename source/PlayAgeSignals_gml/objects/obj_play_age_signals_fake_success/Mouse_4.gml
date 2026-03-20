play_age_signals_test_set_result(
    PlayAgeSignalsVerificationStatus.Supervised,
    13,
    17,
    -1,
    "fake_install_id"
);

play_age_signals_check(function(playAgeSignalsResult)
	{
	    if (!playAgeSignalsResult.success)
	    {
	        show_debug_message("error_code: " + string(playAgeSignalsResult.error_code));
	        show_debug_message("error_message: " + playAgeSignalsResult.error_message);
	        return;
	    }

	    show_debug_message("status: " + string(playAgeSignalsResult.status));
	    show_debug_message("age_lower: " + string(playAgeSignalsResult.age_lower));
	    show_debug_message("age_upper: " + string(playAgeSignalsResult.age_upper));
	    show_debug_message("approval_date_ms: " + string(playAgeSignalsResult.approval_date_ms));
	    show_debug_message("install_id: " + playAgeSignalsResult.install_id);
	});

