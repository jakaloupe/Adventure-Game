package AdventureGameNew.src;

import src.Main;

public class Person {

    int spellState = 0;
    int drownState = 0;
    int hp = 0;
    int magicBall = 0;
    int greenPill = 0;

    public Person(){
        hp = 10;
    }

    public int getSpellState() {
        return spellState;
    }

    public void setSpellState(int spellState) {
        this.spellState = spellState;
    }

    public int getDrownState() {
        return drownState;
    }

    public void setDrownState(int drownState) {
        this.drownState = drownState;
    }

    public int getMagicBall() {
        return magicBall;
    }

    public void setMagicBall(int magicBall) {
        this.magicBall = magicBall;
    }

    public int getGreenPill() {
        return greenPill;
    }

    public void setGreenPill(int greenPill) {
        this.greenPill = greenPill;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
