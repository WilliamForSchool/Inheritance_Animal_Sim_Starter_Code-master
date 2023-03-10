package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hare extends Animal {

    protected boolean isMoving = false;
    protected Texture sleepImage;



    public Hare(int x, int y) {
        super(x, y);
        image = new Texture("hare moving.png");
        sleepImage = new Texture("hare sleeping.png");

    }


    @Override
    public void act() {
        int chance = (int) (1 + Math.random() * 180);
        if(chance < 2) {
            x+=20;
            isMoving = true;
        } else if (chance < 4) {
            x+=5;
            isMoving = true;
        } else {
            isMoving = false;
        }
    }




    public void draw(SpriteBatch batch) {
        if (MyGdxGame.winnerText.equals("")) {
            if (isMoving) {
                batch.draw(image, x, y, 50, 50);
            } else {
                batch.draw(sleepImage, x, y, 50, 50);
            }
        } else {
            batch.draw(dead, x, y, 60, 60);
        }
    }


    @Override
    public String toString() {
        return "Hare";
    }
}

