package com.example.adminapp;

public class Userdata {

   public String mname;
    public String mnumber;
    public String mremarks;
   // public String rating;

    public String getMnumber() {
        return mnumber;
    }

    public String spinner;

    public void setMnumber(String mnumber) {
        this.mnumber = mnumber;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }

    public Userdata(String mname, String mnumber, String mremarks,  String spinner) {
        this.mname = mname;
        this.mnumber = mnumber;
        this.mremarks = mremarks;
       // this.rating = rating;
        this.spinner = spinner;
    }

    public Userdata() {
    }




    public void setMremarks(String mremarks) {
        this.mremarks = mremarks;
    }

   // public void setRating(String rating) {
   //     this.rating = rating;
  //  }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }

    public String getMname() {
        return mname;
    }

    public String getMremarks() {
        return mremarks;
    }

   //// public String getRating() {
    //    return rating;
   // }

    public String getSpinner() {
        return spinner;
    }


}
