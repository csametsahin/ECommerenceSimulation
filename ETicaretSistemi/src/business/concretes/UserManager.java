package business.concretes;

import business.abstracts.UserService;
import core.AuthorizationValidater;
import core.EmailValidator;
import core.S�gnInService;
import core.Utils;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	UserDao userDao;
	S�gnInService signService;
	
	
	public UserManager(UserDao userDao, S�gnInService signService) {
		this.userDao = userDao;
		this.signService = signService;
	}

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void signIn(User user) {
			if(user.getLastName() == null || user.getFirstName() == null || user.getEmail() == null ||  user.getPassword() == null ) {
				 System.out.println("Bilgiler bo� olamaz");
				 return;
			}
			else if (user.getPassword().length()<6) {
				System.out.println("�ifreniz en az 6 karakterden olu�mal�");
				return;
			}
			else if(!Utils.validateEmail(user.getEmail())) {
				System.out.println("Email hatal�d�r");
				return;
			}
			else if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
				System.out.println("�sim veya soy isim en az iki karakterden olu�mal�d�r");
				return;
			}
			else if(EmailValidator.CheckIfEmailUsed(user.getEmail())) {
				System.out.println("Email kullan�lm��");
			}
			System.out.println("Onay Emaili yolland�");
			if(AuthorizationValidater.authEmail(user.getEmail())) {
				if(signService != null) {
					signService.signIn(user);
				}
				this.userDao.add(user);
			}
			else {
				System.out.println("Email onaylanmad�");
			}
		
	}

	@Override
	public void logIn(User user) {
		if(user.getEmail() ==null || user.getPassword() ==null) {
			System.out.println("E-mail ve password zorunludur");
			return;
		}
		else {
			System.out.println("Giri� ba�ar�l�");
			this.userDao.add(user);
		}
		
	}

}
