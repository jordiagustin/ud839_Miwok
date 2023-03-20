/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
// import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Obrir nova activity fent clic sobre una textview;
    TextView numbersTv; //Declarem la TextView
    TextView familyMembersTv;
    TextView colorsTv;
    TextView phrasesTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Associem la TextView al nostre layout
        numbersTv = (TextView) findViewById(R.id.numbers);
        familyMembersTv = (TextView) findViewById(R.id.family);
        colorsTv = (TextView) findViewById(R.id.colors);
        phrasesTv = (TextView) findViewById(R.id.phrases);

        //Afegim el listener la nostra TextView que actuarà com a botó
        numbersTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumbersList();
            }
        });

        familyMembersTv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openFamilyMembersList();
            }
        });

        colorsTv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openColorsList();
            }
        });

        phrasesTv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhrasesList();            }
        });
    }

    //Creem el mètode que obre la activity
    public void openNumbersList(){
        Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
        startActivity(numbersIntent);
    }

    public void openFamilyMembersList(){
        Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
        startActivity(familyIntent);
    }

    public void openColorsList(){
        Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
        startActivity(colorsIntent);
    }

    public void openPhrasesList(){
        Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
        startActivity(phrasesIntent);
    }
}
