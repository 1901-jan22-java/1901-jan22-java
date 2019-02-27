package com.revature.interfaces;

import java.util.List;

public interface DAOInterface<T> {
	
	public T create(T newItem);
	public T read(Integer itemId);
	public List<T> readAll();
	public T update(Integer itemId, T newItem);
	public T delete(T item);
	
}
