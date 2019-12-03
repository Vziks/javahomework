package info.vziks.exam;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class BrokenEncapsulation {
    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();

        set.addAll(Arrays.asList("Snap", "Crackle", "Pop"));

        System.out.println(set.addCount);
    }

}


class InstrumentedHashSet<E> extends HashSet<E> {
    public int addCount = 0;

    @Override
    public boolean add(E a) {
        addCount += 1;
        return super.add(a);
    };

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
}
