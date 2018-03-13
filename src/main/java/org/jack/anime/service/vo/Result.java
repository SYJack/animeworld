/**
 * 
 */
package org.jack.anime.service.vo;

/**
 * 
 * 封装json对象，所有返回结果都使用它
 * @author jack
 *
 */
public class Result<T> {
	
	private boolean success;// 是否成功标志

	private T data;// 成功时返回的数据

	private String error;// 错误信息

	
	public Result() {
	}

	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public Result(T data, String error) {
		this.data = data;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
