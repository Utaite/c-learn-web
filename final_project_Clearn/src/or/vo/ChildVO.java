package or.vo;

import org.springframework.web.multipart.MultipartFile;

public class ChildVO {
	private int c_num,c_age,p_num;
	private String c_name,c_gender,c_img,c_birth;
	private MultipartFile c_pic;
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public int getC_age() {
		return c_age;
	}
	public void setC_age(int c_age) {
		this.c_age = c_age;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_gender() {
		return c_gender;
	}
	public void setC_gender(String c_gender) {
		this.c_gender = c_gender;
	}
	public String getC_birth() {
		return c_birth;
	}
	public void setC_birth(String c_birth) {
		this.c_birth = c_birth;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public MultipartFile getC_pic() {
		return c_pic;
	}
	public void setC_pic(MultipartFile c_pic) {
		this.c_pic = c_pic;
	}
	

	
}
