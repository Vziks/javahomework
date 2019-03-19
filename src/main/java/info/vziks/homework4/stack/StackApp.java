package info.vziks.homework4.stack;

public class StackApp {
    public static void main(String[] args) {
        Stack theStack = new Stack(10); // Создание нового стека
        theStack.push(20); // Занесение элементов в стек
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        while (!theStack.isEmpty()) // Пока стек не станет пустым
        { // Удалить элемент из стека
            long value = theStack.pop();
            System.out.print(value); // Вывод содержимого
            System.out.print(" ");
        }
//        System.out.println(theStack.pop());
        System.out.println("");
    }
}
