package info.vziks.homework15.student;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Student {
    private String login;
    private List<String> professions;

    public Student(String login) {
        this.login = login;
    }

    public void addProfession(String professionName) {
        if (this.professions == null) {
            this.professions = new ArrayList<>();
        }
        this.professions.add(professionName);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public Student setProfessions(List<String> professions) {
        this.professions = professions;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("login='").append(login).append('\'');
        sb.append(", professions=").append(professions);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return new EqualsBuilder()
                .append(getLogin(), student.getLogin())
                .append(getProfessions(), student.getProfessions())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getLogin())
                .append(getProfessions())
                .toHashCode();
    }
}