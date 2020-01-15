package com.spring.training.spring3to5.com.app.l4JavaConfig.a2.javaConfigImport;

import com.spring.training.spring3to5.beans.b4javaConfigBeans.javaConfigImport.Student;
import com.spring.training.spring3to5.beans.b4javaConfigBeans.javaConfigImport.University;
import com.spring.training.spring3to5.config.a2.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by nitin on 12/12/15.
 *
 * METHOD CALLING FROM A BEAN
 * A large Spring XML bean files is split into multiple small files, group by module or category,
 * to make things more maintainable and modular.
 *
 * In Spring 3 JavaConfig, it is achieved by @Import in the config file
 *
 * In XML, when we have multiple files, we keep the reference in one final file.
 * Similarly in annotations, we keep references in one AppConfigFile
 */


public class App {
    public static void main(String[] args) {

        //The AppConfig of a2 package has the reference of the two imported classes
        ApplicationContext c = new AnnotationConfigApplicationContext(AppConfig.class);

        Student s = (Student) c.getBean("test");
        University u = (University) c.getBean("university");

        s.sayHi();
        u.sayHi();

        System.out.println("------ MAIN TERMINATES ------");
    }

}
