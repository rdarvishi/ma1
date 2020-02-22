public class CountryItem {

    private int mflag ;
    private String mname ;
    public CountryItem(String mname , int mflag){
        this.mname = mname ;
        this.mflag = mflag ;

    }

    public int getMflag() {
        return mflag;
    }

    public String getMname() {
        return mname;
    }

    public void setMflag(int mflag) {
        this.mflag = mflag;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
