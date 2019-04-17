
/*
 * 调用后台批量删除
 * 用js临时修改表单的action
 * */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchServlet.action");
	//用js调用submit
	$("#mainForm").submit();
}

/*
* 修改当前页码，调用后台重新查询
* */

function changeCurrentPage(currentPage){
	//使用jquery将currentPage的值设置为传入的currentPage，相当于使用jquery在request.setAttribute
	$("#currentPage").value(currentPage);
	//使用jquery提交mainFrom对应的表单
	$("#mainForm").submit();
}