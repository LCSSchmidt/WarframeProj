/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldContents;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stit_
 */
public class Alert extends WFEvent{
    Integer enemyMinLvl;
    Integer enemyMaxLvl;
    String rewardItem;
    String rewardCredit;

    public Alert(String typeOf, String rewardItem, String rewardCredit, Long inittialTime, Long expiryTime, Integer enemyMinLvl, Integer enemyMaxLvl, int timeLeft) {
        
        super(inittialTime, expiryTime, typeOf, timeLeft);
        this.rewardItem = (rewardItem);
        this.rewardCredit = (rewardCredit);
        this.enemyMinLvl = (enemyMinLvl);
        this.enemyMaxLvl = (enemyMaxLvl);
    }

    @Override
    public int getTimeLeft() {
        return super.timeLeft;
    }

    @Override
    public String getRewardItem() {
        return rewardItem;
    }

    @Override
    public String getRewardCredits() {
        return rewardCredit;
    }

    @Override
    public String getTypeOf() {
        return super.typeOf;
    }

    @Override
    public Integer getMinLvl() {
        return enemyMinLvl;
    }

    @Override
    public Integer getMaxLvl() {
        return enemyMaxLvl;
    }

    @Override
    public Long getExpTime() {
        return super.timeExpiry;
    }
  
    
}
