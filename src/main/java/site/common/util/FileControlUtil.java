package site.common.util;

import org.springframework.context.MessageSource;

/**
 * 保存文件目录路径的一些设置
 * @author Administrator
 *
 * add by bzh 2008.11.6
 */

public class FileControlUtil {
	
	private MessageSource messageSource;
	
    //保存栏目定义的xml文件路径
	//add by bzh 2008.11.6
    private String topicDefineXmlPath;
    private String topicDefineXmlTempPath;

	public String getTopicDefineXmlPath() {
		return topicDefineXmlPath;
	}

	public void setTopicDefineXmlPath(String topicDefineXmlPath) {
		this.topicDefineXmlPath = topicDefineXmlPath;
	}
	
	public void setTopicDefineXmlTempPath(String topicDefineXmlTempPath) {
		this.topicDefineXmlTempPath = topicDefineXmlTempPath;
	}

	public String getTopicDefineXmlTempPath() {
		return topicDefineXmlTempPath;
	}

	//保存栏目定义的xml文件目录设定
	private String topicDefineXmlDirectory;

	public String getTopicDefineXmlDirectory() {
		return topicDefineXmlDirectory;
	}

	public void setTopicDefineXmlDirectory(String topicDefineXmlDirectory) {
		this.topicDefineXmlDirectory = topicDefineXmlDirectory;
	}
	
	private String xmlDirectory;
	
	public String getXmlDirectory() {
		return xmlDirectory;
	}

	public void setXmlDirectory(String xmlDirectory) {
		this.xmlDirectory = xmlDirectory;
	}		
	
	//所有文件的base路径
	private String fileBasePath;

	public String getFileBasePath() {
		return fileBasePath;
	}

	public void setFileBasePath(String fileBasePath) {
		this.fileBasePath = fileBasePath;
	}
	
	private String xsltDirectory;//获取用于与xml动态生成界面的xslt文件 hhg add 

	public String getXsltDirectory() {
		return xsltDirectory;
	}

	public void setXsltDirectory(String xsltDirectory) {
		this.xsltDirectory = xsltDirectory;
	}
	
	private String workflowDbDirectory;// 保存根据解析表单后生成的数据库表配置文件的路径  hhg add 090401
	
	
	public String getWorkflowDbDirectory() {
		return workflowDbDirectory;
	}

	public void setWorkflowDbDirectory(String workflowDbDirectory) {
		this.workflowDbDirectory = workflowDbDirectory;
	}
	
	//附件存放路径
	public String appendixDir;

	public String getAppendixDir() {
		return appendixDir;
	}

	public void setAppendixDir(String appendixDir) {
		this.appendixDir = appendixDir;
	}


	//模板存放路径
	public String templateDir;
	
	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}
	
	//临时文件存放路径
	public String tempDir;

	public String getTempDir() {
		return tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	public String dialect; //获取系统配置中的方言 hhg add 090423

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	private String SOACtrlServer;//正文服务地址IP
	
	private String SOACtrlServerPort;//正文服务端口

	public String getSOACtrlServer() {
		return SOACtrlServer;
	}

	public void setSOACtrlServer(String ctrlServer) {
		SOACtrlServer = ctrlServer;
	}

	public String getSOACtrlServerPort() {
		return SOACtrlServerPort;
	}

	public void setSOACtrlServerPort(String ctrlServerPort) {
		SOACtrlServerPort = ctrlServerPort;
	}
	
	private String workflowDocDir;//工作流正文目录

	public String getWorkflowDocDir() {
		return workflowDocDir;
	}

	public void setWorkflowDocDir(String workflowDocDir) {
		this.workflowDocDir = workflowDocDir;
	}

}
