package other.activity.src

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.activity.res.layout.createActivityXml
import other.activity.src.app_package.createActivityKt

/**

 * @Author hubert

 * @Date 2022/5/1 1:02 下午

 */

fun RecipeExecutor.createActivityRecipe(
    moduleData: ModuleTemplateData,
    packageName: String,
    activityClass: String,
    layoutName: String,
    hasNavigation:Boolean
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(moduleData: com.android.tools.idea.wizard.template.ModuleTemplateData, activityClass: kotlin.String, packageName: kotlin.String,
//    isLauncher: kotlin.Boolean,
//    hasNoActionBar: kotlin.Boolean,
//    activityThemeName: kotlin.String /* = compiled code */,
//    isNewModule: kotlin.Boolean /* = compiled code */,
//    isLibrary: kotlin.Boolean /* = compiled code */,
//    manifestOut: java.io.File /* = compiled code */,
//    baseFeatureResOut: java.io.File /* = compiled code */,
//    generateActivityTitle: kotlin.Boolean,
//    isResizeable: kotlin.Boolean /* = compiled code */): kotlin.Unit { /* compiled code */
//    }
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = packageName,
        isLauncher = false,
        hasNoActionBar = false,
        isNewModule = false,
        isLibrary = false,
//        manifestOut = ,
//        baseFeatureResOut = ,
        generateActivityTitle = false,
        isResizeable = false,
    )

    val createActivity = createActivityKt(projectData.applicationPackage,packageName, activityClass, layoutName, hasNavigation)
    // 保存Activity
    save(createActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存xml
    save(createActivityXml(packageName, activityClass,hasNavigation), resOut.resolve("layout/${layoutName}.xml"))


}