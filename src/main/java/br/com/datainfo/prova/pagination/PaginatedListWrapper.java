package br.com.datainfo.prova.pagination;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.datainfo.prova.entity.Usuario;

import java.io.Serializable;
import java.util.List;


@XmlRootElement
public class PaginatedListWrapper implements Serializable {
    
	private static final long serialVersionUID = 8718050917252789393L;
	private Integer currentPage;
    private Integer pageSize;
    private Integer totalResults;

    private String sortFields;
    private String sortDirections;
    @XmlElement
    private List<Usuario> list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public String getSortFields() {
        return sortFields;
    }

    public void setSortFields(String sortFields) {
        this.sortFields = sortFields;
    }

    public String getSortDirections() {
        return sortDirections;
    }

    public void setSortDirections(String sortDirections) {
        this.sortDirections = sortDirections;
    }

    @SuppressWarnings("rawtypes")
	public List getList() {
        return list;
    }

    public void setList(List<Usuario> list) {
        this.list = list;
    }
}
