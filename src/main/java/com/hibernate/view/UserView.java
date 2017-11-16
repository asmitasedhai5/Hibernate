package com.hibernate.view;

import java.util.Scanner;

import com.hibernate.dao.UserDAO;
import com.hibernate.dao.impl.UserDAOImpl;
import com.hibernate.entity.User;

public class UserView {
	
	Scanner scan = new Scanner(System.in);
	public static int userId;
	
	UserDAO ud = new UserDAOImpl();
	
	
	public void insert(){
		System.out.println("Enter firstname");
        String fname = scan.next();
        System.out.println("Enter lastname");
        String lname = scan.next();
        System.out.println("Enter address");
        String address = scan.next();
        System.out.println("Enter contact no");
        String contactNo = scan.next();
        User u = new User(fname,lname,address,contactNo);
        ud.userInsert(u);
	}
	
	public void view(){
		ud.userView().forEach((user) -> {
            System.out.println(user.toString());
        });
	}
	
	public void update(){
		System.out.println("Enter firstname");
        String fname = scan.next();
        System.out.println("Enter lastname");
        String lname = scan.next();
        System.out.println("Enter contact");
        String contactNo = scan.next();
        System.out.println("Enter address");
        String address = scan.next();
        User u = new User(fname,lname,address,contactNo);
        ud.userUpdate(u);
	}
	
	 public void edit() {
		System.out.println("Enter the id to which you want to update: ");
		userId = scan.nextInt();
		User user = ud.userById(userId);
	        if (user != null) {
	            System.out.println(user.toString());
	            update();
	        } else {
	            System.out.println("User with userID " + userId + " not found");
	        }
	    }
	
	public void delete(){
		System.out.println("Enter id to delete: ");
		ud.userDelete(scan.nextInt());
	}

}
