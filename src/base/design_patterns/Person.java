package base.design_patterns;

public class Person {

    public static void main(String[] args) {
        Person person = new Builder("liu", "JN")
                .setAge(13)
                .setJob("fire")
                .build();
        System.out.println(person.toString());

        Person person2 = new Builder("张", "NJ")
                .setJob("fire")
                .build();
        System.out.println(person2.toString());
    }

    private final String name;
    private final String address;
    private final int age;
    private final String job;

    private Person(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.age = builder.age;
        this.job = builder.job;
    }

    public static class Builder {
        //private String name;
        //private String address;
        private final String name;
        private final String address;
        private int age;
        private String job;

        /**
         * 特殊要求：
         * 比如要求 name和address属性为必须设置，其他属性为可选设置。
         * 此时在声明Builder构造函数的时候就必须要进行数据参数初始化
         */
        public Builder(String name, String address) {
            this.name = name;
            this.address = address;
        }

        /*public Builder setName(String name) {
            this.name = name;
            return this;
        }*/

        /*public Builder setAddress(String address) {
            this.address = address;
            return this;
        }*/

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setJob(String job) {
            this.job = job;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
