// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.records;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.codecs.*;
import ${YYAndroidPackageName}.enums.*;

import java.nio.ByteBuffer;

public record PlayAgeSignalsAccessResult(boolean success, PlayAgeSignalsStatus status, PlayAgeSignalsErrorCode error_code, String error_message) implements GMExtWire.ITypedStruct
{
    public static final int CODEC_ID = 0;
    @Override
    public void encode(GMExtWire.IByteWriter b)
    {
        PlayAgeSignalsAccessResultCodec.write(b, this);
    }
}
