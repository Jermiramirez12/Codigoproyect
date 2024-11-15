package dao;

import java.sql.SQLException;
import java.util.List;

import clases.Cipac;

public interface DAO<T> {
    void create(T t) throws SQLException;
    T read(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    void update(T t) throws SQLException;
    void delete(int id) throws SQLException;
	void create1(Cipac cipac);
}