package com.example.murad.geoquiz;

public class TrueFalse {

    public int mQuestion;
    public int getQuestion() {return mQuestion;}
    public void setQuestion(int question) {mQuestion = question;}


    public boolean mTrueQuestion;
    public boolean isTrueQuestion() {return mTrueQuestion;}
    public void setTrueQuestion(boolean trueQuestion) {mTrueQuestion = trueQuestion;}


    public boolean mIsCheater;
    public boolean isIsCheater() {return mIsCheater;}
    public void setIsCheater(boolean isCheater) {mIsCheater = isCheater;}






    public TrueFalse(int question, boolean trueQuestion, boolean isCheater) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mIsCheater = isCheater;}


}
