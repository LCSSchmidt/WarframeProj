
package DataTracker;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import WorldContents.Alert;
import java.util.concurrent.TimeUnit;

public class AlertDataOrganizer {
    private static long timeAct;
    private static long timeExp;
    private static String rewardItem;
    private static String rewardCredits;
    private static String typeOf;
    private static Integer minLvl;
    private static Integer maxLvl;
    private static String[] allAlerts;
    private static Pattern pattern;
    private static Matcher matcher;
    private static String data;
    private static String[] dataSplited;
    private static int timeLeft;
    
    private static void separateAlerts(String str){
        pattern = Pattern.compile(Settings.Constants.REGEXALERTSDIVISOR);
        allAlerts = pattern.split(str);
        allAlerts[0] = null;
    }
    
    private static String matcherFinder(Matcher matcher){
        String dataMat = "";
        while (matcher.find()) {            
            if(matcher.group().length() != 0 && dataMat.equalsIgnoreCase("")){
                dataMat = matcher.group();
            }
        }
        return dataMat;
    }
        
    private static Long seekInitTime(String alert){
        pattern = Pattern.compile(Settings.Constants.REGEXINITTIME);
        matcher = pattern.matcher(alert);
        data = matcherFinder(matcher);
        return Long.parseLong(data);
    }
    
    private static Long seekExpTime(String alert){
        pattern = Pattern.compile(Settings.Constants.REGEXEXPTIME);
        matcher = pattern.matcher(alert);
        data = matcherFinder(matcher);
        dataSplited = data.split("\"");
        return Long.parseLong(dataSplited[6]);
    }
    
    private static String seekTypeOf(String alert){
        pattern = Pattern.compile(Settings.Constants.REGEXTYPEOF);
        matcher = pattern.matcher(alert);
        data = matcherFinder(matcher);
        dataSplited = data.split("MT_");
        return (dataSplited[1].replace("_", " "));
    }
    
    private static Integer seekLvl(String alert, String p){
        pattern = Pattern.compile(p);
        matcher = pattern.matcher(alert);
        data = matcherFinder(matcher);
        dataSplited = data.split(":");
        return (Integer)Integer.parseInt(dataSplited[1]);
    }
    
    private static void seekRewards(String alert){
        String content = "";
        rewardItem = "";
        pattern = Pattern.compile(Settings.Constants.REGEXREWARDS);
        matcher = pattern.matcher(alert);
        data = matcherFinder(matcher);
        pattern = Pattern.compile(Settings.Constants.REGEXREWARDCREDITS);
        matcher = pattern.matcher(data);
        content = matcherFinder(matcher);
        dataSplited = content.split(":");
        rewardCredits = dataSplited[1];
        pattern = Pattern.compile(Settings.Constants.REGEXREWARDITEM);
        matcher = pattern.matcher(data);
        while (matcher.find()) {            
            if(matcher.group().length() != 0){
                rewardItem = matcher.group();
            }
        }
        rewardItem = rewardItem.replaceAll("\"", "");
        rewardItem = rewardItem.replaceAll(",", "");
        rewardItem = rewardItem.replaceAll("}", "");
        rewardItem = rewardItem.replaceAll("]", "");
    }
    
    public static void organizeManager(String str, List alerts){
        separateAlerts(str);
        for(String alert: allAlerts){
            if(alert != null){
            timeAct = seekInitTime(alert);
            timeExp = seekExpTime(alert);
            typeOf = seekTypeOf(alert);
            minLvl = seekLvl(alert, Settings.Constants.REGEXMINLVL);
            maxLvl = seekLvl(alert, Settings.Constants.REGEXMAXLVL);
            seekRewards(alert);
            if(rewardItem.equalsIgnoreCase(""))
                rewardItem = "Não ha itens";
            timeLeft = (int)TimeUnit.MILLISECONDS.toMinutes(timeExp - System.currentTimeMillis());
            if(timeLeft < 0){
                timeLeft = 0;
            }
            alerts.add(new Alert(typeOf, rewardItem, rewardCredits, timeAct, timeExp, minLvl, maxLvl, timeLeft));
            }
        }
    }
}
