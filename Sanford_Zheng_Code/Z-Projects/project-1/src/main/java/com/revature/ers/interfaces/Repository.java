package com.revature.ers.interfaces;

import java.util.List;

public interface Repository<T> {
	public boolean create(T newItem);
	public T read(Integer itemId);
	public List<T> readAll();
	public T update(Integer itemId, T newItem);
	public boolean delete(T item);
}
