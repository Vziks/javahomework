package info.vziks.lessons.annotation.work.one;

class SomeClass {
    String string;
    @Ignore
    int someInt;
    ChSomeClass chSomeClass;
    @Ignore
    private int psomeInt1;
    private int psomeInt2;

    public SomeClass(String string, int someInt, int CSomeInt) {
        this.string = string;
        this.someInt = someInt;
        this.chSomeClass = new ChSomeClass(CSomeInt);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SomeClass{");
        sb.append("string='").append(string).append('\'');
        sb.append(", someInt=").append(someInt);
        sb.append(", chSomeClass=").append(chSomeClass);
        sb.append('}');
        return sb.toString();
    }
}



class ChSomeClass {
    @Ignore
    int CSomeInt;

    public ChSomeClass(int CSomeInt) {
        this.CSomeInt = CSomeInt;
    }

    public int getCSomeInt() {
        return CSomeInt;
    }

    public ChSomeClass setCSomeInt(int CSomeInt) {
        this.CSomeInt = CSomeInt;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChSomeClass{");
        sb.append("CSomeInt=").append(CSomeInt);
        sb.append('}');
        return sb.toString();
    }
}