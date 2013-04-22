package com.uia.musicplayertest;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class EraseInternalStorage extends UiAutomatorTestCase {
	public static final String LOG_TAG = "UIATEST";
	public UiDevice device = null;
	public int x = 0;
	public int y = 0;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		device = getUiDevice();
		device.pressHome();
		device.pressHome();
		
		x = device.getDisplayWidth();
		y = device.getDisplayHeight();
		
		
		//launch activity : com.android.updater/.MiuiSettings
		Runtime.getRuntime().exec("am start com.android.settings/.MiuiSettings");
	}
	
	public void testWLANConnect() throws UiObjectNotFoundException{
		UiObject textviewCompletesettings = new UiObject(new UiSelector().text("全部设置"));
		textviewCompletesettings.click();

		//drag UI to display "storage" option
		device.swipe((int)Math.floor(x/2), y-30, (int)Math.floor(x/2), (int)Math.floor(y/5), 5);
		sleep(2 * 1000);
		device.swipe((int)Math.floor(x/2), y-30, (int)Math.floor(x/2), (int)Math.floor(y/5), 5);
		sleep(2 * 1000);
		device.swipe((int)Math.floor(x/2), (int)Math.floor(x/5), (int)Math.floor(x/2),  (int)Math.floor(y*2/5), 5);
		
		UiObject textviewStorage = new UiObject(new UiSelector().text("存储"));
		textviewStorage.click();
		sleep(2 * 1000);
		device.swipe((int)Math.floor(x/2), y-30, (int)Math.floor(x/2), (int)Math.floor(y/5), 5);
		UiObject textviewFormat = new UiObject(new UiSelector().text("格式化内存设备"));
		textviewFormat.click();
		UiObject buttonNext = new UiObject(new UiSelector().text("下一步"));
		buttonNext.click();
		UiObject buttonFormat = new UiObject(new UiSelector().text("格式化"));
		buttonFormat.click();

	}

}
