package or.vo;

public class ReplyVo {

	int ic_num, ib_num, p_num;
	String ic_comm, ic_date;
	String p_nickname;
	
	public String getP_nickname() {
		return p_nickname; 
	}
	public void setP_nickname(String p_nickname) {
		this.p_nickname = p_nickname;
	}
	public int getIc_num() {  
		return ic_num;
	}
	public void setIc_num(int ic_num) {
		this.ic_num = ic_num;
	}
	public int getIb_num() {
		return ib_num;
	}
	public void setIb_num(int ib_num) {
		this.ib_num = ib_num;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getIc_comm() { 
		return ic_comm;
	}
	public void setIc_comm(String ic_comm) {
		this.ic_comm = ic_comm;
	}
	public String getIc_date() {
		return ic_date;
	}
	public void setIc_date(String ic_date) {
		this.ic_date = ic_date;
	}
	@Override
	public String toString() {
		return "ReplyVo [ic_num=" + ic_num + ", ib_num=" + ib_num + ", p_num=" + p_num + ", ic_comm=" + ic_comm
				+ ", ic_date=" + ic_date + "]";
	}
	
	
}
