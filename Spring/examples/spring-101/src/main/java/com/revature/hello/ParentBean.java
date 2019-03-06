package com.revature.hello;

public class ParentBean {
	
	private HelloSpring dependency;

	//need for setter injection
	public ParentBean() {}
	
	
	//need for constructor injection
	public ParentBean(HelloSpring dependency) {
		super();
		this.dependency = dependency;
	}

	public HelloSpring getDependency() {
		return dependency;
	}

	public void setDependency(HelloSpring dependency) {
		this.dependency = dependency;
	}
	
}
