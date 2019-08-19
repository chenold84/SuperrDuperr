package com.chen.DeltaA.SuperrDuperr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@SQLDelete(sql = "UPDATE to_do_item SET deleted = true WHERE id = ?", check =ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class ToDoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max=30)
	private String itemName;
	
	@NotNull
	private boolean completed = false;
	
	@Column
	@JsonIgnoreProperties
	private boolean deleted = false;
	
	@ManyToOne
	@JoinColumn(name="to_do_list_id")
	@JsonIgnoreProperties("items")
	private ToDoList toDoList;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="to_do_item_tag", 
		joinColumns = { @JoinColumn(name = "to_do_item_id")},
		inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	@JsonIgnoreProperties("items")
	private List<Tag> tags;
	
	public ToDoItem() {}
	
	public ToDoItem(@Size(max = 30) String itemName, @NotNull boolean completed) {
		super();
		this.itemName = itemName;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public ToDoList getToDoList() {
		return toDoList;
	}

	public void setToDoList(ToDoList toDoList) {
		this.toDoList = toDoList;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "ToDoItem [id=" + id + ", itemName=" + itemName + ", completed=" + completed + ", toDoList=" + toDoList
				+ ", tags=" + tags + "]";
	}
	
	@PreRemove
	public void deleteUser() {
		this.deleted = true;
	}
	
}
