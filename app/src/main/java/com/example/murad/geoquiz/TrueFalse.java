package com.example.murad.geoquiz;

public class TrueFalse {

    public int mQuestion;
    public int getQuestion() {return mQuestion;}
    public void setQuestion(int question) {mQuestion = question;}


    public boolean mTrueQuestion;
    public boolean isTrueQuestion() {return mTrueQuestion;}
    public void setTrueQuestion(boolean trueQuestion) {mTrueQuestion = trueQuestion;}




    public TrueFalse(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;}

}
