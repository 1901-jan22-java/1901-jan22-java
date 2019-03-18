package com.revature.hello;

public class ParentBean {
	
	
	private HelloSpring dependency;
	
	
	
	// need for setter injection
	public ParentBean() {}
	
	
	//need for constructor injection
	public ParentBean(HelloSpring dependency) {
		super();
		this.dependency = dependency;
	}

	/**
	 * @return the dependency
	 */
	public HelloSpring getDependency() {
		return dependency;
	}

	/**
	 * @param dependency the dependency to set
	 */
	public void setDependency(HelloSpring dependency) {
		this.dependency = dependency;
	}
	
	

}
