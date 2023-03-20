package com.example.android.miwok;

/**
 * {@Link Word} Represents a word in certain language a user wants to learn
 * Contains a default word language and it's translation
 */
public class Word {

    /** Default language for the word */
    private String mDefaultLanguage;

    /** Miwok language for the word */
    private String mMiwokLanguage;

    /**
     * Constructor to create a new word object
     *
     * @param defaultLanguage
     * @param miwokLanguage
     */
    public Word(String defaultLanguage, String miwokLanguage){
        mDefaultLanguage = defaultLanguage;
        mMiwokLanguage = miwokLanguage;
    }

    /**
     * Get Default language of the word
     */
    public String getDefaultLanguage(){
        return mDefaultLanguage;
    }

    /**
     * Get miwok language of the word
     */
    public String getMiwokLanguage(){
        return mMiwokLanguage;
    }
}
