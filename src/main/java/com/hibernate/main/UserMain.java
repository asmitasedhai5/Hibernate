package com.hibernate.main;

import java.util.Scanner;

import com.hibernate.view.UserView;

public class UserMain {
	
	public static void main(String args[]){
		String cont;
		do {
            Scanner scan = new Scanner(System.in);
            System.out.println("1. Insert User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println(" Enter your choice");
            switch (scan.nextInt()) {
                case 1:
                    new UserView().insert();
                    break;
                case 2:
                    new UserView().view();
                    break;
                case 3:
                	new UserView().edit();
                	break;
                case 4:
                	new UserView().delete();
                	break;
               
                default:
                    System.out.println("Invalid Choice");
                    break;

            }
            System.out.println("Continue(Y/y)");
            cont = scan.next();
            if (!cont.equalsIgnoreCase("y")){
                System.exit(0);
            }
        } while (cont.equalsIgnoreCase("y"));
		
	}
}
	