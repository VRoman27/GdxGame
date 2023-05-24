package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameOOP.Main;
import com.mygdx.game.GameOOP.Units.*;
import sun.jvm.hotspot.gc.shared.Space;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background, crossbowman, monk, peasant, sniper, spearman, thief, wizard;
	Music music;

	Main game;
	
	@Override
	public void create () {

		game = new Main();
		

		batch = new SpriteBatch();
		background = new Texture("Background/" + Backgrounds.values()[new Random().nextInt(Backgrounds.values().length)] + ".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("Music/Battle Theme " + (new Random().nextInt(3) + 1) + ".mp3" ));
		music.setVolume(0.1f);
		music.setLooping(true);
		music.play();

		crossbowman = new Texture("Sprites/Crossbowman.png");
		monk = new Texture("Sprites/Monk.png");
		peasant = new Texture("Sprites/Peasant.png");
		sniper = new Texture("Sprites/Sniper.png");
		spearman = new Texture("Sprites/Spearman.png");
		thief = new Texture("Sprites/Thief.png");
		wizard = new Texture("Sprites/Wizard.png");
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		int dx = Gdx.graphics.getWidth()/12;
		int dy = Gdx.graphics.getHeight()/13;

		for (int i = Main.team1.size()-1; i >= 0; i--) {
			if(!Main.team1.get(i).die()) {
				if (Main.team1.get(i) instanceof Crossbowman) {
					batch.draw(crossbowman, Main.team1.get(i).getCoords()[1] * dx, Main.team1.get(i).getCoords()[0] * dy);
				}
				if (Main.team1.get(i) instanceof Peasant) {
					batch.draw(peasant, Main.team1.get(i).getCoords()[1] * dx, Main.team1.get(i).getCoords()[0] * dy);
				}
				if (Main.team1.get(i) instanceof Spearman) {
					batch.draw(spearman, Main.team1.get(i).getCoords()[1] * dx, Main.team1.get(i).getCoords()[0] * dy);
				}
				if (Main.team1.get(i) instanceof Wizard) {
					batch.draw(wizard, Main.team1.get(i).getCoords()[1] * dx, Main.team1.get(i).getCoords()[0] * dy);
				}
			}
		}

		for (int i = Main.team2.size()-1; i >= 0; i--) {
			if(!Main.team2.get(i).die()) {
				if (Main.team2.get(i) instanceof Monk) {
					batch.draw(monk, Main.team2.get(i).getCoords()[1] * dx + monk.getWidth(),
							Main.team2.get(i).getCoords()[0] * dy, -monk.getWidth(), monk.getHeight());
				}
				if (Main.team2.get(i) instanceof Peasant) {
					batch.draw(peasant, Main.team2.get(i).getCoords()[1] * dx + peasant.getWidth(),
							Main.team2.get(i).getCoords()[0] * dy, -peasant.getWidth(), peasant.getHeight());
				}
				if (Main.team2.get(i) instanceof Sniper) {
					batch.draw(sniper, Main.team2.get(i).getCoords()[1] * dx + sniper.getWidth(),
							Main.team2.get(i).getCoords()[0] * dy, -sniper.getWidth(), sniper.getHeight());
				}
				if (Main.team2.get(i) instanceof Thief) {
					batch.draw(thief, Main.team2.get(i).getCoords()[1] * dx + thief.getWidth(),
							Main.team2.get(i).getCoords()[0] * dy, -thief.getWidth(), thief.getHeight());
				}
			}
		}

		batch.end();
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			game.step();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
