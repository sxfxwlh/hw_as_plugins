package other.fragment.src

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import java.io.File

/**

 * @Author hubert

 * @Date 2022/5/1 1:42 下午

 */

val createFragmentTemplate
    get() = template {
        name = "Child Fragment"
        description = "继承自BaseFragment的Fragment"
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        val fragmentClass = stringParameter {
            name = "Fargment Name"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT,Constraint.UNIQUE,Constraint.NONEMPTY)
            suggest = { activityToLayout(fragmentClass.value.toLowerCase()) }
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
            TextFieldWidget(fragmentClass),
            TextFieldWidget(layoutName),
            CheckBoxWidget(hasNavigation),
            PackageNameWidget(packageName)
        )

        recipe = { data:TemplateData ->
            createFragmentRecipe(
                data as ModuleTemplateData,
                packageName.value,
                fragmentClass.value,
                layoutName.value,
                hasNavigation.value
            )
        }

        thumb { File("/images/template_child_activity.png") }
    }