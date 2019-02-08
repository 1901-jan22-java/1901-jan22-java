package associate_project.Associate;

public class Admin {
private String password;
public Admin(){}
public Admin(String password){
	this.setPassword(password);
}
@Override
public String toString() {
	return "Admin [password=" + password + "]";
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
