package com.mcelrea;

/*
 * If you are using Intellij idea, this might help:
 *    Settings -> Build, Execution, Deployment ->
 *                Gradle ->
 *                Build and run using: IntelliJ IDEA
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont defaultFont;
	public static String winnerText = "";
	Animal x;
	public final static int finishX = 920;

	ArrayList<Animal> animals = new ArrayList<>();
	public void addAnimals() {
		animals.add(new Animal(50, 700));
		animals.add(new Hare(50, 400));
		animals.add(new Turtle(50, 100));
	}
	public void letThemAct() {
		for(Animal a: animals) {
			a.act();
			if(a.isFinished() && winnerText.equals("")) {
				System.out.println(a);
				winnerText = a.toString();
			}
		}
	}
	public void drawAnimal() {
		for(Animal a: animals) {
			a.draw(batch);
		}
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		defaultFont = new BitmapFont();
		addAnimals();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		if(winnerText.equals(""))
			letThemAct();
		shapeRenderer.setAutoShapeType(true);
		shapeRenderer.setColor(1, 0, 0, 1);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rect(finishX, 50, 28, 100000000);
		shapeRenderer.end();

		//MUST draw all graphics between begin() and end()

		batch.begin();
		drawAnimal();
		defaultFont.draw(batch, winnerText, 400, 400);
		batch.end();

	}

	@Override
	public void dispose () {
		batch.dispose();
	}

}
