package com.demo.DAO;
import java.util.List;

import com.demo.Model.*;
public interface RegisterDAO {
	public void insertUser(RegisterVO reg);
	public List getData(RegisterVO registerVO);
	public void updateData(RegisterVO registerVO);
}
