// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum PlayAgeSignalsVerificationStatus
{
    None((int)-1),
    VERIFIED((int)0),
    SUPERVISED((int)1),
    SUPERVISED_APPROVAL_PENDING((int)2),
    SUPERVISED_APPROVAL_DENIED((int)3),
    UNKNOWN((int)4),
    DECLARED((int)5);

    private final int value;
    private PlayAgeSignalsVerificationStatus(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static PlayAgeSignalsVerificationStatus from(int v)
    {
        switch (v)
        {
            case -1:
                return PlayAgeSignalsVerificationStatus.None;
            case 0:
                return PlayAgeSignalsVerificationStatus.VERIFIED;
            case 1:
                return PlayAgeSignalsVerificationStatus.SUPERVISED;
            case 2:
                return PlayAgeSignalsVerificationStatus.SUPERVISED_APPROVAL_PENDING;
            case 3:
                return PlayAgeSignalsVerificationStatus.SUPERVISED_APPROVAL_DENIED;
            case 4:
                return PlayAgeSignalsVerificationStatus.UNKNOWN;
            case 5:
                return PlayAgeSignalsVerificationStatus.DECLARED;
            default:
                throw new IllegalArgumentException("Unknown PlayAgeSignalsVerificationStatus value: " + v);
        }
    }
}