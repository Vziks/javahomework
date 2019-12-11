package info.vziks.homework16.war;

import java.util.List;

public class ProportionThread implements Runnable {
    private List<String> proportionArray;
    private SummaryClass summaryClass;
    Thread thread;

    public ProportionThread(List<String> proportionArray,  SummaryClass summaryClass) {
        this.proportionArray = proportionArray;
        this.summaryClass = summaryClass;
        thread = new Thread(this);
    }

    @Override
    public void run() {

        for (String string : proportionArray) {
//            System.out.println(Thread.currentThread().getName());
            this.summaryClass.add(string);
        }
    }

    public Thread getThread() {
        return thread;
    }
}