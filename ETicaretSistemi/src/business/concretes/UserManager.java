package business.concretes;

import business.abstracts.UserService;
import core.AuthorizationValidater;
import core.EmailValidator;
import core.SýgnInService;
import core.Utils;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	UserDao userDao;
	SýgnInService signService;
	
	
	public UserManager(UserDao userDao, SýgnInService signService) {
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
				 System.out.println("Bilgiler boþ olamaz");
				 return;
			}
			else if (user.getPassword().length()<6) {
				System.out.println("Þifreniz en az 6 karakterden oluþmalý");
				return;
			}
			else if(!Utils.validateEmail(user.getEmail())) {
				System.out.println("Email hatalýdýr");
				return;
			}
			else if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
				System.out.println("Ýsim veya soy isim en az iki karakterden oluþmalýdýr");
				return;
			}
			else if(EmailValidator.CheckIfEmailUsed(user.getEmail())) {
				System.out.println("Email kullanýlmýþ");
			}
			System.out.println("Onay Emaili yollandý");
			if(AuthorizationValidater.authEmail(user.getEmail())) {
				if(signService != null) {
					signService.signIn(user);
				}
				this.userDao.add(user);
			}
			else {
				System.out.println("Email onaylanmadý");
			}
		
	}

	@Override
	public void logIn(User user) {
		if(user.getEmail() ==null || user.getPassword() ==null) {
			System.out.println("E-mail ve password zorunludur");
			return;
		}
		else {
			System.out.println("Giriþ baþarýlý");
			this.userDao.add(user);
		}
		
	}

}
