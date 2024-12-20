package runner;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Browserlaunch.Browser_initiate;
import Browserlaunch.Browserlaun;
import Pageelement.Business;
import Pageelement.Registration;

public class Runner extends Browser_initiate {

//    @BeforeMethod
//	public void launch() {
//    	Browser_initiate.setItUp("admin");
//	}

	//mkx project
	
	// IBO registration
	@Test
	public void ibo_registration() throws IOException, InterruptedException {
		Registration iboregister = new Registration(driver);
		iboregister.userregistrationexcel();
	}
	
	// Customer Registration
	@Test
	public void customer_registration() throws IOException {
		Registration customerregister = new Registration(driver);
		customerregister.customerregexcel();
	}

	// IBO registration and holing tank using no change sponsor
	@Test
	public void holdingtannochange() throws IOException, InterruptedException {
		Registration iboregister = new Registration(driver);
		iboregister.userregistrationexcel();
		iboregister.holdingtanknosponsorchangeexcel();
	}

	// IBO registration and Holding tank with sponsor change
	@Test
	public void holdingsponsorchange() throws IOException, InterruptedException {
		Registration sponsorchange = new Registration(driver);
		sponsorchange.userregistrationexcel();
		sponsorchange.holdingsponsorchangenoplacement();
	}

	// IBO registration and Holding tank with sponsor change and placement change
	@Test
	public void holingplacementchange() throws IOException, InterruptedException {
		Registration placementchange = new Registration(driver);
		placementchange.userregistrationexcel();
		placementchange.holdingplacementchange();
	}
	// IBO registration and Holding tank with income centers

	@Test
	public void incomecenterschange() throws IOException, InterruptedException {
		Registration incomecenters = new Registration(driver);
		incomecenters.userregistrationexcel();
		incomecenters.incomecenterchangenoplacement();
	}

	// membership and founderclub upgrade package
	@Test
	public void businessplan() throws InterruptedException, IOException {
		Browser_initiate.setItUp("admin");
		Registration obj = new Registration(driver);
		obj.adminlog();
		Business obj1 = new Business();
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

	//grace period and inactive user
	
	@Test
	public void IBO_registration() throws InterruptedException, IOException {
		Browser_initiate.setItUp("ibo");
		Registration obj = new Registration(driver);
		obj.IBORegistration();
		Browser_initiate.setItUp("admin");
		obj.adminlog();
		obj.holding_Tank();
		Browser_initiate.setItUp("userlogin");
		obj.random_user();
		obj.graceperiod_wait();
		Browser_initiate.setItUp("admin");
		obj.adminlog();
		obj.days_change();
		Browser_initiate.setItUp("userlogin");
		obj.random_user();
		obj.graceperiod_wait();
		Browser_initiate.setItUp("admin");
		obj.adminlog();
		obj.days_changeinactive();
		Browser_initiate.setItUp("userlogin");
		obj.random_user();
	}

	@Test
	public void login_user() throws InterruptedException {
		Browser_initiate.setItUp("userlogin");
		Registration obj = new Registration(driver);
		//obj.random_user();
		obj.login();		
		Business obj1 = new Business();
		obj1.membership_package_user();
		//obj1.membership_package_upgrade_user();
	}
}
