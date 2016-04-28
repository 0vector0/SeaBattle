package desktop;

import java.awt.Container;

import javax.swing.JFrame;

public class Okno extends JFrame

{

	// Конструктор класса

	public Okno()

	{

		// Создание объекта панели и подключения ее к окну

		Pole pan = new Pole();

		Container cont = getContentPane();

		cont.add(pan);

		// Заголовок окна

		setTitle("Игра \"Морской бой\"");

		// Границы окна: расположение и размеры

		setBounds(0, 0, 900, 600);

		// Операция при закрытии окна - завершение приложения

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Запрет изменения размеров окна

		setResizable(false);

		// Отображение (показ) окна

		setVisible(true);

	}

}