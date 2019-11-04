package info.vziks.homework9.units;

public interface RestAble {
    void rest();

    default void escapeBattleField(){
        System.out.println("Юнит сбежал с поля боя");
    }

}
