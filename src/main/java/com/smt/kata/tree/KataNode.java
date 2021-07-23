package com.smt.kata.tree;

// JDk 11.x
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: KataNode.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Node data structure to be utilized with data trees
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 13, 2021
 * @updates:
 ****************************************************************************/
public class KataNode<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6385007161610036667L;
	
	// Members
	private String nodeId;
	private String parentId;
	private KataNode<T> parent;
	private T data;
	private List<KataNode<T>> children;
	
	/**
	 * Default Constructor
	 */
	public KataNode() {
		children = new ArrayList<>();
	}
	
	/**
	 * Sets the root node or node head
	 * @param nodeId id of the ndoe
	 * @param parent parent node
	 * @param data node data
	 */
	public KataNode(String nodeId, KataNode<T> parent, T data) {
		this();
		this.nodeId = nodeId;
		this.parent = parent;
		this.data = data;
	}
	
	/**
	 * Sets the root node or node head
	 * @param nodeId id of the ndoe
	 * @param parent parent node
	 * @param data node data
	 */
	public KataNode(String nodeId, String parentId, T data) {
		this();
		this.nodeId = nodeId;
		this.setParentId(parentId);
		this.data = data;
	}
	
	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}
	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the parent
	 */
	public KataNode<T> getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(KataNode<T> parent) {
		this.parent = parent;
	}
	/**
	 * @return the children
	 */
	public List<KataNode<T>> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<KataNode<T>> children) {
		this.children = children;
	}

	/**
	 * @return the leaf
	 */
	public boolean isLeaf() {
		return false;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
