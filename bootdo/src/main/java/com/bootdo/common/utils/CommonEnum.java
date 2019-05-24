package com.bootdo.common.utils;

public class CommonEnum {

    public interface dictEnum {
        String PAYMENT_WAY = "payment_way";//支付方式
        String NOTIFY_TYPE = "oa_notify_type";//通知类型
        String ACT_CATEGORY = "act_category";//"流程分类"
        String ACT_TYPE = "act_type";//"流程类型"
        String BLOG_TYPE = "blog_type";//"博客类型"
        String CMS_DEL_FLAG = "cms_del_flag";//"内容状态"
        String CMS_GUESTBOOK = "cms_guestbook";//"留言板分类"
        String CMS_MODULE = "cms_module";//"栏目模型"
        String CMS_POSID = "cms_posid";//"推荐位"
        String CMS_SHOW_MODES = "cms_show_modes";//"展现方式"
        String CMS_THEME = "cms_theme";//"站点主题"
        String COLOR = "color";//"颜色值"
        String DEL_FLAG = "del_flag";//"删除标记"
        String GEN_CATEGORY = "gen_category";//"代码生成分类"
        String FEN_JAVA_TYPE = "gen_java_type";//"Java类型"
        String GEN_QUERY_TYPE = "gen_query_type";//"查询方式"
        String GEN_SHOW_TYPE = "gen_show_type";//"字段生成方案"
        String HOBBY = "hobby";//"爱好"
        String OA_LEAVE_TYOE = "oa_leave_type";//"请假类型"
        String OA_NOTIFY_READ = "oa_notify_read";//"通知通告状态"
        String OA_BOTIFY_STATUS = "oa_notify_status";//"通知通告状态"
        String SEX = "sex";//"性别"
        String SHOW_HIDE = "show_hide";//"显示/隐藏"
        String SYS_AREA_TYPE = "sys_area_type";//"区域类型"
        String SYS_DATA_SCOPE = "sys_data_scope";//"数据范围"
        String SYS_LOG_TYPE = "sys_log_type";//"日志类型"
        String SYS_OFFICE_COMMON = "sys_office_common";//"快捷通用部门"
        String SYS_OFFICE_GRADE = "sys_office_grade";//"机构等级"
        String SYS_OFFICE_TYPE = "sys_office_type";//"机构类型"
        String SYS_USER_TYPE = "sys_user_type";//"用户类型"
        String THEME = "theme";//"主题方案"
        String YES_NO = "yes_no";//"是/否"
    }

    public interface YesNoDict {
        Integer YES = 1;
        Integer NO = 0;
    }
}
