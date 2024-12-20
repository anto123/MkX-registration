package Pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogLevelMapping;

import Browserlaunch.Browser_initiate;

public class Business extends Browser_initiate {

	public void founderclub() {
		webelement.wait(3000);
		webelement.click(elements.administration);
		webelement.click(elements.business_Plan);
		webelement.click(elements.enrolment_Package);
		webelement.click(elements.founderclub_edit);
		webelement.click(elements.founderclub_vp);
		vpcheck();
		webelement.wait(2500);
		webelement.selectDropDownOption("number_of_months", "10");
		webelement.clear(elements.vp_for_month1);
		webelement.send(elements.vp_for_month1, "1000");
		webelement.clear(elements.vp_for_month2);
		webelement.send(elements.vp_for_month2, "500");
		webelement.clear(elements.vp_for_month3);
		webelement.send(elements.vp_for_month3, "100");
		webelement.clear(elements.vp_for_month4);
		webelement.send(elements.vp_for_month4, "100");
		webelement.clear(elements.vp_for_month5);
		webelement.send(elements.vp_for_month5, "100");
		webelement.clear(elements.vp_for_month6);
		webelement.send(elements.vp_for_month6, "100");
		webelement.clear(elements.vp_for_month7);
		webelement.send(elements.vp_for_month7, "100");
		webelement.clear(elements.vp_for_month8);
		webelement.send(elements.vp_for_month8, "100");
		webelement.clear(elements.vp_for_month9);
		webelement.send(elements.vp_for_month9, "100");
		webelement.clear(elements.vp_for_month10);
		webelement.send(elements.vp_for_month10, "100");
		webelement.click(elements.button_option);
	}

	public static void vpcheck() {
		if (driver.findElement(By.xpath(elements.vp_checkbox)).isSelected()) {
			webelement.click(elements.vp_checkbox);
		} else {

			System.out.println("checkbox clicking");
		}

	}

	public void membership_Package_admin_configure() {
		webelement.wait(2500);
		webelement.click(elements.administration);
		webelement.click(elements.business_Plan);
		webelement.click(elements.membership_package);
		// MKX wealth
		webelement.click(elements.mkx_wealth_edit);
		webelement.wait(3500);
		webelement.click(elements.product_specification);
		webelement.wait(800);
		webelement.clear(elements.volume_points);
		webelement.send(elements.volume_points, "100");
//    	webelement.click(elements.update1);
//    	driver.navigate().back();
		webelement.click(elements.pricing1);
		webelement.clear(elements.product_name);
		webelement.send(elements.product_name, "MKX Wealth");
		webelement.clear(elements.subscription_type);
		webelement.send(elements.subscription_type, "regular");
		webelement.clear(elements.price);
		webelement.send(elements.price, "129");
		webelement.click(elements.update2);
		// MKX Exclusive
		webelement.wait(2000);
		webelement.click(elements.mkx_exclusive_edit);
		webelement.wait(2500);
		webelement.click(elements.product_specification);
		webelement.wait(800);
		webelement.clear(elements.volume_points2);
		webelement.send(elements.volume_points, "199.0");
		webelement.click(elements.update3);
		driver.navigate().back();
		webelement.wait(2000);
		webelement.click(elements.pricing1);
		webelement.clear(elements.product_name);
		webelement.send(elements.product_name, "MKX Exclusive");
		webelement.clear(elements.subscription_type);
		webelement.send(elements.subscription_type, "pro");
		webelement.clear(elements.price);
		webelement.send(elements.price, "199.0");
		webelement.click(elements.update2);
	}

	public void membership_package_user() {
		webelement.wait(2000);
		webelement.click(elements.membership_Menu);
		webelement.click(elements.membership_Package);
		webelement.click(elements.wealth_Package);
		// webelement.click(elements.exclusive_package);
		webelement.click(elements.checkout_Button);
		webelement.wait(2500);
		webelement.click(elements.checkout_Button);
		webelement.wait(1000);
		webelement.click(elements.testPayment);
		webelement.wait(2500);
		webelement.selectDropDownOption("id_status", "Confirmed");
		webelement.click(elements.finishButton);
	}

	public void membership_package_upgrade_user() {
		webelement.wait(2000);
		webelement.click(elements.membership_Menu);
		webelement.click(elements.upgrade_menu);
		webelement.click(elements.member_package_menu);
		webelement.click(elements.checkout_but);
		webelement.wait(2500);
		webelement.click(elements.checkout_Button);
		webelement.click(elements.testPayment);
		webelement.wait(2500);
		webelement.selectDropDownOption("id_status", "Confirmed");
		webelement.click(elements.finishButton);
	}

	public void founder_club_upgrade_user() {
		webelement.wait(2500);
		webelement.click(elements.membership_Menu);
		webelement.click(elements.upgrade_menu);
		webelement.click(elements.enrolment_package_menu);
		webelement.click(elements.founder_package);
		webelement.click(elements.checkout);
		webelement.wait(1500);
		webelement.click(elements.checkout_Button);
		webelement.wait(500);
		webelement.click(elements.testPayment);
		webelement.wait(2500);
		webelement.selectDropDownOption("id_status", "Confirmed");
		webelement.click(elements.finishButton);

	}
}