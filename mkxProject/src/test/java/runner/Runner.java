package runner;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Browserlaunch.Browser_initiate;
import Browserlaunch.Browserlaun;
import Pageelement.Business;
import Pageelement.Registration;

public class Runner extends Browser_initiate{
 
//    @BeforeMethod
//	public void launch() {
//    	Browser_initiate.setItUp("admin");
//	}

	@Test(priority = 1)
	
	public void IBO_registration() throws InterruptedException, IOException {
		Browser_initiate.setItUp("customer");
        Registration obj=new Registration(driver);
		//obj.IBORegistration();
		obj.customerRegistration();
//		Browser_initiate.setItUp("admin");
//		obj.adminlog();	
//		obj.holding_Tank();
		}
	@Test(enabled = false)
	public void login_user() throws InterruptedException {
		Browser_initiate.setItUp("userlogin");
		Registration obj=new Registration(driver);
		obj.random_user();
		Business obj1=new Business();
		obj1.membership_package_user();
		obj1.membership_package_upgrade_user();
	}
	@Test(enabled = false)
	public void Customer_Registration() {
		
		
	}
	@Test(enabled = false)
	public void businessplan() throws InterruptedException, IOException {
		Browser_initiate.setItUp("admin");
		Registration obj=new Registration(driver);
		obj.adminlog();
		Business obj1=new Business();
		obj1.membership_Package_admin_configure();
		Browser_initiate.setItUp("ibo");
		obj.IBORegistration();
		Browser_initiate.setItUp("admin");
		obj.adminlog();	
		obj.holding_Tank();
		Browser_initiate.setItUp("userlogin");
		obj.random_user();
		obj1.membership_package_user();
		obj1.membership_package_upgrade_user();
		obj1.founder_club_upgrade_user();
	}
}