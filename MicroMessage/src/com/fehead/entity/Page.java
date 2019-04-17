package com.fehead.entity;

public class Page {

    //������
    private int totalNumber;

    //��ǰ�ڼ�ҳ
    private int currentPage;

    //��ҳ��
    private int totalPage;

    //ÿҳ��ʾ������
    private int pageNumber=5;

    //���ݿ���limit�Ĳ������ӵڼ�����ʼȡ
    private int dbIndex;

    //���ݿ���limit�Ĳ�����һ��ȡ������
    private int dbNumber;

    //���ݵ�ǰ����������ֵ���㲢�����������ֵ
    public void count(){
        //������ҳ��
        int totalPageTemp = this.totalNumber/this.pageNumber;
        //�����������Ҫ�ٿ�һҳ
        int plus = (this.totalNumber%this.pageNumber)==0?0:1;
        totalPageTemp = totalPageTemp + plus;
        //�������һҳ����Ҫ����Ϊһҳ
        if(totalPageTemp<=0){
            totalPageTemp=1;
        }
        this.totalPage = totalPageTemp;

        //���õ�ǰҳ��
        //��ҳ��С�ڵ�ǰҳ����Ӧ����ǰҳ������Ϊ��ҳ��
        if(this.totalPage<this.currentPage){
            this.totalPage = this.currentPage;
        }
        //��ǰҳ��С��1����Ϊ1
        if(this.currentPage<1){
            this.currentPage=1;
        }

        //����limit�Ĳ���
        //limit��һ������dbIndex���ӵڼ�����ʼȡ��0��ʼ��
        this.dbIndex=(this.currentPage-1)*pageNumber;
        //limit�ڶ�������dbNumber��ȡ����
        this.dbNumber=pageNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
        //��Page�����ڲ������ú��˸�������
        this.count();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }
}
