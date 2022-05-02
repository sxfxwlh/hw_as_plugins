package other.activity.src.app_package

import java.lang.StringBuilder

/**

 * @Author hubert

 * @Date 2022/5/1 12:57 下午

 */

fun createActivityKt(
    applicationPackage: String?,
    packageName: String,
    activityClass: String,
    layoutName: String,
    hasNavigation: Boolean
):String{
    val sb = StringBuilder()
    sb.append("""
package $packageName

import android.os.Bundle
import ${applicationPackage}.R
import com.necer.basic2.ui.BaseActivity
import kotlinx.android.synthetic.main.${layoutName}.*

class ${activityClass}Activity : BaseActivity() {
   

    override fun getLayoutId()=R.layout.${layoutName}

    override fun onCreatee(savedInstanceState: Bundle?) {
      """)
    if(hasNavigation){
        sb.append("""
             navigation.title("").left(true)
        """)
    }

    sb.append("""
        }
         override fun getNetData() {
        
         }
    }
    """)
    return sb.toString()
}