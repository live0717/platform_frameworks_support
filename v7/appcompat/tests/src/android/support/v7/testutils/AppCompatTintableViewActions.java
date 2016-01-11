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

package android.support.v7.testutils;

import android.content.res.ColorStateList;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static org.hamcrest.core.AllOf.allOf;

public class AppCompatTintableViewActions {
    /**
     * Sets enabled state on a <code>View</code> that implements the
     * <code>TintableBackgroundView</code> interface.
     */
    public static ViewAction setEnabled(final boolean enabled) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayingAtLeast(90), TestUtilsMatchers.isTintableBackgroundView());
            }

            @Override
            public String getDescription() {
                return "set enabled";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadUntilIdle();

                view.setEnabled(enabled);

                uiController.loopMainThreadUntilIdle();
            }
        };
    }

    /**
     * Sets the passed color state list as the background layer on a <code>View</code> that
     * implements the <code>TintableBackgroundView</code> interface.
     */
    public static ViewAction setBackgroundTintList(final ColorStateList colorStateList) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayingAtLeast(90), TestUtilsMatchers.isTintableBackgroundView());
            }

            @Override
            public String getDescription() {
                return "set background tint list";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadUntilIdle();

                TintableBackgroundView tintableBackgroundView = (TintableBackgroundView) view;
                tintableBackgroundView.setSupportBackgroundTintList(colorStateList);

                uiController.loopMainThreadUntilIdle();
            }
        };
    }
}
