package or.vo;

import java.util.List;

public class ChapEnrollVO {
	int ch_num, ct_num, ch_time;
	String ch_sub, ch_file;
	List<ChapEnrollVO> list;

	public List<ChapEnrollVO> getList() {
		return list;
	}

	public void setList(List<ChapEnrollVO> list) {
		this.list = list;
	}

	public int getCh_num() {
		return ch_num;
	}
 
	public void setCh_num(int ch_num) {
		this.ch_num = ch_num;
	} 

	public int getCt_num() {
		return ct_num;
	} 

	public void setCt_num(int ct_num) {
		this.ct_num = ct_num;
	}

	// 강의시간
	public int getCh_time() {
		return ch_time;
	}

	public void setCh_time(int ch_time) {
		this.ch_time = ch_time;
	}

	public String getCh_sub() {
		return ch_sub;
	}

	public void setCh_sub(String ch_sub) {
		this.ch_sub = ch_sub;
	}

	public String getCh_file() {
		return ch_file;
	}

	public void setCh_file(String ch_file) {
		this.ch_file = ch_file;
	}  


}
