public class Armor{
  
  private int health;
  private int durability;
  private int maxHealth;
  
  public Armor(int hp, int dura){
    health = hp;
    durability = dura;
    maxHealth = health;
  }
  
  public int getHp(){
    return health;
  }
  public int getDura(){
    return durability;
  }
  
  public void setHp(int hpAdd){
    hpAdd += health;
  }
  public void setDura(int duraAdd){
    duraAdd += durability;
  }
  
  public boolean damageEvade(Weapon evader, Enemy invader){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
    double playerEvaChance = Math.random();
    if(playerEvaChance / invader.getEnemyAcc() < evader.getEvasive()){
      return true;
    }
    else{
      return false;
    }
  }
  
  public String damage(Enemy offender, Weapon defender, boolean isDefending){
    if(damageEvade(defender, offender) == true){
      return "\nEnemy Missed Their Attack.";
    }
    else{
      if(isDefending == true){
        health -= (int) (offender.getEnemyDmg() / 2);
        return "\nYou Were Hit, You Partially Blocked The Damage.\n Enemy Strength: " + offender.getEnemyDmg() + "\n Health Remaining: " + health;
      }
      else{
        health -= offender.getEnemyDmg();
        return "\nYou Were Hit. \n Enemy Strength: " + offender.getEnemyDmg() + "\n Health Remaining: " + health;
      }
    }
  }
  
  public String heal(){
    int previousHealth = health;
    if(health + (int) (maxHealth / 4) >= maxHealth){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
      health = maxHealth;
      return "\nYou Healed To Maximum:\n Previous Health: " + previousHealth + "\n Current Health: " + health;
    }
    else{
      health += (int) (maxHealth / 4);
      return "\nYou Healed A Fourth Of Your Maximum Health:\n Previous Health: " + previousHealth + "\n Current Health: " + health;
    }
  }
}
