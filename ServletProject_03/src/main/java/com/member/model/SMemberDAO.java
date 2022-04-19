package com.member.model;

import java.util.ArrayList;



public interface SMemberDAO {
	public void memberJoin (SMemberDTO member);
	public ArrayList<SMemberDTO> getMember();
	public int memberDelete(String userid);
	public int memberUpdate(SMemberDTO member);
	public SMemberDTO findByID(String usetid);
	public int memberCount();
	public String memberIdCheck(String userid);
	public SMemberDTO memberLoginCheck(String userid,String pwd);
	
	
}
