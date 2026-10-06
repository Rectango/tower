public class Weapon{
  
  private int strength;
  private double evasive;
  private double accuracy;
  private int vulnerability;
  
  public Weapon(int str, double eva, double acc, int vuln){
    strength = str;
    evasive = eva;
    accuracy = acc;
    vulnerability = vuln;
  }
  
  public int getStrength(){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
    return strength;
  }
  public double getEvasive(){
    return evasive;
  }
  public double getAccuracy(){
    return accuracy;
  }
  public int getVulnerability(){
    return vulnerability;
  }
  
  public void setStrength(int strAdd){
    strength = strAdd;
  }
  public void setEvasive(double evaAdd){
    evasive = evaAdd;
  }
  public void setAccuracy(double accAdd){
    accuracy = accAdd;
  }
  public void setVulnerability(int vulnAdd){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
    vulnerability = vulnAdd;
  }
  
  public int attackDamage(int enemyHealth){
    if(strength > 0){
      return enemyHealth - strength;
    }
    else{
      return 0;
    }
  }
  
  public boolean attackEvade(double enemyEvasion){
    double EvaChance = Math.random();
    if(accuracy == 0){
      if(EvaChance < enemyEvasion){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      if(EvaChance / accuracy < enemyEvasion){
        return true;
      }
      else{
        return false;
      }
    }
  }
  
  public String attack(Enemy victim){
    if(attackEvade(victim.getEnemyEva()) == true){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
      return "Enemy dodged your attack.";
    }
    else{
      int damagedHealth = attackDamage(victim.getEnemyHp());
      victim.setEnemyHp(damagedHealth);
      vulnerability--;
      if(damagedHealth != 0){
        return "Enemy Hit\n Total Attack Damage: " + strength + "\n Durability Remaining: " + vulnerability + "\n Health Remaining: " + (damagedHealth);
      }
      else{
        return "Enemy Slain\n Total Attack Damage: " + strength + "\n Durability Remaining: " + vulnerability;
      }
    }
  }
  
  public String run(boolean ifCoin, Enemy victor){
    ifCoin = false;
    return "Ran Away, Coins For This Battle Were Lost.";
  }
  
  public String battleWon(int coins, int coinsGathered){
    coins = coinsGathered;
    return "\nBattle Won: " + coins + " Coins Gathered.\n";
  }
}
