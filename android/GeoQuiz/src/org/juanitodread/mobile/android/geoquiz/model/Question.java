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
package org.juanitodread.mobile.android.geoquiz.model;

/**
 * This class represents a Question in the application.
 *
 * @author juanitodread
 * @version 1.0
 * 
 * Feb 18, 2015
 */
public class Question {

    private int question;

    private boolean trueQuestion;

    public Question( int question, boolean trueQuestion ) {
        this.question = question;
        this.trueQuestion = trueQuestion;
    }

    public int getQuestion( ) {
        return question;
    }

    public void setQuestion( int question ) {
        this.question = question;
    }

    public boolean isTrueQuestion( ) {
        return trueQuestion;
    }

    public void setTrueQuestion( boolean trueQuestion ) {
        this.trueQuestion = trueQuestion;
    }
}
