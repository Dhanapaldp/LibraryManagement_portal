package daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataTransferObjects.Book;
import dataTransferObjects.Librarian;
import util.JdbcUtil;

public class LibrarianDaoImpl implements ILibrarianDao {

	Connection connection=null;
	PreparedStatement pst=null;
	ResultSet resultSet=null;
	Librarian librarian=null;
	@Override
	public String addLibrarian(Librarian librarian) {
		String myQuery="insert into elibrarian(lname,password,mobile) values(?,?,?)";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setString(1, librarian.getName());
				pst.setString(2,librarian.getPassword());
				pst.setLong(3, librarian.getMobile());
				
				int rows = pst.executeUpdate();
				
				if(rows==1)
					return "success";
				
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}

	@Override
	public Librarian searchLibrarian(Integer id) {
		
		String myQuery="select * from elibrarian where lid=?";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setInt(1,id);
				
				resultSet = pst.executeQuery();
			}
			if(resultSet!=null)
			{
				
				librarian =new Librarian();
					if(resultSet.next())
					{
						librarian.setId(resultSet.getInt(1));
					    librarian.setName(resultSet.getString(2));
				        librarian.setPassword(resultSet.getString(3));
					    librarian.setMobile(resultSet.getLong(4));
					    return librarian;
					}else {
						return null;
					}
				
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return null;
		
	}

	@Override
	public String updateLibrarian(Librarian librarian) {
		String myQuery="update elibrarian set lname=?,password=?,mobile=? where lid=?";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setString(1, librarian.getName());
				pst.setString(2,librarian.getPassword());
				pst.setLong(3, librarian.getMobile());
				pst.setInt(4, librarian.getId());
				
				int rows = pst.executeUpdate();
				
				if(rows==1)
					return "success";
				
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}

	@Override
	public String deleteLibrarian(Integer id) {
		String myQuery="delete from elibrarian where lid=?";
		try {
			connection =JdbcUtil.getConnect();
			
			if(connection !=null)
			{
				pst=connection.prepareStatement(myQuery);
			}
			if(pst!= null)
			{
				pst.setInt(1, id);
				
				int rows = pst.executeUpdate();
				
				if(rows==1)
					return "success";
				
			}
		} catch (SQLException | IOException e) {
			e.getMessage();
		}
		return "failure";
	}

	public boolean authenticate(Integer lid,String password){
		boolean status=false;
		try{
			connection =JdbcUtil.getConnect();
			PreparedStatement ps=connection.prepareStatement("select * from elibrarian where lid=? and password=?");
			ps.setInt(1,lid);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			connection.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}
