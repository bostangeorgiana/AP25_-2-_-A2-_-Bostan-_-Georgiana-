public class Main {

    enum ProjectType {
        THEORETICAL,
        PRACTICAL
    }

    static class Project {
        String name;
        ProjectType type;

        Project(String name, ProjectType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }
        public ProjectType getType() {
            return type;
        }

        public void setType(ProjectType type) {
            this.type = type;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Project [name=" + name + ", type=" + type + "]";
        }
    }

    static class Student{
        String name;
        int age;
        public Student(String name, int age){
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName(){
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }
        public int getAge(){
            return age;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + "]";
        }

    }


    public static void main(String[] args) {

        Project project1 = new Project("AI", ProjectType.THEORETICAL);

        Student student1 = new Student("John Doe", 22);

        System.out.println(project1);
        System.out.println(student1);
    }

}