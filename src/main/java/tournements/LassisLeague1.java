package tournements;

import core.Game;
import core.Player;
import functions.Excel;
import functions.IOFiles;

import java.util.ArrayList;

public class LassisLeague1 {

	public static void main(String[] args) {
		IOFiles io = new IOFiles("lassisLeaguePlayers");
		String tn = "LassisLeague #1-2 - 5.juni 2020";
		Excel ex = new Excel(tn);



		ArrayList<Player> sl = new ArrayList<Player>();

		Player ola = new Player("Ola");
		sl.add(ola);
		Player morten = new Player("Morten");
		sl.add(morten);
		Player grotting = new Player("Martin");
		sl.add(grotting);

		Player brudevoll = new Player("Fredrik Brudevoll");
		sl.add(brudevoll);

		Player mariaFinden = new Player("Maria Finden");
		sl.add(mariaFinden);

		Player cathrine = new Player("Cathrine");
		sl.add(cathrine);

		Player bjorn = new Player("Bjørn");
		sl.add(bjorn);

		Player eivind = new Player("Eivind");
		sl.add(eivind);

		Player andreas = new Player("Andreas");
		sl.add(andreas);

		Player simenP = new Player("Simen Persch");
		sl.add(simenP);

		Player simenD = new Player("Simen Dyb");
		sl.add(simenD);

		Player sixten = new Player("Sixten");
		sl.add(sixten);

		Player marius = new Player("Marius");
		sl.add(marius);

		Player jonas = new Player("Jonas");
		sl.add(jonas);

		Player lydia = new Player("Lydia");
		sl.add(lydia);

		Player aksel = new Player("Aksel");
		sl.add(aksel);

		Player fredrik = new Player("Fredrik Kloster");
		sl.add(fredrik);

		Player vetle = new Player("Vetle");
		sl.add(vetle);

		Player mariaH = new Player("Maria Hansteen");
		sl.add(mariaH);

		Player amanda = new Player("Amanda");
		sl.add(amanda);

		Player ingvild = new Player("Ingvild");
		sl.add(ingvild);

		Player ingrid = new Player("Ingrid");
		sl.add(ingrid);


		/*
			GRUPPE 1
		 */

		new Game(ola, 1, marius, 0, tn, 1);
		new Game(ola, 4, mariaFinden, 0, tn, 2);
		new Game(marius, 4, mariaFinden, 0, tn, 3);
		new Game(andreas, 5, mariaFinden, 0, tn, 4);
		new Game(ola, 2, andreas, 0, tn, 5);
		new Game(ola, 6, ingvild, 0, tn, 6);

		new Game(mariaFinden, 3, ingvild, 0, tn, 7);
		new Game(fredrik, 2, mariaFinden, 0, tn, 8);
		new Game(fredrik, 3, marius, 0, tn, 9);

		new Game(marius, 2, ingvild, 0, tn, 10);
		new Game(andreas, 2, ingvild, 0, tn, 11);

		new Game(marius, 7, andreas, 0, tn, 12);

		new Game(ola, 6, fredrik, 0, tn, 13);
		new Game(fredrik, 4, andreas, 0, tn, 14);
		new Game(fredrik, 4, ingvild, 0, tn, 15);


		/*
			Gruppe 2
		 */

		new Game(jonas, 3, vetle, 0, tn, 16);
		new Game(morten, 4, jonas, 0, tn, 17);
		new Game(morten, 4, cathrine, 0, tn, 18);
		new Game(cathrine, 1, ingrid, 0, tn, 19);
		new Game(vetle, 1, ingrid, 0, tn, 20);

		new Game(morten, 6, vetle, 0, tn, 21);
		new Game(morten, 5, simenP, 0, tn, 22);
		new Game(cathrine, 4, simenP, 1, tn, 23);
		new Game(jonas, 2, simenP, 0, tn, 24);
		new Game(simenP, 4, ingrid, 0, tn, 25);
		new Game(jonas, 1, ingrid, 0, tn, 26);
		new Game(cathrine, 7, jonas, 0, tn, 27);

		new Game(vetle, 5, simenP, 0, tn, 28);
		new Game(cathrine, 1, vetle, 0, tn, 29);
		new Game(morten, 1, ingrid, 0, tn, 30);

		/*

			Gruppe 3

		 */


		new Game(grotting, 4, bjorn, 0, tn, 31);
		new Game(simenD, 4, grotting, 0, tn, 32);
		new Game(simenD, 6, lydia, 0, tn, 33);
		new Game(bjorn, 3, lydia, 0, tn, 34);
		new Game(bjorn, 7, mariaH, 0, tn, 35);
		new Game(mariaH, 4, lydia, 0, tn, 36);

		new Game(simenD, 6, bjorn, 0, tn, 37);
		new Game(mariaH, 2, simenD, 0, tn, 38);

		new Game(grotting, 2, lydia, 0, tn, 39);
		new Game(grotting, 6, mariaH, 0, tn, 40);



		/*

			Gruppe 4

		 */

		new Game(eivind, 2, brudevoll, 0, tn, 41);
		new Game(eivind, 3, sixten, 0, tn, 42);
		new Game(sixten, 6, amanda, 0, tn, 43);

		new Game(aksel, 4, amanda, 0, tn, 44);
		new Game(aksel, 6, brudevoll, 0, tn, 45);

		new Game(sixten, 7, brudevoll, 0, tn, 46);
		new Game(sixten, 1, aksel, 0, tn, 47);

		new Game(eivind, 5, aksel, 0, tn, 48);
		new Game(eivind, 4, amanda, 0, tn, 49);

		new Game(amanda, 3, brudevoll, 0, tn, 50);



		/*
			Kvart
		 */

		new Game(morten, 2, fredrik, 0, tn, 51, "Kvartfinale");
		new Game(ola, 2, cathrine, 0, tn, 52, "Kvartfinale");
		new Game(eivind, 2, grotting, 0, tn, 53,"Kvartfinale");
		new Game(sixten, 2, simenD, 0, tn, 54, "Kvartfinale");


		new Game(ola, 2, sixten, 0, tn, 55, "Semifinale");
		new Game(eivind, 2, morten, 0, tn, 56, "Semifinale");

		new Game(ola, 2, eivind, 0, tn, 57, "Finale");




		//io.savePlayers(sl);
		//ex.WriteToBook(sl);




		
	}

}
