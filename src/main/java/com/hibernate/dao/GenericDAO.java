package com.hibernate.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public void userInsert(T t);

    public List<T> userView();
    
    public void userUpdate(T t);
    
    public void userDelete(int id);
    
    public T userById(int id);

  
}
