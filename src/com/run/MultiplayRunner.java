package com.run;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiplayRunner {
	public void runMultiplayStorrage(String dirName){
		ExecutorService executor = Executors.newFixedThreadPool(10);
		File f = new File(dirName);
		File[] listFiles = f.listFiles(new DataFileFiler());
		for (File file : listFiles) {
			ListingStorageRunner runner = new ListingStorageRunner(file.getPath());
			executor.execute(runner);
		}
		executor.shutdown();
	}

	private class DataFileFiler implements FileFilter {
		@Override
		public boolean accept(File f) {
			if (f.getName().toLowerCase().endsWith(".xml")){
				return true;
			}
			return false;
		}
	}
}
