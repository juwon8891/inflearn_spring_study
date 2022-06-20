package hello.core.member;

public class Member {
    private Long id;
    private Long name;
    private Grade grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Member(Long id, Long name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
