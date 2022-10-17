public abstract class AEntity {
    protected boolean isLive = true;
    protected int attackRange;

    protected int protection;
    protected int damageDealt;
    protected int HP;
    protected int speed;
//    protected int specialOpportunity;

    protected int currentEnemy;
    protected int coordinateX;

    public AEntity() {

    }

    public void takeDamageWithHonor(int damage) {
        int newDamage = protection - damage;
        if (newDamage<0) HP += newDamage;

        if (HP <= 0) {
            die();
        }
    }
    public boolean getIsLive(){
        return isLive;
    }

    public void move(AEntity entity) {
        int enemyX = entity.getCoordinateX();
        if (enemyX > coordinateX) {
            coordinateX += speed;
        } else {
            coordinateX -= speed;
        }
    }

    public void SuperAbilities(AEntity entity){
        System.out.print("Кормит хлебушком голубей");
    }


    public void die() {
        isLive = false;
        HP = 0;
    }



    public int getCoordinateX() {
        return coordinateX;
    }

    public int getDamageDealt(){
        return damageDealt;
    }

    public void attack(AEntity entity) {
        if (attackRange < Math.abs(entity.getCoordinateX() - coordinateX)) {
            move(entity);
        } else {
            entity.takeDamageWithHonor(damageDealt);
        }
    }
    public void action(AEntity entity){
        if (Math.toIntExact(Math.round(Math.random()*1)) == 1){
            SuperAbilities(entity);
        }
        else{
            attack(entity);
        }
        System.out.println();

    }
}