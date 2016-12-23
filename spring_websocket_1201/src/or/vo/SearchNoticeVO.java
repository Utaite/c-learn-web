package or.vo;

public class SearchNoticeVO {
	private String searchValue, searchType;
	private int start, end, nowPage;
	private int n_num, n_hit, n_fix;
	private String n_sub, n_cont, n_date;
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
	public int getN_num() {
		return n_num;
	}
	public void setN_num(int n_num) {
		this.n_num = n_num;
	}
	public int getN_hit() {
		return n_hit;
	}
	public void setN_hit(int n_hit) {
		this.n_hit = n_hit;
	}
	public int getN_fix() {
		return n_fix;
	}
	public void setN_fix(int n_fix) {
		this.n_fix = n_fix;
	}
	public String getN_sub() {
		return n_sub;
	}
	public void setN_sub(String n_sub) {
		this.n_sub = n_sub;
	}
	public String getN_cont() {
		return n_cont;
	}
	public void setN_cont(String n_cont) {
		this.n_cont = n_cont;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	public SearchNoticeVO(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public SearchNoticeVO(String searchValue, String searchType, int start, int end) {
		this.searchValue = searchValue;
		this.searchType = searchType;
		this.start = start;
		this.end = end;
	}
	public SearchNoticeVO() {
	}
	
	
}
