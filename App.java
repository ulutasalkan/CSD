package Homework_Java_015;

public class App {
	public static void main(String[] args){
		Sudoku sd=new Sudoku();
		sd.read();
		if (sd.isValid())
			System.out.println("Ge�erli");
		else
			System.out.println("Ge�erli de�il");
	}
}
