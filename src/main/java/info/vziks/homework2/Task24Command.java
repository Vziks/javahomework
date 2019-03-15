package info.vziks.homework2;

import info.vziks.utils.Command;
import info.vziks.exceptions.TaskCommandException;

import java.math.BigInteger;

/**
 * Class Task24Command
 *
 * @author Anton Prokhorov
 */
public class Task24Command implements Command {

    private Integer prime = 1439;

    public Task24Command() {
    }

    public Task24Command(Integer prime) throws TaskCommandException {
        if (prime < 1) throw new TaskCommandException();
        this.prime = prime;
    }

    @Override
    public void execute() {
        isProbablePrimeByLib();
        isProbablePrimeByFor();
    }

    public void isProbablePrimeByLib() {
        BigInteger bigInteger = BigInteger.valueOf(getPrime());
        boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(getPrime()));
        System.out.println("The number " + getPrime() + " is" + (probablePrime ? "" : " not") + " prime by lib");
    }

    public void isProbablePrimeByFor() {
        Boolean flag = false;
        for (int i = 2; i <= (getPrime() / 2); i++) {
            if (getPrime() % i == 0)
                flag = true;
        }

        System.out.println("The number " + getPrime() + " is" + (flag ? " not" : "") + " prime by for");
    }

    public Integer getPrime() {
        return prime;
    }

    public void setPrime(Integer prime) {
        this.prime = prime;
    }
}
