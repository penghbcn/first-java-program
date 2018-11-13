package yohm.web.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能简述 (newsList)
 *
 * @author tarena
 * @date 2018/8/16
 * @since 1.0.0
 */
public class News implements Serializable {
	private static final long serialVersionUID = 233L;
	private String newsId;
	private String title;
	private String url;
	private String covers;
	private String source;
	private String pDate;
	private String keywords;
	private String descId;
	private String channel;
	private Date created;

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCovers() {
		return covers;
	}

	public void setCovers(String covers) {
		this.covers = covers;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPDate() {
		return pDate;
	}

	public void setPDate(String pDate) {
		this.pDate = pDate;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescId() {
		return descId;
	}

	public void setDescId(String descId) {
		this.descId = descId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", url=" + url + ", covers=" + covers + ", source="
				+ source + ", pDate=" + pDate + ", keywords=" + keywords + ", descId=" + descId + ", channel=" + channel
				+ ", created=" + created + "]";
	}

}
