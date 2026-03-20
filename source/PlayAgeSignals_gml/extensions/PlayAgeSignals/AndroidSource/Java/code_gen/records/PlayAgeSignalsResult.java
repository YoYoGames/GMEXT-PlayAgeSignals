// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.records;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.codecs.*;
import ${YYAndroidPackageName}.enums.*;

import java.nio.ByteBuffer;

public record PlayAgeSignalsResult(boolean success, PlayAgeSignalsVerificationStatus status, int age_lower, int age_upper, double approval_date_ms, String install_id, PlayAgeSignalsErrorCode error_code, String error_message) implements GMExtWire.ITypedStruct
{
    public static final int CODEC_ID = 0;
    @Override
    public void encode(ByteBuffer b)
    {
        PlayAgeSignalsResultCodec.write(b, this);
    }
}
