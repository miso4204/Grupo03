package org.stamppyProject.businessLogic.business.socialNetwork;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.stamppyProject.businessLogic.InitBean;

@Stateless
public class SocialNetworkBean implements ISocialNetwork {
	
	@EJB
	private InitBean initBean;
	
	@Override
	public Boolean facebookPost() {
		if(initBean.getFacebook())
			return true;
		else
			return false;
	}
	
	@Override
	public Boolean twitterPost() {
		if(initBean.getTwitter())
			return true;
		else
			return false;
		
	}
	
}
