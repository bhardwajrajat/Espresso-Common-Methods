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

class ZSample {

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

    fun swipeToTop(): ViewAction {
        return GeneralSwipeAction(Swipe.FAST, GeneralLocation.CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER)
    }

    fun takeScreenShotOfCurrentActivity(screenShotName: String) {
        val currentActivity = InstrumentationUtility.currentActivityInstance()
        val screenshot = Screenshot.snapActivity(currentActivity)
        screenshot.setName(screenShotName)
        screenshot.record()
    }

    /**
     * clickXY(coordinateX, coordinateY) : Used to generate clicks on XY coordinates on the app screen.
     * @param ch [Channel]
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


    public class RecyclerViewItemCountAssertion implements ViewAssertion {
       private final int expectedCount;

       public RecyclerViewItemCountAssertion(int expectedCount) {
           this.expectedCount = expectedCount;
       }

       @Override
       public void check(View view, NoMatchingViewException noViewFoundException) {
           if (noViewFoundException != null) {
               throw noViewFoundException;
           }

           RecyclerView recyclerView = (RecyclerView) view;
           RecyclerView.Adapter adapter = recyclerView.getAdapter();
           assertThat(adapter.getItemCount(), is(expectedCount));
       }
   }

}