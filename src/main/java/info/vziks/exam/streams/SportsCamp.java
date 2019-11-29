package info.vziks.exam.streams;

public  class SportsCamp {
    private  String name; //Имя спортсмена
    private  Integer day; //Количество дней в спортивном лагере

    public SportsCamp(String name, int day) {

        this.name = name;
        this.day = day;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getDay() {
        return day;
    }
    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SportsCamp{");
        sb.append("name='").append(name).append('\'');
        sb.append(", day=").append(day);
        sb.append('}');
        return sb.toString();
    }
}