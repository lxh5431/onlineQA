package entity;

public class Selecter {
	private int qseq;//����ѡ��ѡ��
	private int oid;//����id
	private int selseq;//ѡ��
	private String content;
	private String remark;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public int getQseq() {
		return qseq;
	}
	public void setQseq(int qseq) {
		this.qseq = qseq;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSelseq() {
		return selseq;
	}
	public void setSelseq(int selseq) {
		this.selseq = selseq;
	}
	

}
