package com.revature.ers.services;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * I have no idea what to do here... TODO: Figure it out... Q.Q
 * 
 * @author Sanford
 *
 */
public class Receipt implements Blob {

	private String details;

	public Receipt(String details) {
		super();
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public void free() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public InputStream getBinaryStream() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getBinaryStream(long arg0, long arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getBytes(long arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long length() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long position(byte[] arg0, long arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long position(Blob arg0, long arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OutputStream setBinaryStream(long arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setBytes(long arg0, byte[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBytes(long arg0, byte[] arg1, int arg2, int arg3) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void truncate(long arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * When I figure out what this is I'll know what to do...
	 * 
	 */
	public Receipt clone() {
		return null;
	}
}
