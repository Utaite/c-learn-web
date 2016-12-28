package or.vo;

public class SearchParentVO {
	private String searchValue, searchType;
	private int start, end, nowPage;
	private int p_num, r_num,v_num;
	private String p_id, p_pw, p_mail, p_phone, p_name;
	private String p_addr, p_pic, p_date, p_nickname, p_token;
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getV_num() {
		return v_num;
	}
	public void setV_num(int v_num) {
		this.v_num = v_num;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_pw() {
		return p_pw;
	}
	public void setP_pw(String p_pw) {
		this.p_pw = p_pw;
	}
	public String getP_mail() {
		return p_mail;
	}
	public void setP_mail(String p_mail) {
		this.p_mail = p_mail;
	}
	public String getP_phone() {
		return p_phone;
	}
	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_addr() {
		return p_addr;
	}
	public void setP_addr(String p_addr) {
		this.p_addr = p_addr;
	}
	public String getP_pic() {
		return p_pic;
	}
	public void setP_pic(String p_pic) {
		this.p_pic = p_pic;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public String getP_nickname() {
		return p_nickname;
	}
	public void setP_nickname(String p_nickname) {
		this.p_nickname = p_nickname;
	}
	public String getP_token() {
		return p_token;
	}
	public void setP_token(String p_token) {
		this.p_token = p_token;
	}
	public SearchParentVO(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public SearchParentVO(String searchValue, String searchType, int start, int end) {
		this.searchValue = searchValue;
		this.searchType = searchType;
		this.start = start;
		this.end = end;
	}
	public SearchParentVO() {
	}
	
}
