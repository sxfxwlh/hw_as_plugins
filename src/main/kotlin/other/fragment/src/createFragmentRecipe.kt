package other.fragment.src

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.fragment.res.layout.createFragmentXml
import other.fragment.src.app_package.createFragmentKt

/**

 * @Author hubert

 * @Date 2022/5/1 1:02 下午

 */

fun RecipeExecutor.createFragmentRecipe(
    moduleData: ModuleTemplateData,
    packageName: String,
    fragmentClass: String,
    layoutName: String,
    hasNavigation:Boolean
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val createFragment = createFragmentKt(projectData.applicationPackage,packageName, fragmentClass, layoutName, hasNavigation)
    // 保存Activity
    save(createFragment, srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
    // 保存xml
    save(createFragmentXml(packageName, fragmentClass,hasNavigation), resOut.resolve("layout/${layoutName}.xml"))

    open(srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
}