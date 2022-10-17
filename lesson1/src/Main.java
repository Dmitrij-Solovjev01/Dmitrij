public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        monk MyFirstMonk = new monk(25);
        AArcher MyFirstAArcher = new AArcher(0);
        System.out.println(MyFirstMonk.getDamageDealt());
        System.out.println(MyFirstAArcher.getDamageDealt());
        while (MyFirstAArcher.getIsLive() && MyFirstMonk.getIsLive()){
            MyFirstAArcher.action(MyFirstMonk);
            MyFirstMonk.action(MyFirstAArcher);
        }
    }
}



//Monk
//Archer