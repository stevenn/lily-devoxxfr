package com.sfeir.demo.devoxx.domain;

public enum ConferenceType {
    Conference(1), 
    Quickies(2), 
    BOF(3), 
    CodeStory(4), 
    Labs(5), 
    ToolsInAction(6), 
    University(7);
    
    private int code;
    
    private ConferenceType(int c) {
      code = c;
    }
    
    public int getConferenceType() {
      return code;
    }
}
