package other.fragment.src.app_package

import java.lang.StringBuilder

/**

 * @Author hubert

 * @Date 2022/5/1 12:57 下午

 */

fun createFragmentKt(
    applicationPackage: String?,
    packageName: String,
    fragmentClass: String,
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

class ${fragmentClass}Fragment : BaseActivity() {
   

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