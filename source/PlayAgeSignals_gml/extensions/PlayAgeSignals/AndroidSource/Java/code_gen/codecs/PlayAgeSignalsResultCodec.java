// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.codecs;

import java.nio.ByteBuffer;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public final class PlayAgeSignalsResultCodec {
    private PlayAgeSignalsResultCodec()
    {
    }
    public static PlayAgeSignalsResult read(ByteBuffer b)
    {
        boolean success = GMExtWire.readBool(b);

        PlayAgeSignalsAgeRangeSource age_range_source = PlayAgeSignalsAgeRangeSource.from(GMExtWire.readI32(b));

        int age_lower = GMExtWire.readI32(b);

        int age_upper = GMExtWire.readI32(b);

        PlayAgeSignalsSignificantChangeStatus significant_change_status = PlayAgeSignalsSignificantChangeStatus.from(GMExtWire.readI32(b));

        double significant_change_approval_date_ms = GMExtWire.readF64(b);

        String install_id = GMExtWire.readString(b);

        PlayAgeSignalsErrorCode error_code = PlayAgeSignalsErrorCode.from(GMExtWire.readI32(b));

        String error_message = GMExtWire.readString(b);

        return new PlayAgeSignalsResult(success, age_range_source, age_lower, age_upper, significant_change_status, significant_change_approval_date_ms, install_id, error_code, error_message);
    }

    public static void write(GMExtWire.IByteWriter b, PlayAgeSignalsResult obj)
    {
        GMExtWire.writeBool(b, obj.success());

        GMExtWire.writeI32(b, obj.age_range_source().value());

        GMExtWire.writeI32(b, obj.age_lower());

        GMExtWire.writeI32(b, obj.age_upper());

        GMExtWire.writeI32(b, obj.significant_change_status().value());

        GMExtWire.writeF64(b, obj.significant_change_approval_date_ms());

        GMExtWire.writeString(b, obj.install_id());

        GMExtWire.writeI32(b, obj.error_code().value());

        GMExtWire.writeString(b, obj.error_message());

    }
}