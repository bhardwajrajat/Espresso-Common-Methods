package com.pretlist.maxwell.app.qa_group.Test

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import com.facebook.testing.screenshot.Screenshot
import com.pretlist.maxwell.app.group.EditGroupScreen
import com.pretlist.maxwell.app.group.EnterNameScreen
import com.pretlist.maxwell.app.qa_group.Screen.GroupInfoScreen
import com.pretlist.maxwell.app.utility.InstrumentationUtility
import com.pretlist.maxwell.common.utils.GroupType
import com.pretlist.maxwell.database.RoomMaxwellDatabase
import com.pretlist.maxwell.database.entity.RoomGroupEntity
import com.pretlist.maxwell.database.entity.RoomParticipantsEntity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.koin.standalone.get

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class NthChildOf {

    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("with $childPosition child view of type parentMatcher")
            }

            override fun matchesSafely(view: View): Boolean {
                if (view.getParent() !is ViewGroup) {
                    return parentMatcher.matches(view.getParent())
                }

                val group = view.getParent() as ViewGroup
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition) == view
            }
        }
    }
}