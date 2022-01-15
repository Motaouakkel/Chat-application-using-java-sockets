package msgManagement;

import java.io.Serializable;

public class Msg implements Serializable {
	private int msgId;
	private String contentMsg;
	private int userId;
	private String sender;
	
	public Msg(int msgId, String contentMsg, int userId, String sender) {
		super();
		this.msgId = msgId;
		this.contentMsg = contentMsg;
		this.userId = userId;
		this.sender = sender;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getContentMsg() {
		return contentMsg;
	}

	public void setContentMsg(String contentMsg) {
		this.contentMsg = contentMsg;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "Msg [msgId=" + msgId + ", contentMsg=" + contentMsg + ", userId=" + userId + ", sender=" + sender + "]";
	}
	
	
}
