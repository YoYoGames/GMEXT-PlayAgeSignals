// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.codecs;

import java.nio.ByteBuffer;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public final class PlayAgeSignalsAccessResultCodec {
    private PlayAgeSignalsAccessResultCodec()
    {
    }
    public static PlayAgeSignalsAccessResult read(ByteBuffer b)
    {
        boolean success = GMExtWire.readBool(b);

        PlayAgeSignalsStatus status = PlayAgeSignalsStatus.from(GMExtWire.readI32(b));

        PlayAgeSignalsErrorCode error_code = PlayAgeSignalsErrorCode.from(GMExtWire.readI32(b));

        String error_message = GMExtWire.readString(b);

        return new PlayAgeSignalsAccessResult(success, status, error_code, error_message);
    }

    public static void write(GMExtWire.IByteWriter b, PlayAgeSignalsAccessResult obj)
    {
        GMExtWire.writeBool(b, obj.success());

        GMExtWire.writeI32(b, obj.status().value());

        GMExtWire.writeI32(b, obj.error_code().value());

        GMExtWire.writeString(b, obj.error_message());

    }
}