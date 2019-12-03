package info.vziks.homework15.pupil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;
import java.time.Period;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    public Pupil(int number, String name, Gender gender, LocalDate birth) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public int getNumber() {
        return number;
    }

    public Pupil setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pupil setName(String name) {
        this.name = name;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Pupil setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getBirth() {
        return birth;
    }


    public int getFullAge() {
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public Pupil setBirth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pupil{");
        sb.append("number=").append(number);
        sb.append(", name='").append(name).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", birth=").append(birth);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pupil pupil = (Pupil) o;

        return new EqualsBuilder()
                .append(getNumber(), pupil.getNumber())
                .append(getName(), pupil.getName())
                .append(getGender(), pupil.getGender())
                .append(getBirth(), pupil.getBirth())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getNumber())
                .append(getName())
                .append(getGender())
                .append(getBirth())
                .toHashCode();
    }
}
