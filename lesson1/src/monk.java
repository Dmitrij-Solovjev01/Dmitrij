public class monk extends AEntity{
    public monk(int _coordinateX){
        coordinateX = _coordinateX;
        attackRange = 12;
        damageDealt = 12 + Math.toIntExact(Math.round(Math.random()*2));
        HP = 30;
        speed = 5;
        protection = 7;

    }
    @Override
    public void takeDamageWithHonor(int damage){
        System.out.print("Сейчас будут бить монаха:  ");
        System.out.print(HP);
        super.takeDamageWithHonor(damage);
        System.out.print(" -> ");
        System.out.print(HP);
        System.out.println();
    }
    @Override
    public void move(AEntity entity){
        System.out.print("Сейчас будет идти монах:  ");
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
            if(HP <= 15) {
                System.out.println ("Режим истерии активирован, урон: ");
                int hysterics = Math.toIntExact(Math.round(Math.random()*damageDealt));
                System.out.println(hysterics);
                entity.takeDamageWithHonor(hysterics);
            } else {
                System.out.println("<-------(ПРОВАЛ!!!)--------->");
                attack(entity);
                System.out.println("<--------------------------->");
            }
        }
    }
}
