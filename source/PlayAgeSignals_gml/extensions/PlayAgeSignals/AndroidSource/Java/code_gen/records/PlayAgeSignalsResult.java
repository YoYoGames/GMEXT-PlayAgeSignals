// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.records;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.codecs.*;
import ${YYAndroidPackageName}.enums.*;

import java.nio.ByteBuffer;

public record PlayAgeSignalsResult(boolean success, PlayAgeSignalsAgeRangeSource age_range_source, int age_lower, int age_upper, PlayAgeSignalsSignificantChangeStatus significant_change_status, double significant_change_approval_date_ms, String install_id, PlayAgeSignalsErrorCode error_code, String error_message) implements GMExtWire.ITypedStruct
{
    public static final int CODEC_ID = 1;
    @Override
    public void encode(GMExtWire.IByteWriter b)
    {
        PlayAgeSignalsResultCodec.write(b, this);
    }
}
