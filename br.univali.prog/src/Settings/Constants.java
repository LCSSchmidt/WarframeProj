package Settings;

public class Constants {

    protected static final String URL = "http://content.warframe.com/dynamic/worldState.php";
    public static final String PATTERNALERTSDIVISOR = "Activation";
    public static final String PATTERNINITTIME = "\\d{13,13}";
    public static final String PATTERNEXPTIME = "Expiry.*?\\d{13,13}";
    public static final String PATTERNTYPEOF = "MT_[A-Z]*[_A-Z]*";
    public static final String PATTERNMINLVL = "minEnemyLevel.*?[\\d]+";
    public static final String PATTERNMAXLVL = "maxEnemyLevel.*?[\\d]+";
    public static final String PATTERNREWARDS = "missionReward.*";
    public static final String PATTERNREWARDITEM = "[A-Za-z0-9][^:,./]*\",\"|[A-Za-z0-9][^:,./]*\"]}";
    public static final String PATTERNREWARDCREDITS = "credits\":\\d+[^,}]*";
}
