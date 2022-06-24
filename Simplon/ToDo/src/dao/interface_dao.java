package dao;

import java.util.Set;


public interface interface_dao<T> {
	
	public boolean insert(T item);
	
	public Set<T> select();
	
	public boolean update(T item);
	
	public void delete(T item); 
}
