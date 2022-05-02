package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.activity.src.createActivityTemplate
import other.fragment.src.createFragmentTemplate

/**

 * @Author hubert

 * @Date 2022/5/1 12:13 下午

 */
class WizardTemplateProviderImpl: WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        //自定义模板就添加在此处
        createActivityTemplate,
        createFragmentTemplate
    )
}