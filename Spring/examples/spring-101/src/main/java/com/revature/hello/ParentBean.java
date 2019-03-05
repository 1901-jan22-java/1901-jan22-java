package com.revature.hello;

public class ParentBean {
<<<<<<< HEAD

	private HelloSpring dependency;

	public ParentBean() {
		
	}

=======
	
	private HelloSpring dependency;

	//need for setter injection
	public ParentBean() {}
	
	
	//need for constructor injection
>>>>>>> master
	public ParentBean(HelloSpring dependency) {
		super();
		this.dependency = dependency;
	}
<<<<<<< HEAD
	
=======
>>>>>>> master

	public HelloSpring getDependency() {
		return dependency;
	}

	public void setDependency(HelloSpring dependency) {
		this.dependency = dependency;
	}
	
<<<<<<< HEAD
=======
	

>>>>>>> master
}
