// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum PlayAgeSignalsSignificantChangeStatus
{
    None((int)-1),
    Approved((int)0),
    Pending((int)1),
    Declined((int)2);

    private final int value;
    private PlayAgeSignalsSignificantChangeStatus(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static PlayAgeSignalsSignificantChangeStatus from(int v)
    {
        switch (v)
        {
            case -1:
                return PlayAgeSignalsSignificantChangeStatus.None;
            case 0:
                return PlayAgeSignalsSignificantChangeStatus.Approved;
            case 1:
                return PlayAgeSignalsSignificantChangeStatus.Pending;
            case 2:
                return PlayAgeSignalsSignificantChangeStatus.Declined;
            default:
                throw new IllegalArgumentException("Unknown PlayAgeSignalsSignificantChangeStatus value: " + v);
        }
    }
}