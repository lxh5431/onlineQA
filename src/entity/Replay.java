package entity;

import java.sql.Timestamp;

public class Replay {
	
	private int replayId; // �ظ���ID
	private String replayCode;// �ظ���ʽ
	private String replayIp;// �ظ���ip
	private int oId;// ����id
	private Timestamp replayTime;//�ظ�ʱ��
	private String remark;//����¼
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
