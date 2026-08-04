// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum PlayAgeSignalsStatus
{
    None((int)-1),
    Shared((int)0),
    NotShared((int)1),
    VerificationRequired((int)2);

    private final int value;
    private PlayAgeSignalsStatus(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static PlayAgeSignalsStatus from(int v)
    {
        switch (v)
        {
            case -1:
                return PlayAgeSignalsStatus.None;
            case 0:
                return PlayAgeSignalsStatus.Shared;
            case 1:
                return PlayAgeSignalsStatus.NotShared;
            case 2:
                return PlayAgeSignalsStatus.VerificationRequired;
            default:
                throw new IllegalArgumentException("Unknown PlayAgeSignalsStatus value: " + v);
        }
    }
}