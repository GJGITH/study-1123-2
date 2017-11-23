package com.example;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
	private static final Logger log = LoggerFactory.getLogger(AnnotationApp.class);

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);//区别比下面的少一个bean
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();//没有添加类，通过下面的scan方法查找
		context.scan("com.example");//scan找所有component、service、找所有的bean
		context.refresh();
		context.registerShutdownHook();
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		System.out.println(dataSource);
		AnnotationBean annotationBean = (AnnotationBean) context.getBean(AnnotationBean.class);
		System.out.println(annotationBean);
//		SampleBean sampleBean = context.getBean(SampleBean.class);
//		System.out.println(sampleBean);
		int count =context.getBeanDefinitionCount();
		System.out.println("total bean defined: " + count);
		String[] names = context.getBeanDefinitionNames();
		for (String name: names) {
			System.out.println(context.getBean(name));
		}
	}

}
