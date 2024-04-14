package site.common.util;

/**
 * 保存一些字符常量
 * @author Administrator
 *
 */

public class ResourceConstantUtil {

  //Resource 默认功能点名称 如果需要增加按此标准添加
	public static final String RESOURCE_AUDIT_ADD = "增加";
	
	public static final String RESOURCE_AUDIT_DELETE = "删除";

	public static final String RESOURCE_AUDIT_EDIT = "修改";
	
	public static final String RESOURCE_AUDIT_READ = "浏览";
   	
 //新建资源默认名称
	public static final String RES_INIT_NAME = "新建资源节点";
	public static final String RES_ORG_INIT_NAME = "新建机构节点";
	public static final String RES_ORG_UNIT_INIT_NAME = "新建部门节点";
	public static final String RES_GROUP_INIT_NAME = "新建用户组";
	public static final String RES_USER_INTT_NAME = "新建用户";
	public static final String RES_WEB_INIT_NAME =  "新建网站";
	public static final String RES_TOPIC_INIT_NAME = "新建栏目";
	public static final String RES_WORKFLOW_NODE_NAME = "新建工作流节点";
	public static final String RES_WORKFLOW_DEFINE = "新建工作流";
	
	//默认新建资源的cn固定名称
	public static final String RES_INIT_CN = "NEW_RES_CN";
    //add by bzh 2008.10.5 增加功能点的初始cn值
	public static final String AUDIT_POINT_INIT_CN = "NEW_AP_CN";
	
   //默认的查询数据表名 add by bzh 2008.10.5  10.6
	public static final String TABLE_RESOURCE = "PLAT_RES";
	public static final String TABLE_ORG = "PLAT_ORGS";
	public static final String TABLE_ORG_UNIT ="PLAT_ORG_UNITS";
	public static final String TABLE_GROUP ="PLAT_GROUPS";
	public static final String TABLE_USER = "PLAT_USERS";
	public static final String TABLE_USER_GROUP =" PLAT_USERGROUPS";
	public static final String TABLE_AUDIT_POINT = "PLAT_AUDITPOINT";
	public static final String TABLE_AUTH = "PLAT_AUTHS";
	public static final String TABLE_DICT_SEX = "PLAT_DICT_SEX";
	public static final String TABLE_DICT_NATION = "PLAT_DICT_NATION";
	public static final String TABLE_DICT_ORIGIN = "PLAT_DICT_ORIGIN";
	public static final String TABLE_DICT_POSTCODE = "PLAT_DICT_POSTCODE";
	public static final String TABLE_DICT_MARRYSTATE = "PLAT_DICT_MARRYSTATE";
	//add by bzh 2008.10.19 
	public static final String TABLE_WEB_SITE = "PLAT_WEB_SITES";
	public static final String TABLE_WEB_TOPIC = "PLAT_WEB_TOPICS";
	//add by bzh 2008.11.7 
	public static final String TABLE_APPENDIX = "PLAT_APPENDIX_FILE";	
	//add by bzh 2009.3.9 增加一个实体关系的表名
	public static final String TABLE_WEB_TOPIC_RELATION = "ENTITY_TOPIC_RELATION";
    //设定默认值
	public static final int AUDIT_POINT_DEF_SELECT =1;
	public static final int AUDIT_POINT_DEF_UNSELECT =2;
	
	//设定需要过滤属性的值
	public static final String[] IGNORE_RESOURCE_PROPERTY = new String[]{"parent","children","path","authorization","auditPoints","links","valueListHandler","inherited","tabIndex","type"};

	public static final String[] IGNORE_USER_PROPERTY = new String[]{"parent","children","path","authorization","auditPoints","links","valueListHandler","inherited","tabIndex","userGroups","type","workflowCopyto","workflowConsign","userGroupMembers","workflowCommentDefines", "ssoInformations"};

	public static final String[] IGNORE_WEBSITE_PROPERTY = new String[]{"parent","children","path","authorization","auditPoints","links","valueListHandler","inherited","tabIndex","type","topics"};

	public static final String[] IGNORE_TOPIC_PROPERTY = new String[]{"parent","children","path","authorization","auditPoints","links","valueListHandler","inherited","tabIndex","type","webSite","fields","entityTopicRelations","topicTemplates"};

	public static final String[] IGNORE_WORKFLOWNODE_PROPERTY = new String[]{"parent","children","path","authorization","auditPoints","links","valueListHandler","inherited","tabIndex","type","workflowDefines"};
	
	public static final String FILE_PREFIX_XML = ".hbm.xml";
	
	//add by ymz 2009-04-02
	public static final String[] IGNORE_USERGROUPDEFINE_PROPERTY = new String[]{"userGroupMembers","workflowRowPermissions","workflowMasterPermissions","tabIndex","expression"};
	
	//add by bzh 2008.11.7
	public static final String TOPIC_NEWS_XML ="news.xml";
	public static final String TOPIC_MODEL_XML ="model.xml";

    /**
     * 获取资源的path路径 根据授权路径
     * @param rootPath
     * @return
     */
	public static String getResourcePath(String rootPath) {
	   if (rootPath.lastIndexOf("/") > 0){
			String path = rootPath.substring(0,rootPath.lastIndexOf("/"));
			return path;  
	   }
       return null;
	}
	/**
	 * 
	 * @param rootPath
	 * @return
	 */
	public static String getAuditPointName(String rootPath) {
		   if (rootPath.lastIndexOf("/") > 0){
				String name = rootPath.substring(rootPath.lastIndexOf("/")+1,rootPath.length());
				return name;  
		   }
	       return null;
		}

}
