package test06;

import java.util.Objects;

/**
 * 验证Set和Map添加元素使用时
 * 如果两个元素的哈希码相同，那么需要进行equals判断。
 * 【所以可以自定义返回值作为哈希码】 equals()返回true代表两元素相同，
 * 返回false代表不同。
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test06
 * hyp create at 19-11-5
 **/
public class Person {
    private String name;
    private Integer age;
    private Boolean sex;

    public Person() {
    }

    public Person(String name, Integer age, Boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(sex, person.sex);
//        return true;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(name, age, sex);
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
