package com.revature.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Life implements 	BeanNameAware, BeanFactoryAware, 
								ApplicationContextAware, BeanPostProcessor,
								InitializingBean, DisposableBean {
	private String lifecycle;
	
	public String getLifecycle() {
		return lifecycle;
	}
	
	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
		System.out.println("SETTING LIFE PROPERTIES");
	}

	public Life() {
		super();
		System.out.println("INSTANTIATING LIFE");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("DESTROY LIFE");
		
	}

	public void customInit() {
		System.out.println("IN CUSTOM INIT");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AFTER PROPERTIES SET");		
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("POST BEFORE INITIALIZATION");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("POST INITIALIZATION");
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("SET APPLICATION CONTEXT " + applicationContext);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("SET BEAN FACTORY " + beanFactory);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("SET BEAN NAME " + name);
	}

}
