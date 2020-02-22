package com.example.ma1;

public class CountryItem {

    private String mCountryname ;
    private  int mflagImage ;

    public CountryItem(String mCountryname, int mflagImage) {
        this.mCountryname = mCountryname;
        this.mflagImage = mflagImage;
    }

    public String getmCountryname() {
        return mCountryname;
    }

    public int getMflagImage() {
        return mflagImage;
    }

    public void setmCountryname(String mCountryname) {
        this.mCountryname = mCountryname;
    }

    public void setMflagImage(int mflagImage) {
        this.mflagImage = mflagImage;
    }
}
