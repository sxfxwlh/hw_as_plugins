package other.activity.src

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.intellij.openapi.util.IconLoader
import java.io.File

/**

 * @Author hubert

 * @Date 2022/5/1 1:42 下午

 */

val createActivityTemplate
    get() = template {
        name = "Child Activity"
        description = "继承自BaseActivity的Activity"
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        val activityClass = stringParameter {
            name = "Activity Name"
            default = "Main"
            help = "只输入名字，不要包含Activity"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT,Constraint.UNIQUE,Constraint.NONEMPTY)
            suggest = { activityToLayout(activityClass.value.toLowerCase()) }
        }

        val hasNavigation = booleanParameter {
            name = "Has a Navigation"
            default = true
            help = "若勾选，自动添加导航栏"
        }

        val packageName =  stringParameter {
            name = "Package name"
            visible = { !isNewModule }
            default = "com.hw.lzjr"
            constraints = listOf(Constraint.PACKAGE)
            suggest = { packageName }
        }

        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            CheckBoxWidget(hasNavigation),
            PackageNameWidget(packageName)
        )

        recipe = { data:TemplateData ->
            createActivityRecipe(
                data as ModuleTemplateData,
                packageName.value,
                activityClass.value,
                layoutName.value,
                hasNavigation.value
            )
        }
        thumb { File("/images/template_child_activity.png") }
    }