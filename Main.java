package net.ukr.andy777;

import java.io.File;

/*
 Lesson08
 2. Создайте класс-контейнер типа стек (класс в который можно добавлять и удалять объекты других 
 классов, только в вершину стека), в который можно сохранять объекты произвольного типа. 
 Должен быть метод:
 - добавления элемента в стек, 
 - получение с удалением элемента из стека, 
 - и просто получение элемента из вершины из стека. 
 Должна быть реализована работа с «черным списком» классов (смотри ниже). 
 Если объект который добавляется в стек принадлежит классу из «черного списка», 
 то добавление такого объекта запрещено.

 3. Для описанного выше стека создайте класс «Черный список», в котором будут описаны 
 классы объектов которые нельзя добавлять в стек.
 Должна быть возможность добавления классов в черный список, проверка объекта на то, 
 что класс, к которому он принадлежит, принадлежит или не принадлежит к классам в черном списке. 
 */

public class Main {

	public static void main(String[] args) {

		// формування чорного списку
		BlackList bl = new BlackList(Integer.class);
		bl.addBlackListElement(Integer.class);
		bl.addBlackListElement(Long.class);
		bl.addBlackListElement(File.class);
		bl.addBlackListElement(Long.class);
		System.out.println("= BlackList: \n" + bl);
		bl.deleteBlackListElement(Long.class);
		System.out.println("= BlackList: \n" + bl);

		// формування стеку
		Object obj;
		Stack stk = new Stack(bl);

		System.out.println("=== читання елементу з вершини пустого стеку");
		obj = stk.readLastStackElement();
		System.out.println(obj.getClass() + " -> \t" + obj.toString() + "\n");

		System.out.println("=== наповнення стеку об'єктами різнх класів");
		stk = new Stack(bl,"string");
		stk.addLastStackElement(0);
		stk.addLastStackElement(1L);
		stk.addLastStackElement(2D);
		stk.addLastStackElement(new File(".//Stack"));
		stk.addLastStackElement(3);
		stk.addLastStackElement("4");
		stk.addLastStackElement(5.1);
		stk.addLastStackElement("stk 6.2");
		System.out.println(stk);

		System.out.println("=== читання елементу з вершини стеку");
		obj = stk.readLastStackElement();
		System.out.println(obj.getClass() + " -> \t" + obj.toString() + "\n");

		System.out.println("=== отримання та видалення елементу з вершини стеку");
		obj = stk.getLastStackElement();
		System.out.println("= останній елемент: \n" + obj.getClass() + " -> \t" + obj.toString());
		System.out.println("= стек, що лишився: \n" + stk);


	}
}
