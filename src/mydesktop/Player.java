package mydesktop;

import java.io.Serializable;

public class Player implements Serializable {

	private int[][] masPlay;
	private int numberPlayer;
	private String name;
	private String password;

	public Player() {
		// Создаем массив 10x10 - игровое поле игрока
		// this.name = name;
		masPlay = new int[10][10];

	}

	public void randomField() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				masPlay[i][j] = (int) (Math.random() * 3);
			}
		}
	}

	public void start() {
		// Очищаем игровое поле игрока и компьютера
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				masPlay[i][j] = 0;
			}
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[][] getMasPlay() {
		return masPlay;
	}

	public void setMasPlay(int[][] masPlay) {
		this.masPlay = masPlay;
	}

	public int getNumberPlayer() {
		return numberPlayer;
	}

	public void setNumberPlayer(int numberPlayer) {
		this.numberPlayer = numberPlayer;
	}

	public void setElementArray(int i, int j, int value) {
		masPlay[i][j] = value;
	}

}
