package com.example.hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.Teacher;

@ImportResource("classpath:beans.xml")

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class HelloApplication {

	public static void main(String[] args) {
		System.out.println("Hello, springboot!");


		ApplicationContext context = SpringApplication.run(HelloApplication.class, "args");
		//1.Using XML file
		Greet greet=context.getBean(Greet.class);
		greet.sayHello();
		//2.Using stereotype annotation
		Person person=context.getBean(Person.class);
		person.sayHello();
		//3.Using configuration file
		Student student=context.getBean(Student.class);
		student.sayHello();

		Teacher teacher=context.getBean(Teacher.class);
		teacher.sayHello();
		System.out.println(teacher.hashCode());
		Teacher teacher1=context.getBean(Teacher.class);
		System.out.println(teacher1.hashCode());

		System.err.println("Student1:" + student.hashCode());
		Student student1=context.getBean(Student.class);
		System.err.println("Student2:" + student1.hashCode());
	}
	// @Bean
    // public Student student(){
    //     // Student ss=new Student();
    //     // return ss;
    //     return new Student();
    // }

}
