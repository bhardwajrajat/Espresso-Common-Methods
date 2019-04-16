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

class ClickXY {

    /**
     * clickXY(coordinateX, coordinateY) : Used to generate clicks on XY coordinates on the app screen.
     * @author rbhardwaj
     * @date 09/13/18
     */

    int[] screenPos = new int[3];
    float[] retArray= new float[2];

    public ViewAction clickXY(final int x, final int y){
        return new GeneralClickAction (
                Tap.SINGLE,
                new CoordinatesProvider () {
                    @Override
                    public float[] calculateCoordinates(View view) {

                        view.getLocationOnScreen(screenPos);

                        float screenX;
                        int a = screenPos[0];
                        screenX = a + x;
                        float screenY;
                        int b = screenPos[1];
                        screenY = b + y;
                        retArray[0] = screenX;
                        retArray[1] = screenY;
                        return retArray;
                    }
                },
                Press.FINGER);
    }
}