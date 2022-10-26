package src;

public class Person extends Main{

    int spellState;
    int drownState;
    int hp;
    int magicBall = 0;
    int greenPill = 0;

    public Person(int health, int sState, int dState){

        hp = health;
        spellState = sState;
        drownState = dState;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
