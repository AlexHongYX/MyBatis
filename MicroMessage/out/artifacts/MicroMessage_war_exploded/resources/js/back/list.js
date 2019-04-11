/*
 * 调用后台批量删除
 * 用js临时修改表单的action
 * */

function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchServlet.action");
	//用js调用submit
	$("#mainForm").submit();
}