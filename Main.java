import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    String[][] tower = {{"", "", "Start", "Fight1", "Shop", "",}, {"", "", "Fight2", "Fight1", "", "",}, {"", "", "Fight1", "Fight2", "Fight3", "",}, { "", "Fight4", "Fight3", "Fight2", "Fight1", "",}, {"Fight1", "Fight2", "Fight3", "Fight4", "Boss", "AscShop",}, {"", "", "Rebirth", "", "", "",}};
    Weapon currentWeapon = null;
    String curWeapon;
    Armor currentArmor = null;
    String curArmor;
    String action;
    boolean isGetCoin = true;
    int wallet = 0;
    boolean isDefend = false;
    int Fight1Count = 0;
    int Fight2Count = 0;
    int Fight3Count = 0;
    int Fight4Count = 0;
    Scanner scan = new Scanner(System.in);
    for(int i = 0; i < tower.length; i++){
      if(i % 2 == 0){
        for(int j = 0; j < tower.length; j++){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
          if(tower[i][j].equals("Start")){
            Weapon bSword = new Weapon(4, 0.1, 2, 10);
            Weapon bShield = new Weapon(2, 0.5, 1.5, 15);
            Weapon bBow = new Weapon(6, 0.18, 1, 6);
            System.out.println("Choose Starting Weapon:\n Basic Sword (Strength: 4, Evasive: 10%, Durability: 10)\n Basic Shield (Strength: 2, Evasive: 50%, Durability: 15)\n Basic Bow (Strength: 6, Evasive: 18%, Durability: 6)");
            while(currentWeapon == null){
              curWeapon = scan.nextLine();
              if(curWeapon.equals("Basic Sword")){
                currentWeapon = bSword;
              }
              else if(curWeapon.equals("Basic Shield")){
                currentWeapon = bShield;
              }
              else if(curWeapon.equals("Basic Bow")){
                currentWeapon = bBow;
              }
              else{
                System.out.println(" Invalid Choice Selected, Try Again.");
              }
            }
            Armor iron = new Armor(20, 15);
            Armor chain = new Armor(15, 20);
            System.out.println("Choose Starting Armor Set:\n Iron Armor (Health: 20, Durability: 15)\n Chainmail Armor (Health: 15, Durability: 25)");
            while(currentArmor == null){
              curArmor = scan.nextLine();
              if(curArmor.equals("Iron Armor")){
                currentArmor = iron;
              }
              else if(curArmor.equals("Chainmail Armor")){  // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
                currentArmor = chain;
              }
              else{
                System.out.println(" Invalid Choice Selected, Try Again.");
              }
            }
          }
          if(tower[i][j].equals("Fight1")){
            currentArmor.heal();
            currentArmor.heal();
            currentArmor.heal();
            currentArmor.heal();
            currentArmor.heal();
            if(currentArmor.getHp() <= 0){
              System.out.println("Death.");
              System.exit(0);
            }
            if(Fight1Count == 0){
              Enemy zombie = new Enemy(10, 3, 0.1, 1);
              while(zombie.getEnemyHp() > 0){
                System.out.println("\nA Zombie Stands Before You, What Shall You Do?\n Attack\n Defend\n Heal\n Run");
                action = scan.nextLine();
                if(action.equals("Attack")){
                  System.out.println(currentWeapon.attack(zombie));
                }
                else if(action.equals("Defend")){
                  isDefend = true;
                }
                else if(action.equals("Heal")){
                  System.out.println(currentArmor.heal());
                }
                else if(action.equals("Run")){
                  System.out.println(currentWeapon.run(isGetCoin, zombie));
                  Fight1Count++;
                  break;
                }
                else{
                  System.out.println("\nInvalid Choice Selected, Try Again.");
                }
                if(zombie.getEnemyHp() <= 0){
                  System.out.println(currentWeapon.battleWon(wallet, (zombie.getEnemyMaxHp() * (Fight1Count + 1))));
                  Fight1Count++;
                  break;
                }
                System.out.println(currentArmor.damage(zombie, currentWeapon, isDefend));
                isDefend = false;
                if(currentArmor.getHp() <= 0){
                  System.out.println("Death.");
                  System.exit(0);
                }
              }
            }
            else if(Fight1Count == 1){ // LOG IN NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW
              Enemy sBZombie = new Enemy(25, 5, 0.05, 1);
              while(sBZombie.getEnemyHp() > 0){
                System.out.println("\nA Slightly Bigger Zombie Stands Before You, What Shall You Do?\n Attack\n Defend\n Heal\n Run");
                action = scan.nextLine();
                if(action.equals("Attack")){
                  System.out.println(currentWeapon.attack(sBZombie));
                }
                else if(action.equals("Defend")){
                  isDefend = true;
                }
                else if(action.equals("Heal")){
                  System.out.println(currentArmor.heal());
                }
                else if(action.equals("Run")){
                  System.out.println(currentWeapon.run(isGetCoin, sBZombie));
                  Fight1Count++;
                  break;
                }
                else{
                  System.out.println("\nInvalid Choice Selected, Try Again.");
                }
                if(sBZombie.getEnemyHp() <= 0){
                  System.out.println(currentWeapon.battleWon(wallet, (sBZombie.getEnemyMaxHp() * (Fight1Count + 1))));
                  Fight1Count++;
                  break;
                }
                System.out.println(currentArmor.damage(sBZombie, currentWeapon, isDefend));
                isDefend = false;
                if(currentArmor.getHp() <= 0){
                  System.out.println("Death.");
                  System.exit(0);
                }
              }
            }
            else if(Fight1Count == 2){
              Enemy mBZombie = new Enemy(40, 7, 0.04, 1);
              while(mBZombie.getEnemyHp() > 0){
                System.out.println("\nA Moderately Bigger Zombie Stands Before You, What Shall You Do?\n Attack\n Defend\n Heal\n Run");
                action = scan.nextLine();
                if(action.equals("Attack")){
                  System.out.println(currentWeapon.attack(mBZombie));
                }
                else if(action.equals("Defend")){
                  isDefend = true;
                }
                else if(action.equals("Heal")){
                  System.out.println(currentArmor.heal());
                }
                else if(action.equals("Run")){
                  System.out.println(currentWeapon.run(isGetCoin, mBZombie));
                  Fight1Count++;
                  break;
                }
                else{
                  System.out.println("\nInvalid Choice Selected, Try Again.");
                }
                if(mBZombie.getEnemyHp() <= 0){
                  System.out.println(currentWeapon.battleWon(wallet, (mBZombie.getEnemyMaxHp() * (Fight1Count + 1))));
                  Fight1Count++;
                  break;
                }
                System.out.println(currentArmor.damage(mBZombie, currentWeapon, isDefend));
                isDefend = false;
                if(currentArmor.getHp() <= 0){
                  System.out.println("Death.");
                  System.exit(0);
                }
              }
            }
            else if(Fight1Count == 3){
              Enemy sBZombie = new Enemy (60, 10, 0.02, 2);
              while(sBZombie.getEnemyHp() > 0){
                System.out.println("\nA Sizeably Bigger Zombie Stands Before You, What Shall You Do?\n Attack\n Defend\n Heal\n Run");
                action = scan.nextLine();
                if(action.equals("Attack")){
                  System.out.println(currentWeapon.attack(sBZombie));
                }
                else if(action.equals("Defend")){
                  isDefend = true;
                }
                else if(action.equals("Heal")){
                  System.out.println(currentArmor.heal());
                }
                else if(action.equals("Run")){
                  System.out.println(currentWeapon.run(isGetCoin, sBZombie));
                  Fight1Count++;
                  break;
                }
                else{
                  System.out.println("\nInvalid Choice Selected, Try Again.");
                }
                if(sBZombie.getEnemyHp() <= 0){
                  System.out.println(currentWeapon.battleWon(wallet, (sBZombie.getEnemyMaxHp() * (Fight1Count + 1))));
                  Fight1Count++;
                  break;
                }
                System.out.println(currentArmor.damage(sBZombie, currentWeapon, isDefend));
                isDefend = false;
                if(currentArmor.getHp() <= 0){
                  System.out.println("Death.");
                  System.exit(0);
                }
              }
            }
            else if(Fight1Count == 4){
              Enemy gZombie = new Enemy (100, 15, 0.01, 2);
              while(gZombie.getEnemyHp() > 0){
                System.out.println("\nA Gargantuan Zombie Stands Before You, What Shall You Do?\n Attack\n Defend\n Heal\n Run");
                action = scan.nextLine();
                if(action.equals("Attack")){
                  System.out.println(currentWeapon.attack(gZombie));
                }
                else if(action.equals("Defend")){
                  isDefend = true;
                }
                else if(action.equals("Heal")){
                  System.out.println(currentArmor.heal());
                }
                else if(action.equals("Run")){
                  System.out.println(currentWeapon.run(isGetCoin, gZombie));
                  Fight1Count++;
                  break;
                }
                else{
                  System.out.println("\nInvalid Choice Selected, Try Again.");
                }
                if(gZombie.getEnemyHp() <= 0){
                  System.out.println(currentWeapon.battleWon(wallet, (gZombie.getEnemyMaxHp() * (Fight1Count + 1))));
                  Fight1Count++;
                  break;
                }
                System.out.println(currentArmor.damage(gZombie, currentWeapon, isDefend));
                isDefend = false;
                if(currentArmor.getHp() <= 0){
                  System.out.println("Death.");
                  System.exit(0);
                }
              }
            }
            else if(Fight1Count == 5){
              Enemy mZombie = new Enemy (150, 20, 0.01, 2);
              while(mZombie.getEnemyHp() > 0){
                System.out.println("\nA Mega-Zombie Stands Before You, What Shall You Do?\n Attack\n Defend\n Heal\n Run");
                action = scan.nextLine();
                if(action.equals("Attack")){
                  System.out.println(currentWeapon.attack(mZombie));
                }
                else if(action.equals("Defend")){
                  isDefend = true;
                }
                else if(action.equals("Heal")){
                  System.out.println(currentArmor.heal());
                }
                else if(action.equals("Run")){
                  System.out.println(currentWeapon.run(isGetCoin, mZombie));
                  Fight1Count++;
                  break;
                }
                else{
                  System.out.println("\nInvalid Choice Selected, Try Again.");
                }
                if(mZombie.getEnemyHp() <= 0){
                  System.out.println(currentWeapon.battleWon(wallet, (mZombie.getEnemyMaxHp() * (Fight1Count + 1))));
                  Fight1Count++;
                  break;
                }
                System.out.println(currentArmor.damage(mZombie, currentWeapon, isDefend));
                isDefend = false;
                if(currentArmor.getHp() <= 0){
                  System.out.println("Death.");
                  System.exit(0);
                }
              }
            }
            else{
              System.out.println("If you see this in the console, it means I really suck at coding");
            }
          }
          if(tower[i][j].equals("Shop")){
            if(currentArmor.getHp() <= 0){
                System.out.println("Death.");
                System.exit(0);
            }
            Weapon dSword = new Weapon(7, 0.12, 2, 12);
            Weapon dShield = new Weapon(3, 0.6, 1.5, 23);
            Weapon dBow = new Weapon(9, 0.2, 1, 9);
            Armor rIron = new Armor(35, 20);
            System.out.println("\nYou Encounter A Shop Without A Shopkeeper, There Are Various Items For Sale At A 'Conveniently Low' Price: \n Decent Sword (Strength: 7, Evasive: 12%, Durability: 12)\n Decent Shield (Strength: 3, Evasive: 60%, Durability: 23)\n Decent Bow(Strength: 9, Evasive: 20%, Durability: 9)\nYou Decide To 'Purchase' One Weapon First Before The Shopkeeper Returns.");
            while(currentWeapon != dSword && currentWeapon != dShield && currentWeapon != dBow){
              curWeapon = scan.nextLine();
              if(curWeapon.equals("Decent Sword")){
                currentWeapon = dSword;
              }
              else if(curWeapon.equals("Decent Shield")){
                currentWeapon = dShield;
              }
              else if(curWeapon.equals("Decent Bow")){
                currentWeapon = dBow;
              }
              else{
                System.out.println(" Invalid Choice Selected, Try Again.");
              }
            }
            System.out.println("With Little Time To Spare Before The Shopkeeper Returns, You Grab The Reinforced Iron Armor (Health: 35, Durability: 20) On Your Way Out, The Shopkeeper Never Knew What Hit Him.");
            currentArmor = rIron;
          }
        }
      }  
      else{
        for(int k = tower.length - 1; k >= 0; k--){
          
        }
      }
    }
  }
}
