package array.schoolSystem.models;

public class Student {

    private String name;
    private Double gradeA;
    private Double gradeB;

    public boolean isApproved() {
        if ((gradeA + (gradeB * 2)) / 3 >= 6) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGradeA() {
        return gradeA;
    }

    public void setGradeA(Double gradeA) {
        this.gradeA = gradeA;
    }

    public Double getGradeB() {
        return gradeB;
    }

    public void setGradeB(Double gradeB) {
        this.gradeB = gradeB;
    }
}
