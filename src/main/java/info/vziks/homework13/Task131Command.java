package info.vziks.homework13;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework13.Calculator.AppCalculator;
import info.vziks.homework13.Exception.DivisionByZero;
import info.vziks.homework13.Exception.InvalidFormat;
import info.vziks.utils.Command;


public class Task131Command implements Command {
    @Override
    public void execute() throws TaskCommandException {

        // Это конфликтует с моей логикой ...
        // В случае если введенное выражение не совпадает с заданным шабломом,
        // выбрасывает исключения: отсутствуют n или m - выбрасывать один тип исключения,
        // указан не тот оператор - выбрасывать другое исключение, в качестве оператора указан /,
        // а второй операнд 0, либо n или m не целые числа - выбрасывать третий тип исключения.

        AppCalculator appCalculator = new AppCalculator();

        try {
            appCalculator.run();
        } catch (DivisionByZero divisionByZero) {
            System.out.println(divisionByZero.getMessage());
        } catch (InvalidFormat invalidFormat) {
            System.out.println(invalidFormat.getMessage());
        }
    }
}
