package yohm.web.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 功能简述 (JS与后台交互使用的临时对象)
 *
 * @author tarena
 * @date 2018/8/14
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysResult implements Serializable {

	// 200:成功
	// 201:失败
	// 400：参数错误
	private Integer status;
	private String msg;
	private Object data;

	public SysResult() {
	}

	public SysResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public SysResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public static SysResult ok() {
		return new SysResult(null);
	}

	public static SysResult ok(Object data) {
		return new SysResult(data);
	}

	public static SysResult build(Integer status, String msg) {
		return new SysResult(status, msg, null);
	}

	public static SysResult build(Integer status, String msg, Object data) {
		return new SysResult(status, msg, data);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SysResult{" + "status=" + status + ", msg='" + msg + '\'' + ", data=" + data + '}';
	}
}
