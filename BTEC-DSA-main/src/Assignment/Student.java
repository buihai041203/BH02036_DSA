package Assignment;

public class Student {
    private String id;
    private String name;
    private double mark;
    private String rank;

    public Student(String id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.rank = calculateRank();
    }

    private String calculateRank() {
        if (mark >= 0 && mark < 5.0) {
            return "Fail";
        } else if (mark >= 5.0 && mark < 6.5) {
            return "Medium";
        } else if (mark >= 6.5 && mark < 7.5) {
            return "Good";
        } else if (mark >= 7.5 && mark < 9.0) {
            return "Very Good";
        } else if (mark >= 9.0 && mark <= 10.0) {
            return "Excellent";
        } else {
            return "Invalid";
        }
    }

    public void getStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Mark: " + mark);
        System.out.println("Rank: " + rank);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public String getRank() {
        return rank;
    }
    
}
