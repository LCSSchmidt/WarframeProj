package Settings;

public class Constants {

    protected static final String URL = "http://content.warframe.com/dynamic/worldState.php";
    public static final String REGEXALERTSDIVISOR = "Activation";
    public static final String REGEXINITTIME = "\\d{13,13}";
    public static final String REGEXEXPTIME = "Expiry.*?\\d{13,13}";
    public static final String REGEXTYPEOF = "MT_[A-Z]*[_A-Z]*";
    public static final String REGEXMINLVL = "minEnemyLevel.*?[\\d]+";
    public static final String REGEXMAXLVL = "maxEnemyLevel.*?[\\d]+";
    public static final String REGEXREWARDS = "missionReward.*";
    public static final String REGEXREWARDITEM = "[A-Za-z0-9][^:,./]*\",\"|[A-Za-z0-9][^:,./]*\"]}";
    public static final String REGEXREWARDCREDITS = "credits\":\\d+[^,}]*";
    public static final String REGEXALERTINITINDEX = "Alerts\":[";
    public static final String REGEXALERTFINALINDEX = "}}],\"Sorties";
}
