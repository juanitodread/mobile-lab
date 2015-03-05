/**
 * GeoQuiz
 *
 * Copyright 2015 juanitodread
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.juanitodread.mobile.android.geoquiz;

import org.juanitodread.mobile.android.geoquiz.model.Question;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the main activity
 * 
 * @author juanitodread
 * @version 1.0
 * 
 *          Feb 18, 2015
 */
public class QuizActivity extends ActionBarActivity {

    private Button      mTrueButton;
    private Button      mFalseButton;
    private Button      mNextButton;
    private TextView    mQuestionTextView;

    private int         mCurrentIndex = 0;

    private Question[ ] mQuestionBank = new Question[ ] {
            new Question( R.string.question_oceans, true ),
            new Question( R.string.question_mideast, false ),
            new Question( R.string.question_africa, false ),
            new Question( R.string.question_americas, true ),
            new Question( R.string.question_asia, true ) };

    private void updateQuestion( ) {
        int question = mQuestionBank[ mCurrentIndex ].getQuestion( );
        mQuestionTextView.setText( question );
    }
    
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion( );
        int msgResId = 0;
        
        if(userPressedTrue == answerIsTrue) {
            msgResId = R.string.correct_toast;
        } else {
            msgResId = R.string.incorrect_toast;
        }
        
        Toast.makeText( this, msgResId, Toast.LENGTH_SHORT ).show( );
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_quiz );

        mQuestionTextView = ( TextView ) findViewById( R.id.question_text_view );

        mTrueButton = ( Button ) findViewById( R.id.true_button );
        mTrueButton.setOnClickListener( new View.OnClickListener( ) {
            /*
             * (non-Javadoc)
             * 
             * @see android.view.View.OnClickListener#onClick(android.view.View)
             */
            @Override
            public void onClick( View v ) {
                checkAnswer( true );
            }
        } );

        mFalseButton = ( Button ) findViewById( R.id.false_button );
        mFalseButton.setOnClickListener( new View.OnClickListener( ) {
            /*
             * (non-Javadoc)
             * 
             * @see android.view.View.OnClickListener#onClick(android.view.View)
             */
            @Override
            public void onClick( View v ) {
                checkAnswer( false );
            }
        } );

        mNextButton = ( Button ) findViewById( R.id.next_button );
        mNextButton.setOnClickListener( new View.OnClickListener( ) {

            @Override
            public void onClick( View v ) {
                mCurrentIndex = ( mCurrentIndex + 1 ) % mQuestionBank.length;
                updateQuestion( );
            }
        } );

        updateQuestion( );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater( ).inflate( R.menu.quiz, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId( );
        if ( id == R.id.action_settings ) {
            return true;
        }
        return super.onOptionsItemSelected( item );
    }
}
