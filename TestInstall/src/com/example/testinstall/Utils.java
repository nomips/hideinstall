package com.example.testinstall;

import java.io.DataOutputStream;

import android.util.Log;

public class Utils {
	
	public synchronized boolean getRootAhth() {
		Process process = null;
		DataOutputStream os = null;
		try {
			process = Runtime.getRuntime().exec("su");
			os = new DataOutputStream(process.getOutputStream());
			os.writeBytes("exit\n");
			os.flush();
			int exitValue = process.waitFor();
			if (exitValue == 0) {
				System.out.println("your phone has root");
				return true;
			} else {
				System.out.println("your phone not root");
				return false;
			}
		} catch (Exception e) {
			Log.d("com.example.testinstall", "Unexpected error - Here is what I know: "
					+ e.getMessage());
			return false;
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (process != null) {
					process.destroy();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
