public class Enemy{
  
  private int enemyHp;
  private int enemyMaxHp;
  private int enemyDmg;
  private double enemyEva;
  private int enemyAcc;
  
  public Enemy(int eneHp, int eneDmg,double eneEva, int eneAcc){
    enemyHp = eneHp;
    enemyMaxHp = enemyHp;
    enemyDmg = eneDmg;
    enemyEva = eneEva;
    enemyAcc = eneAcc;
  }
  
  public int getEnemyHp(){
    return enemyHp;
  }
  public int getEnemyMaxHp(){
    return enemyMaxHp;
  }
  public int getEnemyDmg(){
    return enemyDmg;
  }
  public double getEnemyEva(){
    return enemyEva;
  }
  public int getEnemyAcc(){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
    return enemyAcc;
  }
  
  public void setEnemyHp(int enemyHpAdd){
    enemyHp = enemyHpAdd;
  }
  public void setEnemyMaxHp(int enemyMaxHpAdd){
    enemyMaxHp = enemyMaxHpAdd;
  }
  public void setEnemyDmg(int enemyDmgAdd){
    enemyDmg = enemyDmgAdd;
  }
  public void setEnemyEva(double enemyEvaAdd){
    enemyEva = enemyEvaAdd;
  }
  public void setEnemyAcc(int enemyAccAdd){
    enemyAcc = enemyAccAdd;
  }
}
