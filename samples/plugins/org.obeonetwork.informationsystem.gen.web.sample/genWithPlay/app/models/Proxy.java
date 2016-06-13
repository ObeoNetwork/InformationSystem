package models;


public class Proxy {

	private Long id;
	
	private String desc;
	

	
	public Proxy(Long id, String desc) {

		super();
		
		this.id = id;
		this.desc = desc;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}

}
