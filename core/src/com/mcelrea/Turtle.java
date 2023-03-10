package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;

public class Turtle extends Animal {

    public Turtle(int x, int y) {
        super(x, y);
        image = new Texture("turtle.png");
    }


    @Override
    public void act() {
        int chance = (int) (1 + Math.random() * 180);
        if(chance < 10) {
            x += 10;
        } else if(chance < 30) {
            x++;
        } else if(chance < 50) {
            x--;
        }
    }

}
