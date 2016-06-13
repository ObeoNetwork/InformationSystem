package models;

public class Stat {
	public Long res;
	public String desc;
	
	public Stat(Long res, String desc) {
		super();
		this.res = res;
		this.desc = desc;
	}
	
	public Long getRes() {
		return res;
	}
	public void setRes(Long res) {
		this.res = res;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
