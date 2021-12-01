package com.tonyvx.generics.array_sorter;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArraySorterApplication {

	public static void main(String[] args) throws Exception {
		Scanner myObj = new Scanner(System.in);

		System.out.println("enter comma seperated values");

		// String input
		String str = myObj.nextLine();

		System.out.println(str);

		boolean stringList = Arrays.asList(str.split(",")).stream().anyMatch((val) -> {
			try {
				Integer.parseInt(val);
			} catch (Exception e) {
				return true;
			}
			return false;
		});
		
		Sorter sorter = new Sorter() {
			@Override
			protected <String> boolean compare(String a, String b) {
				try {
					return stringList ? a.toString().compareTo(b.toString()) > 0
							: Integer.parseInt(a.toString()) > Integer.parseInt(b.toString());
				} catch (Exception e) {
					return false;
				}
			}
		};
		System.out.println(String.join(",", sorter.sort(str.split(","))));
	}

}
