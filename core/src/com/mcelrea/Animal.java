package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Animal {
    protected int x;
    protected int y;
    protected Texture image = new Texture("animal_foot.png");
    protected Texture dead = new Texture("DEAD.png");


    public Animal (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(SpriteBatch batch) {
        if (MyGdxGame.winnerText.equals("")) {
            batch.draw(image, x, y, 50, 50);
        } else if(x <= 920) {
            batch.draw(dead, x, y, 60, 60);
        }
    }

    public void act() {
        int chance = (int)(1* Math.random() * 100);
        if(chance <= 50) {
            x++;

        } else {
            x--;
            if(x < 0) {
                x = 0;
            }
        }
    }

    public boolean isFinished() {
        return this.x >= MyGdxGame.finishX;
    }

    @Override
    public String toString() {
        return "Animal";
    }

}
