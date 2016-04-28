package mydesktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Field extends JPanel {

	// Изображения, используемые в игре
	private Image fon, paluba, ubit, ranen, end1, end2, bomba;
	private Timer tmDraw;
	private int[][] masPlay;

	public void setMasPlay(int[][] masPlay) {
		this.masPlay = masPlay;
	}
	// Координаты курсора мыши

	private int mX, mY;

	/**
	 * Create the panel.
	 */
	public Field(int[][] masPlay) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				mX = e.getX();
				mY = e.getY();

				if ((e.getButton() == 1) && (e.getClickCount() == 1)) {

					// Вычисляем номер строки в массиве
					int i = (mY - 50) / 30;
					// Вычисляем номер элемента в строке в массиве
					int j = (mX - 50) / 30;

					masPlay[i][j] = 1;
				}
			}
		});

		this.masPlay = masPlay;
		try {

			fon = ImageIO.read(new File("img\\fon.png"));

			paluba = ImageIO.read(new File("img\\paluba.png"));

			ranen = ImageIO.read(new File("img\\ranen.png"));

			ubit = ImageIO.read(new File("img\\ubit.png"));

			end1 = ImageIO.read(new File("img\\end1.png"));

			end2 = ImageIO.read(new File("img\\end2.png"));

			bomba = ImageIO.read(new File("img\\bomba.png"));

		} catch (Exception ex) {
			System.err.println("File not found");
		}
		// Создаем, настраиваем и запускаем таймер
		// для отрисовки игрового поля
		tmDraw = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Вызываем перерисовку -paintComponent()
				repaint();
			}
		});
		tmDraw.start();

		// Включаем возможность произвольного размещения
		// элементов интерфейса на панели
		setLayout(null);
	}

	public void paintComponent(Graphics gr) {

		// Очищение игрового поля

		super.paintComponent(gr);

		// Отрисовка фона
		// gr.drawImage(fon, 0, 0, 900, 600, null);

		// Установка шрифта
		gr.setFont(new Font("serif", 3, 40));

		// Установка цвета
		gr.setColor(Color.BLUE);

		// Выведение надписей
		// gr.drawString("Компьютер", 150, 50);
		// gr.drawString("Игрок", 590, 50);

		// Отрисовка игровых полей Компьютера
		// и Игрока на основании массивов
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				// Игровое поле компьютера
				if (masPlay[i][j] != 0) {

					// Если это палуба корабля

					if ((masPlay[i][j] >= 1) && (masPlay[i][j] <= 4)) {

						gr.drawImage(paluba, 50 + j * 30, 50 + i * 30, 30, 30, null);

					}

					// Если это подбитая палуба корабля
					if ((masPlay[i][j] >= 8) && (masPlay[i][j] <= 11)) {
						gr.drawImage(ranen, 50 + j * 30, 50 + i * 30, 30, 30, null);
					}
					// Если это палуба полностью подбитого корабля
					else if (masPlay[i][j] >= 15) {
						gr.drawImage(ubit, 50 + j * 30, 50 + i * 30, 30, 30, null);
					}
					// Если был выстрел
					if (masPlay[i][j] >= 5) {
						gr.drawImage(bomba, 50 + j * 30, 50 + i * 30, 30, 30, null);
					}

				}
			}
		}

		gr.setColor(Color.RED); // Красный цвет

		// // Если курсор мыши внутри игрового поля компьютера
		//
		// if((mX>100)&&(mY>100)&&(mX<400)&&(mY<400))
		//
		// {
		//
		// // Если не конец игры и ход игрока
		//
		// if ((myGame.endg == 0) && (myGame.compHod == false)) {
		//
		// // Вычисляем номер строки в массиве
		//
		// int i = (mY - 100) / 30;
		//
		// // Вычисляем номер элемента в строке в массиве
		//
		// int j = (mX - 100) / 30;
		//
		// // Если ячйека подходит для выстрела
		//
		// if (myGame.masComp[i][j] <= 4)
		//
		// // Рисуем квадрат с заливкой
		//
		// gr.fillRect(100 + j * 30, 100 + i * 30, 30, 30);
		//
		// }
		//
		// }

		// Отрисовка сетки игрового поля из синих линий
		gr.setColor(Color.BLUE);
		for (int i = 0; i <= 10; i++) {
			// Рисование линий сетки игрового поля Компьютера
			gr.drawLine(50 + i * 30, 50, 50 + i * 30, 350);
			gr.drawLine(50, 50 + i * 30, 350, 50 + i * 30);
		}

		// Установка шрифта
		gr.setFont(new Font("serif", 0, 20));

		// Установка цвета
		gr.setColor(Color.RED);

		// Введение цифр и букв слева и сверху от игровых полей
		for (int i = 1; i <= 10; i++) {
			// Вывод цифр
			gr.drawString("" + i, 23, 43 + i * 30);
			// Вывод букв
			gr.drawString("" + (char) ('A' + i - 1), 28 + i * 30, 43);
		}
	}
}
