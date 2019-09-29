

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class TaskBean1 implements Comparable<TaskBean1>, Serializable{
	
	private String name,desc,tags;
	private Date endDt;
	private String sdt;
	private int priority;
	private Date actualEndDt;
	private String status;
	
	public TaskBean1() {
		
	}
	
	public TaskBean1(String name, String desc, String tags, String sdt,
			int priority, String status) {
		super();
		this.name = name;
		this.desc = desc;
		this.tags = tags;
		this.sdt = sdt;
		this.priority = priority;
		this.status = status;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Date getEndDt() {
		return endDt;
	}
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getActualEndDt() {
		return actualEndDt;
	}
	public void setActualEndDt(Date actualEndDt) {
		this.actualEndDt = actualEndDt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actualEndDt == null) ? 0 : actualEndDt.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((endDt == null) ? 0 : endDt.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priority;
		result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskBean1 other = (TaskBean1) obj;
		if (actualEndDt == null) {
			if (other.actualEndDt != null)
				return false;
		} else if (!actualEndDt.equals(other.actualEndDt))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (endDt == null) {
			if (other.endDt != null)
				return false;
		} else if (!endDt.equals(other.endDt))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority != other.priority)
			return false;
		if (sdt == null) {
			if (other.sdt != null)
				return false;
		} else if (!sdt.equals(other.sdt))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskBean [name=" + name + ", desc=" + desc + ", tags=" + tags
				+ ", endDt=" + endDt + ", sdt=" + sdt + ", priority="
				+ priority + ", actualEndDt=" + actualEndDt + ", status="
				+ status + "]";
	}

	@Override
	public int compareTo(TaskBean1 t) {
		
		return this.name.compareTo(t.name);
	}

	
	
	
	
}
