package other.activity.res.layout

import java.lang.StringBuilder
/**

 * @Author hubert

 * @Date 2022/5/1 12:51 下午

 */

fun createActivityXml(
    packageName: String,
    activityClass: String,
    hasNavigation:Boolean
):String{
    val sb = StringBuilder()
    sb.append( """
        <?xml version="1.0" encoding="utf-8"?>
        <LinearLayout
            xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            tools:context="${packageName}.${activityClass}Activity">
        """)
    if(hasNavigation){
        sb.append("""
            <com.necer.basic2.view.Navigation
           android:id="@+id/navigation"
           android:layout_width="match_parent"
           android:layout_height="wrap_content"/>
        """)
    }
    sb.append("""
        </LinearLayout>
    """)
    return sb.toString().trim()
}