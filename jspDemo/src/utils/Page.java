package utils;

import java.util.List;

/**
 * 姓名：龙吟
 * QQ：812779047
 */
public class Page<T> {
	
	// 当前页
	private int pageCode;
	
	// 总页数 = 总记录数/每页显示的记录的条数
	// private int totalPage;
	
	// 总记录数
	private int totalCount;
	// 每页显示的记录的条数
	private int pageSize;
	// 每页显示的数据
	private List<T> beanList;

	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	
	/**
	 * 获取总页数totalPage也是属性
	 * @return
	 */
	public int getTotalPage() {
		// 做计算，计算的结果直接返回给你
		int tp = totalCount / pageSize;
		// 说明整除，
		if(totalCount % pageSize == 0){
			return tp;
		}else{
			return tp+1;
		}
	}
	
	/*public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

}
