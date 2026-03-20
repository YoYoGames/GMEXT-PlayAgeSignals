// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum PlayAgeSignalsVerificationStatus
{
    None((int)-1),
    Verified((int)0),
    Supervised((int)1),
    SupervisedApprovalPending((int)2),
    SupervisedApprovalDenied((int)3),
    Unknown((int)4),
    Declared((int)5);

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
                return PlayAgeSignalsVerificationStatus.Verified;
            case 1:
                return PlayAgeSignalsVerificationStatus.Supervised;
            case 2:
                return PlayAgeSignalsVerificationStatus.SupervisedApprovalPending;
            case 3:
                return PlayAgeSignalsVerificationStatus.SupervisedApprovalDenied;
            case 4:
                return PlayAgeSignalsVerificationStatus.Unknown;
            case 5:
                return PlayAgeSignalsVerificationStatus.Declared;
            default:
                throw new IllegalArgumentException("Unknown PlayAgeSignalsVerificationStatus value: " + v);
        }
    }
}