package com.uia.musicplayertest;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class MusicplayerTest extends UiAutomatorTestCase{
	
	public static final String LOG_TAG = "UIATEST";
	public UiDevice device = null;
	public int width = 0;
	public int height = 0;	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		device = getUiDevice();
		device.pressHome();
		device.pressHome();
		
		width = device.getDisplayWidth();
		height = device.getDisplayHeight();

		
		
		//launch activity : com.android.updater/.MiuiSettings
		Runtime.getRuntime().exec("am start com.android.settings/.MiuiSettings");
	}
	
	
	public void musicplayerTest() throws UiObjectNotFoundException, RemoteException {
		
		UiObject textviewCompletesettings = new UiObject(new UiSelector().text("全部设置"));
		textviewCompletesettings.click();

		//drag UI to display "storage" option
		device.swipe((int)Math.floor(width/2), height-30, (int)Math.floor(width/2), (int)Math.floor(height/5), 5);
		sleep(2 * 1000);
		device.swipe((int)Math.floor(width/2), height-30, (int)Math.floor(width/2), (int)Math.floor(height/5), 5);
		sleep(2 * 1000);
		device.swipe((int)Math.floor(width/2), (int)Math.floor(width/5), (int)Math.floor(width/2),  (int)Math.floor(height*2/5), 5);
		
		UiObject textviewStorage = new UiObject(new UiSelector().text("存储"));
		textviewStorage.click();
		sleep(2 * 1000);
		device.swipe((int)Math.floor(width/2), height-30, (int)Math.floor(width/2), (int)Math.floor(height/5), 5);
		UiObject textviewFormat = new UiObject(new UiSelector().text("格式化内存设备"));
		textviewFormat.click();
		UiObject buttonNext = new UiObject(new UiSelector().text("下一步"));
		buttonNext.click();
		UiObject buttonFormat = new UiObject(new UiSelector().text("格式化"));
		buttonFormat.click();
		
	}
	
}
