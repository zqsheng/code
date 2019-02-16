package com.muzi.stu.obj;

public class ObjCopyTest {
    public static void  main(String[] args){
//        Student s = new Student("张三",1,20);
//        System.out.println(s.hashCode());
//        s.setId(1001);
//        System.out.println(s.hashCode());
//        Student t = s;
//        System.out.println(t.hashCode());
        Student s1 = new Student("张三",1,20);
        School school = new School("海南国际小学","北京路测试小区","18976231612");
        s1.setSchool(school);
        Student sc = CloneUtils.clone(s1);
        System.out.println(s1.hashCode());
        System.out.println(sc.hashCode());
        school.setName("ceshi");
        System.out.println(s1);
        System.out.println(sc);
    }
}
