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

class SwipeTo {


    fun swipeToTop(): ViewAction {
        return GeneralSwipeAction(Swipe.FAST, GeneralLocation.CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER)
    }
}