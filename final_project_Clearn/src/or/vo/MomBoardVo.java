package or.vo;

public class MomBoardVo {
	private String searchValue, searchType;
	private int start, end, nowPage;
	private int ib_num, ib_hit, ib_recom, p_num;
	private String ib_sub, ib_cont, ib_date, p_id, p_name;

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

	public int getIb_num() {
		return ib_num;
	}

	public void setIb_num(int ib_num) {
		this.ib_num = ib_num;
	}

	public int getIb_hit() {
		return ib_hit;
	}

	public void setIb_hit(int ib_hit) {
		this.ib_hit = ib_hit;
	}

	public int getIb_recom() {
		return ib_recom;
	}

	public void setIb_recom(int ib_recom) {
		this.ib_recom = ib_recom;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getIb_sub() {
		return ib_sub;
	}

	public void setIb_sub(String ib_sub) {
		this.ib_sub = ib_sub;
	}

	public String getIb_cont() {
		return ib_cont;
	}

	public void setIb_cont(String ib_cont) {
		this.ib_cont = ib_cont;
	}

	public String getIb_date() {
		return ib_date;
	}

	public void setIb_date(String ib_date) {
		this.ib_date = ib_date;
	}

	public MomBoardVo(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public MomBoardVo(String searchValue, String searchType, int start, int end) {
		this.searchValue = searchValue; 
		this.searchType = searchType;
		this.start = start;
		this.end = end; 
	}
 
	public MomBoardVo() {
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

}
