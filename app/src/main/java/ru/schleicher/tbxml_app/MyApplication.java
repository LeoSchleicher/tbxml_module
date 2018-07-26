package ru.schleicher.tbxml_app;

import android.app.Application;
import android.util.Log;

import ru.schleicher.tbxml.TBXML;

/**
 * Created by leonidschleicher on 26.07.18.
 */

public class MyApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("app", "created");
		
		TBXML tbxml = new TBXML();
		try {
			tbxml.parse("<root><a/><b/><c/></root>");
			long root = tbxml.rootXMLElement();
			long[] nodes = tbxml.listElementsForQuery("*", root);
			for (long n : nodes) {
				String name = tbxml.elementName(n);
				Log.d("app", name);
			}
			
		} catch (TBXML.TBXMLException e) {
			e.printStackTrace();
			
		} finally {
			tbxml.release();
		}
	}
}
