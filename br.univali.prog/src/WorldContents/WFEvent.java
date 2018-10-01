package WorldContents;
public abstract class WFEvent {
    Long timeActivation;
    Long timeExpiry;
    int timeLeft;
    String typeOf;
    
    public WFEvent(Long timeActivation, Long timeExpiry, String typeOf, int timeLeft) {
        this.timeActivation = timeActivation;
        this.timeExpiry = timeExpiry;
        this.typeOf = typeOf;
        this.timeLeft = timeLeft;
    }
    
    public void setTimeLeft(int t){
        this.timeLeft = t;
    }
    
    public abstract int getTimeLeft();
    public abstract String getRewardItem();
    public abstract String getRewardCredits();
    public abstract String getTypeOf();
    public abstract Integer getMinLvl();
    public abstract Integer getMaxLvl();
    public abstract Long getExpTime();
}
    
