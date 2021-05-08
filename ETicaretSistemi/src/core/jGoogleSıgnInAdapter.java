package core;

import entities.concretes.User;
import jSýgnInViaGoogle.GoogleSýgnIn;

public class jGoogleSýgnInAdapter implements SýgnInService {

	@Override
	public void signIn(User user) {
		GoogleSýgnIn sign= new GoogleSýgnIn();
		sign.signIn();
	}
      
}
