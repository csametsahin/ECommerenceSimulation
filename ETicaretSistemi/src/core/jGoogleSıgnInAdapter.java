package core;

import entities.concretes.User;
import jS�gnInViaGoogle.GoogleS�gnIn;

public class jGoogleS�gnInAdapter implements S�gnInService {

	@Override
	public void signIn(User user) {
		GoogleS�gnIn sign= new GoogleS�gnIn();
		sign.signIn();
	}
      
}
