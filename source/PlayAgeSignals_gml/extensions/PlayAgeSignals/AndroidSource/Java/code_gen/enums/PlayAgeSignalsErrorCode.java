// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum PlayAgeSignalsErrorCode
{
    NO_ERROR((int)0),
    API_NOT_AVAILABLE((int)-1),
    PLAY_STORE_NOT_FOUND((int)-2),
    NETWORK_ERROR((int)-3),
    PLAY_SERVICES_NOT_FOUND((int)-4),
    CANNOT_BIND_TO_SERVICE((int)-5),
    PLAY_STORE_VERSION_OUTDATED((int)-6),
    PLAY_SERVICES_VERSION_OUTDATED((int)-7),
    CLIENT_TRANSIENT_ERROR((int)-8),
    APP_NOT_OWNED((int)-9),
    SDK_VERSION_OUTDATED((int)-10),
    INTERNAL_ERROR((int)-100);

    private final int value;
    private PlayAgeSignalsErrorCode(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static PlayAgeSignalsErrorCode from(int v)
    {
        switch (v)
        {
            case 0:
                return PlayAgeSignalsErrorCode.NO_ERROR;
            case -1:
                return PlayAgeSignalsErrorCode.API_NOT_AVAILABLE;
            case -2:
                return PlayAgeSignalsErrorCode.PLAY_STORE_NOT_FOUND;
            case -3:
                return PlayAgeSignalsErrorCode.NETWORK_ERROR;
            case -4:
                return PlayAgeSignalsErrorCode.PLAY_SERVICES_NOT_FOUND;
            case -5:
                return PlayAgeSignalsErrorCode.CANNOT_BIND_TO_SERVICE;
            case -6:
                return PlayAgeSignalsErrorCode.PLAY_STORE_VERSION_OUTDATED;
            case -7:
                return PlayAgeSignalsErrorCode.PLAY_SERVICES_VERSION_OUTDATED;
            case -8:
                return PlayAgeSignalsErrorCode.CLIENT_TRANSIENT_ERROR;
            case -9:
                return PlayAgeSignalsErrorCode.APP_NOT_OWNED;
            case -10:
                return PlayAgeSignalsErrorCode.SDK_VERSION_OUTDATED;
            case -100:
                return PlayAgeSignalsErrorCode.INTERNAL_ERROR;
            default:
                throw new IllegalArgumentException("Unknown PlayAgeSignalsErrorCode value: " + v);
        }
    }
}