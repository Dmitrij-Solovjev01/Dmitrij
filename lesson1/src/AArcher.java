public class AArcher extends AEntity {
    public AArcher(int _coordinateX) {
        coordinateX = _coordinateX;
        attackRange = 6;
        damageDealt = 2 + Math.toIntExact(Math.round(Math.random()*1));
        HP = 50;            //10
        speed = 4;
        protection = 3;
    }
    @Override
    public void takeDamageWithHonor(int damage){
        System.out.print("Сейчас будут бить лучника:  ");
        System.out.print(HP);
        super.takeDamageWithHonor(damage);
        System.out.print(" -> ");
        System.out.print(HP);
        System.out.println();
    }
    @Override
    public void move(AEntity entity){
        System.out.print("Сейчас будет идти лучник:  ");
        System.out.print(coordinateX);
        super.move(entity);
        System.out.print(" -> ");
        System.out.print(coordinateX);
        System.out.println();
    }

    @Override
    public void SuperAbilities(AEntity entity){
        if (attackRange < Math.abs(entity.getCoordinateX() - coordinateX)) {
            move(entity);
        } else {
            System.out.println("<-------(Суперспособность)--------->");
            if(HP >= 10) {
                System.out.println("Режим 'Азарт, пятикратная стрела', урон: ");
                System.out.println(damageDealt * 5);
                entity.takeDamageWithHonor(damageDealt * 5);
            } else {
                System.out.println("<-------(ПРОВАЛ!!!)--------->");
                attack(entity);
                System.out.println("<--------------------------->");
            }
        }
    }
}