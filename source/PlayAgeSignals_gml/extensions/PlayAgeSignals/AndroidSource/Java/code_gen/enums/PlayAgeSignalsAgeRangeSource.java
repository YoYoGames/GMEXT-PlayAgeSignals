// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum PlayAgeSignalsAgeRangeSource
{
    None((int)-1),
    TierA((int)0),
    TierB((int)1),
    TierC((int)2),
    TierD((int)3);

    private final int value;
    private PlayAgeSignalsAgeRangeSource(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static PlayAgeSignalsAgeRangeSource from(int v)
    {
        switch (v)
        {
            case -1:
                return PlayAgeSignalsAgeRangeSource.None;
            case 0:
                return PlayAgeSignalsAgeRangeSource.TierA;
            case 1:
                return PlayAgeSignalsAgeRangeSource.TierB;
            case 2:
                return PlayAgeSignalsAgeRangeSource.TierC;
            case 3:
                return PlayAgeSignalsAgeRangeSource.TierD;
            default:
                throw new IllegalArgumentException("Unknown PlayAgeSignalsAgeRangeSource value: " + v);
        }
    }
}