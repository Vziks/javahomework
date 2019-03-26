package info.vziks.homework6.pupil;

import java.util.Arrays;

public class Pupil {
    String name;
    public ExamResult[] examResults;

    public Pupil(String name) {
        this.name = name;
    }

    public void setExams(String[] ex, int[] marks){
        this.examResults = new ExamResult[ex.length];
        for (int i = 0; i < ex.length; i++) {
            this.examResults[i] = new ExamResult(ex[i], marks[i]);
        }
    }

    @Override
    public String toString() {
        return "Student " + name + "\n" + Arrays.toString(examResults);
    }

    public ExamResult[] getExamResults() {
        return examResults;
    }

    public void setExamResults(ExamResult[] examResults) {
        this.examResults = examResults;
    }

    class ExamResult {
        String ex;
        int mark;

        public ExamResult(String ex, int mark) {
            setEx(ex);
            setMark(mark);
        }

        boolean check() {
            return getMark() > 2;
        }

        @Override
        public String toString() {
            return getEx() + (this.check() ? "" : " not") + " passsed";
        }

        public String getEx() {
            return ex;
        }

        public void setEx(String ex) {
            this.ex = ex;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
