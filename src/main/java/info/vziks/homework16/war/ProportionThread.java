package info.vziks.homework16.war;

import java.util.List;

public class ProportionThread implements Runnable {
    private List<String> proportionArray;
    private SummaryClass summaryClass;

    public ProportionThread(List<String> proportionArray,  SummaryClass summaryClass) {
        this.proportionArray = proportionArray;
        this.summaryClass = summaryClass;
    }

    @Override
    public void run() {

        for (String string : proportionArray) {
            this.summaryClass.add(string);
        }
    }
}