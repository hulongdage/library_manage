package com.library.entity;

public class Readertype {
    private Integer readertypeid;

    private String readertypename;

    private Integer maxborrownum;

    private Integer booklimit;

    public Integer getReadertypeid() {
        return readertypeid;
    }

    public void setReadertypeid(Integer readertypeid) {
        this.readertypeid = readertypeid;
    }

    public String getReadertypename() {
        return readertypename;
    }

    public void setReadertypename(String readertypename) {
        this.readertypename = readertypename == null ? null : readertypename.trim();
    }

    public Integer getMaxborrownum() {
        return maxborrownum;
    }

    public void setMaxborrownum(Integer maxborrownum) {
        this.maxborrownum = maxborrownum;
    }

    public Integer getBooklimit() {
        return booklimit;
    }

    public void setBooklimit(Integer booklimit) {
        this.booklimit = booklimit;
    }

	@Override
	public String toString() {
		return "Readertype [readertypeid=" + readertypeid + ", readertypename=" + readertypename + ", maxborrownum="
				+ maxborrownum + ", booklimit=" + booklimit + "]";
	}
    
}