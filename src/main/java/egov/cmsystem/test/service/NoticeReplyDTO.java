package egov.cmsystem.test.service;

import java.sql.Date;
import java.time.LocalDate;

public class NoticeReplyDTO {
	
	private int replyNum;
	private int boardNum;
	private String replyName;
	private String replyPw;
	private String replyContents;
	private LocalDate replyDate;
	public LocalDate getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate.toLocalDate();
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public String getReplyPw() {
		return replyPw;
	}
	public void setReplyPw(String replyPw) {
		this.replyPw = replyPw;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	
	
	
}
