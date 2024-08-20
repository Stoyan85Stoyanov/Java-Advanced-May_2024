package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_SimpleTextEditor_07_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder(); // модифициране на текста преминавайки през командите

        ArrayDeque <String> textStack = new ArrayDeque<>();

        for (int count = 1; count <=countCommands ; count++) {// прочитаме n на брой команди спрямо предварително зададения техен брой "countCommands"

            String command = scanner.nextLine(); // {цифра} {параметър}

            // "1 {string}". split -> ["1", "{string}"]
            // "2 {count}". split -> ["2", "{count}"]
            // "3 {index}". split -> ["3", "{index}"]
            // "4".split -> ["4"]

            int commandNumber = Integer.parseInt(command.split("//s+")[0]); // взимаме първата част от командата (числовата стойност -- 1, 2, 3, 4)

            switch (commandNumber){
                case 1:
                    textStack.push(currentText.toString()); // добавяме към текущият текст (взимаме текущият текст и го запазваме как е изглеждал)
                    String stringForAppend = command.split("\\s+")[1]; // добавя [низ] в края на текста
                    currentText.append(stringForAppend); // трябва да добавя stringForAppend към сегашния текст
                    break;

                case 2:
                    textStack.push(currentText.toString()); // добавяме към текущият текст
                    int countElementsForDelete = Integer.parseInt(command.split("\\s+")[1]); // изтрива последните [count] елементи от текста
                    int startIndexForDelete = currentText.length() - countElementsForDelete; // изтриваме countElementsForDelete брой елементи // "abcd" //
                    currentText.delete(startIndexForDelete, startIndexForDelete + countElementsForDelete);

                    break;

                case 3:
                    int index = Integer.parseInt(command.split("\\s+")[1]); // връща елемента на позиция [индекс] от текста
                    System.out.println(currentText.charAt(index - 1)); // печатаме (дай ми елемента на дадения индекс - 1)
                    break;

                case 4:
                    if (!textStack.isEmpty()) { // проверка дали стека не е празен --> винаги се прилага при използване на командата pop
                        currentText = new StringBuilder(textStack.pop());
                    }
                    break;
            }
        }
    }
}
