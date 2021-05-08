import business.concretes.UserManager;
import core.jGoogleSýgnInAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1= new User(1,"Samet","Sahin","sahincsamet@gmail.com","0123456");
		UserManager userManager = new UserManager(new HibernateUserDao());
		UserManager userManager2 = new UserManager(new HibernateUserDao(),new jGoogleSýgnInAdapter());
		userManager.signIn(user1);
		userManager2.signIn(user1);
		userManager.logIn(user1);
	}

}
