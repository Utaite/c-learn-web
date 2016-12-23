package or.clearn.service;

public class Paging {
	private String pagingCode; // set/get추가하기
	public Paging(int totalRecord, int nowPage,
			int numPerPage, int numPerBlock, String url){
		int totalPage = (int) Math.ceil(
				(double) totalRecord / numPerPage);
		int totalBlock = (int) Math.ceil(
				(double) totalPage/numPerBlock);
		int nowBlock = (int) Math.ceil((double) nowPage/numPerBlock);
		StringBuffer prev = new StringBuffer();
		StringBuffer next = new StringBuffer();
		StringBuffer paging = new StringBuffer();
		
		if(nowBlock > 1){
			prev.append("<a href='").append(url);
			prev.append("?nowPAge=").append((nowBlock - 2) * numPerBlock + 1);
			prev.append("'>◁</a>&nbsp;&nbsp;");
		}else{
			prev.append("◁&nbsp;&nbsp;");
		}
		
		for(int i = 0; i < numPerBlock; i++){
			int printPage = ((nowBlock -1) * numPerBlock) + i + 1;
			
			if(printPage == nowPage) {
				// [1] [2] 3 [4] [5]
				paging.append("<font color='olive'>");
				paging.append(printPage).append("</font>");
			}else{
				paging.append("<a href='").append(url);
				paging.append("?nowPage=");
				paging.append(printPage).append("'>");
				paging.append(printPage).append("</a>&nbsp;&nbsp;");
			}
			if(printPage == totalPage){
				break;
			}
		}
		if(totalBlock > nowBlock){
			next.append("<a href='").append(url);
			next.append("?nowPage=").append(nowBlock * numPerBlock + 1);
			next.append(">▷").append("</a>");
		}else{
			next.append("&nbsp;&nbsp;▷");
		}
		pagingCode = prev.toString() + paging.toString() + next.toString();
	}
	
	
	
	public Paging(int totalRecord, int nowPage,
			int numPerPage, int numPerBlock, String url, String searchType, String searchValue){
		int totalPage = (int) Math.ceil(
				(double) totalRecord / numPerPage);
		int totalBlock = (int) Math.ceil(
				(double) totalPage/numPerBlock);
		int nowBlock = (int) Math.ceil((double) nowPage/numPerBlock);
		StringBuffer prev = new StringBuffer();
		StringBuffer next = new StringBuffer();
		StringBuffer paging = new StringBuffer();
		
		if(nowBlock > 1){
			prev.append("<a href='").append(url);
			prev.append("?nowPAge=").append((nowBlock - 2) * numPerBlock + 1);
			prev.append("&searchType=").append(searchType);
			prev.append("&searchValue=").append(searchValue);
			prev.append("'>◁</a>&nbsp;&nbsp;");
		}else{
			prev.append("◁&nbsp;&nbsp;");
		}
		
		for(int i = 0; i < numPerBlock; i++){
			int printPage = ((nowBlock -1) * numPerBlock) + i + 1;
			
			if(printPage == nowPage) {
				// [1] [2] 3 [4] [5]
				paging.append("<font color='olive'>");
				paging.append(printPage).append("</font>");
			}else{
				paging.append("<a href='").append(url);
				paging.append("?nowPage=");
				paging.append(printPage).append("&searchType=").append(searchType);
				paging.append("&searchValue=").append(searchValue).append("'>");
				paging.append(printPage).append("</a>&nbsp;&nbsp;");
			}
			if(printPage == totalPage){
				break;
			}
		}
		if(totalBlock > nowBlock){
			next.append("<a href='").append(url);
			next.append("?nowPage=").append(nowBlock * numPerBlock + 1);
			next.append("&searchType=").append(searchType);
			next.append("&searchValue=").append(searchValue);
			next.append(">▷").append("</a>");
		}else{
			next.append("&nbsp;&nbsp;▷");
		}
		pagingCode = prev.toString() + paging.toString() + next.toString();
	}
	
	
	
	
	
	
	public String getPagingCode() {
		return pagingCode;
	}
	public void setPagingCode(String pagingCode) {
		this.pagingCode = pagingCode;
	}

}
