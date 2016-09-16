package entity;

import java.sql.Timestamp;

public class Replay {
	
	private int replayId; // 回复者ID
	private String replayCode;// 回复形式
	private String replayIp;// 回复者ip
	private int oId;// 主题id
	private Timestamp replayTime;//回复时间
	private String remark;//备忘录
	public int getReplayId() {
		return replayId;
	}
	public void setReplayId(int replayId) {
		this.replayId = replayId;
	}
	public String getReplayCode() {
		return replayCode;
	}
	public void setReplayCode(String replayCode) {
		this.replayCode = replayCode;
	}
	public String getReplayIp() {
		return replayIp;
	}
	public void setReplayIp(String replayIp) {
		this.replayIp = replayIp;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public Timestamp getReplayTime() {
		return replayTime;
	}
	public void setReplayTime(Timestamp replayTime) {
		this.replayTime = replayTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
