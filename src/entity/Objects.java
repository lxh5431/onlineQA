package entity;

import java.sql.Timestamp;

public class Objects {
    private int oid; //主题id
    private String title;//标题
    private String discribe;//描述
    private Timestamp createTime;//创建时间
    private String remark;
    private int state;
    private String anonymousFlag;//是否匿名
    
    public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Objects() {
    }

    public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setTitle(String title) {
        this.title = title;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscribe() {
        return discribe;
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAnonymousFlag() {
		return anonymousFlag;
	}

	public void setAnonymousFlag(String anonymousFlag) {
		this.anonymousFlag = anonymousFlag;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

   
}
