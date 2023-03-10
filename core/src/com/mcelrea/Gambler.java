package com.mcelrea;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gambler extends Animal{

    protected boolean isMoving = false;
    protected Texture sleepImage;



    public Gambler(int x, int y) {
        super(x, y);
        image = new Texture("gamba_win.png");
        sleepImage = new Texture("gamba_lose.png");

    }


    @Override
    public void act() {

        int chance = (int) (1 + Math.random() * 180);
        if(chance < 2) {
            x+=20;
            isMoving = true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } else if (chance < 4) {
            x+=5;
            isMoving = true;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } else {
            isMoving = false;

    }



    public void draw(SpriteBatch batch) {
        if (MyGdxGame.winnerText.equals("")) {
            if (isMoving) {
                batch.draw(image, x, y, 100, 100);
            } else {
                batch.draw(sleepImage, x, y, 100, 100);
            }
        } else {
            batch.draw(dead, x, y, 60, 60);
        }
    }



}
