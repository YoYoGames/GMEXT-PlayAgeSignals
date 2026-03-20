// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum PlayAgeSignalsErrorCode
{
    NoError((int)0),
    ApiNotAvailable((int)-1),
    PlayStoreNotFound((int)-2),
    NetworkError((int)-3),
    PlayServicesNotFound((int)-4),
    CannotBindToService((int)-5),
    PlayStoreVersionOutdated((int)-6),
    PlayServicesVersionOutdated((int)-7),
    ClientTransientError((int)-8),
    AppNotOwned((int)-9),
    SdkVersionOutdated((int)-10),
    InternalError((int)-100);

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
                return PlayAgeSignalsErrorCode.NoError;
            case -1:
                return PlayAgeSignalsErrorCode.ApiNotAvailable;
            case -2:
                return PlayAgeSignalsErrorCode.PlayStoreNotFound;
            case -3:
                return PlayAgeSignalsErrorCode.NetworkError;
            case -4:
                return PlayAgeSignalsErrorCode.PlayServicesNotFound;
            case -5:
                return PlayAgeSignalsErrorCode.CannotBindToService;
            case -6:
                return PlayAgeSignalsErrorCode.PlayStoreVersionOutdated;
            case -7:
                return PlayAgeSignalsErrorCode.PlayServicesVersionOutdated;
            case -8:
                return PlayAgeSignalsErrorCode.ClientTransientError;
            case -9:
                return PlayAgeSignalsErrorCode.AppNotOwned;
            case -10:
                return PlayAgeSignalsErrorCode.SdkVersionOutdated;
            case -100:
                return PlayAgeSignalsErrorCode.InternalError;
            default:
                throw new IllegalArgumentException("Unknown PlayAgeSignalsErrorCode value: " + v);
        }
    }
}