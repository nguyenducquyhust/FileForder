package com.bksoftware.forder;

import java.io.File;
import java.util.Date;

public class Forder {
	public static void main(String[] args) {
		File path = new File("D:\\test");
		System.out.printf("%-50s|%-40s|%-10s|%-20s|%n", "Name", "Modifiled Date", "Size", "Type");
		getChild(path, 0);
	}

	private static void getChild(File file, int level) {
		if (file.isDirectory()) {
			System.out.printf("%-50s", getPadding(level) + " - " + file.getName());
			getInforFileAndForder(file);
			File[] children = file.listFiles();
			for (File child : children) {
				getChild(child, level + 1);
			}
		} else if (file.isFile()) {
			System.out.printf("%-50s", getPadding(level) + " + " + file.getName());
			getInforFileAndForder(file);
		}
	}

	public static void getInforFileAndForder(File file) {
		String type = "File Forder";
		if (file.getName().endsWith(".txt")) {
			type = "Text Document";
		} else if (file.getName().endsWith(".zip")) {
			type = "WinRar Zip";
		} else if (file.getName().endsWith(".jar")) {
			type = "WinRar jar";
		} else if (file.getName().endsWith(".exe")) {
			type = "Application";
		}
		if (file.exists()) {
			long lastMofifyInMillis = file.lastModified();
			Date lastModifyDate = new Date(lastMofifyInMillis);
			System.out.printf("|%-40s|%-10s|%-30s|%n", lastModifyDate, file.length(), type);
		}
	}

	private static String getPadding(int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= level; i++) {
			sb.append("    ");
		}
		return sb.toString();
	}
}
