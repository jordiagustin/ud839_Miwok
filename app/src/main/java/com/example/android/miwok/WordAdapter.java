package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/*
 * Creem aquesta classe que hereda d'Array Adapter per tal d'adaptar el nostre objecte word a la listview.
 * L'ArrayAdapter que ve predefinit per android no ens seveix i ens creem el nostre propi adapter per a la nostra classe Word
 * */

/*
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link AndroidFlavor} objects.
 * */
public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of words objects to display in a list
     */
    private ArrayList<Word> words;

    public WordAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        //La nostra classe WordAdapter hereda de Array Adapter, amb "super" cridem el seu constructor
        //Si mirem la documentació;
        // https://developer.android.com/reference/android/widget/ArrayAdapter.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics
        // veurem que en els diferents constructors que pot fer servir ArrayAdapter tenim el que li passem;
        // context, resource i la llista d'objectes (List<T> objects
        super(context, 0, words);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /**
         * Get the {@link Word} object located at this position in the list
         */
        Word currentAndroidWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the miwok translation
        TextView miwokWordTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the miwokWordTextView TextView
        miwokWordTextView.setText(currentAndroidWord.getMiwokLanguage());

        // Find the TextView in the list_item.xml layout with the miwok translation
        TextView defaultWordTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the miwokWordTextView TextView
        defaultWordTextView.setText(currentAndroidWord.getDefaultLanguage());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
